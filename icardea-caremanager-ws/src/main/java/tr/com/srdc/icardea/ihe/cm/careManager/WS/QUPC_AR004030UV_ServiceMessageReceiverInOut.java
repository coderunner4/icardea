
/**
 * QUPC_AR004030UV_ServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package tr.com.srdc.icardea.ihe.cm.careManager.WS;

        /**
        *  QUPC_AR004030UV_ServiceMessageReceiverInOut message receiver
        */

        public class QUPC_AR004030UV_ServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        QUPC_AR004030UV_ServiceSkeleton skel = (QUPC_AR004030UV_ServiceSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        

            if("qUPC_AR004030UV_QUPC_IN043200UV".equals(methodName)){
                
                org.hl7.v3.MCCIIN000002UV01 mCCI_IN000002UV011 = null;
	                        org.hl7.v3.QUPCIN043200UV01 wrappedParam =
                                                             (org.hl7.v3.QUPCIN043200UV01)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.hl7.v3.QUPCIN043200UV01.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               mCCI_IN000002UV011 =
                                                   
                                                   
                                                         skel.qUPC_AR004030UV_QUPC_IN043200UV(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), mCCI_IN000002UV011, false);
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
        
        private static final javax.xml.bind.JAXBContext wsContext;
        static {
            javax.xml.bind.JAXBContext jc;
            jc = null;
            try {
				jc = javax.xml.bind.JAXBContext.newInstance(
            org.hl7.v3.QUPCIN043200UV01.class,
                        org.hl7.v3.MCCIIN000002UV01.class
				);
            }
            catch ( javax.xml.bind.JAXBException ex ) {
                System.err.println("Unable to create JAXBContext: " + ex.getMessage());
                ex.printStackTrace(System.err);
                Runtime.getRuntime().exit(-1);
            }
            finally {
                wsContext = jc;
			}
        }

        

                private org.apache.axiom.om.OMElement toOM(org.hl7.v3.QUPCIN043200UV01 param, boolean optimizeContent)
                throws org.apache.axis2.AxisFault {
                    try {
                        javax.xml.bind.JAXBContext context = wsContext;
                        javax.xml.bind.Marshaller marshaller = context.createMarshaller();
                        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

                        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

                        JaxbRIDataSource source = new JaxbRIDataSource( org.hl7.v3.QUPCIN043200UV01.class,
                                                                        param,
                                                                        marshaller,
                                                                        "urn:hl7-org:v3",
                                                                        "QUPC_IN043200UV01");
                        org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("urn:hl7-org:v3",
                                                                           null);
                        return factory.createOMElement(source, "QUPC_IN043200UV01", namespace);
                    } catch (javax.xml.bind.JAXBException bex){
                        throw org.apache.axis2.AxisFault.makeFault(bex);
                    }
                }

                private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.hl7.v3.QUPCIN043200UV01 param, boolean optimizeContent)
                throws org.apache.axis2.AxisFault {
                    org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
                    envelope.getBody().addChild(toOM(param, optimizeContent));
                    return envelope;
                }

                

                private org.apache.axiom.om.OMElement toOM(org.hl7.v3.MCCIIN000002UV01 param, boolean optimizeContent)
                throws org.apache.axis2.AxisFault {
                    try {
                        javax.xml.bind.JAXBContext context = wsContext;
                        javax.xml.bind.Marshaller marshaller = context.createMarshaller();
                        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

                        org.apache.axiom.om.OMFactory factory = org.apache.axiom.om.OMAbstractFactory.getOMFactory();

                        JaxbRIDataSource source = new JaxbRIDataSource( org.hl7.v3.MCCIIN000002UV01.class,
                                                                        param,
                                                                        marshaller,
                                                                        "urn:hl7-org:v3",
                                                                        "MCCI_IN000002UV01");
                        org.apache.axiom.om.OMNamespace namespace = factory.createOMNamespace("urn:hl7-org:v3",
                                                                           null);
                        return factory.createOMElement(source, "MCCI_IN000002UV01", namespace);
                    } catch (javax.xml.bind.JAXBException bex){
                        throw org.apache.axis2.AxisFault.makeFault(bex);
                    }
                }

                private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.hl7.v3.MCCIIN000002UV01 param, boolean optimizeContent)
                throws org.apache.axis2.AxisFault {
                    org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();
                    envelope.getBody().addChild(toOM(param, optimizeContent));
                    return envelope;
                }

                

        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
            return factory.getDefaultEnvelope();
        }

        private java.lang.Object fromOM (
            org.apache.axiom.om.OMElement param,
            java.lang.Class type,
            java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{
            try {
                javax.xml.bind.JAXBContext context = wsContext;
                javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();

                return unmarshaller.unmarshal(param.getXMLStreamReaderWithoutCaching(), type).getValue();
            } catch (javax.xml.bind.JAXBException bex){
                throw org.apache.axis2.AxisFault.makeFault(bex);
            }
        }

        class JaxbRIDataSource implements org.apache.axiom.om.OMDataSource {
            /**
             * Bound object for output.
             */
            private final Object outObject;

            /**
             * Bound class for output.
             */
            private final Class outClazz;

            /**
             * Marshaller.
             */
            private final javax.xml.bind.Marshaller marshaller;

            /**
             * Namespace
             */
            private String nsuri;

            /**
             * Local name
             */
            private String name;

            /**
             * Constructor from object and marshaller.
             *
             * @param obj
             * @param marshaller
             */
            public JaxbRIDataSource(Class clazz, Object obj, javax.xml.bind.Marshaller marshaller, String nsuri, String name) {
                this.outClazz = clazz;
                this.outObject = obj;
                this.marshaller = marshaller;
                this.nsuri = nsuri;
                this.name = name;
            }

            public void serialize(java.io.OutputStream output, org.apache.axiom.om.OMOutputFormat format) throws javax.xml.stream.XMLStreamException {
                try {
                    marshaller.marshal(new javax.xml.bind.JAXBElement(
                            new javax.xml.namespace.QName(nsuri, name), outObject.getClass(), outObject), output);
                } catch (javax.xml.bind.JAXBException e) {
                    throw new javax.xml.stream.XMLStreamException("Error in JAXB marshalling", e);
                }
            }

            public void serialize(java.io.Writer writer, org.apache.axiom.om.OMOutputFormat format) throws javax.xml.stream.XMLStreamException {
                try {
                    marshaller.marshal(new javax.xml.bind.JAXBElement(
                            new javax.xml.namespace.QName(nsuri, name), outObject.getClass(), outObject), writer);
                } catch (javax.xml.bind.JAXBException e) {
                    throw new javax.xml.stream.XMLStreamException("Error in JAXB marshalling", e);
                }
            }

            public void serialize(javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                try {
                    marshaller.marshal(new javax.xml.bind.JAXBElement(
                            new javax.xml.namespace.QName(nsuri, name), outObject.getClass(), outObject), xmlWriter);
                } catch (javax.xml.bind.JAXBException e) {
                    throw new javax.xml.stream.XMLStreamException("Error in JAXB marshalling", e);
                }
            }

            public javax.xml.stream.XMLStreamReader getReader() throws javax.xml.stream.XMLStreamException {
                try {
                    javax.xml.bind.JAXBContext context = wsContext;
                    org.apache.axiom.om.impl.builder.SAXOMBuilder builder = new org.apache.axiom.om.impl.builder.SAXOMBuilder();
                    javax.xml.bind.Marshaller marshaller = context.createMarshaller();
                    marshaller.marshal(new javax.xml.bind.JAXBElement(
                            new javax.xml.namespace.QName(nsuri, name), outObject.getClass(), outObject), builder);

                    return builder.getRootElement().getXMLStreamReader();
                } catch (javax.xml.bind.JAXBException e) {
                    throw new javax.xml.stream.XMLStreamException("Error in JAXB marshalling", e);
                }
            }
        }
        
    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    