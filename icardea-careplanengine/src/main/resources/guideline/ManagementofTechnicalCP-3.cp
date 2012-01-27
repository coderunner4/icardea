<Body>
    <EligibilityCriteria>
		<EvaluationScript>function EligibleToGuidelineCriterion() {  return true; }</EvaluationScript>
    </EligibilityCriteria>
	<Algorithm>
    <StartStep ID="S82293105DAA9A6873318FA161C7DD868">
      <NextStep name="Care plan algorithm is initiated" ref="S421ECAFA67518F987871FA16A6619BE7"/>
    </StartStep>
    <FinalStep ID="S75A153A047C15D07C8C0FA19F6442AE3" name="Guideline finalized!"/>
    <ConsultStep ID="S421ECAFA67518F987871FA16A6619BE7" name="Present the CIED Data and EGM to the Medical Professional">
     <Variable name="BatteryVoltage" type="boolean">
	  <Concept code="721280" name="MDC_IDC_MSMT_BATTERY_STATUS" schemeID="MDC_IDC"/>
	  <DataSource code="C0581396" name="Cardiac implant device" schemeID="UMLS"/>
	  <RefinementScript></RefinementScript>
	</Variable>
	<Variable name="CapacitorChargeTime" type="boolean">
	  <Concept code="721728" name="MDC_IDC_MSMT_CAP_CHARGE_TIME" schemeID="MDC_IDC"/>
	  <DataSource code="C0581396" name="Cardiac implant device" schemeID="UMLS"/>
	  <RefinementScript></RefinementScript>
	</Variable>
	<Variable name="DeviceManufacturer" type="boolean">
	  <Concept code="720900" name="MDC_IDC_PG_MFG" schemeID="MDC_IDC"/>
	  <DataSource code="C0581396" name="Cardiac implant device" schemeID="UMLS"/>
	  <RefinementScript></RefinementScript>
	</Variable>
	<Display>
	  <HTML>
		    
	    <head>
	    </head>
	    <body>					
	      <table cellspacing="10" style="background-color:#e1e1e1">
		<tbody>
		  <tr name="PatientBlock" id="PatientBlock">
		    <td style="background-color:#eeeeee"><!--The following HTML will be populated automatically in the execution phase-->

		      <p align="center"><b>Brief Information about the patient </b></p>

		      <p>Patient Name: 
			<data src="caremanagementdb://Patient/@givenName"/>
			<data src="caremanagementdb://Patient/@secondName"/>
			<data src="caremanagementdb://Patient/@familyName"/>
			<br />
			Patient ID: 
			<data src="caremanagementdb://Patient/@patientIdentifier"/>
			<br />
			<a
			  href="http://patient.parameter.monitor.link/a.php?patientID">Access to
			  EHR</a> <br />
			Implanted Device:
			<data src="caremanagementdb://720897:MDC_IDC_PG_TYPE"/>
			<data src="caremanagementdb://720898:MDC_IDC_PG_MODEL"/>
			<br />
			Last Follow-up Date: <data src="caremanagementdb://721028:MDC_IDC_SESS_DTM_PREVIOUS"/><a href="http://link.to.care.management.db">Access
			  to previous Remote follow-up results</a> </p>

		      <p><br />
		      </p>
		    </td>
		  </tr>
		  <tr name="CIEDBlock">

		    <td style="background-color:#eeeeee"><!--The following HTML will be populated in the execution step-->
		      Received Date:	<data src="caremanagementdb://Patient/CIEDData/@receivedTime"/>
		      <br/>
		      Alarms Detected:
		      <data src="alarmmanager://Alarm/Time"/>
		      Technical Problem
		      <br/>
		      <a href="http://patient.parameter.monitor.link">Access to Report Exported</a>
		    </td>
		  </tr>
		  <tr name="EGMBlock"> <td style="background-color:#eeeeee">
		      <p align="center"><b>Brief Information about the EGM and detected
			  problems </b> </p>
		      <table  cellspacing="10" width="100%">
			<tbody>
			  <tr>
			    <td><!--The following HTML will be populated in the execution step-->
			      <p align="center"> EGM: <a href="http://patient.parameter.monitor.link">Access to
				  Report Exported</a> <br /> </p>


			      <p><img width="312" height="190" id="Picture1"
				  src="caremanagementdb://Patient/Observation/@base64String"
				  alt="x.bmp" /></p>
			    </td>
			    <td><!--The following HTML will be populated in the execution step-->

			      <p align="center">  Assesment by CIED <a href="http://patient.parameter.monitor.link">Access
				  to Report Exported</a> <br />
				<br/>
				<p align="left"> Battery voltage: $BatteryVoltage <br />
				  Capacitor Charge Time: $CapacitorChargeTime <br />
				  Implantable Device Manufacturer: $DeviceManufacturer <br />
				</p>
				<p align="left">
					<font color="#880015">Warning: Capacitor Charge Time threshold values vary from the manufacturers!</font><br/>
					<b>Medtronic: </b><br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Capacitor Charge Time low threshold: 16 <br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Capacitor Charge Time high threshold: 30 <br/>
					<b>St.Jude: </b><br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Capacitor Charge Time low threshold: Not provided<br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Capacitor Charge Time high threshold: 28<br/>
				  </p>
			      </p>
			    </td>
			  </tr>
			</tbody>
		      </table>
		    </td>
		  </tr>
		  <tr name="ChoiceBlock">
		    <td style="background-color:#eeeeee">
		      <p align="center"><b>Recommendation and Next Step to follow </b> </p>
		      <p>Please choose the suitable option</p>

		      <form onsubmit="return ValidateData();" action="null" method="post">
			<input type="submit" name="S5Choice" value="Case of urgency based on the battery voltage and capacitor charge time" onclick="btnWhichButton=this" />
			<input type="submit" name="S5Choice" value="Case of emergency based on the battery voltage and capacitor charge time" onclick="btnWhichButton=this"/>
			<input type="submit" name="S5Choice" value="Battery voltage and capacitor charge times are normal" onclick="btnWhichButton=this"/>
			  </form>
		    </td>
		  </tr>
		</tbody>
	      </table>
	    </body>
	  </HTML>
	</Display>
      <NextStep name="Case of urgency based on the battery voltage and capacitor charge time" ref="SF28FB7A1C13017A266EDFA18DCC46098">
        <EvaluationScript>function check(S421ECAFA67518F987871FA16A6619BE7Choice) { if(S421ECAFA67518F987871FA16A6619BE7Choice.getValue().getText() == "Case of urgency based on the battery voltage and capacitor charge time") return true; else return false; }</EvaluationScript>
      </NextStep>
      <NextStep name="Case of emergency based on the battery voltage and capacitor charge time" ref="S7EAEE8180FAEF9D0E073FA18F4FE3B84">
        <EvaluationScript>function check(S421ECAFA67518F987871FA16A6619BE7Choice) { if(S421ECAFA67518F987871FA16A6619BE7Choice.getValue().getText() == "Case of emergency based on the battery voltage and capacitor charge time") return true; else return false; }</EvaluationScript>
      </NextStep>
      <NextStep name="Battery voltage and capacitor charge times are normal" ref="S75A153A047C15D07C8C0FA19F6442AE3">
        <EvaluationScript>function check(S421ECAFA67518F987871FA16A6619BE7Choice) { if(S421ECAFA67518F987871FA16A6619BE7Choice.getValue().getText() == "Battery voltage and capacitor charge times are normal") return true; else return false; }</EvaluationScript>
      </NextStep>
    </ConsultStep>
    <RecommendationStep ID="SF28FB7A1C13017A266EDFA18DCC46098" name="Urgent in person control">
      <Receiver ref="P3"/>
	  <Urgency>2</Urgency>
      <NextStep name="Guideline finalized!" ref="S75A153A047C15D07C8C0FA19F6442AE3">
        <EvaluationScript>function check(SF28FB7A1C13017A266EDFA18DCC46098Choice) { if(SF28FB7A1C13017A266EDFA18DCC46098Choice.getValue().getText() == "Guideline finalized!") return true; else return false; }</EvaluationScript>
      </NextStep>
      <Display>
	  <HTML>
	    <head/>
	    <body>

	      <table  cellspacing="10" style="background-color:#e1e1e1">
		<tbody>
		  <tr name="PatientBlock" id="PatientBlock">
		    <td style="background-color:#eeeeee"><!--The following HTML will be populated automatically in the execution phase-->

		      <p align="center"><b>Brief Information about the patient </b></p>

		      <p>Patient Name: 
			<data src="caremanagementdb://Patient/@givenName"/>
			<data src="caremanagementdb://Patient/@secondName"/>
			<data src="caremanagementdb://Patient/@familyName"/>
			<br />
			Patient ID: 
			<data src="caremanagementdb://Patient/@patientIdentifier"/>
			<br />
			<a
			  href="http://patient.parameter.monitor.link/a.php?patientID">Access to
			  EHR</a> <br />
			Implanted Device:
			<data src="caremanagementdb://720897:MDC_IDC_PG_TYPE"/>
			<data src="caremanagementdb://720898:MDC_IDC_PG_MODEL"/>
			<br />
			Last Follow-up Date: <data src="caremanagementdb://721028:MDC_IDC_SESS_DTM_PREVIOUS"/><a href="http://link.to.care.management.db">Access
			  to previous Remote follow-up results</a> </p>

		      <p><br />
		      </p>
		    </td>
		  </tr>
		  <tr name="CIEDBlock">
		    <td style="background-color:#eeeeee"><!--The following HTML will be populated in the execution step-->

		      <p align="center"><b>Brief Information about the recent alarm </b></p>
		      Received Date: <data src="caremanagementdb://Patient/CIEDData/@receivedTime"/><br />
		      Alarms Detected: Technical Problem <br />
		      <a href="http://patient.parameter.monitor.link">Access to Report
			Exported</a> </td>
		  </tr>
		  <tr name="RecommendationBlock">
		    <td style="background-color:#eeeeee">
		      <p align="center"><b><font color="#880015">Recommendation and Next Step to follow</font> </b> </p>
		      <p>Take an action as soon as possible when the clinic is open.</p>

		      <form onsubmit="return ValidateData();" action="null" method="post">
			<input type="submit" name="D5Choice" value="Continue" onclick="btnWhichButton=this"/>
		      </form>
		    </td>
		  </tr>
		</tbody>
	      </table>
	    </body>
	  </HTML>
	</Display>
    </RecommendationStep>
	<RecommendationStep ID="S7EAEE8180FAEF9D0E073FA18F4FE3B84" name="Emergency in person control">
      <Receiver ref="P3"/>
	  <Urgency>2</Urgency>
      <NextStep name="Guideline finalized!" ref="S75A153A047C15D07C8C0FA19F6442AE3">
        <EvaluationScript>function check(S7EAEE8180FAEF9D0E073FA18F4FE3B84Choice) { if(S7EAEE8180FAEF9D0E073FA18F4FE3B84Choice.getValue().getText() == "Guideline finalized!") return true; else return false; }</EvaluationScript>
      </NextStep>
      <Display>
	  <HTML>
	    <head/>
	    <body>

	      <table  cellspacing="10" style="background-color:#e1e1e1">
		<tbody>
		  <tr name="PatientBlock" id="PatientBlock">
		    <td style="background-color:#eeeeee"><!--The following HTML will be populated automatically in the execution phase-->

		      <p align="center"><b>Brief Information about the patient </b></p>

		      <p>Patient Name: 
			<data src="caremanagementdb://Patient/@givenName"/>
			<data src="caremanagementdb://Patient/@secondName"/>
			<data src="caremanagementdb://Patient/@familyName"/>
			<br />
			Patient ID: 
			<data src="caremanagementdb://Patient/@patientIdentifier"/>
			<br />
			<a
			  href="http://patient.parameter.monitor.link/a.php?patientID">Access to
			  EHR</a> <br />
			Implanted Device:
			<data src="caremanagementdb://720897:MDC_IDC_PG_TYPE"/>
			<data src="caremanagementdb://720898:MDC_IDC_PG_MODEL"/>
			<br />
			Last Follow-up Date: <data src="caremanagementdb://721028:MDC_IDC_SESS_DTM_PREVIOUS"/><a href="http://link.to.care.management.db">Access
			  to previous Remote follow-up results</a> </p>

		      <p><br />
		      </p>
		    </td>
		  </tr>
		  <tr name="CIEDBlock">
		    <td style="background-color:#eeeeee"><!--The following HTML will be populated in the execution step-->

		      <p align="center"><b>Brief Information about the recent alarm </b></p>
		      Received Date: <data src="caremanagementdb://Patient/CIEDData/@receivedTime"/><br />
		      Alarms Detected: Technical Problem <br />
		      <a href="http://patient.parameter.monitor.link">Access to Report
			Exported</a> </td>
		  </tr>
		  <tr name="RecommendationBlock">
		    <td style="background-color:#eeeeee">
		      <p align="center"><b><font color="#880015">Recommendation and Next Step to follow</font> </b> </p>
			  <p>Take an immediate action, an emergency room should be prepared immediately.</p>
		      

		      <form onsubmit="return ValidateData();" action="null" method="post">
			<input type="submit" name="D5Choice" value="Continue" onclick="btnWhichButton=this"/>
		      </form>
		    </td>
		  </tr>
		</tbody>
	      </table>
	    </body>
	  </HTML>
	</Display>
    </RecommendationStep>
   </Algorithm>
  </Body>