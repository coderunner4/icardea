package ca.uhn.hl7v2.model.v26.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 MOC (Money and Code) data type.  Consists of the following components: </p><ol>
 * <li>Monetary Amount (MO)</li>
 * <li>Charge Code (CWE)</li>
 * </ol>
 */
public class MOC extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a MOC.
	 * @param message the Message to which this Type belongs
	 */
	public MOC(Message message) {
		super(message);
		data = new Type[2];
		data[0] = new MO(message);
		data[1] = new CWE(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 2 element MOC composite"); 
		} 
	} 
	/**
	 * Returns Monetary Amount (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public MO getMonetaryAmount() {
	   MO ret = null;
	   try {
	      ret = (MO)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Monetary Amount (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public MO getMoc1_MonetaryAmount() {
	   MO ret = null;
	   try {
	      ret = (MO)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Charge Code (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getChargeCode() {
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
	 * Returns Charge Code (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CWE getMoc2_ChargeCode() {
	   CWE ret = null;
	   try {
	      ret = (CWE)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}