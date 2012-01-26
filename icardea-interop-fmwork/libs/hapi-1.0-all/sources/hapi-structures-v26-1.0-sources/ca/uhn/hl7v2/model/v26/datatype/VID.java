package ca.uhn.hl7v2.model.v26.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 VID (Version Identifier) data type.  Consists of the following components: </p><ol>
 * <li>Version ID (ID)</li>
 * <li>Internationalization Code (CWE)</li>
 * <li>International Version ID (CWE)</li>
 * </ol>
 */
public class VID extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a VID.
	 * @param message the Message to which this Type belongs
	 */
	public VID(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new ID(message, 104);
		data[1] = new CWE(message);
		data[2] = new CWE(message);
	}

	/**
	 * Returns an array containing the data elements.
	 */
	public Type[] getComponents() { 
		return this.data; 
	}

	/**
	 * Returns an individual data component.
	 * @throws DataTypeException if the given element number is out of range.
	 */
	public Type getComponent(int number) throws DataTypeException { 

		try { 
			return this.data[number]; 
		} catch (ArrayIndexOutOfBoundsException e) { 
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element VID composite"); 
		} 
	} 
	/**
	 * Returns Version ID (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getVersionID() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Version ID (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getVid1_VersionID() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Internationalization Code (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getInternationalizationCode() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Internationalization Code (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getVid2_InternationalizationCode() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns International Version ID (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getInternationalVersionID() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns International Version ID (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getVid3_InternationalVersionID() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}