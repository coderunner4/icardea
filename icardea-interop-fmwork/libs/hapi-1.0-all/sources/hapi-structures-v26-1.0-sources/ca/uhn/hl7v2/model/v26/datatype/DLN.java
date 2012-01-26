package ca.uhn.hl7v2.model.v26.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 DLN (Driver's License Number) data type.  Consists of the following components: </p><ol>
 * <li>License Number (ST)</li>
 * <li>Issuing State, Province, Country (IS)</li>
 * <li>Expiration Date (DT)</li>
 * </ol>
 */
public class DLN extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a DLN.
	 * @param message the Message to which this Type belongs
	 */
	public DLN(Message message) {
		super(message);
		data = new Type[3];
		data[0] = new ST(message);
		data[1] = new IS(message, 333);
		data[2] = new DT(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 3 element DLN composite"); 
		} 
	} 
	/**
	 * Returns License Number (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getLicenseNumber() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns License Number (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getDln1_LicenseNumber() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Issuing State, Province, Country (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getIssuingStateProvinceCountry() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Issuing State, Province, Country (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getDln2_IssuingStateProvinceCountry() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Expiration Date (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public DT getExpirationDate() {
	   DT ret = null;
	   try {
	      ret = (DT)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Expiration Date (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public DT getDln3_ExpirationDate() {
	   DT ret = null;
	   try {
	      ret = (DT)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}