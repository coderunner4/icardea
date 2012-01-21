package tr.com.srdc.icardea.consenteditor.webservice.client;

import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.security.Security;
import java.util.ResourceBundle;

import org.apache.axis2.AxisFault;
import org.joda.time.DateTime;
import org.opensaml.saml2.core.Issuer;
import org.opensaml.xacml.ctx.ActionType;
import org.opensaml.xacml.ctx.AttributeType;
import org.opensaml.xacml.ctx.AttributeValueType;
import org.opensaml.xacml.ctx.RequestType;
import org.opensaml.xacml.ctx.ResourceType;
import org.opensaml.xacml.ctx.SubjectType;
import org.opensaml.xacml.profile.saml.XACMLAuthzDecisionQueryType;
import org.opensaml.xacml.profile.saml.impl.XACMLAuthzDecisionQueryTypeImpl;
import org.opensaml.xacml.profile.saml.impl.XACMLAuthzDecisionQueryTypeMarshaller;
import org.opensaml.xml.io.MarshallingException;
import org.w3c.dom.Element;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import tr.com.srdc.icardea.atnalog.client.Audit;
import tr.com.srdc.icardea.consenteditor.saml.SAML;
import tr.com.srdc.icardea.consenteditor.webservice.client.ConsentManagerImplServiceStub.ArrayOf_xsd_anyType;
import tr.com.srdc.icardea.consenteditor.webservice.client.ConsentManagerImplServiceStub.GenerateRequest;
import tr.com.srdc.icardea.consenteditor.webservice.client.ConsentManagerImplServiceStub.GenerateRequestResponse;
import tr.com.srdc.icardea.consenteditor.webservice.client.ConsentManagerImplServiceStub.GetDecision;
import tr.com.srdc.icardea.consenteditor.webservice.client.ConsentManagerImplServiceStub.GetDecisionResponse;
import tr.com.srdc.icardea.consenteditor.webservice.client.ConsentManagerImplServiceStub.GetResources;
import tr.com.srdc.icardea.consenteditor.webservice.client.ConsentManagerImplServiceStub.GetResourcesResponse;
import tr.com.srdc.icardea.consenteditor.webservice.client.ConsentManagerImplServiceStub.GetSubjects;
import tr.com.srdc.icardea.consenteditor.webservice.client.ConsentManagerImplServiceStub.GetSubjectsResponse;

public class ConsentManagerImplServiceTest {
	private static ConsentManagerImplServiceTest instance = null;
	
	private ConsentManagerImplServiceTest() {
	}
	
	public static ConsentManagerImplServiceTest getInstance() {
		if(instance == null)
			instance = new ConsentManagerImplServiceTest();
		return instance;
	}

	public static void main(String[] argv) throws RemoteException {
		// callGetSubjects();
		// callGetResources();
		ConsentManagerImplServiceTest.getInstance().grantRequest("191", "doctor", "condition");
		// callgenerateRequest(argv[0],argv[1],argv[2],argv[3],argv[4]);
		// callgenerateRequest("1","srdc","ROLECODE:DOCTOR","RESOURCECODE:CONDITION","READ");
	}

	private void sslSetup() {
		boolean atnatls = new Boolean(ResourceBundle.getBundle("icardea")
				.getString("atna.tls")).booleanValue();
		if (atnatls) {
			// Properties for SSL Security Provider
			System.out.println(" $$$$ SECURE COMMUNICATION .....");
			String protocolProp = "java.protocol.handler.pkgs";
			String sunSSLProtocol = "com.sun.net.ssl.internal.www.protocol";
			String sslStoreProp = "javax.net.ssl.trustStore";
			String certPath = ResourceBundle.getBundle("icardea").getString("icardea.home") + "/icardea-caremanager-ws/src/test/resources/jssecacerts";

			// Enable SSL communication
			System.setProperty(protocolProp, sunSSLProtocol);
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			System.setProperty(sslStoreProp, certPath);
			System.setProperty("javax.net.ssl.trustStorePassword", "srdcpass");
		}
	}

	public boolean grantRequest(String patientId, String requesterRole,
			String resource) {
		sslSetup();

		boolean result = false;
		String response = callGetDecision(patientId, "srdc", "ROLECODE:"
				+ requesterRole.toUpperCase(), "RESOURCECODE:"
				+ resource.toUpperCase().replaceAll(" ", ""), "READ");
		result = response.indexOf("Permit") != -1;
		System.out.println("$$$ Grant request for patient '" + patientId
				+ "' from requestor role '" + requesterRole
				+ "' for resource '" + resource + "' results in " + result);
		boolean atnalog = new Boolean(ResourceBundle.getBundle("icardea")
				.getString("atna.log")).booleanValue();
		// TODO: ATNA
		// Send ATNA Message: Grant Request Message
		// +"resource"+ is requested from "+requesterRole+" for
		// "+patientID+" with result "+result.
		if (atnalog) {
			ResourceBundle properties = ResourceBundle.getBundle("icardea");
			String atnalogServer = properties.getString("atna.log.server");
			
			String xml = Audit.createMessage("GRM", patientId, resource, requesterRole);//TODO: Grant Request Message
			Audit a = null;
			try {
				a = new Audit(atnalogServer, 2861);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            a.send_udp( a.create_syslog_xml("caremanager", xml) );
		}
		
		return result;
	}

	public String callGetDecision(String patientId, String issuerName,
			String subjectCode, String resourceCode, String action) {
		ConsentManagerImplServiceStub stub;
		try {
			ResourceBundle properties = ResourceBundle.getBundle("icardea");
			String endpoint = properties.getString("consent.ws.endpoint");

			stub = new ConsentManagerImplServiceStub(endpoint);
			GetDecision request = new GetDecision();
			request.setPatientID(patientId);
			String requestString = generateRequestAsString(generateSAMLRequest(
					"1", issuerName, subjectCode, resourceCode, action));
			requestString = requestString.substring(39);
			request.setRequestString(requestString);
			GetDecisionResponse response = stub.getDecision(request);
			String resultString = response.getGetDecisionReturn();
			System.out.println(resultString);
			return resultString;
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "<?xml version=\"1.0\" encoding=\"UTF-16\"?><xacml-saml:XACMLAuthzDecisionStatement xmlns:xacml-saml=\"urn:oasis:names:tc:xacml:2.0:profile:saml2.0:v2:schema:assertion\"><xacml-context:Response xmlns:xacml-context=\"urn:oasis:names:tc:xacml:2.0:context:schema:os\"><xacml-context:Result><xacml-context:Decision>Deny</xacml-context:Decision></xacml-context:Result></xacml-context:Response></xacml-saml:XACMLAuthzDecisionStatement>";
	}

	public void callgenerateRequest(String requestId, String issuerName,
			String subjectCode, String resourceCode, String action) {
		ConsentManagerImplServiceStub stub;
		try {
			ResourceBundle properties = ResourceBundle.getBundle("icardea");
			String endpoint = properties.getString("consent.ws.endpoint");

			stub = new ConsentManagerImplServiceStub(endpoint);
			GenerateRequest request = new GenerateRequest();
			request.setRequestId(requestId);
			request.setIssuerName(issuerName);
			request.setSubjectCode(subjectCode);
			request.setResourceCode(resourceCode);
			request.setAction(action);
			GenerateRequestResponse response = stub.generateRequest(request);
			String result = response.getGenerateRequestReturn();
			System.out.println(result);
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void callGetSubjects() {
		ConsentManagerImplServiceStub stub;
		try {
			ResourceBundle properties = ResourceBundle.getBundle("icardea");
			String endpoint = properties.getString("consent.ws.endpoint");

			stub = new ConsentManagerImplServiceStub(endpoint);
			GetSubjects request = new GetSubjects();
			GetSubjectsResponse response = stub.getSubjects(request);
			ArrayOf_xsd_anyType result = response.getGetSubjectsReturn();
			System.out.println("SUBJECTS");
			for (Object o : result.getItem()) {
				System.out.println("Subject Code: " + o);
			}
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void callGetResources() {
		ConsentManagerImplServiceStub stub;
		try {
			ResourceBundle properties = ResourceBundle.getBundle("icardea");
			String endpoint = properties.getString("consent.ws.endpoint");

			stub = new ConsentManagerImplServiceStub(endpoint);
			GetResources request = new GetResources();
			GetResourcesResponse response = stub.getResources(request);
			ArrayOf_xsd_anyType result = response.getGetResourcesReturn();
			System.out.println("RESOURCES");
			for (Object o : result.getItem()) {
				System.out.println("Resource Code: " + o);
			}
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String generateRequestAsString(
			XACMLAuthzDecisionQueryType request) {
		XACMLAuthzDecisionQueryTypeMarshaller marshaller = new XACMLAuthzDecisionQueryTypeMarshaller();
		Element element = null;
		String result = "";
		try {
			element = marshaller.marshall(request);

			DOMImplementationRegistry registry = DOMImplementationRegistry
					.newInstance();

			DOMImplementationLS impl = (DOMImplementationLS) registry
					.getDOMImplementation("LS");

			LSSerializer writer = impl.createLSSerializer();
			result = writer.writeToString(element);
		} catch (MarshallingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	private XACMLAuthzDecisionQueryType generateSAMLRequest(
			String requestId, String issuer, String subjectId,
			String resourceId, String actionString) {
		SAML saml = new SAML();
		XACMLAuthzDecisionQueryType query = saml.create(
				XACMLAuthzDecisionQueryTypeImpl.class,
				XACMLAuthzDecisionQueryTypeImpl.DEFAULT_ELEMENT_NAME_XACML20);
		RequestType request = saml.create(RequestType.class,
				RequestType.DEFAULT_ELEMENT_NAME);

		DateTime now = new DateTime();

		if (!subjectId.equals("")) {
			AttributeType subjectAttr = saml.create(AttributeType.class,
					AttributeType.DEFAULT_ELEMENT_NAME);
			subjectAttr
					.setAttributeID("urn:oasis:names:tc:xacml:1.0:subject:subject-id");
			subjectAttr.setDataType("http://www.w3.org/2001/XMLSchema#string");

			AttributeValueType subjectAttrValue = saml.create(
					AttributeValueType.class,
					AttributeValueType.DEFAULT_ELEMENT_NAME);
			subjectAttrValue.setValue(subjectId);
			subjectAttr.getAttributeValues().add(subjectAttrValue);

			SubjectType subject = saml.create(SubjectType.class,
					SubjectType.DEFAULT_ELEMENT_NAME);
			subject.getAttributes().add(subjectAttr);
			request.getSubjects().add(subject);
		}

		if (!resourceId.equals("")) {
			AttributeType resourceAttr = saml.create(AttributeType.class,
					AttributeType.DEFAULT_ELEMENT_NAME);
			resourceAttr
					.setAttributeID("urn:oasis:names:tc:xacml:1.0:resource:resource-id");
			resourceAttr.setDataType("http://www.w3.org/2001/XMLSchema#string");

			AttributeValueType resourceAttrValue = saml.create(
					AttributeValueType.class,
					AttributeValueType.DEFAULT_ELEMENT_NAME);
			resourceAttrValue.setValue(resourceId);
			resourceAttr.getAttributeValues().add(resourceAttrValue);

			ResourceType resource = saml.create(ResourceType.class,
					ResourceType.DEFAULT_ELEMENT_NAME);
			resource.getAttributes().add(resourceAttr);
			request.getResources().add(resource);
		}

		if (!actionString.equals("")) {
			ActionType action = saml.create(ActionType.class,
					ActionType.DEFAULT_ELEMENT_NAME);

			AttributeType actionAttr = saml.create(AttributeType.class,
					AttributeType.DEFAULT_ELEMENT_NAME);
			actionAttr
					.setAttributeID("urn:oasis:names:tc:xacml:1.0:action:action-id");
			actionAttr.setDataType("http://www.w3.org/2001/XMLSchema#string");

			AttributeValueType actionAttrValue = saml.create(
					AttributeValueType.class,
					AttributeValueType.DEFAULT_ELEMENT_NAME);
			actionAttrValue.setValue(actionString);
			actionAttr.getAttributeValues().add(actionAttrValue);

			action.getAttributes().add(actionAttr);
			request.setAction(action);
		}
		Issuer issuer_ = saml.create(Issuer.class, Issuer.DEFAULT_ELEMENT_NAME);
		issuer_.setValue(issuer);
		query.setID(requestId);
		query.setIssueInstant(now);
		query.setIssuer(issuer_);
		query.setRequest(request);
		return query;
	}
}
