package ca.uhn.hl7v2.model.v26.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v26.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFR_M05_MF_LOC_DEPT Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: LDP (Location Department) <b></b><br>
 * 1: LCH (Location Characteristic) <b>optional repeating</b><br>
 * 2: LCC (Location Charge Code) <b>optional repeating</b><br>
 */
public class MFR_M05_MF_LOC_DEPT extends AbstractGroup {

	/** 
	 * Creates a new MFR_M05_MF_LOC_DEPT Group.
	 */
	public MFR_M05_MF_LOC_DEPT(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(LDP.class, true, false);
	      this.add(LCH.class, false, true);
	      this.add(LCC.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFR_M05_MF_LOC_DEPT - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns LDP (Location Department) - creates it if necessary
	 */
	public LDP getLDP() { 
	   LDP ret = null;
	   try {
	      ret = (LDP)this.get("LDP");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of LCH (Location Characteristic) - creates it if necessary
	 */
	public LCH getLCH() { 
	   LCH ret = null;
	   try {
	      ret = (LCH)this.get("LCH");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of LCH
	 * (Location Characteristic) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public LCH getLCH(int rep) throws HL7Exception { 
	   return (LCH)this.get("LCH", rep);
	}

	/** 
	 * Returns the number of existing repetitions of LCH 
	 */ 
	public int getLCHReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("LCH").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of LCH
	 * (Location Characteristic)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertLCH(LCH structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of LCH
	 * (Location Characteristic)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public LCH insertLCH(int rep) throws HL7Exception { 
	   return (LCH)super.insertRepetition("LCH", rep);
	}

	/**
	 * Removes a specific repetition of LCH
	 * (Location Characteristic)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public LCH removeLCH(int rep) throws HL7Exception { 
	   return (LCH)super.removeRepetition("LCH", rep);
	}

	/**
	 * Returns  first repetition of LCC (Location Charge Code) - creates it if necessary
	 */
	public LCC getLCC() { 
	   LCC ret = null;
	   try {
	      ret = (LCC)this.get("LCC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of LCC
	 * (Location Charge Code) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public LCC getLCC(int rep) throws HL7Exception { 
	   return (LCC)this.get("LCC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of LCC 
	 */ 
	public int getLCCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("LCC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of LCC
	 * (Location Charge Code)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertLCC(LCC structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of LCC
	 * (Location Charge Code)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public LCC insertLCC(int rep) throws HL7Exception { 
	   return (LCC)super.insertRepetition("LCC", rep);
	}

	/**
	 * Removes a specific repetition of LCC
	 * (Location Charge Code)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public LCC removeLCC(int rep) throws HL7Exception { 
	   return (LCC)super.removeRepetition("LCC", rep);
	}

}