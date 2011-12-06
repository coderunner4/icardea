
package tr.com.srdc.icardea.model.userRoles{
	import tr.com.srdc.icardea.model.userControl.ID;
	import tr.com.srdc.icardea.model.userControl.Organization;
	
	[Bindable]
	[XmlClass(alias="CareplanReviewer")]
	public class CareplanReviewer{
		public function CareplanReviewer(){
			
		}

		[XmlElement(alias="ID")]	
		public  var id : ID = new ID;   //<ID schemeID="TCKN">14920263490</ID> ???
		[XmlElement(alias="Name")]	
		public  var name : String = "";
		[XmlElement(alias="Organization")]	
		public  var organization : Organization = new Organization;
		[XmlAttribute(alias="personID")]	
		public  var personID : String = "";
		[XmlElement(alias="Surname")]	
		public  var surname : String = "";
		[XmlElement(alias="Title")]	
		public  var title : String = "";
		}
}

