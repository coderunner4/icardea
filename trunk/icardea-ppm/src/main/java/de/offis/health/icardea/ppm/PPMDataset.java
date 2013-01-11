/**
 * 
 */
package de.offis.health.icardea.ppm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.codec.language.RefinedSoundex;
import org.apache.log4j.Logger;
import org.eclipse.ui.part.ShowInContext;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.message.AuthRequest;

import com.mysql.jdbc.Driver;

import de.offis.health.icardea.ppm.login.LoginServiceImpl;
import de.offis.health.icardea.ppm.login.RegistrationService;
import tr.com.srdc.icardea.consenteditor.webservice.client.ConsentManagerImplServiceTest;
import de.offis.health.icardea.ppm.DactPatternDataSet;

/**
 * @author thiel
 *
 */
@SuppressWarnings("unused")
public class PPMDataset {

	private	  String url = "jdbc:mysql://localhost:3306/";
	private	  String dbName = "icardea";
	private	  String driver = "com.mysql.jdbc.Driver";
	private	  String dbUserName = "root"; 
	private	  String dbPassword = "icardea";
	private	  Connection conn = null;
	private   Statement stmt =null;
	boolean isDemoMode=true;

	private String dropPPMDataset="drop table  if exists icardea.PPMDATASET; ";
	private String dropPPMPending="drop table  if exists icardea.PPMPENDING; ";
	private String dropDACT="drop table  if exists icardea.dact_pattern; drop table  if exists icardea.dact_counter;";


	private String createPPMDataset = "CREATE TABLE icardea.PPMDATASET (   SHEET VARCHAR(20),   PARAMETER VARCHAR(50),   DATASET LONGTEXT,   TYPE_OF_VARIABLE TEXT,   EXPLANATION TEXT,   SOURCE TEXT,   FULLREFID TEXT,   PPMDATASOURCE TEXT,   TIME_FRAME TEXT,   FORMAT TEXT,   VALIDATION TEXT,   COMMENTS TEXT,   SJM_COMMENTS TEXT,   PATID TEXT,   SORTNUMBER INTEGER,   SUBTITEL TEXT,   BUTTONTITEL TEXT,   BUTTONTABLE TEXT,   USERPREF TEXT,   SQLCAREPLAN TEXT,   DEMODATASET_AF TEXT,   TIMELOW TEXT,   TIMEHIGH TEXT,   ID INTEGER NOT NULL  AUTO_INCREMENT,   PRIMARY KEY (ID) );";
	private String createPPMPending = "CREATE TABLE icardea.PPMPENDING (   SerialID TEXT,   DATASET LONGTEXT,   SOURCE TEXT,   FULLREFID TEXT,   PATID TEXT,   TIMELOW TEXT,   TIMEHIGH TEXT,   STATUS CHAR,   localid MEDIUMINT NOT NULL AUTO_INCREMENT,    PRIMARY KEY (localid)   );";
	private String createDACT;
	private String createVIEWS="";
	private String createInitial= "";
	private static Logger logger = Logger.getLogger(PPMDataset.class);

	public PPMDataset() {
		// TODO Auto-generated constructor stub

		try {
			driver = ResourceBundle.getBundle("icardea").getString(
					"jdbc.driverClassName");
			dbUserName = ResourceBundle.getBundle("icardea").getString(
					"mysql.username");
			dbPassword = ResourceBundle.getBundle("icardea").getString(
					"mysql.password");
			ResourceBundle properties = ResourceBundle.getBundle("icardea");
			//			boolean isSalkUsage = Boolean.parseBoolean(properties.getString("salk.usage"));
			testConsent=Boolean.parseBoolean(properties.getString("consent.usage"));
			logger.debug("Testing consent="+testConsent);



		} catch (java.util.MissingResourceException e) {
			// TODO: handle exception
			logger.error("Missing Ressource bundle:"+e.getMessage());
		}
		dbName=dbName+"?allowMultiQueries=true";
		try {
			Class.forName(driver).newInstance();
			logger.info("Connect to "+url+dbName);
			conn = DriverManager.getConnection(url+dbName,dbUserName,dbPassword);

			stmt=conn.createStatement();
			//			System.out.println("Connected to the database");
			//			conn.close();
			//			System.out.println("Disconnected from database");
			DateFormat dd=new SimpleDateFormat("dd.MM.yyyy");
			this.dateStrings[0]=dd.format(Calendar.getInstance().getTime());
			logger.info("Set currrentdate="+this.dateStrings[0]);
			setCurrentDate(PPMDataset.convPointToTime(this.dateStrings[0] ));
			checkDB();
		} catch (Exception e) {
			logger.fatal("Database is missing");
			logger.fatal(e.getMessage());
			//			throw new RuntimeException("Database is missing");
		}
	}

	/**
	 * Internal singleton self reference.
	 */
	private volatile static PPMDataset instance;
	/**
	 * This method will create the PPMDataset singleton if it doesn't exist
	 * and return the PPMDataset instance.
	 * 
	 * @return PPMDataset singleton object
	 */
	public static PPMDataset getInstance() {
		if (instance == null) {
			synchronized(PPMDataset.class) {
				if (instance == null) {
					instance = new PPMDataset();
				} // end if
			} // end synchronized
		} // end if
		return instance;
	}
	private void createInitialDB() throws SQLException {
		fillStatements();
		stmt.execute(dropPPMPending);
		logger.info("Table pending dropped");
		stmt.execute(createPPMDataset + createPPMPending);
		logger.info("Table ppmdataset created");
		//					stmt.execute(createPPMPending);
		logger.info("Table ppmpending created");
		stmt.execute(createInitial);
		logger.info("Initial configuration created");
		stmt.execute(dropDACT);
		logger.info("DACT Tables dropped");
		stmt.execute(createDACT);
		logger.info("Dact Tables created");
//		stmt.execute("update ppmdataset set sortnumber=sortnumber*10000 where sortnumber<10000");

	}

	private void createInitialViewsDB() throws SQLException {
		fillStatements();
		stmt.execute(createVIEWS);
		logger.info("Views created");

	}

	private boolean checkDB(){
		logger.info("Check PPM DB"); 
		boolean retval=true;
		ResultSet rs;
		//		ResultSet rs2;

		try {
			rs = stmt.executeQuery("SELECT  sheet FROM ppmdataset");

		} catch (SQLException e) {
			logger.info("Check Database Error:"+e.getErrorCode());
			logger.info("Check Database "+e.getMessage());
			// TODO Auto-generated catch block
			if (e.getErrorCode()==1146){
				logger.info("Create Database ");
				try {
					retval=false;
					createInitialDB();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}


		}
		//create new and old view each time
		try {
			createInitialViewsDB();
			rs = stmt.executeQuery("SELECT  buttontable FROM `ppmdataset`  where length(buttontable)>0  group by buttontable");
			String tablename="unknown";
			String nextStmt;
			Statement exec_stmt=this.createStmt();
			while (rs.next()){
				tablename=rs.getString(1);
				logger.info("Prepare Query Table for "+tablename);
				nextStmt="create or replace view "+tablename+"_order as "
						+"SELECT old.effectiveTimeLow oldtime, new.effectiveTimeLow newtime ,old.val oldvalue, new.val newvalue , old.val-new.val diffvalue,"
						+"datediff(STR_TO_DATE(new.effectiveTimeLow,'%Y%m%d%H%i'),STR_TO_DATE(old.effectiveTimeLow,'%Y%m%d%H%i')) diffdate "
						+"FROM "+ tablename+ " old,"+ tablename+ " new order by new.effectiveTimeLow desc,old.effectiveTimeLow desc";
				try {
					exec_stmt.execute(nextStmt);

					try {

						nextStmt="create or replace view "+tablename+"_test as "
								+ " select  diffvalue/diffdate changeperday, diffvalue, newvalue, diffdate, oldtime , newtime from "
								+tablename+"_order c where oldtime < newtime limit 1";
						exec_stmt.execute(nextStmt);
					} catch (Exception e2) {
						// TODO: handle exception
						logger.error(nextStmt);
						e2.printStackTrace();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error(nextStmt);
					e.printStackTrace();
				}
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			logger.error("Select buttontable failed");
			e1.printStackTrace();
			return retval;
		}
		try {
			rs.close();
			//			rs2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retval;

	}
	private String role="doctor"; //current user role

	// userFullName = The name of the user from OpenID
	private String userFullName = "";
	// userOpenID = the openID of the user
	private String userOpenID = ""; 
	// Is the userOpenId successfull verified? 
	private boolean userOpenIdVerified = false;
	//URL which was called initial
	private String initialCalledUrl = "";
	// AutoLoginModus = Should the user automatically get logged in?
	private boolean autoLogin = false;
	private String currentPatID = "1";
	private String patiennameBirthdateString = "Mayr, Jane (22.04.1973)";
	private String diagnosesString="Sudden Cardiac Death";
	private String implantationString="02.12.2008";
	private String icdString="Medtronic";
	private String icdIDString="model:Maximo/serial:D284DRG";
	private String iCardeaID="191";
	public boolean testConsent=false;
	public List<Patient> patientList = new ArrayList();


	private String[] sheetStrings = {"Overview", "VT/VF", "AF/AT","PatInfo","ProPara"};
	private List<String> sheetList = new ArrayList(Arrays.asList(new String[]{"Overview", "VT/VF", "AF/AT","PatInfo","ProPara"}));
	private String[] dateStrings ={"23.03.2012","05.12.2010","25.01.2012","30.09.2011","01.12.2008","15.06.2010","30.09.2010","24.01.2011"};
	private String currentDate  ;
	private String ppmROW= "SHEET,PARAMETER,DATASET,TYPE_OF_VARIABLE,EXPLANATION,SOURCE,fullrefid,PPMDATASOURCE,TIME_FRAME,FORMAT,VALIDATION,COMMENTS,SJM_COMMENTS,SORTNUMBER,SUBTITEL,BUTTONTITEL,BUTTONTABLE,USERPREF,SQLCAREPLAN,DEMODATASET_AF,TIMELOW,TIMEHIGH,PATID";

	/**
	 * @return the currentDate
	 */
	public String getCurrentDate() {
		return currentDate;
	}
	/**
	 * @param currentDate the currentDate to set
	 */
	public void setCurrentDate(String currentDate) {
		this.currentDate = (currentDate+"00000000000000000").substring(0,12);
	}
	static public String convTimeToPoint(String in){
		if (in!=null) 
			if(in.length()>=8){
				String day=in.substring(6, 8);
				String mon=in.substring(4, 6);
				String year=in.substring(0, 4);
				return(day+"."+mon+"."+year);
			}
		return("");
	}
	static public String convPointToTime(String in){
		if (in!=null) 
			if(in.length()>=10){
				String day=in.substring(0, 2);

				String mon=in.substring(3, 5);
				String year=in.substring(6, 10);
				return(year+mon+day);
			}
		return("");
	}

	public String getUrl() {
		return url;
	}
	public String getDbName() {
		return dbName;
	}
	public String getDriver() {
		return driver;
	}
	public String getDbUserName() {
		return dbUserName;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public Connection getConn() {
		return conn;
	}
	public List<String> getSheetList() {
		return sheetList;
	}
	public String[] getDateStrings() {
		return dateStrings;
	}
	public PPMRowModel getCurrentRowModel() {
		return currentRowModel;
	}

	private PPMRowModel currentRowModel;

	public PPMRowModel[] getRows(String sheet){
		List<PPMRowModel> colList = new ArrayList();
		try {

			ResultSet rs = getStmt().executeQuery(
					"SELECT  parameter,dataset,type_of_variable,explanation,buttontable FROM ppmdataset "+
							"where patid=trim("+currentPatID+") and sheet=\""+sheet+"\""+
							"order by userpref,sortnumber"
					);
			if (rs==null) {
				colList.add(new PPMRowModel("No Information","",""));
			}else{
				while (rs.next()) {
					PPMRowModel ppmModel=new PPMRowModel(rs.getString(1),rs.getString(2),rs.getString(3));
					ppmModel.setExplanation(rs.getString(4));
					ppmModel.setSubContentName(rs.getString(5));

					//				System.out.println("Sheet: "+ppmModel);
					colList.add(ppmModel);
				}}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			colList.add(new PPMRowModel("No Information","",""));
		}
		return(colList.toArray(new PPMRowModel[0]));
	}

	public PPMSubItemsModel[] getSubItems(String view){
		List<PPMSubItemsModel> colList = new ArrayList();
		String query="";
		try {
			query="SELECT effectivetimelow,effectivetimehigh,text FROM "+ view 
					+" where patid=trim(\""+currentPatID+"\") "
					+" and val is not null and effectiveTimeLow is not null and text is not null" ;
			logger.trace(query);
			ResultSet rs = getStmt().executeQuery(
					query
					);
			if (rs==null) {
				colList.add(new PPMSubItemsModel("No Information available","",""));
			}else{
				while (rs.next()) {
					PPMSubItemsModel ppmModel=new PPMSubItemsModel(rs.getString(3),rs.getString(1),rs.getString(2));
					//				ppmModel.setExplanation(rs.getString(4));
					//				ppmModel.setSubContentName(rs.getString(5));

					//				System.out.println("Sheet: "+ppmModel);
					colList.add(ppmModel);
				}}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(query);
			e.printStackTrace();
			colList.add(new PPMSubItemsModel("No Information available","",""));
		}
		return(colList.toArray(new PPMSubItemsModel[0]));
	}

	public void dactCalled(){
		String sqlQuery="";
		int res=0;
		String userName = "";
		if (this.userOpenID.equalsIgnoreCase("")){
			userName="UnkownID";
		}
		else{
			userName=this.userOpenID;
		}
		sqlQuery = "INSERT INTO dact_counter(username) VALUE ( '"+userName+"');";
		//System.out.println("DACT Called" + sqlQuery);
		try{
			res= getStmt().executeUpdate(sqlQuery);
			if(res==0){
				logger.error("Undocumented call of DACT");
			}
			else{
				logger.info("DACT was counted to be used by "+this.userOpenID);
			}

		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error("Problem with counting Dact: " + e.getMessage() );
		}

	}


	//returns all known patterns, whithout patient validation
	public ArrayList<DactPatternDataSet> getDactItems()
	//Start reading
	{		
		ArrayList<DactPatternDataSet> allPatterns = new ArrayList<DactPatternDataSet>();
		int nextItem=0;
		String sqlQuery="";		
		//keep in mind, that parameter is NOT unique withhin one patid, may be sheet have to be added
		ResultSet rs = null;

		sqlQuery = "SELECT "+ 
				" pattern_id, "+
				" prerequisite_db_relations,  "+
				" prerequisiute_db_attributes,  "+
				" prerequisite_view,  "+
				" conclusion_db_attribute,  "+
				" conclusion_db_relation,  "+
				" confidence_view,  "+
				" conclusion_view,  "+
				" support_view,  "+
				" approvedstatus_view,  "+
				" validforpatient,  "+
				" creationdate,  "+
				" creationsource,  "+
				" active  "+
				" FROM "+ 
				" dact_pattern " +
				" where active = true "+
				" order by pattern_id;";

		try {
			rs = this.getStmt().executeQuery(sqlQuery);
			//System.out.println("DACT Button Test - getSTmt");
			// Is the preReqValid for Patient?
			//curPattern.preReqFullFilled = rs.getBoolean("");
			//`validforpatient`,
			//curPattern.validForPat=rs.getBoolean("");

			while (rs.next())
			{
				//System.out.println("DACT Button Test - resultset");
				DactPatternDataSet curPattern = new DactPatternDataSet();
				curPattern.patternID=rs.getInt("pattern_id");
				curPattern.viewPreReq=rs.getString("prerequisite_view");
				//  `pattern_id`,
				curPattern.patternID = rs.getInt("pattern_id");
				//`prerequisite_db_relations`,
				curPattern.preReqRelations = rs.getString("prerequisite_db_relations");
				//`prerequisiute_db_attributes`,
				curPattern.preReqAttributes =rs.getString("prerequisiute_db_attributes");
				//`prerequisite_view`,
				curPattern.viewPreReq = rs.getString("prerequisite_view");
				// `conclusion_db_attribute`,
				curPattern.conCluAttribute =rs.getString("conclusion_db_attribute");
				// `conclusion_db_relation`,
				curPattern.concluRelation =rs.getString("conclusion_db_relation");
				// `confidence_view`,
				curPattern.viewConf =rs.getString("confidence_view");
				//`conclusion_view`,
				curPattern.viewConclu=rs.getString("conclusion_view");
				//`support_view`,
				curPattern.viewSupport = rs.getString("support_view");
				//`approvedstatus_view`,
				curPattern.viewApproved = rs.getString("approvedstatus_view");
				//`creationdate`,
				curPattern.creationDate =rs.getString("creationdate");
				//`creationsource`,
				curPattern.creationSource =rs.getString("creationsource");
				//`active`
				curPattern.active = rs.getBoolean("active");

				//System.out.println("PatternID add " + curPattern.patternID.toString());
				// Store at the list array
				allPatterns.add(curPattern);

			}

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("Major error. Restart could help: "+e.getMessage());;
			}
		}
		return allPatterns;
	}// End of reading

	public ArrayList<DactPatternDataSet> checkDactItems(ArrayList<DactPatternDataSet> pPatternCheck, Integer pPatientID)
	{// set the booleans of the pattern, if they are valid for the current patient or not.
		DactPatternDataSet selected = null; 	
		String sqlQuery="";		
		ResultSet rs = null;

		for (int i=0; i < pPatternCheck.size(); i++  ) 
		{
			selected = pPatternCheck.get(i);
			//TODO keep in mind, that parameter is NOT unique withhin one patid, may be sheet have to be added
			sqlQuery = "select distinct t1.pattern_id " +
					"from dact_pattern as t1 " + selected.preReqRelations 
					+ " where " + selected.preReqAttributes 
					+ pPatientID ;
			try{
				logger.debug("SQLString "+sqlQuery);
				rs = this.getStmt().executeQuery(sqlQuery);

				// Is the preReqValid for Patient?
				//curPattern.preReqFullFilled = rs.getBoolean("");
				//`validforpatient`,
				//curPattern.validForPat=rs.getBoolean("");

				if (rs.next())
				{
					selected.preReqFullFilled = true;
					//TODO: Fast hack 
					sqlQuery = "select distinct t1.pattern_id from dact_pattern as t1 "
							+selected.concluRelation 
							+" where " + selected.conCluAttribute + pPatientID +" and t1.pattern_id = "+selected.patternID +";";
					logger.debug("Determine PatternFullfiled " + sqlQuery);
					rs = this.getStmt().executeQuery(sqlQuery);
					if(rs.next()){
						selected.validForPat = true;
					}
				}
				else{
					selected.preReqFullFilled = false;
				}
				//update into patternset
				pPatternCheck.set(i, selected);
			}
			catch (SQLException e) {
				
				logger.error("Dact patternCheck caused error : "+ e.getMessage());
			}
			finally{
				try {
					rs.close();
				} catch (Exception e) {
					logger.error("Major error. Restart could help: "+e.getMessage());;
				}
			}

		}
		return pPatternCheck;
	}

	/**
	 * @return The userFullName
	 */
	public String getUserFullName() {
		return userFullName;
	}


	/**
	 * @param userFullName The userFullName to set with OpenID value
	 */
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	/**
	 * @return The userOpenID
	 */

	public String getUserOpenID() {
		return userOpenID;
	}
	/**
	 * @param userOpenID The userOpenID to set. Should be like abcde.myopenid.com
	 */

	public void setUserOpenID(String pUserOpenID) {
		if(pUserOpenID.equalsIgnoreCase(this.userOpenID)){
			this.userOpenID = pUserOpenID;
		}
		else{// OtherUserOpenID, reset values for user
			System.out.println("Test: UseropenID reseted");
			this.userOpenID = pUserOpenID;
			this.setUserOpenIdVerified(false);
			this.setRole("");
			this.setUserFullName("");
		}
	}

	public void resetUserOpenID(){
		this.userOpenID = "";
		this.setUserOpenIdVerified(false);
		this.setRole("");
		this.setUserFullName("");

	}
	/**
	 * @return the currentPatID
	 */
	public String getCurrentPatID() {
		return currentPatID;
	}


	/**
	 * @param currentPatID the currentPatID to set
	 */
	public void setCurrentPatID(String currentPatID) {
		this.currentPatID = currentPatID.trim();
		logger.info("Choose PatID:"+currentPatID);
		updateDataset();
	}
	public void setCurrentPatID(int currentPatID) {
		setCurrentPatID(String.valueOf(currentPatID));
	}


	/**
	 * @return the patiennameBirthdateString
	 */
	public String getPatiennameBirthdateString() {
		return patiennameBirthdateString;
	}


	/**
	 * @param patiennameBirthdateString the patiennameBirthdateString to set
	 */
	public void setPatiennameBirthdateString(String patiennameBirthdateString) {
		this.patiennameBirthdateString = patiennameBirthdateString;
	}


	/**
	 * @return the diagnosesString
	 */
	public String getDiagnosesString() {
		return diagnosesString;
	}


	/**
	 * @param diagnosesString the diagnosesString to set
	 */
	public void setDiagnosesString(String diagnosesString) {
		this.diagnosesString = diagnosesString;
	}


	/**
	 * @return the implantationString
	 */
	public String getImplantationString() {
		return implantationString;
	}


	/**
	 * @param implantationString the implantationString to set
	 */
	public void setImplantationString(String implantationString) {
		this.implantationString = implantationString;
	}

	/**
	 * @return OpenID Role of the user
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role The role to set of the user
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return Status, if the OpenID User is verified
	 */
	public boolean isUserOpenIdVerified() {
		return userOpenIdVerified;
	}
	/**
	 * @param userOpenIdVerified The status of the OpenIDUSer
	 */

	public void setUserOpenIdVerified(boolean userOpenIdVerified) {
		this.userOpenIdVerified = userOpenIdVerified;
	}


	/**
	 * @return the initial called URL 
	 */
	public String getCalledUrl() {
		return initialCalledUrl;
	}

	/**
	 * @param callerUrl the callerUrl to set
	 */
	public void setCallerUrl(String pInitialCalledUrl) {

		this.initialCalledUrl = pInitialCalledUrl;

	}

	/**
	 * @return the autoLogin
	 */
	public boolean isAutoLogin() {
		return autoLogin;
	}

	/**
	 * @param autoLogin the autoLogin to set
	 */
	public void setAutoLogin(boolean autoLogin) {
		this.autoLogin = autoLogin;
	}

	/**
	 * @return the icdString
	 */
	public String getIcdString() {
		return icdString;
	}


	/**
	 * @param icdString the icdString to set
	 */
	public void setIcdString(String icdString) {
		this.icdString = icdString;
	}


	/**
	 * @return the icdIDString
	 */
	public String getIcdIDString() {
		return icdIDString;
	}


	/**
	 * @param icdIDString the icdIDString to set
	 */
	public void setIcdIDString(String icdIDString) {
		this.icdIDString = icdIDString;
	}
	/**
	 * @return the iCardeaID
	 */
	public String getiCardeaID() {
		return iCardeaID;
	}

	/**
	 * @param iCardeaID the iCardeaID to set
	 */
	public void setiCardeaID(String iCardeaID) {
		this.iCardeaID = iCardeaID;
		ResultSet rs;
		try {
			rs = getStmt().executeQuery("SELECT  ID, patientIdentifier, citizenshipNumber FROM patient "+
					" where trim(citizenshipNumber)=trim("+iCardeaID+")");
			if (rs.next()) {
				this.currentPatID=rs.getString(1);
				logger.debug("Changes currrentID="+this.currentPatID);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateDataset();

	}

	/**
	 * @return the sheetStrings
	 */
	public String[] getSheetStrings() {
		return sheetStrings;
	}
	/**
	 * @return the stmt
	 */
	public Statement getStmt() {
		//fixme con =null means no DB connection, exception through
		try {
			if (conn==null){
				conn = DriverManager.getConnection(url+dbName,dbUserName,dbPassword);
				stmt=conn.createStatement();
			}else
				if (!conn.isValid(2)){
					logger.warn("JDBC Connection is invalid, try to get a new");
					conn = DriverManager.getConnection(url+dbName,dbUserName,dbPassword);
					stmt=conn.createStatement();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (stmt==null) {
			logger.fatal("No Statement created");
			throw new RuntimeException("Database is missing");
		}
		return stmt;
	}


	public Statement createStmt() {
		//TODO error handling
		try {
			return conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private void updateDataset(){

		this.patiennameBirthdateString = getDataItem("Name") + " (" + getDataItem("Date of birth") +")";
		this.diagnosesString=getDataItem("Diagnosis");
		this.implantationString=getDataItem("Date of implantation");
		this.icdString=getDataItem("CIED manufacturer");
		this.icdIDString=getDataItem("ID");


	}
	private String getDataItem(String parameter){
		//TODO keep in mind, that parameter is NOT unique withhin one patid, may be sheet have to be added
		ResultSet rs;
		String bez ="--";
		try {
			rs = getStmt().executeQuery("SELECT  dataset FROM ppmdataset  where Parameter=\""+parameter+"\" and patID="+this.currentPatID);
			if (rs.next())
				//			while (rs.next())
			{
				bez = rs.getString(1);
				logger.info(parameter+": "+bez);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bez;	
	}
	public void fillPatientList(){
		ResultSet rs=null;
		boolean birthdatecheck=false;
		patientList = new ArrayList();
		try {
			rs = getStmt().executeQuery("SELECT  ID,givenName, familyName,dateTimeOfBirth,patientIdentifier, citizenshipNumber FROM patient");

			while (rs.next()) {
				Patient cPatient = new Patient();
				cPatient.setId(rs.getInt(1));
				cPatient.setGivenName(rs.getString(2));
				cPatient.setFamilyName(rs.getString(3));
				cPatient.setDateOfBirth(rs.getString(4));
				cPatient.setCiedIdentifier(rs.getString(5));
				cPatient.setCitizenshipNumber(rs.getString(6));
				//				this.iCardeaID=cPatient.getCitizenshipNumber();
				if (this.iCardeaID!=null && this.iCardeaID.equalsIgnoreCase("191")){
					if (cPatient.getDateOfBirth()==null || cPatient.getDateOfBirth().trim().length()<7){
						cPatient.setDateOfBirth("19710310");
						birthdatecheck=true;
					}
				}
				boolean isAllowed=true;
				if (this.isUserOpenIdVerified()){
					if (false){
						//DISABLE consent test for patient list because of slow ConsentManagerImplServiceTest implementation					
						//if (testConsent){

						isAllowed = ConsentManagerImplServiceTest.getInstance().grantRequest(cPatient.getCitizenshipNumber(), role, "CIEDREPORT");
					}
					if (!isAllowed) {
						System.out.println("DENY FillList:"+cPatient);
						logger.info("DENY!!!!:"+cPatient);

						//			retrieveCIEDDataByPatientID(patientID);
					}else{//Local testting assumed	
						logger.debug("consentmager would be asked for: CitizenChip "+ cPatient.getCitizenshipNumber() + " and with Role "+ role +" for openid user ");
						patientList.add(cPatient);
						logger.info("FillList:"+cPatient);
					}
				}
			}
			if (birthdatecheck){
				try {
					logger.debug("Check Birtdate !!");
					getStmt().execute("Update patient set dateTimeOfBirth=\"19710310\" where  citizenshipNumber=\"191\" ");
				}catch (Exception e){
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info("Some Error closing Resultset, do not matter. "+ e.getMessage());
			}
		}
		return ;	

	}
	/**
	 * @param ciedSerial IDCO compatible serial numer like model:Secura/serial:PZC600368S
	 * @param fullRefID IDCO / IEEE or private  Reference like 721344^MDC_IDC_MSMT_BATTERY_VOLTAGE^MDC
	 * @param data the stored value
	 * @param timeLow  date time format yyyymmddhhmmss from this time the data value is correct
	 * @param timeHigh date time format yyyymmddhhmmss up to this time the data value is correct
	 * @return true if successfull
	 */
	public boolean addCIEDData(String ciedSerial, String fullRefID, String data, String timeLow, String timeHigh){

		int rs=-1;
		if (timeLow.length()<14 || timeHigh.length()<14) {
			//			

			logger.warn("error datetime to small:"+timeLow+":"+timeHigh);
			timeLow=timeLow+"00";
			timeHigh=timeHigh+"00";
			if (timeLow.length()<12){
				logger.warn("error timelow to small");
				return false;
			}
			if (timeHigh.length()<12){
				logger.warn("error timehight to small");
				return false;
			}

		}

		String insertString="insert into ppmpending (source,status,SerialID,dataset,FULLREFID,timelow,timehigh) values ('CIED','P',";
		logger.info("add CIED Pending:"+ciedSerial+":"+fullRefID+":"+timeLow+":"+timeHigh);
		if (data.length()<200){
			logger.info(data);
		}
		insertString=insertString+"'"+ciedSerial+"','"+data+"','"+fullRefID+"','"+timeLow.trim().substring(0,13)+"','"+timeHigh.trim().substring(0,13)+"')";
		try {
			rs= getStmt().executeUpdate(insertString);
			logger.trace(rs+":" +insertString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(rs+":" +insertString);
			logger.error("Data len:"+data.length());
			e.printStackTrace();
			return false;
		}

		return true;
	}
	public boolean addCIEDData(String ciedSerial, String fullRefID, String data){
		return addCIEDData( ciedSerial,  fullRefID,  data, "19000101120000", "21000101120000");
	}
	public boolean addCIEDData(String ciedSerial, String fullRefID, String data,String timeLow){
		return addCIEDData( ciedSerial,  fullRefID,  data, timeLow, "21000101120000");
	}

	public void checkPendingData(){

		ResultSet rsPending;
		ResultSet checkrsNew;
		ResultSet rsNew;
		ResultSet rsNew1;
		Statement stNew=createStmt();
		Statement stNew1=createStmt();
		Statement stcheckrsNew=createStmt();
		Statement stUpdates=createStmt();

		String statmentString="";
		String id="1";
		String dataset="";
		String datatype="";
		int subRefIDadder=1;
		try {
			rsPending = createStmt().executeQuery("SELECT  source,status,SerialID,dataset,fullrefid,w.timelow,w.timehigh,ID,w.localid FROM ppmpending w,patient p "+
					"where w.status='P' and trim(w.SerialID)=trim(p.patientIdentifier) and ID<>'0'"
					);
			logger.info("Check Pending Data ");
			while (rsPending.next()) {


				String currentPendingFullrefID=rsPending.getString("fullrefid");
				id= rsPending.getString("ID");
				statmentString="select * from ppmdataset where patid=trim('"+id+"')";
				checkrsNew=stcheckrsNew.executeQuery(statmentString);
				if (!checkrsNew.next()){
					logger.info("New Patient found");
					newPPMPatient(id);
				}
				checkrsNew.close();
				//new loop for subitems
				statmentString="select id, timelow,timehigh,TYPE_OF_VARIABLE,PARAMETER,patid from ppmdataset where patid=trim('"+id+"') " 
						+" and right(fullrefid,1)='^' and left('"+currentPendingFullrefID+"',length(fullrefid))=fullrefid";
				//				System.out.println(statmentString);
				logger.debug(statmentString);
				checkrsNew=stcheckrsNew.executeQuery(statmentString);
				String subRef="unknown";
				String insertROW="empty";


				while (checkrsNew.next()){
					subRefIDadder=0;
					logger.info("Subitem fullref:"+currentPendingFullrefID);
					String temp[]=currentPendingFullrefID.split("\\^");
					//					for (int ii=0;ii<temp.length;ii++){
					//						logger.info(ii+":"+temp[ii]);
					//					}
					subRef=temp[temp.length-1];
					temp=currentPendingFullrefID.split("\\#");
					try{
						if (temp.length>1){
							subRefIDadder=Integer.parseInt(temp[temp.length-1]);
						}
//						logger.info("Got ID:"+subRefIDadder);
					}catch(Exception e)
					{
						logger.warn(temp.length+" Catched Exception while trying to get SubID:"+e.getMessage()+ " from String:"+currentPendingFullrefID);
					}

					//create new subitem entry for this one
					try {
						//check if it already there

						rsNew1 = stNew1.executeQuery("select * from ppmdataset where trim(patid)='"+id+"' and fullrefid='"+currentPendingFullrefID+"'");
						if (!rsNew1.next()){
							rsNew1.close();
							rsNew1=null;
							//ok new line have to be insert
							rsNew = stNew.executeQuery("SELECT  "+ppmROW+ " FROM ppmdataset where id='"+checkrsNew.getString("id")+"'" );
							while (rsNew.next()) {
								//private String ppmROW= "SHEET,PARAMETER,DATASET,TYPE_OF_VARIABLE,EXPLANATION,SOURCE,fullrefid,PPMDATASOURCE,TIME_FRAME,FORMAT,VALIDATION,COMMENTS,SJM_COMMENTS,SORTNUMBER,SUBTITEL,BUTTONTITEL,BUTTONTABLE,USERPREF,SQLCAREPLAN,DEMODATASET_AF,TIMELOW,TIMEHIGH,PATID";
								insertROW = "INSERT INTO icardea.PPMDATASET ("+ppmROW+") values (";
								for (int i=1;i<23;i++){//CAVE count 
									switch (i){
									case 2://description
										insertROW=insertROW+"'"+rsNew.getString(i)+" "+subRef+"',";
										break;

									case 7://fullref
										insertROW=insertROW+"'"+currentPendingFullrefID+"',";
										break;
									case 18:
										insertROW=insertROW+"'"+subRef+"',";
										break;
									default:
										insertROW=insertROW+"'"+rsNew.getString(i)+"',";
										break;
									}
								}
								insertROW=insertROW+"'"+checkrsNew.getString("patid")+"')";
								stUpdates.executeUpdate(insertROW);
								//				System.out.println(insertROW);
								logger.info(insertROW);
							}
							rsNew.close();
							rsNew=null;
						}else{
							logger.info("Already inserted: "+currentPendingFullrefID);
						}

					}
					catch (SQLException e) {
						logger.error("ERROR:"+insertROW);
						e.printStackTrace();
					}					
				}

				checkrsNew.close();
				checkrsNew=null;
				statmentString="select id, timelow,timehigh,TYPE_OF_VARIABLE from ppmdataset where patid=trim('"+id
						+"') and fullrefid='"+currentPendingFullrefID+"'";
				//				System.out.println(statmentString);
				logger.debug(statmentString);
				ResultSet checkrs;

				checkrs=getStmt().executeQuery(statmentString);
				while (checkrs.next()){
					if (rsPending.getString("timehigh").compareTo(checkrs.getString("timelow")) <= 0){
						//new value high time is below actual value ignore it
						statmentString="update ppmpending set status='O' where localid="+rsPending.getInt("localid");
						stUpdates.executeUpdate(statmentString);
						//						System.out.println(statmentString);
						logger.info(statmentString);
					}else
						if 	(rsPending.getString("timelow").compareTo(checkrs.getString("timelow")) <= 0){
							//new value low time is below actual low value ignore it
							statmentString="update ppmpending set status='O' where localid="+rsPending.getInt("localid");
							stUpdates.executeUpdate(statmentString);
							//							System.out.println(statmentString);
							logger.info(statmentString);
						}else{
							//new value inserting
							dataset=rsPending.getString("dataset");
							if (dataset==null) {
								logger.error("Null Dataset");
								rsPending.close();
								return;
							}
							datatype=checkrs.getString("TYPE_OF_VARIABLE");
							if (datatype.equals("Image")){
								dataset="";
							}else if (datatype.equals("Time")){
								
								if (dataset.length()>9){//FIXME only time here, but for better vie dtm 
									dataset=PPMDataset.convTimeToPoint(dataset.substring(0,8))+" "+dataset.substring(8);
									
								}
							}else if (datatype.equals("Date")){
								if (dataset.length()>=8){
									dataset=dataset.substring(0,8);
									dataset=PPMDataset.convTimeToPoint(dataset);
									//									dataset=dataset.substring(7,8)+"."+dataset.substring(5,6)+"."+dataset.substring(0,4);
								}

							}
							logger.info("Insert datatype:"+datatype+" :"+dataset+"  pre:"+rsPending.getString("dataset"));
							statmentString="update ppmdataset set dataset='"+dataset+"',timelow='"+rsPending.getString("timelow")
									+"', timehigh='"+rsPending.getString("timehigh")
									+"', sortnumber=sortnumber+"+(100000*subRefIDadder)
									+" where id="+checkrs.getInt("id");
							stUpdates.executeUpdate(statmentString);
							logger.trace(statmentString);
							statmentString="update ppmpending set status='I' where localid="+rsPending.getInt("localid");
							stUpdates.executeUpdate(statmentString);
							logger.trace(statmentString);
						}

				}
				checkrs.close();
				checkrs=null;

				//				statmentString="Update EHR Data";
				//				logger.debug(statmentString);
				//				this.updatePPM_EHR_Data(id);
				//easier garbage collection
			}
			statmentString="Update EHR Data";
			logger.debug(statmentString);
			this.updatePPM_EHR_Data(id);

			rsPending.close();
			rsPending=null;
			stcheckrsNew.close();
			stNew.close();
			stNew1.close();
			stUpdates.close();
		} catch (SQLException e) {
			logger.error(statmentString);
			e.printStackTrace();
		}



	}

	private void newPPMPatient(String patid){	
		ResultSet rs;
		String insertROW ="";
		//		System.out.println("Add PPMDataset for patid="+patid);
		logger.info("Add PPMDataset for patid="+patid);
		try {
			//			System.out.println("SELECT  "+ppmROW+ " FROM ppmdataset where trim(patid)='0' " );
			rs = createStmt().executeQuery("SELECT  "+ppmROW+ " FROM ppmdataset where trim(patid)=0 " );
			while (rs.next()) {
				insertROW = "INSERT INTO icardea.PPMDATASET ("+ppmROW+") values (";
				for (int i=1;i<23;i++){//CAVE count 
					insertROW=insertROW+"'"+rs.getString(i)+"',";
				}
				insertROW=insertROW+"'"+patid+"')";
				getStmt().executeUpdate(insertROW);
				//				System.out.println(insertROW);
				logger.debug(insertROW);
			}
			updatePPM_EHR_Data(patid);

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			//			System.out.println("ERROR:"+insertROW);
			logger.error("ERROR:"+insertROW);
			e.printStackTrace();
		}
	}
	private boolean updatePPM_EHR_Data(String patid) throws SQLException{
		ResultSet rs;
		String code=null;
		//FIXME missing EHR etc. data to insert in iniital ppmdataset
		rs = createStmt().executeQuery("SELECT  * FROM patient where id= "+patid );
		if (rs.next()){
			setDataItem(patid,"Name",rs.getString("familyName")+","+rs.getString("givenName"));
			setDataItem(patid,"Date of birth",convTimeToPoint(rs.getString("dateTimeOfBirth")));
			//			if (rs.getString("citizenshipNumber").equalsIgnoreCase("191")){
			//				if (rs.getString("dateTimeOfBirth").length()<7)
			//				{
			//					setDataItem(patid,"Date of birth","10.03.1971");
			//				}
			//			}
		}
		rs.close();
		rs = createStmt().executeQuery("SELECT  * FROM history where patid= "+patid +" and problemValue in "+
				"('C0085298','C0242698') "+
				" order by effectiveTimeLow");
		if (rs.next()){
			setDataItem(patid,"Diagnosis",rs.getString("text"));
		}else{
			logger.warn("No Maindiagnosis found for patient:"+patid);
		}
		rs.close();
		rs= createStmt().executeQuery("select id,drugCode from medication where length(trim(text))<2 or text like('unknown (Code=%')");
		while (rs.next()){
			code=rs.getString("drugCode");
			if (code!=null) {
				if (code.length()>0){
					ResultSet rs2=createStmt().executeQuery("select text from medication where drugCode='"+code+"'");
					if (rs2.next()){
						String medtext=rs2.getString("text");
						if (medtext!=null){
							logger.debug("Setting medication text to "+medtext);
							createStmt().execute("update medication set text='"+medtext+"' where id="+rs.getInt("id"));
						}
					}else{
						createStmt().execute("update medication set text='unknown (Code="+code+")' where id="+rs.getInt("id"));
					}
					rs2.close();
					rs2=null;
				}
			}
		}
		rs.close();
		rs=null;
		return true;
	}
	private boolean setDataItem(String patid,String dataitem, String dataset)  {
		String updateString="update ppmdataset set dataset='"+dataset+"' where Parameter='"+dataitem+"' and patid="+patid;
		try {
			getStmt().executeUpdate(updateString);
			logger.trace(updateString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("ERROR:"+updateString);
			e.printStackTrace();
		}
		return true;

	}

	/**
	 * 
	 * @param pPatientID The PatientID for which the Pattern should be identified
	 * @return false, if there is not a single valid pattern for the Patient 
	 */

	public ArrayList<DactPatternDataSet>  getPatternStatus(int pPatientID){
		// Boolean indicating if one valid pattern was found
		boolean retVal = false;
		ArrayList<DactPatternDataSet> patternList = new ArrayList<DactPatternDataSet>();

		String sqlString = "";
		ResultSet rs=null;
		//1. Pattern anfragen
		sqlString = "select t1.pattern_id,  t1.prerequisite_db_relations, t1.prerequisiute_db_attributes from dact_pattern as t1 where t1.active = true";
		logger.debug("SQL Pattern anfragen: " + sqlString);
		try{
			rs = createStmt().executeQuery(sqlString);
			while(rs.next()){
				DactPatternDataSet currentPattern = new DactPatternDataSet();
				currentPattern.patternID = rs.getInt("pattern_id");
				logger.debug("PAtternVAlues: IP" + currentPattern.patternID);
				currentPattern.preReqRelations= rs.getString("prerequisite_db_relations");
				logger.debug("PAtternVAlues: " +currentPattern.preReqRelations);
				currentPattern.preReqAttributes= rs.getString("prerequisiute_db_attributes");
				logger.debug("PAtternVAlues: " +currentPattern.preReqAttributes);
				patternList.add(currentPattern);
			}
			// look for patterns of user

			for(DactPatternDataSet iterDactPattern:patternList ){ 

				sqlString = "select distinct t1.pattern_id from dact_pattern as t1 "
						+iterDactPattern.preReqRelations 
						+" where " + iterDactPattern.preReqAttributes + pPatientID +" and t1.pattern_id = "+iterDactPattern.patternID +";";
				logger.debug("SQL pattern: " + sqlString);
				rs = createStmt().executeQuery(sqlString);
				if(rs.next()){
					Integer patternID = rs.getInt("pattern_id");
					logger.debug("Following Pattern is useful: " + iterDactPattern.patternID);	
					iterDactPattern.preReqFullFilled = true;
				}
				else{
					logger.debug("Following Pattern is useless: " + iterDactPattern.patternID);	
					iterDactPattern.preReqFullFilled = false;
				}
			}


			// 3. Aufbereiten der Pattern die Anzeige
			for(DactPatternDataSet iterDactPattern:patternList ){
				sqlString ="";
				// PreRequisites are fullfilled for Patient
				if (iterDactPattern.preReqFullFilled){
					sqlString = "SELECT  t1.pattern_id,   t1.prerequisite_view," +
							" t1.conclusion_db_attribute,  t1.conclusion_db_relation," +
							" t1.confidence_view,  t1.conclusion_view, t1.support_view," +
							" t1.approvedstatus_view, t1.creationdate,  t1.creationsource," +
							"  t1.active " +
							"FROM dact_pattern as t1" +
							"  where t1.pattern_id = " +iterDactPattern.patternID;
					rs = createStmt().executeQuery(sqlString);
					if(rs.next()){
						//Store data
						iterDactPattern.viewPreReq =  rs.getString("prerequisite_view");
						iterDactPattern.conCluAttribute =  rs.getString("conclusion_db_attribute");
						iterDactPattern.concluRelation =  rs.getString("conclusion_db_relation");
						iterDactPattern.viewConf =  rs.getString("confidence_view");
						iterDactPattern.viewConclu =  rs.getString("conclusion_view");
						iterDactPattern.viewSupport =  rs.getString("support_view");
						iterDactPattern.viewApproved =  rs.getString("approvedstatus_view");
						iterDactPattern.creationDate =  rs.getString("creationdate");
						iterDactPattern.creationSource =  rs.getString("creationsource");
						iterDactPattern.active =  rs.getBoolean("active");
						logger.debug("Pattern; " +iterDactPattern);

						if(rs.next()){
							logger.error("Threre where multiple Lines for on PatternId in dact_pattern. Primary Key problem! for PatternID"+iterDactPattern.patternID);
						}
					}
					else{
						logger.error("There was no line but had to be for PattternID:"+iterDactPattern.patternID);
					}
					// Check, if the whole pattern is already fullfilled by the patient
					sqlString="";
					sqlString = "select distinct t1.pattern_id from dact_pattern as t1 "
							+iterDactPattern.concluRelation 
							+" where " + iterDactPattern.conCluAttribute + pPatientID +" and t1.pattern_id = "+iterDactPattern.patternID +";";
					logger.debug("SQL pattern: " + sqlString);
					rs = createStmt().executeQuery(sqlString);
					if(rs.next()){
						Integer patternID = rs.getInt("pattern_id");
						logger.debug("Following Pattern is fullfillen in totoal: " + iterDactPattern.patternID);	
						iterDactPattern.validForPat = true;
					}
					else{
						logger.debug("Following Pattern conclusion is not fullfilled: " + iterDactPattern.patternID);	
						iterDactPattern.validForPat = false;
					}	
				} // End of IF PreReqFullfilled
			}// End of Step 3
		}// end of try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("Major error. Restart could help: "+e.getMessage());;
			}
		}
		// Demo output:
		logger.debug("Following Patterns where found for patient " + pPatientID);
		for(DactPatternDataSet iterDactPattern:patternList ){

			logger.debug(iterDactPattern.toHealthCareActorString());

		}
		return patternList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] testStrings;
		List<String>  mySheetsList = new ArrayList<String>();
		String[] mysheetStrings;

		//		System.out.println("Start Login getInstance ");
		//		String username="http://134.106.52.9:4545/idp/u="+"user";
		//		username="https://www.google.com/accounts/o8/id";
		//
		//		//		 username="http://athiel.meinguter.name";
		//		System.out.println("##############AT Discovery for: "+username);
		//		DiscoveryInformation discovery = RegistrationService
		//				.performDiscoveryOnUserSuppliedIdentifier(username);
		//		System.out.println("##############AT GOT Discovery for:");
		//		String url = RegistrationService.getReturnToUrl();
		//		System.out.println("##############AT return url:"+url);
		//
		//		AuthRequest authRequest = RegistrationService.createOpenIdAuthRequest(discovery, url);
		//		System.out.println("##############AT authrequested");
		//		String redirectUrl = authRequest.getDestinationUrl(true);
		//		System.out.println("##############AT authrequested redirect url:"+redirectUrl);

		System.out.println("Start PPMDataset getInstance ");

		PPMDataset ppmDataset =PPMDataset.getInstance();
		//		System.out.println("Show Sheets:" + ppmDataset.getSheetStrings());
		if (ppmDataset.checkDB())
		{
			ppmDataset.setCurrentPatID(2);
			mySheetsList=new ArrayList(Arrays.asList(ppmDataset.getSheetStrings()));
			try {
				ResultSet rs = ppmDataset.getStmt().executeQuery("SELECT  sheet FROM ppmdataset  group by sheet order by userpref,sortnumber");
				//			while (rs.next()) {
				//
				//				String bez = rs.getString(1);
				//				System.out.println("Sheet: "+bez);
				//				mySheetsList.add(bez);
				//			}
				for (String aktsheet : mySheetsList) {
					PPMRowModel[] allRows= ppmDataset.getRows(aktsheet);
					logger.info("++++++++++++++++++++Show Sheets:" + aktsheet);
					for (int i=0;i<allRows.length;i++){
						if (!allRows[i].getContent().equalsIgnoreCase("--"))
							logger.info(allRows[i].getName()+":\t"+allRows[i].getContent());
						//					System.out.println(aktsheet+"#"+i+":"+allRows[i]);
					}



				}
				//FIXME Use PateintID
				ppmDataset.getPatternStatus(2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.debug(e);
				//logger.debug("No Sheets");
			}
			if (false){
				ppmDataset.addCIEDData("model:Secura/serial:PZC600368S", "720897^MDC_IDC_PG_TYPE^MDC", "CIED");
				ppmDataset.addCIEDData("model:Secura/serial:PZC600368S","720900^MDC_IDC_PG_MFG^MDC","Medtronic");
				ppmDataset.addCIEDData("model:Secura/serial:PZC600368S","721344^MDC_IDC_MSMT_BATTERY_VOLTAGE^MDC","2.94");
				ppmDataset.addCIEDData("model:Secura/serial:PZC600368S","720898^MDC_IDC_PG_MODEL^MDC","Secura");
				ppmDataset.addCIEDData("model:unbekannt/serial:000", "720897^MDC_IDC_PG_TYPE^MDC", "unbekannt");
				ppmDataset.addCIEDData("model:unbekannt/serial:000", "720897^MDC_IDC_PG_TYPE^MDC", "unbekannt", "20110101123456000","20110101123456000");
				ppmDataset.addCIEDData("model:Secura/serial:PZC600368S","721344^MDC_IDC_MSMT_BATTERY_VOLTAGE^MDC","20001010101010", "20001010101010");
				ppmDataset.addCIEDData("model:Secura/serial:PZC600368S","721344^MDC_IDC_MSMT_BATTERY_VOLTAGE^MDC","20101010101010", "20101010101010");


				ppmDataset.addCIEDData("model:Maximo/serial:D284DRG", "720897^MDC_IDC_PG_TYPE^MDC", "CIED");
				ppmDataset.checkPendingData();

			}else{
				//FIXME Auskommentiert DACT
				//ppmDataset.checkPendingData();
			}
		}else{
			logger.info("Database created");
		}

	}

	private void fillStatements(){
		dropPPMDataset="drop table  if exists icardea.PPMDATASET; ";
		dropPPMPending="drop table  if exists icardea.PPMPENDING; ";
		String replaceInto=" REPLACE INTO ppmdataset (SHEET,PARAMETER,DATASET,TYPE_OF_VARIABLE,EXPLANATION,SOURCE,FULLREFID,PPMDATASOURCE,TIME_FRAME,FORMAT,VALIDATION,COMMENTS,SJM_COMMENTS,PATID,SORTNUMBER,SUBTITEL,BUTTONTITEL,BUTTONTABLE,USERPREF,SQLCAREPLAN,DEMODATASET_AF,TIMELOW,TIMEHIGH) VALUES ";
		createPPMDataset = "CREATE TABLE icardea.PPMDATASET (   SHEET VARCHAR(20),   PARAMETER VARCHAR(50),   DATASET LONGTEXT,   TYPE_OF_VARIABLE TEXT,   EXPLANATION TEXT,   SOURCE TEXT,   FULLREFID TEXT,   PPMDATASOURCE TEXT,   TIME_FRAME TEXT,   FORMAT TEXT,   VALIDATION TEXT,   COMMENTS TEXT,   SJM_COMMENTS TEXT,   PATID TEXT,   SORTNUMBER INTEGER,   SUBTITEL TEXT,   BUTTONTITEL TEXT,   BUTTONTABLE TEXT,   USERPREF TEXT,   SQLCAREPLAN TEXT,   DEMODATASET_AF TEXT,   TIMELOW TEXT,   TIMEHIGH TEXT,   ID INTEGER NOT NULL  AUTO_INCREMENT,   PRIMARY KEY (ID) );";
		createPPMPending = "CREATE TABLE icardea.PPMPENDING (   SerialID TEXT,   DATASET LONGTEXT,   SOURCE TEXT,   FULLREFID TEXT,   PATID TEXT,   TIMELOW TEXT,   TIMEHIGH TEXT,   STATUS CHAR,   localid MEDIUMINT NOT NULL AUTO_INCREMENT,    PRIMARY KEY (localid)   );";
		createDACT = "CREATE TABLE dact_counter (   dactcounter INTEGER(11) NOT NULL AUTO_INCREMENT,   calltime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,   username TEXT,   PRIMARY KEY (dactcounter) ); "+
				"CREATE TABLE dact_pattern (   pattern_id int(11) NOT NULL AUTO_INCREMENT COMMENT 'AutoIcrementID for the pattern',   prerequisite_db_relations text NOT NULL COMMENT 'Prerequisite for comparing to Database values',   prerequisiute_db_attributes text NOT NULL COMMENT 'The values for the attribute exchange',   prerequisite_view text COMMENT 'Prerequiste for showing to healthcare professionel',   conclusion_db_relation text NOT NULL COMMENT 'the attribute values',   conclusion_db_attribute text NOT NULL COMMENT 'Conclusion for Database comparision. Could be used for showing patterns, that are also true for this patient',   confidence_view text COMMENT 'Cofidence to show to the healthcare actor',   conclusion_view text COMMENT 'The conclusion of the view to be shown to the healthcare actor',   support_view text COMMENT 'Support to be shown to the healtchare actor',   approvedstatus_view text COMMENT 'Show the status of the pattern (approved rejected) to the healthcare actor',   validforpatient boolean DEFAULT NULL COMMENT 'Flag to show, if the pattern in total (prerequisuite and conclusion) is valid for the patient',   creationdate date DEFAULT NULL COMMENT 'Date of creation of the pattern YYYY-MM-DD',   creationsource text COMMENT 'Name of the Source / Analysisprocess that created the pattern',   active boolean NOT NULL COMMENT 'Boolean to enable or disable the usage of a pattern',   PRIMARY KEY (pattern_id) ) COMMENT='Information for patterns and comparing to CaremanagementDB' ";
		createVIEWS="create OR REPLACE view icardea.medications as select  m.doseQuantity val, m.effectiveTime effectiveTimeLow, m.effectiveTimeHigh effectiveTimeHigh,concat(m.text ,' ', m.doseQuantity,' mg',IF(ehr.isEHR=0,' (from PHR)',' (from EHR)')) text,ehr.isEHR ,p.id patid from Medication m,Patient p, EHRPHRData ehr where  p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID and careProvisionCode=\"MEDLIST\" and ehr.isEHR=1 order by m.text,m.effectiveTime,m.effectiveTimeHigh ;"
				+" create  OR REPLACE view icardea.Compliance as   select  0 val,  m.effectiveTime effectiveTimeLow, m.effectiveTimeHigh effectiveTimeHigh, concat(m.text, ' taken ',m.doseQuantity,' mg prescribed ' ,m2.doseQuantity,' mg') text, ehr.isEHR ,ehr2.isEHR isEHr2,p.id patid from Medication m, Medication m2,Patient p, EHRPHRData ehr, EHRPHRData ehr2 where  p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID and ehr2.id=m2.EHRPHRDataID and  m.drugcode=m2.drugcode  and ehr.isEHR=0 and ehr2.isEHR=1 and (cast(`m`.`doseQuantity` as DECIMAL(50,3)) <> cast(`m2`.`doseQuantity` as DECIMAL(50,3))) order by m.text,m.effectiveTime,m.effectiveTimeHigh ;  "
				+" create  OR REPLACE view icardea.symptoms as     select  0 val,  m.problemValueOriginalText text,m.effectiveTimeLow, m.effectiveTimeHigh ,p.id patid from Problem m,Patient p, EHRPHRData ehr where p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID  and ehr.IsEHR=1 and problemCode=\"409586006\" order by m.effectiveTimeLow; "
				+" create  OR REPLACE view icardea.problems as     select  0 val,  m.problemValueOriginalText text,m.effectiveTimeLow, m.effectiveTimeHigh ,p.id patid from Problem m,Patient p, EHRPHRData ehr where p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID  and (problemCode=\"409586006\" or problemCode=\"C0277786\") order by m.effectiveTimeLow; "
				+" create  OR REPLACE view icardea.history as      select  0 val,  m.problemValueOriginalText text,m.effectiveTimeLow, m.effectiveTimeHigh ,p.id patid , m.problemValue, m.problemValueCodeSystem from Problem m,Patient p, EHRPHRData ehr where p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID  and ehr.IsEHR=1 and problemCode=\"409586006\" order by m.effectiveTimeLow; "
				+" create  OR REPLACE view icardea.activies as     select  0 val,  m.problemValueOriginalText text,m.effectiveTimeLow, m.effectiveTimeHigh ,p.id patid from Problem m,Patient p, EHRPHRData ehr where p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID  and ehr.IsEHR=0 and problemCode=\"404684003\" order by m.effectiveTimeLow; "
				+" create  OR REPLACE view icardea.patcomment as   select  0 val,  m.problemValueOriginalText text,m.effectiveTimeLow, ' ' effectiveTimeHigh ,p.id patid from Problem m,Patient p, EHRPHRData ehr where p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID  and ehr.IsEHR=0 and problemCode=\"404684003\" order by m.effectiveTimeLow;  "
				+" create  OR REPLACE view icardea.BodyWeight as   select m.value val, concat(m.value,' ',m.unit,IF(ehr.isEHR=0,' (from PHR)',' (from EHR)')) text, m.effectivetime effectiveTimeLow, ' 'effectiveTimeHigh ,p.id patid from vitalsign m,Patient p, EHRPHRData ehr where p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID and (m.careprovisioncode=\"COBSCAT\" or m.careprovisioncode=\"3141-9\") order by m.effectivetime;  "
				+" create  OR REPLACE view icardea.SystolicBlood as   select  m.value val, concat(m.value,' ',m.unit,IF(ehr.isEHR=0,' (from PHR)',' (from EHR)')) text, m.effectivetime effectiveTimeLow, ' 'effectiveTimeHigh ,p.id patid from vitalsign m,Patient p, EHRPHRData ehr where p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID and ( m.careprovisioncode=\"8480-6\") order by m.effectivetime;  "
				+" create  OR REPLACE view icardea.DiastolicBlood as   select  m.value val, concat(m.value,' ',m.unit,IF(ehr.isEHR=0,' (from PHR)',' (from EHR)')) text, m.effectivetime effectiveTimeLow, ' 'effectiveTimeHigh ,p.id patid from vitalsign m,Patient p, EHRPHRData ehr where p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID and ( m.careprovisioncode=\"8480-4\") order by m.effectivetime; "
				+" create  OR REPLACE view icardea.heartrate as   select  m.value val, concat(m.value,' ',m.unit,IF(ehr.isEHR=0,' (from PHR)',' (from EHR)')) text, m.effectivetime effectiveTimeLow, ' 'effectiveTimeHigh ,p.id patid from vitalsign m,Patient p, EHRPHRData ehr where p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID and ( m.careprovisioncode=\"8867-4\") order by m.effectivetime;  "
				+" create  OR REPLACE view icardea.labresult as   select m.labresultvalue val, concat(m.labresultvalue,'  ',m.labresulttext) text, m.effectivetime effectiveTimeLow, ' 'effectiveTimeHigh ,p.id patid from imagingresult m,Patient p, EHRPHRData ehr where p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID order by m.effectivetime;  " 
				+" create  OR REPLACE view icardea.Contraindication as   select 0 val, m.allergyOriginalText text,m.effectiveTimeLow, m.effectiveTimeHigh ,p.id patid from Concern m,Patient p, EHRPHRData ehr where p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID  order by m.effectiveTimeLow; "
				+" create  OR REPLACE view icardea.procedures as   select  0 val, m.proceduretext text,m.effectiveTimeLow, m.effectiveTimeHigh ,p.id patid  from `procedure` m,Patient p, EHRPHRData ehr  where p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID   order by m.effectiveTimeLow;"
				+" create  OR REPLACE view icardea.fullmedications as select  m.doseQuantity val, m.effectiveTime effectiveTimeLow, m.effectiveTimeHigh effectiveTimeHigh,concat(m.text ,' ', m.doseQuantity,' mg',IF(ehr.isEHR=0,' (from PHR)',' (from EHR)')) text,ehr.isEHR ,p.id patid from Medication m,Patient p, EHRPHRData ehr where  p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID and careProvisionCode=\"MEDLIST\" order by m.effectiveTime,m.effectiveTimeHigh,m.text ;"
				+" create  OR REPLACE view icardea.medicationsPHR as select  m.doseQuantity val, m.effectiveTime effectiveTimeLow, m.effectiveTimeHigh effectiveTimeHigh,concat(m.text ,' ', m.doseQuantity,' mg') text,ehr.isEHR ,p.id patid from Medication m,Patient p, EHRPHRData ehr where  p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID and careProvisionCode=\"MEDLIST\" and ehr.isEHR=0 order by m.text,m.effectiveTime,m.effectiveTimeHigh ;"
				+" create  OR REPLACE view icardea.prescriptions as select  m.doseQuantity val, m.effectiveTime effectiveTimeLow, m.effectiveTimeHigh effectiveTimeHigh,concat(m.text ,' ', m.doseQuantity,' mg') text,ehr.isEHR ,p.id patid from Medication m,Patient p, EHRPHRData ehr where  p.id=ehr.Patientid and ehr.id=m.EHRPHRDataID and careProvisionCode=\"MEDLIST\" and ehr.isEHR=1 order by m.text,m.effectiveTime,m.effectiveTimeHigh ;";
		//				+" CREATE OR REPLACE  VIEW icardea.dact AS SELECT '201105121200' as effectivetimelow, '' as effectivetimehigh, CONCAT_WS('; ',  CONCAT('Vorbedingung: ', t1.prerequisite),  CONCAT('Folgerung: ' , t1.conclusion),  CONCAT('% Zuversicht: ' ,  t1.confidence),  CONCAT('Patienten: ' , t1.support)) as text,  5 as val,  1 as patid FROM   dact_raw as t1;";

		createInitial=  replaceInto +" ( 'Overview','Name','--','Text','Name of the patient','CIED / EHR / PHR','','','fixed value','','','','can be filled out during implant (ASCII) or FU','0',1,'Overview','','','','','Andreas Schmidt','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','ID','--','Numeric','Hospitals ID number','EHR','','','fixed value','F8.0','Depends on each institution, but usually it has >3 digits and <9','','is caluclated from birthdate and used for statistsics','0','2','Overview','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Age','--','Numeric','Age of the patient at the time of interrogation','EHR','','','','F3.0','>2 and <110','Calculated item: date of interrogation - date of birth','no constraint in SJM devices','0','3','Overview','','','','','57','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Diagnosis','--','Text','Main diagnosis of the patient','EHR','','','fixed value','','','Reason for implantation of the device','','0','4','Overview','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Date of implantation','--','Date','Date of implantation','CIED / EHR','720901^MDC_IDC_PG_IMPLANT_DT^MDC','','fixed value','DD-MM-YYYY','> Date of birth','','field can be set during implant or followup','0','5','Overview','','','','','20.11.2009','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Date of battery exchange','--','Date','Date of battery exchange','CIED / EHR','180101^ICARDEA_IDC_PG_BATTERY EXCHANGE_DTM^ICARDEA','','latest value','DD-MM-YYYY','> Date of implantation','Show ONLY if there has been a battery exchange (if the information is not blank)','autoamtic or during implant/fup','0','6','Overview','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Type of device','--','Categoric','PM / ICD / CRT-P / CRT-D','CIED / EHR','720897^MDC_IDC_PG_TYPE^MDC','','fixed value','Nominal','','','automatic value','0','7','Overview','','','','','A dual chamber St Jude Current excel DR with serial number 525113','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','CIED manufacturer','--','Categoric','Medtronic / SJM','CIED / EHR','720900^MDC_IDC_PG_MFG^MDC','','fixed value','Nominal','','There are others in the market (Biotronik, Boston, etc,) but for the current project we are only using these two','automatic value','0','8','Overview','','','','','SJM','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Model','--','Categoric','for types - ASK Medtronic & SJM','CIED / EHR','720898^MDC_IDC_PG_MODEL^MDC','','fixed value','Nominal','','','automatic value','0','9','Overview','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Battery Voltage','--','Numeric','(volts) SHOW IN PARANTHESES (ERI and EOL limits for the specific model - Ask Medtronic & SJM)','CIED','721344^MDC_IDC_MSMT_BATTERY_VOLTAGE^MDC','','latest value','F3.2','>1.00 and <4.00 - Check the exact limits with Medtronic & SJM','Check with Medtronic and SJM, because I believe that they are in the process of changing the parameter for the evaluation of the battery longevity','depends on device 2.4 Volt in descibed case','0','11','Measured Parameters','','','','','3,2V','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Battery Impedance','--','Numeric','Battery Impedance','CIED','721408^MDC_IDC_MSMT_BATTERY_IMPEDANCE^MDC','','latest value','','Check limits with Medtronic & SJM','Check with Medtronic and SJM, because I believe that they are in the process of changing the parameter for the evaluation of the battery longevity','-','0','12','Measured Parameters','','','','','-','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Magnet rate','--','Numeric','for pacemakers (bpm)','CIED','180201^ICARDEA_IDC_MSMT_MAGNET_RATE^ICARDEA ','','latest value','F3.0','<110 and >50','','upper rate limit? Is higher than 110!','0','13','Measured Parameters','','','','','-','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Charge time','--','Numeric','for ICDs (seconds)','CIED','721728^MDC_IDC_MSMT_CAP_CHARGE_TIME^MDC','','latest value','F3.1','>6.0 and <35 seconds','','28 sec or 32 sec','0','14','Measured Parameters','','','','','9 sec','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Date of last capacitor charge','--','Date','Date that the above variable was measured','CIED','721664^MDC_IDC_MSMT_CAP_CHARGE_DTM^MDC','','latest value','DD-MM-YYYY','> Date of implantation','','set automatic','0','15','Measured Parameters','','','','','na','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','RA lead impedance','--','Numeric','Impedance of the atrial lead','CIED','722432^MDC_IDC_MSMT_LEADCHNL_RA_IMPEDANCE_VALUE^MDC','','latest value and prior review value','F4.0','For valid limits, ask Medtronic & SJM','Some patients may not have an atrial lead implanted','200-2000 Ohm','0','16','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','RA lead P wave amplitude','--','Numeric','Amplitude of the atrial lead signal','CIED','180202^ICARDEA_IDC_MSMT_LEADCHNEL_RA_PWAVE_AMPLITUDE^ICARDEA','','latest value and prior review value','F2.1','<15.0 and >0.1','Some patients may not have an atrial lead implanted','-','0','17','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','RA lead pacing','--','Numeric','Pacing threshold of the atrial lead','CIED','722176^MDC_IDC_MSMT_LEADCHNL_RA_PACING_THRESHOLD_AMPLITUDE^MDC','','latest value and prior review value','F2.1','<5.0','Some patients may not have an atrial lead implanted','-','0','18','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','RV lead defribrillation impedance','--','Numeric','Defibrillation impedance of the right ventricular lead','CIED','180203^ICARDEA_IDC_MSMT_LEADCHNEL_RV_DEFRIBRILLATION_IMPENDENCE^ICARDEA ','','latest value and prior review value','F2.0','For valid limits, ask Medtronic & SJM','Patients without an ICD (only PM functions) will not have this parameter','20-200 Ohm','0','19','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','RV lead pacing impedance','--','Numeric','Pacing impedance of the right ventricular lead','CIED','722433^MDC_IDC_MSMT_LEADCHNL_RV_IMPEDANCE_VALUE^MDC','','latest value and prior review value','F4.0','For valid limits, ask Medtronic & SJM','','200-2000 Ohm','0','20','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','RV lead R wave amplitude','--','Numeric','Amplitude of the right ventricular lead signal','CIED','180204^ICARDEA_IDC_MSMT_LEADCHNEL_RV_RWAVE_AMPLITUDE^ICARDEA ','','latest value and prior review value','F2.1','<15.0 and >0.1','','-','0','21','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','RV lead pacing threshold','--','Numeric','Pacing threshold of the right ventricular lead','CIED','722177^MDC_IDC_MSMT_LEADCHNL_RV_PACING_THRESHOLD_AMPLITUDE^MDC','','latest value and prior review value','F2.1','<5.0','','-','0','22','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','LV lead pacing impedance','--','Numeric','Pacing impedance of the left ventricular lead','CIED','722435^MDC_IDC_MSMT_LEADCHNL_LV_IMPEDANCE_VALUE^MDC','','latest value and prior review value','F4.0','For valid limits, ask Medtronic & SJM','Some patients may not have a left ventricular lead implanted','200-2000 Ohm','0','23','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','LV lead R wave amplitude','--','Numeric','Amplitude of the left ventricular lead signal','CIED','180205^ICARDEA_IDC_MSMT_LEADCHNEL_LV_RWAVE_AMPLITUDE^ICARDEA ','','latest value and prior review value','F2.1','<15.0 and >0.1','Some patients may not have a left ventricular lead implanted','-','0','24','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','LV lead pacing threshold','--','Numeric','Pacing threshold of the left ventricular lead','CIED','722179^MDC_IDC_MSMT_LEADCHNL_LV_PACING_THRESHOLD_AMPLITUDE','','latest value and prior review value','F2.1','<5.0','Some patients may not have a left ventricular lead implanted','-','0','25','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Percentage of AS','--','Numeric','% of atrial sensing','CIED','180206^ICARDEA_IDC_MSMT_AS_PERCENT^ICARDEA','','latest value','F3.0','0 - 100','Some patients may not have an atrial lead implanted','summed up autovalue','0','26','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Percentage of AP','--','Numeric','% of atrial pacing','CIED','180207^ICARDEA_IDC_MSMT_AP_PERCENT^ICARDEA','','latest value','F3.0','0 - 100','Some patients may not have an atrial lead implanted','summed up autovalue','0','27','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Percentage of RVS','--','Numeric','% of right ventricular sensing','CIED','180208^ICARDEA_IDC_MSMT_RVS_PERCENT^ICARDEA','','latest value','F3.0','0 - 100','','summed up autovalue','0','28','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Percentage of RVP','--','Numeric','% of right ventricular pacing','CIED','180209^ICARDEA_IDC_MSMT_RVP_PERCENT^ICARDEA','','latest value','F3.0','0 - 100','','summed up autovalue','0','29','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Percentage of LVS','--','Numeric','% of left ventricular sensing','CIED','180210^ICARDEA_IDC_MSMT_LVS_PERCENT^ICARDEA','','latest value','F3.0','0 - 100','Some patients may not have a left ventricular lead implanted','summed up autovalue','0','30','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); ";

		createInitial=createInitial+replaceInto +" ( 'Overview','Percentage of LVP','--','Numeric','% of left ventricular pacing','CIED','180211^ICARDEA_IDC_MSMT_LVP_PERCENT^ICARDEA  ','','latest value','F3.0','0 - 100','Some patients may not have a left ventricular lead implanted','summed up autovalue','0','31','Measured Parameters','','','','','PDF','19000101120000','21000101120000'); "
				//
				+replaceInto +" ( 'Overview','SVT','--','Numeric','Number of episodes classified as SVT','CIED','739568^MDC_IDC_EPISODE_TYPE^MDC (SVT)','','latest value','F3.0','','','autovalue','0','33','Arrhytmia Episodes','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','AF / AT','--','Numeric','Number of episodes classified as AF / AT','CIED','739568^MDC_IDC_EPISODE_TYPE^MDC (AT/AF)','','latest value','F3.0','','','autovalue plus histogram data','0','34','Arrhytmia Episodes','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','VT','--','Numeric','Number of episodes classified as VT / VF','CIED','739568^MDC_IDC_EPISODE_TYPE^MDC (VT)','','latest value','F3.0','','','autovalue','0','35','Arrhytmia Episodes','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','PMT','--','Numeric','Number of episodes classified as pacemaker mediated tachycardia','CIED','180301^ICARDEA_IDC_EPISODE_PMT^ICARDEA','','latest value','F3.0','','','autovalue','0','36','Arrhytmia Episodes','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','SVT treated','--','Numeric','Number of episodes classified as SVT treated','CIED','180302^ICARDEA_IDC_EPISODE_TREATED_SVT^ICARDEA','','latest value','F3.0','','','autovalue','0','37','Arrhytmia Episodes','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','VT treated','--','Numeric','Number of episodes classified as VT / VF treated','CIED','180303^ICARDEA_IDC_EPISODE_TREATED_VT^ICARDEA','','latest value','F3.0','','','autovalue','0','38','Arrhytmia Episodes','','','','','PDF','19000101120000','21000101120000'); "
//
				+replaceInto +" ( 'Overview','Safety alerts','--','Text','Safety alerts detected by the device','CIED','180304^ICARDEA_IDC_EPISODE_SAFETY_ALERTS^ICARDEA','','','','','','warning message during interrogation','0','40','Alerts','','','','','PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','NYHA functional class','--','Categoric','Functional class according to the New York Heart Association Classification (I -IV)','PHR','','','latest value','Ordinal','I, II, III or IV','In the PHR a questionnare could be filled, with simple questions to obtain this parameter','','0','42','Clinical Status','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','QOL score','--','Numeric','Quality of Life test score','PHR','','','latest value','F3.0','0 - 105','The QOL test could be on the PHR to be filled by SOME patients (those with HF) before the review date','','0','43','Clinical Status','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Hospital admissions','--','Numeric','Any hospital admissions since prior visit','EHR / PHR','','','latest value','F1.0','','Should include both the EHR information and the PHR s because the patient may have been admitted at a different facility','','0','44','Clinical Status','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'Overview','Medications','--','List','Current medical treatment of the patient','EHR / PHR','','','latest value','','','Could also underline or show the medication that has been changed','','0','45','Clinical Status','Medications','Medications','','','Nexium 20 mg,Thrombo ass 100 mg Aspirin, Plavix 75 mg,  Nomexor (Nebivolol), - Simvastatin 20 mg','19000101120000','21000101120000'); "
				//only at/af
				+replaceInto +" ( 'AF/AT','Nr of episodes','--','Numeric','Number of episodes','CIED','737952^MDC_IDC_STAT_EPISODE_TYPE^MDC^AT/AF','','latest value','F3.0','','Maybe it would be useful to have a diagram with the number of episodes, how they were classified and their treatment','','0','47','AF/AT','','','','','1','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Date of episode','--','Date','Date of each episode','CIED','739552^MDC_IDC_EPISODE_DTM^MDC^AT/AF','','latest value','DD-MM-YYYY','','Show it in a chart','','0','48','AF/AT','','','','','22.03.2010','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Time of episode','--','Time','Time of each episode','CIED','739552^MDC_IDC_EPISODE_DTM^MDC^AT/AF','','latest value','hh:mm:ss','','Show it in a chart','','0','49','AF/AT','','','','','in the night','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Duration of episode','--','Time','Duration of each episode','CIED','739712^MDC_IDC_EPISODE_DURATION^MDC^AT/AF','','latest value','hh:mm:ss','','Show it in a chart','','0','50','AF/AT','','','','','20 minutes','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','VT zone','--','Categoric','Programmed zone to which each episode is classified','CIED','180305^ICARDEA_IDC_EPISODE_VT_ZONE^ICARDEA','','latest value','Nominal','','Show it in a chart','','0','51','AF/AT','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Cycle length','--','Numeric','If stable, the mean cycle length (ms) of the tacycardia','CIED','180306^ICARDEA_IDC_EPISODE_CYCLE_LENGTH^ICARDEA','','latest value','F3.0','','Show it in a chart','','0','52','AF/AT','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Onset','--','Numeric','Onset of the tachycardia (%)','CIED','180307^ICARDEA_IDC_EPISODE_ONSET^ICARDEA','','latest value','F2.0','','Show it in a chart','','0','53','AF/AT','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Stability','--','Numeric','Stability of tachycardias cycle length (%)','CIED','180308^ICARDEA_IDC_EPISODE_STABILITY^ICARDEA','','latest value','F2.0','','Show it in a chart','','0','54','AF/AT','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','VA relationship','--','Categoric','In patients with atrial lead, VA relationship (V>A, V=A, V<A)','CIED','180309^ICARDEA_IDC_EPISODE_VA_RELATIONSHIP^ICARDEA','','latest value','Nominal','','Show it in a chart','','0','55','AF/AT','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Morphology criteria','--','Numeric','% QRS conconrdance between baseline electrogram and the electrogram during the tachycardia','CIED','180310^ICARDEA_IDC_EPISODE_MORPHOLOGY_CRITERIA^ICARDEA','','latest value','F2.0','','Show it in a chart','','0','56','AF/AT','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','ATP','--','Numeric','Number of ATP delivered for each episode','CIED','737888^MDC_IDC_STAT_TACHYTHERAPY_ATP_DELIVERED_RECENT^MDC^AT/AF','','latest value','F3.0','','Show it in a chart','','0','57','AF/AT','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Shock','--','Numeric','Number of shocks delivered for each episode','CIED','737824^MDC_IDC_STAT_TACHYTHERAPY_SHOCKS_DELIVERED_RECENT^MDC^AT/AF','','latest value','F1.0','','Show it in a chart','','0','58','AF/AT','','','','','0','19000101120000','21000101120000'); "
				// further information
				+replaceInto +" ( 'AF/AT','Electrogram','--','Image','Intracardiac electrogram registered by the device for each episode','CIED','18750-0^Cardiac Electrophysiology Report^LN','','latest value','','','Link to each particular electrogram','','0','59','AF/AT','','','','','Afib rate 180','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Diagnosis','--','Text','Main diagnosis of the patient','EHR','','','fixed value','','','Reason for implantation of the device','','0','61','Patient relevant information ','','','','','sudden cardiac death','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Problems','--','List','Patient s reported symptoms (palpitations, dizziness, syncope, chest pain, shortness of breath, etc.)','PHR','','','latest value','','','Could be a free text, or better: list of specific symptoms marked by the patient','','0','62','Patient relevant information ','Problems','Problems','','','none?','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Anticoagulation','--','Categoric','Oral chronic anticoagulation (YES / NO)','CALCULATE','','','','Binary','','','','0','63','Patient relevant information ','','','','','NO','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Medications','--','List','Current medical treatment of the patient','EHR / PHR','','','latest value','','','Could also underline or show the medication that has been changed','','0','64','Patient relevant information ','Medications','Medications','','','Nexium 20 mg,Thrombo ass 100 mg Aspirin, Plavix 75 mg,  Nomexor (Nebivolol), - Simvastatin 20 mg','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Medication compliance','--','List','Patient s reported compliance to medication','PHR','','','4 weeks','','','','','0','65','Patient relevant information ','Compliance','Compliance','','','Nexium 20 mg,Thrombo ass 100 mg Aspirin, Plavix 75 mg,  Nomexor (Nebivolol), - Simvastatin 20 mg','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Treatment changes','--','Text','Changes in treatment','PHR','','','4 weeks','','','','','0','66','Patient relevant information ','','','','','None','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Reports','--','Text','Recent hospital admission reports','EHR','','','12 months','','','Maybe highlight admissions to the Emergency Room or any Cardiovascular Department','','0','67','Patient relevant information ','','','','','alert from st jude','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','CHADS2 Score','--','Numeric','Prior congestive heart failure / Hypertension / Age >75 years / Diabetes mellitus / Stroke (table 7 D.4.2.1)','EHR / PHR','','','latest value','F1.0','','','','0','68','Patient relevant information ','','','','','3','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','CHADS2-Vasc Score','--','Numeric','Table 9 D.4.2.1','CALCULATE','','','','F1.0','','','','0','69','Patient relevant information ','','','','','NA','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','HAS-BLED Score','--','Numeric','Table 11 D.4.2.1','CALCULATE','','','','F1.0','','','','0','70','Patient relevant information ','','','','','1','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Contraindications for anticoagulation','--','List','List of possible contraindications for oral chronic anticoagulation (see flowchart 10 of D.4.1.1)','EHR / PHR','','','latest value','','','','','0','71','Patient relevant information ','Contraindication','Contraindication','','','Simvastatin, and Drug Eluting Stent','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Patient comments','--','List','any other comment that the patient wants to resgister (like his diary)','PHR','','','Dates of episodes of vt','','','','','0','72','Patient relevant information ','Patient comments','PatComment','','','none','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Lab results','--','List','Table showing the patient s laboratory results','EHR','','','latest value','','','Link to the patients last lab results','maybe also show the specific laboratory s lower und upper normal values and highlight those outside their limits ','0','74','Patient Objective Data','Lab results','LabResult','','','Potassium mEq/L     - 4.0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Electrocardiogram','--','Image','Electrocardiogram','EHR','','','latest value','','','Link to the patients last electrocardiogram results','','0','75','Patient Objective Data','','','','','Normal sinus rythm','19000101120000','21000101120000'); "
				+replaceInto +" ( 'AF/AT','Echocardiogram','--','Image','Table showing the patient s echocardiography results, report and images','EHR','','','latest value','','','Link to the patient s last echocardiogram','','0','76','Patient Objective Data','','','','','none available','19000101120000','21000101120000'); "
				//episode subitems
				+replaceInto +" ( 'VT/VF','Nr of episodes:','--','Numeric','Number of episodes','CIED','737952^MDC_IDC_EPISODE_ID^MDC^','','latest value','F3.0','','','','0','780','VT/VF','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Date of episode:','--','Date','Date of each episode','CIED','739552^MDC_IDC_EPISODE_DTM^MDC^','','latest value','DD-MM-YYYY','','Show it in a chart','','0','790','VT/VF','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Time of episode:','--','Time','Time of each episode','CIED','739552^MDC_IDC_EPISODE_DTM^MDC^','','latest value','hh:mm:ss','','Show it in a chart','','0','800','VT/VF','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Therapy Details:','--','Text','','CIED','739680^MDC_IDC_EPISODE_DETECTION_THERAPY_DETAILS^MDC^','','latest value','','','','','0','801','Tachycardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Therapy Result:','--','Text','','CIED','739696^MDC_IDC_EPISODE_THERAPY_RESULT^MDC^','','latest value','','','','','0','802','Tachycardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Duration of episode','--','Time','Duration of each episode','CIED','739712^MDC_IDC_EPISODE_DURATION^MDC^','','latest value','hh:mm:ss','','Show it in a chart','','0','810','VT/VF','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','VT zone','--','Categoric','Programmed zone to which each episode is classified','CIED','180305^ICARDEA_IDC_EPISODE_VT_ZONE^ICARDEA^','','latest value','Nominal','','Show it in a chart','','0','820','VT/VF','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Cycle length','--','Numeric','If stable, the mean cycle length (ms) of the tacycardia','CIED','180306^ICARDEA_IDC_EPISODE_CYCLE_LENGTH^ICARDEA^','','latest value','F3.0','','Show it in a chart','','0','830','VT/VF','','','','','0','19000101120000','21000101120000'); "
				//
				+replaceInto +" ( 'VT/VF','Onset','--','Numeric','Onset of the tachycardia (%)','CIED','180307^ICARDEA_IDC_EPISODE_ONSET^ICARDEA','','latest value','F2.0','','Show it in a chart','','0','84','VT/VF','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Stability','--','Numeric','Stability of tachycardias cycle length (%)','CIED','180308^ICARDEA_IDC_EPISODE_STABILITY^ICARDEA','','latest value','F2.0','','Show it in a chart','','0','85','VT/VF','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','VA relationship','--','Categoric','In patients with atrial lead, VA relationship (V>A, V=A, V<A)','CIED','180309^ICARDEA_IDC_EPISODE_VA_RELATIONSHIP^ICARDEA','','latest value','Nominal','','Show it in a chart','','0','86','VT/VF','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Morphology criteria','--','Numeric','% QRS conconrdance between baseline electrogram and the electrogram during the tachycardia','CIED','180310^ICARDEA_IDC_EPISODE_MORPHOLOGY_CRITERIA^ICARDEA','','latest value','F2.0','','Show it in a chart','','0','87','VT/VF','','','','','0','19000101120000','21000101120000'); "
				//same as above?
				+replaceInto +" ( 'VT/VF','ATP each episode','--','Numeric','Number of ATP delivered for each episode','CIED','737888^MDC_IDC_STAT_TACHYTHERAPY_ATP_DELIVERED_RECENT^MDC','','latest value','F3.0','','Show it in a chart','','0','88','VT/VF','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Shock delivered each episode','--','Numeric','Number of shocks delivered for each episode','CIED','737824^MDC_IDC_STAT_TACHYTHERAPY_SHOCKS_DELIVERED_RECENT^MDC','','latest value','F1.0','','Show it in a chart','','0','89','VT/VF','','','','','0','19000101120000','21000101120000'); "
				//furtherinformation
				+replaceInto +" ( 'VT/VF','Electrogram','--','Image','Intracardiac electrogram registered by the device for each episode','CIED','18750-0^Cardiac Electrophysiology Report^LN','','latest value','','','Link to each particular electrogram','','0','90','VT/VF','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Diagnosis','--','Text','Main diagnosis of the patient','EHR','','','fixed value','','','Reason for implantation of the device','','0','92','Patient relevant information ','','','','','none','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Problems','--','List','Patient s reported symptoms (palpitations, dizziness, syncope, chest pain, shortness of breath, etc.)','PHR','','','latest value','','','Could be a free text, or better: list of specific symptoms marked by the patient','','0','93','Patient relevant information ','Problems','Problems','','','none','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Medications','--','List','Current medical treatment of the patient','EHR / PHR','','','latest value','','','Could also underline or show the medication that has been changed','','0','94','Patient relevant information ','Medications','Medications','','','same','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Medication compliance','--','List','Patient s reported compliance to medication','PHR','','','4 weeks','','','','','0','95','Patient relevant information ','Medication compliance','Compliance','','','good','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Treatment changes','--','Text','Changes in treatment','PHR','','','4 weeks','','','','','0','96','Patient relevant information ','','','','','none','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Hospital reports','--','Text','Recent hospital admission reports','EHR','','','12 months','','','Maybe highlight admissions to the Emergency Room or any Cardiovascular Department','','0','97','Patient relevant information ','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Patient comments','--','Text','any other comment that the patient wants to resgister (like his diary)','PHR','','','Dates of episodes of vt','','','','','0','98','Patient relevant information ','','','','','none','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Lab results','--','Numeric','Table showing the patient s laboratory results','EHR','','','latest value','','','Link to the patients last lab results','','0','100','Patient Objective Data','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','INR','--','Numeric','Patient s anticoagulation status','EHR','','','8 weeks','F2.1','','','','0','101','Patient Objective Data','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Electrocardiogram','--','Image','Electrocardiogram','EHR','','','latest value','','','Link to the patients last electrocardiogram results','','0','102','Patient Objective Data','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'VT/VF','Echocardiogram','--','Image','Table showing the patient s echocardiography results, report and images','EHR','','','latest value','','','Link to the patient s last echocardiogram','','0','103','Patient Objective Data','','','','','0','19000101120000','21000101120000'); "
				//patinfo start
				+replaceInto +" ( 'PatInfo','Date of birth','--','Date','Date of birth','EHR','','','fixed value','DD-MM-YYYY','>01-01-1900 and <interrogation date','','','0','1050','Patient Information','','','','','Andreas Schmidt','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Diagnosis','--','Text','Main diagnosis of the patient','EHR','','','fixed value','','','Reason for implantation of the device','','0','1060','Patient Information','','','','','Sudden cardiac death','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','NYHA functional class at implant','--','Categoric','Functional class according to the New York Heart Association Classification (I -IV) at implant','PHR','','','latest value','Ordinal','I, II, III or IV','In the PHR a questionnare could be filled, with simple questions to obtain this parameter','','0','1070','Patient Information','','','','','NHYA 1','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','EF','--','Numeric','Ejection fraction','EHR','','','Latest value','F2.0','>8 and <95','It can be retrieved from the echocardiogram parameters or catheterisation (use the latest value)','','0','1080','Patient Information','','','','','0,6','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Date of EF','--','Date','Date of EF shown','EHR','','','Latest value','DD-MM-YYYY','','Give the date that the test was perfomed','','0','1090','Patient Information','','','','','15.11.2009','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Date of implantation','--','Date','Date of implantation','CIED / EHR','720901^MDC_IDC_PG_IMPLANT_DT^MDC','','fixed value','DD-MM-YYYY','> Date of birth','','','0','1110','Device Parameters','','','','','20.11.2009','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Date of battery exchange','--','Date','Date of battery exchange','CIED / EHR','180101^ICARDEA_IDC_PG_BATTERY EXCHANGE_DTM^ICARDEA','','latest value','DD-MM-YYYY','> Date of implantation','Show ONLY if there has been a battery exchange (if the information is not blank)','','0','1112','Device Parameters','','','','','non applicable','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Type of device','--','Categoric','PM / ICD / CRT-P / CRT-D','CIED / EHR','720897^MDC_IDC_PG_TYPE^MDC','','fixed value','Nominal','','','','0','1130','Device Parameters','','','','','ICD','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','CIED manufacturer','--','Categoric','Medtronic / SJM','CIED / EHR','720900^MDC_IDC_PG_MFG^MDC','','fixed value','Nominal','','There are others in the market (Biotronik, Boston, etc,) but for the current project we are only using these two','','0','1140','Device Parameters','','','','','SJM','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Model','--','Categoric','for types - ASK Medtronic & SJM','CIED / EHR','720898^MDC_IDC_PG_MODEL^MDC','','fixed value','Nominal','','','','0','1150','Device Parameters','','','','','Current accel','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','CIED serial number','--','Numeric','CIED serial number','CIED / EHR','720899^MDC_IDC_PG_SERIAL^MDC','','fixed value','ASK Medtronic & SJM','','','','0','1160','Device Parameters','','','','','9925119','19000101120000','21000101120000'); "

				// direkt access changed to variable marking
				+replaceInto +" ( 'PatInfo','Lead Model:','--','Categoric','lead model','CIED / EHR','720961^MDC_IDC_LEAD_MODEL^MDC^','','fixed value','Nominal','','Some patients may not have an atrial lead implanted','','0','1170','Device Parameters','','','','','Tendril ST ','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Lead Serial number:','--','Numeric','lead serial number','CIED / EHR','720962^MDC_IDC_LEAD_SERIAL^MDC^','','fixed value','','','Some patients may not have an atrial lead implanted','','0','1170','Device Parameters','','','','','BKM99752','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Date of implantation:','--','Date','Date of implantation','CIED / EHR','720964^MDC_IDC_LEAD_IMPLANT_DT^MDC^','','fixed value','DD-MM-YYYY','> Date of birth','','field can be set during implant or followup','0','1170','Device Parameters','','','','','20.11.2009','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Lead manufacturer:','--','Categoric','Medtronic / SJM','CIED / EHR','720963^MDC_IDC_LEAD_MFG^MDC^','','fixed value','Nominal','','In Project only SJM/MEDTRONIC','automatic value','0','1170','Device Parameters','','','','','SJM','19000101120000','21000101120000'); "

				//
				+replaceInto +" ( 'PatInfo','RA lead model','--','Categoric','Right atrial lead model','CIED / EHR','720961^MDC_IDC_LEAD_MODEL^MDC^RA','','fixed value','Nominal','','Some patients may not have an atrial lead implanted','','0','1181','Device Parameters','','','','','Tendril ST ','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','RA lead serial number','--','Numeric','Right atrial lead serial number','CIED / EHR','720962^MDC_IDC_LEAD_SERIAL^MDC^RA','','fixed value','','','Some patients may not have an atrial lead implanted','','0','1182','Device Parameters','','','','','BKM99752','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','RA lead impedance at implant','--','Numeric','Impedance of the atrial lead at implant','CIED / EHR','722432^MDC_IDC_MSMT_LEADCHNL_RA_IMPEDANCE_VALUE^MDC','','fixed value','F4.0','For valid limits, ask Medtronic & SJM','','','0','1183','Device Parameters','','','','','SAME AS ON DEMO PATIENT PDF','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','RA lead P wave amplitude at implant','--','Numeric','Amplitude of the atrial lead signal at implant','CIED / EHR','180202^ICARDEA_IDC_MSMT_LEADCHNEL_RA_PWAVE_AMPLITUDE^ICARDEA','','fixed value','F2.1','<15.0 and >0.1','','','0','1184','Device Parameters','','','','','Demo Data','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','RA lead pacing threshold at implant','--','Numeric','Pacing threshold of the atrial lead at implant','CIED / EHR','722176^MDC_IDC_MSMT_LEADCHNL_RA_PACING_THRESHOLD_AMPLITUDE^MDC','','fixed value','F2.1','<5.0','','','0','1185','Device Parameters','','','','','Demo Data','19000101120000','21000101120000'); "
				//
				+replaceInto +" ( 'PatInfo','RV lead model','--','Categoric','Right ventricular lead model','CIED / EHR','720961^MDC_IDC_LEAD_MODEL^MDC^RV','','fixed value','Nominal','','','','0','1192','Device Parameters','','','','','Durata 7120','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','RV lead serial number','--','Numeric','Right ventricular lead serial number','CIED / EHR','720962^MDC_IDC_LEAD_SERIAL^MDC^RV','','fixed value','','','','','0','1193','Device Parameters','','','','','AKA99156','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','RV lead def. impedance at implant','--','Numeric','Defibrillation impedance of the right ventricular lead at implant','CIED / EHR','180203^ICARDEA_IDC_MSMT_LEADCHNEL_RV_DEFRIBRILLATION_IMPENDENCE^ICARDEA','','fixed value','F2.0','For valid limits, ask Medtronic & SJM','Patients without an ICD ','','0','1194','Device Parameters','','','','','SAME AS  ON DEMO PATIRENT','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','RV lead pacing impedance at implant','--','Numeric','Pacing impedance of the right ventricular lead at implant','CIED / EHR','722433^MDC_IDC_MSMT_LEADCHNL_RV_IMPEDANCE_VALUE^MDC','','fixed value','F4.0','For valid limits, ask Medtronic & SJM','','','0','1195','Device Parameters','','','','','PDF SAME AS DEMO','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','RV lead R wave amplitude at implant','--','Numeric','Amplitude of the right ventricular lead signal at implant','CIED / EHR','180204^ICARDEA_IDC_MSMT_LEADCHNEL_RV_RWAVE_AMPLITUDE^ICARDEA','','fixed value','F2.1','<15.0 and >0.1','','','0','1196','Device Parameters','','','','','Demo Data','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','RV lead pacing threshold at implant','--','Numeric','Pacing threshold of the right ventricular lead at implant','CIED / EHR','722177^MDC_IDC_MSMT_LEADCHNL_RV_PACING_THRESHOLD_AMPLITUDE^MDC','','fixed value','F2.1','<5.0','','','0','1197','Device Parameters','','','','','Demo Data','19000101120000','21000101120000'); "
				//
				+replaceInto +" ( 'PatInfo','LV lead model','--','Categoric','Left ventricular lead model','CIED / EHR','720961^MDC_IDC_LEAD_MODEL^MDC^LV','','fixed value','Nominal','','Some patients may not have a left ventricular lead implanted','','0','1200','Device Parameters','','','','','NA','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','LV lead serial number','--','Numeric','Left ventricular lead serial number','CIED / EHR','720962^MDC_IDC_LEAD_SERIAL^MDC^LV','','fixed value','','','Some patients may not have a left ventricular lead implanted','','0','1201','Device Parameters','','','','','NA','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','LV lead pacing impedance at implant','--','Numeric','Pacing impedance of the left ventricular lead at implant','CIED / EHR','722435^MDC_IDC_MSMT_LEADCHNL_LV_IMPEDANCE_VALUE^MDC','','fixed value','F4.0','For valid limits, ask Medtronic & SJM','','','0','1202','Device Parameters','','','','','NA','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','LV lead R wave amplitude at implant','--','Numeric','Amplitude of the left ventricular lead signal at implant','CIED / EHR','180205^ICARDEA_IDC_MSMT_LEADCHNEL_LV_RWAVE_AMPLITUDE^ICARDEA','','fixed value','F2.1','<15.0 and >0.1','','','0','1203','Device Parameters','','','','','NA','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','LV lead pacing threshold at implant','--','Numeric','Pacing threshold of the left ventricular lead at implant','CIED / EHR','722179^MDC_IDC_MSMT_LEADCHNL_LV_PACING_THRESHOLD_AMPLITUDE^MDC','','fixed value','F2.1','<5.0','','','0','1204','Device Parameters','','','','','NA','19000101120000','21000101120000'); "
				//rest information patinfo medical
				+replaceInto +" ( 'PatInfo','NOTES','--','Text','Space por the clinitian to write important notes about the patient to be remembered','PPM','','','','','','','','0','142','Patient relevant information ','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Doctor','--','Text','Name of doctor responsible for the patient s care','EHR','','','','','','','','0','134','Patient relevant information ','','','','','OP turnusartz 1','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Doctor s contact details','--','Text','Could be work number or email (to be decided by the institution)','EHR','','','','','','','','0','135','Patient relevant information ','','','','','4482 2066','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Systolic blood pressure','--','List','systolic blood pressure  of day x recorded by the patient','PHR','','','','integer','','daily for the review scenario','','0','136','Patient relevant information ','Systolic blood pressure','SystolicBlood','','','135','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Diastolic blood pressure','--','List','diastolic blood pressure  of day x recorded by the patient','PHR','','','','integer','','daily for the review scenario','','0','137','Patient relevant information ','Diastolic blood pressure','DiastolicBlood','','','80','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Heart rate','--','List','heart rate  of day x recorded by the patient','PHR','','','','integer','','daily for the review scenario','','0','138','Patient relevant information ','Heart rate','HeartRate','','','83','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Body weight','--','List','body weight of day x recorded by the patient','PHR','','','','F2','','','','0','139','Patient relevant information ','Body weight','BodyWeight','','(value < 60) or (value > 80)','87','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Medications','--','List','medication changes including drug name, frequency, dosage, recorded by the patient','PHR','','','','Text, F2, text','','a list of drugs','','0','140','Patient relevant information ','Medications','Medications','','','Simvastatin, 1 tablet, 1x day ','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Prescriptions','--','List','medication changes including drug name, frequency, dosage, recorded by EHR','EHR','','','','Text, F2, text','','a list of drugs','','0','141','Patient relevant information ','Prescriptions','Prescriptions','','','Simvastatin, 1 tablet, 1x day ','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Medication compliance','--','List','Patient s reported compliance to medication','PHR','','','4 weeks','','','','','0','139','Patient relevant information ','Compliance','Compliance','','','Nexium 20 mg,Thrombo ass 100 mg Aspirin, Plavix 75 mg,  Nomexor (Nebivolol), - Simvastatin 20 mg','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Lab results','--','Numeric','Table showing the patient s laboratory results','EHR','','','latest value','','','Link to the patients last lab results','','0','141','Patient Objective Data','','','','','0','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Problems','--','List','symptom recorded by the patient','PHR','','','','text ','','','','0','119','Patient relevant information ','Problems','Problems','','','shortness of breath','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Procedures','--','List','symptom recorded by the patient','PHR','','','','text ','','','','0','118','Patient relevant information ','Procedures','Procedures','','','shortness of breath','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','Patient comments','--','List','any other comment that the patient wants to resgister (like his diary)','PHR','','','Dates of episodes of vt','','','','','0','130','Patient relevant information ','Patient comments','PatComment','','','none','19000101120000','21000101120000'); "
				+replaceInto +" ( 'PatInfo','All Medications','--','List','medication changes including drug name, frequency, dosage, recorded','EHR/PHR','','','','Text, F2, text','','a list of drugs','','0','140','Patient relevant information ','Full Medications','fullmedications','','','Simvastatin, 1 tablet, 1x day ','19000101120000','21000101120000'); "
				//generell para device
				+replaceInto +" ( 'ProPara','Pacing mode','--','Categoric','DDD / DDDR / VVI / VVIR / AAI / AAIR / VDD','CIED','730752^MDC_IDC_SET_BRADY_MODE^MDC','','latest value','Nominal','','','','0','1430','Bradicardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'ProPara','Lower rate limit','--','Numeric','Lower rate limit','CIED','180401^ICARDEA_IDC_SET_RATE_LIMIT_LOWER^ICARDEA','','latest value','F2.0','LRL < ULR; LRL >35','','','0','1440','Bradicardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'ProPara','Upper rate limit','--','Numeric','Upper rate limit','CIED','180402^ICARDEA_IDC_SET_RATE_LIMIT_UPPER^ICARDEA','','latest value','F3.0','LRL < ULR; URL >95','','','0','1450','Bradicardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'ProPara','Maximal rate of the sensor','--','Numeric','Maximal rate of the sensor','CIED','731200^MDC_IDC_SET_BRADY_MAX_SENSOR_RATE^MDC','','latest value','F3.0','MSR = URL','','','0','1460','Bradicardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'ProPara','AV sensed','--','Numeric','AV interval sensed','CIED','731266^MDC_IDC_SET_BRADY_SAV_DELAY_LOW^MDC','','latest value','F3.0','60 - 350','','','0','1470','Bradicardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'ProPara','AV paced','--','Numeric','AV interval paced','CIED','731330^MDC_IDC_SET_BRADY_PAV_DELAY_LOW^MDC','','latest value','F3.0','60 - 350','','','0','1480','Bradicardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'ProPara','VP mode','--','Categoric','RV only / LV only / BiVentricular','CIED','180403^ICARDEA_IDC_SET_VP_MODE^ICARDEA','','latest value','Nominal','','','','0','1490','Bradicardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'ProPara','VV','--','Numeric','VV interval','CIED','180404^ICARDEA_IDC_SET_VV^ICARDEA','','latest value','F3.0','','Only for CRT devices - can be a negative number','','0','1500','Bradicardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'ProPara','Number of zones programmed','--','Categoric','1, 2 or 3','CIED','180405^ICARDEA_IDC_SET_ZONE_NUM^ICARDEA','','latest value','Ordinal','','','','0','1520','Tachycardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'ProPara','VT1 limit','--','Numeric','Rate at what VT1 zone is considered','CIED','180406^ICARDEA_IDC_SET_LIMIT_VT1^ICARDEA','','latest value','F3.0','VT1 limit < VT2 limit','','','0','1530','Tachycardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'ProPara','VT2 limit','--','Numeric','Rate at what VT2 zone is considered','CIED','180407^ICARDEA_IDC_SET_LIMIT_VT2^ICARDEA','','latest value','F3.0','VT2 limit < VF limit','','','0','1540','Tachycardia parameters','','','','','','19000101120000','21000101120000'); "
				+replaceInto +" ( 'ProPara','VF limit','--','Numeric','Rate at what VF zone is considered','CIED','180408^ICARDEA_IDC_SET_LIMIT_VF^ICARDEA','','latest value','F3.0','VF limit > VT1 or VT2 limit','','','0','1550','Tachycardia parameters','','','','','','19000101120000','21000101120000'); "
				//all the same
				//				+replaceInto +" ( 'ProPara','VT1 therapy','--','Text','VT1 therapy programmed','CIED','739680^MDC_IDC_EPISODE_DETECTION_THERAPY_DETAILS^MDC','','latest value','','','','','0','1560','Tachycardia parameters','','','','','','19000101120000','21000101120000'); "
				//				+replaceInto +" ( 'ProPara','VT2 therapy','--','Text','VT2 therapy programmed','CIED','739680^MDC_IDC_EPISODE_DETECTION_THERAPY_DETAILS^MDC','','latest value','','','','','0','1570','Tachycardia parameters','','','','','','19000101120000','21000101120000'); " 
				//				+replaceInto +" ( 'ProPara','VF therapy','--','Text','VF therapy programmed','CIED','739680^MDC_IDC_EPISODE_DETECTION_THERAPY_DETAILS^MDC','','latest value','','','','','0','1580','Tachycardia parameters','','','','','','19000101120000','21000101120000');";
				;
	}

}
