<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Login</title>
<style type="text/css">
    #container {
      padding: 1em;      
    }
    
    #container p {
      font-size: 1.2em;
      font-family: Tahoma,Verdana;
    }
    
    #openid_identifier {
      background-image: url(images/login-bg.gif);
      background-position: 3px 2px;
      background-repeat: no-repeat;
      margin: 0;
      padding: 0.2em 0.2em 0.2em 20px;
      vertical-align: middle;
      width: 322px;
    }
</style>
<script type="text/javascript">

function startsWith(theString,theStart,caseNormal){	  
	  if(caseNormal){	   
	   	theString=theString.toUpperCase();
	   	theStart=theStart.toUpperCase();	   
	  }	  
	  return theString.substr(0,theStart.length)==theStart?true:false;
}

function processForm(theForm){
	
    var objHidden = document.getElementById("openid_identifier");
    var objUser   = document.getElementById("username");
    var objDropDown = document.getElementById("loginWith");
    var mess = document.getElementById("message");
    
   // alert("objDropDown.value="+objDropDown.value);
    
    if(objUser.value.length < 3){
    	mess.value="Too short, please provide a login identifier";
    	alert(mess.value);
    	return false;
    }
    //icardea local server accepts short names. We must combine this here otherwise the servlet request must be wrapped
    if(objDropDown.value == "icardea" ){
    	objHidden.value ="https://localhost:8443/idp/u="+objUser.value;
    	alert("Your actual iCARDEA OpenID identifier is: "+objHidden.value);
    } else objHidden.value = objUser.value; 
    
    if(objDropDown.value =='local'){
    	if(objUser.value =='phradmin'){
    		return true;
    	}
    	if(startsWith(objUser.value,'phruser',false)){
    		return true;
    	} 
    	if(startsWith(objUser.value,'phrtest',false)){
    		return true;
    	}
    	if(startsWith(objUser.value,'nurse',false)){
    		return true;
    	}        
    	mess.value="For a local user account, please provide a user name starting with 'phruser'";
    	alert(mess.value);
    	return false;
    }
      
    return true;
    
}

</script>
</head>
<body>
<!-- onchange="changeHiddenInput(this)"   <div style="color:red;font-size:1.4em">&nbsp;${openid_servlet_filter_msg}</div>-->
<div id="container">

  <div style="clear:both"></div>

  <p>Login with your <b>OpenID</b> or Local account</p>
  <div id="message"></div>
  <form id="idLoginForm" name="idLoginForm"  method="post" onsubmit="return processForm(this);">
  	<input type="hidden" name="openid_identifier" id="openid_identifier" value="" />
  	<table>
  	<tr>
  		<td><b>Login with:</b> </td>
  		<td><b>User name: </b></td>
  	</tr>
  	<tr>  	
	  	<td>
		    <select id="loginWith" name="loginWith">
			   <option selected="selected" value="local">PHR User Account (begins with 'phruser')</option>	    
		    	<option  value="icardea">iCARDEA User Account</option>
		    	<option value="google">Google</option>
		    	<option value="yahoo">Yahoo</option>	    	
		    </select>	  
		    <!-- <option value="phrsopenid">Phrs OpenID provider</option> -->	
	  	</td>
	  	<td>
	  		<input id="username" name="username" type="text" size="90"/>
	  	</td>
  	</tr>
  	<tr>
	  	<td><input class="btn" type="submit" value="Login" /></td>
	  	<td></td>
	  	<td></td>
  	</tr>
  	<tr>
	  	<td>Local login</td>
	  	<td>Role</td>
	  	<td></td>
  	</tr>
    	<tr>
	  	<td>nurse</td>
	  	<td>Nurse</td>
	  	<td></td>
  	</tr>             
  	<tr>
	  	<td>phruser</td>
	  	<td></td>
	  	<td></td>
  	</tr>  	
  	<tr>
	  	<td>phrtest</td>
	  	<td><!--Nurse--></td>
	  	<td>Test EHR with 
                    <br/>protocolId= 14920263490
                    <br/>phrId     = phr/test/testuser
                
                </td>
  	</tr>
  	<tr>
	  	<td>phrtest1</td>
	  	<td>Doctor</td>
	  	<td></td>
  	</tr>  
          
  	</table>
  	<p>The prefix <b>phrtest</b> or <b>phruser</b> can be used to create additional local login identifiers 
  	e.g. <b>phruser123</b> No passwords are needed in order to facilitate demonstration and testing activities</p>
  	<p></p>
    
<!--     <input id="xxloginWith" name="xxloginWith" type="text" size="90" value="icardea"/>  -->   
    
  </form>

</div>

</body>
</html>