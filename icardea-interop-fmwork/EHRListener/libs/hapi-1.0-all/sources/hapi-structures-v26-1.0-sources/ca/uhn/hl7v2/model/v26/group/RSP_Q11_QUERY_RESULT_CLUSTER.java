package ca.uhn.hl7v2.model.v26.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v26.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RSP_Q11_QUERY_RESULT_CLUSTER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: MFE (Master File Entry) <b></b><br>
 * 1: LOC (Location Identification) <b></b><br>
 * 2: LCH (Location Characteristic) <b>optional repeating</b><br>
 * 3: LRL (Location Relationship) <b>optional repeating</b><br>
 * 4: RSP_Q11_MF_LOC_DEPT (a Group object) <b>repeating</b><br>
 */
public class RSP_Q11_QUERY_RESULT_CLUSTER extends AbstractGroup {

	/** 
	 * Creates a new RSP_Q11_QUERY_RESULT_CLUSTER Group.
	 */
	public RSP_Q11_QUERY_RESULT_CLUSTER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(MFE.class, true, false);
	      this.add(LOC.class, true, false);
	      this.add(LCH.class, false, true);
	      this.add(LRL.class, false, true);
	      this.add(RSP_Q11_MF_LOC_DEPT.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RSP_Q11_QUERY_RESULT_CLUSTER - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MFE (Master File Entry) - creates it if necessary
	 */
	public MFE getMFE() { 
	   MFE ret = null;
	   try {
	      ret = (MFE)this.get("MFE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns LOC (Location Identification) - creates it if necessary
	 */
	public LOC getLOC() { 
	   LOC ret = null;
	   try {
	      ret = (LOC)this.get("LOC");
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
	 * Returns  first repetition of LRL (Location Relationship) - creates it if necessary
	 */
	public LRL getLRL() { 
	   LRL ret = null;
	   try {
	      ret = (LRL)this.get("LRL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of LRL
	 * (Location Relationship) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public LRL getLRL(int rep) throws HL7Exception { 
	   return (LRL)this.get("LRL", rep);
	}

	/** 
	 * Returns the number of existing repetitions of LRL 
	 */ 
	public int getLRLReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("LRL").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of LRL
	 * (Location Relationship)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertLRL(LRL structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of LRL
	 * (Location Relationship)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public LRL insertLRL(int rep) throws HL7Exception { 
	   return (LRL)super.insertRepetition("LRL", rep);
	}

	/**
	 * Removes a specific repetition of LRL
	 * (Location Relationship)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public LRL removeLRL(int rep) throws HL7Exception { 
	   return (LRL)super.removeRepetition("LRL", rep);
	}

	/**
	 * Returns  first repetition of RSP_Q11_MF_LOC_DEPT (a Group object) - creates it if necessary
	 */
	public RSP_Q11_MF_LOC_DEPT getMF_LOC_DEPT() { 
	   RSP_Q11_MF_LOC_DEPT ret = null;
	   try {
	      ret = (RSP_Q11_MF_LOC_DEPT)this.get("MF_LOC_DEPT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RSP_Q11_MF_LOC_DEPT
	 * (a Group object) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RSP_Q11_MF_LOC_DEPT getMF_LOC_DEPT(int rep) throws HL7Exception { 
	   return (RSP_Q11_MF_LOC_DEPT)this.get("MF_LOC_DEPT", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RSP_Q11_MF_LOC_DEPT 
	 */ 
	public int getMF_LOC_DEPTReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("MF_LOC_DEPT").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of RSP_Q11_MF_LOC_DEPT
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertMF_LOC_DEPT(RSP_Q11_MF_LOC_DEPT structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of RSP_Q11_MF_LOC_DEPT
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public RSP_Q11_MF_LOC_DEPT insertMF_LOC_DEPT(int rep) throws HL7Exception { 
	   return (RSP_Q11_MF_LOC_DEPT)super.insertRepetition("MF_LOC_DEPT", rep);
	}

	/**
	 * Removes a specific repetition of RSP_Q11_MF_LOC_DEPT
	 * (a Group object)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public RSP_Q11_MF_LOC_DEPT removeMF_LOC_DEPT(int rep) throws HL7Exception { 
	   return (RSP_Q11_MF_LOC_DEPT)super.removeRepetition("MF_LOC_DEPT", rep);
	}

}