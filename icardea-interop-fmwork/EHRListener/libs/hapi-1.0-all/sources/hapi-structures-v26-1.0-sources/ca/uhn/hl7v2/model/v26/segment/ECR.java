package ca.uhn.hl7v2.model.v26.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 ECR message segment. 
 * This segment has the following fields:</p><p>
 * ECR-1: Command Response (CWE)<br> 
 * ECR-2: Date/Time Completed (DTM)<br> 
 * ECR-3: Command Response Parameters (TX)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class ECR extends AbstractSegment  {

  /**
   * Creates a ECR (Equipment Command Response) segment object that belongs to the given 
   * message.  
   */
  public ECR(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(CWE.class, true, 1, 705, new Object[]{message}, "Command Response");
       this.add(DTM.class, true, 1, 24, new Object[]{message}, "Date/Time Completed");
       this.add(TX.class, false, 0, 65536, new Object[]{message}, "Command Response Parameters");
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Command Response (ECR-1).
   */
  public CWE getCommandResponse()  {
    CWE ret = null;
    try {
        Type t = this.getField(1, 0);
        ret = (CWE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Command Response (ECR-1).
   */
  public CWE getEcr1_CommandResponse()  {
    CWE ret = null;
    try {
        Type t = this.getField(1, 0);
        ret = (CWE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Date/Time Completed (ECR-2).
   */
  public DTM getDateTimeCompleted()  {
    DTM ret = null;
    try {
        Type t = this.getField(2, 0);
        ret = (DTM)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Date/Time Completed (ECR-2).
   */
  public DTM getEcr2_DateTimeCompleted()  {
    DTM ret = null;
    try {
        Type t = this.getField(2, 0);
        ret = (DTM)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns a single repetition of Command Response Parameters (ECR-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TX getCommandResponseParameters(int rep) throws HL7Exception {
    TX ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (TX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Command Response Parameters (ECR-3).
   */
  public TX[] getCommandResponseParameters() {
     TX[] ret = null;
    try {
        Type[] t = this.getField(3);  
        ret = new TX[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (TX)t[i];
        }
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns a count of the number of repetitions of Command Response Parameters (ECR-3).
   */
  public int getCommandResponseParametersReps() {
    try {
        return this.getField(3).length;  
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
  }

  /**
   * Inserts a repetition of Command Response Parameters (ECR-3) at a given index and returns it.
   * @param index The index
   */
  public TX insertCommandResponseParameters(int index) throws HL7Exception {
     return (TX) super.insertRepetition(3, index);
  }

  /**
   * Removes a repetition of Command Response Parameters (ECR-3) at a given index and returns it.
   * @param index The index
   */
  public TX removeCommandResponseParameters(int index) throws HL7Exception {
     return (TX) super.removeRepetition(3, index);
  }

  /**
   * Returns a single repetition of Command Response Parameters (ECR-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TX getEcr3_CommandResponseParameters(int rep) throws HL7Exception {
    TX ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (TX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Command Response Parameters (ECR-3).
   */
  public TX[] getEcr3_CommandResponseParameters() {
     TX[] ret = null;
    try {
        Type[] t = this.getField(3);  
        ret = new TX[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (TX)t[i];
        }
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns a count of the number of repetitions of Command Response Parameters (ECR-3).
   */
  public int getEcr3_CommandResponseParametersReps() {
    try {
        return this.getField(3).length;  
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
  }

  /**
   * Inserts a repetition of Command Response Parameters (ECR-3) at a given index and returns it.
   * @param index The index
   */
  public TX insertEcr3_CommandResponseParameters(int index) throws HL7Exception {
     return (TX) super.insertRepetition(3, index);
  }

  /**
   * Removes a repetition of Command Response Parameters (ECR-3) at a given index and returns it.
   * @param index The index
   */
  public TX removeEcr3_CommandResponseParameters(int index) throws HL7Exception {
     return (TX) super.removeRepetition(3, index);
  }

   protected Type createNewTypeWithoutReflection(int field) {
      switch (field) {
         case 0: return new ca.uhn.hl7v2.model.v26.datatype.CWE(getMessage());
         case 1: return new ca.uhn.hl7v2.model.v26.datatype.DTM(getMessage());
         case 2: return new ca.uhn.hl7v2.model.v26.datatype.TX(getMessage());
         default: return null;
      }
   }

}