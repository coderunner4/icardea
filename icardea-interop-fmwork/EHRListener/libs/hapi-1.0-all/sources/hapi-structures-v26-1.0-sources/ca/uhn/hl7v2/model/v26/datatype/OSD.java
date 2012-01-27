package ca.uhn.hl7v2.model.v26.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 OSD (Order Sequence Definition) data type.  Consists of the following components: </p><ol>
 * <li>Sequence/Results Flag (ID)</li>
 * <li>Placer Order Number: Entity Identifier (ST)</li>
 * <li>Placer Order Number: Namespace ID (IS)</li>
 * <li>Filler Order Number: Entity Identifier (ST)</li>
 * <li>Filler Order Number: Namespace ID (IS)</li>
 * <li>Sequence Condition Value (ST)</li>
 * <li>Maximum Number of Repeats (NM)</li>
 * <li>Placer Order Number: Universal ID (ST)</li>
 * <li>Placer Order Number: Universal ID Type (ID)</li>
 * <li>Filler Order Number: Universal ID (ST)</li>
 * <li>Filler Order Number: Universal ID Type (ID)</li>
 * </ol>
 */
public class OSD extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a OSD.
	 * @param message the Message to which this Type belongs
	 */
	public OSD(Message message) {
		super(message);
		data = new Type[11];
		data[0] = new ID(message, 524);
		data[1] = new ST(message);
		data[2] = new IS(message, 363);
		data[3] = new ST(message);
		data[4] = new IS(message, 363);
		data[5] = new ST(message);
		data[6] = new NM(message);
		data[7] = new ST(message);
		data[8] = new ID(message, 301);
		data[9] = new ST(message);
		data[10] = new ID(message, 301);
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
			throw new DataTypeException("Element " + number + " doesn't exist in 11 element OSD composite"); 
		} 
	} 
	/**
	 * Returns Sequence/Results Flag (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getSequenceResultsFlag() {
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
	 * Returns Sequence/Results Flag (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getOsd1_SequenceResultsFlag() {
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
	 * Returns Placer Order Number: Entity Identifier (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getPlacerOrderNumberEntityIdentifier() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Placer Order Number: Entity Identifier (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOsd2_PlacerOrderNumberEntityIdentifier() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Placer Order Number: Namespace ID (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getPlacerOrderNumberNamespaceID() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Placer Order Number: Namespace ID (component #2).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getOsd3_PlacerOrderNumberNamespaceID() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(2);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Filler Order Number: Entity Identifier (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getFillerOrderNumberEntityIdentifier() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Filler Order Number: Entity Identifier (component #3).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOsd4_FillerOrderNumberEntityIdentifier() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(3);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Filler Order Number: Namespace ID (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getFillerOrderNumberNamespaceID() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Filler Order Number: Namespace ID (component #4).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public IS getOsd5_FillerOrderNumberNamespaceID() {
	   IS ret = null;
	   try {
	      ret = (IS)getComponent(4);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Sequence Condition Value (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getSequenceConditionValue() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Sequence Condition Value (component #5).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOsd6_SequenceConditionValue() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(5);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Maximum Number of Repeats (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getMaximumNumberOfRepeats() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Maximum Number of Repeats (component #6).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public NM getOsd7_MaximumNumberOfRepeats() {
	   NM ret = null;
	   try {
	      ret = (NM)getComponent(6);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Placer Order Number: Universal ID (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getPlacerOrderNumberUniversalID() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(7);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Placer Order Number: Universal ID (component #7).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOsd8_PlacerOrderNumberUniversalID() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(7);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Placer Order Number: Universal ID Type (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getPlacerOrderNumberUniversalIDType() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(8);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Placer Order Number: Universal ID Type (component #8).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getOsd9_PlacerOrderNumberUniversalIDType() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(8);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Filler Order Number: Universal ID (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getFillerOrderNumberUniversalID() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(9);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Filler Order Number: Universal ID (component #9).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ST getOsd10_FillerOrderNumberUniversalID() {
	   ST ret = null;
	   try {
	      ret = (ST)getComponent(9);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Filler Order Number: Universal ID Type (component #10).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getFillerOrderNumberUniversalIDType() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(10);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Filler Order Number: Universal ID Type (component #10).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public ID getOsd11_FillerOrderNumberUniversalIDType() {
	   ID ret = null;
	   try {
	      ret = (ID)getComponent(10);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}