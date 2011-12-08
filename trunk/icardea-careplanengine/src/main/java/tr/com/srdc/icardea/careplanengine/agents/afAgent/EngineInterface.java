/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.srdc.icardea.careplanengine.agents.afAgent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import tr.com.srdc.icardea.careplanengine.entities.AssignmentEntity;
import tr.com.srdc.icardea.careplanengine.entities.GuidelineEntity;
import tr.com.srdc.icardea.careplanengine.glif.generator.GlifGenerator;

/**
 * 
 * @author yildiray
 */
public class EngineInterface {

	private static Logger logger = Logger.getLogger(EngineInterface.class);
	private static ArrayList<ConsultMessage> cmq = new ArrayList<ConsultMessage>();
	private static ArrayList<MonitoringMessage> mmq = new ArrayList<MonitoringMessage>();

	public static synchronized String executeCareplan(String patientID,
			String carePlanID) {
		AssignmentEntity ae = new AssignmentEntity();
		ae.setPatientCode(new Long(patientID));
		ae.setAssignmentID(new Long("111"));
		// TODO: Delete in the future
		ResourceBundle properties = ResourceBundle.getBundle("icardea");
		String username = properties.getString("mysql.username");
		String password = properties.getString("mysql.password");
		String url = properties.getString("mysql.host");
		String jdbcDriver = properties.getString("jdbc.driverClassName");
		String jdbcURL = "jdbc:mysql://" + url + "/final_icardea_repository";
		String careplanURL = "";
		try {
			Class.forName(jdbcDriver).newInstance();
			Connection conn = DriverManager.getConnection(jdbcURL, username,
					password);
			Statement s = conn.createStatement();
			ResultSet resultSet = s
					.executeQuery("select GUIDELINE_URL from guideline_entity where guideline_id = "+ carePlanID);
			
			if (resultSet.next()) {
				careplanURL = resultSet.getString("GUIDELINE_URL");
			}
			s.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO
		logger.info(" $$$ Starting careplan:"+carePlanID+" carepla URL:"+careplanURL + " for patient:"+patientID);
		ae.setProcessedGuidelineURL(careplanURL);
		GuidelineEntity ge = new GuidelineEntity();
		ge.setGuidelineURL(careplanURL);
		ae.setGuidelineEntity(ge);
		return AFAgent.createStandaloneGuidelineAgent(ae).getAID();
	}

	public static synchronized void processConsultingMessage(
			String consultHTMLString, String careplanProcessorID, String stepID) {
		logger.info(" $$$ Process the Consult Message for Careplan Processor ID:" + careplanProcessorID + " Step ID:" + stepID
				+ " \n " + consultHTMLString);
		/*
		 * ConsultMessage consultMessage = new
		 * ConsultMessage(careplanProcessorID, consultHTMLString);
		 * Flex.addConsultingMessageToQueue(consultMessage);
		 */
		ConsultMessage consultMessage = new ConsultMessage(careplanProcessorID,
				consultHTMLString, stepID);
		cmq.add(consultMessage);
	}

	public static synchronized void informConsultMessage(
			String careplanProcessorID, String result) {
		// result = "The case is VT!";
		logger.info(" $$$ Result from monitoring:" + result + " for careplan processor Id="+ careplanProcessorID);
		result = "<Data> <Observation> <Certainity_OB>0</Certainity_OB> "
				+ "<Normal_Range_OB> <Display_Name_RN>string</Display_Name_RN> </Normal_Range_OB> "
				+ "<Severity_OB>0</Severity_OB> <Text_Value>" + result
				+ "</Text_Value> " + "</Observation> </Data>";
		AFAgent.getInstance().getGuidelineAgent(careplanProcessorID)
				.informConsultMessage(result);
		if(cmq.size() > 0)
			cmq.remove(0);
		else
			logger.info(" $$$ CMQ Size is less than ZERO");
	}

	public static synchronized void sendMonitoringMessage(
			String careplanProcessorID, String stepID, String status,
			String monitorMessage) {
		logger.info(" $$$ Monitoring Message: Careplan Processor ID:"
				+ careplanProcessorID + " Step ID: " + stepID + " Status:"
				+ status + " Result:" + monitorMessage);
		/*
		 * MonitoringMessage monitoringMessage = new
		 * MonitoringMessage(careplanProcessorID, stepID, status,
		 * monitoringMessage);
		 * Flex.addMonitoringMessageToQueue(monitoringMessage);
		 */
		MonitoringMessage monitoringMessage = new MonitoringMessage(
				careplanProcessorID, stepID, status, monitorMessage);
		mmq.add(monitoringMessage);
	}
	public static synchronized void assertMonitoringMessage(boolean isSuccessful){
		if(isSuccessful) {
			if(mmq.size() > 0)
				mmq.remove(0);
			else
				logger.info(" $$$ MMQ Size is less than ZERO");
		}
		
	}

	public static synchronized ArrayList<MonitoringMessage> receiveMonitoringMessage() {
		return mmq;
	}

	public static synchronized ArrayList<ConsultMessage> receiveConsultMessage() {
		return cmq;
	}

}