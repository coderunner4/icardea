package ca.uhn.hl7v2.model.v26.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 PTA (Policy Type and Amount) data type.  Consists of the following components: </p><ol>
 * <li>Policy Type (IS)</li>
 * <li>Amount Class (IS)</li>
 * <li>Money or Percentage Quantity (NM)</li>
 * <li>Money or Percentage (MOP)</li>
 * </ol>
 */
public class PTA extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a PTA.
	 * @param message the Message to which this Type belongs
	 */
	public PTA(Message message) {
		super(message);
		data = new Type[4];
		data[0] = new IS(message, 147);
		data[1] = new IS(message, 193);
		data[2] = new NM(message);
		data[3] = new MOP(message);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 4 element PTA composite"); 
		} 
	} 
	/**
	 * Returns Policy Type (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getPolicyType() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Policy Type (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getPta1_PolicyType() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Amount Class (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getAmountClass() {
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
	 * Returns Amount Class (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getPta2_AmountClass() {
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
	 * Returns Money or Percentage Quantity (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getMoneyOrPercentageQuantity() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Money or Percentage Quantity (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getPta3_MoneyOrPercentageQuantity() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Money or Percentage (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public MOP getMoneyOrPercentage() {
	   MOP ret = null;
	   try {
	      ret = (MOP)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Money or Percentage (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public MOP getPta4_MoneyOrPercentage() {
	   MOP ret = null;
	   try {
	      ret = (MOP)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}