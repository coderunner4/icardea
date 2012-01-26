package ca.uhn.hl7v2.model.v26.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v26.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RSP_K31_ORDER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common Order) <b></b><br>
 * 1: RSP_K31_TIMING (a Group object) <b>optional repeating</b><br>
 * 2: RSP_K31_ORDER_DETAIL (a Group object) <b>optional </b><br>
 * 3: RSP_K31_ENCODING (a Group object) <b>optional </b><br>
 * 4: RXD (Pharmacy/Treatment Dispense) <b></b><br>
 * 5: RXR (Pharmacy/Treatment Route) <b>repeating</b><br>
 * 6: RXC (Pharmacy/Treatment Component Order) <b>optional repeating</b><br>
 * 7: RSP_K31_OBSERVATION (a Group object) <b>repeating</b><br>
 */
public class RSP_K31_ORDER extends AbstractGroup {

	/** 
	 * Creates a new RSP_K31_ORDER Group.
	 */
	public RSP_K31_ORDER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(RSP_K31_TIMING.class, false, true);
	      this.add(RSP_K31_ORDER_DETAIL.class, false, false);
	      this.add(RSP_K31_ENCODING.class, false, false);
	      this.add(RXD.class, true, false);
	      this.add(RXR.class, true, true);
	      this.add(RXC.class, false, true);
	      this.add(RSP_K31_OBSERVATION.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RSP_K31_ORDER - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORC (Common Order) - creates it if necessary
	 */
	public ORC getORC() { 
	   ORC ret = null;
	   try {
	      ret = (ORC)this.get("ORC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RSP_K31_TIMING (a Group object) - creates it if necessary
	 */
	public RSP_K31_TIMING getTIMING() { 
	   RSP_K31_TIMING ret = null;
	   try {
	      ret = (RSP_K31_TIMING)this.get("TIMING");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RSP_K31_TIMING
	 * (a Group object) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RSP_K31_TIMING getTIMING(int rep) throws HL7Exception { 
	   return (RSP_K31_TIMING)this.get("TIMING", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RSP_K31_TIMING 
	 */ 
	public int getTIMINGReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("TIMING").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of RSP_K31_TIMING
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertTIMING(RSP_K31_TIMING structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of RSP_K31_TIMING
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public RSP_K31_TIMING insertTIMING(int rep) throws HL7Exception { 
	   return (RSP_K31_TIMING)super.insertRepetition("TIMING", rep);
	}

	/**
	 * Removes a specific repetition of RSP_K31_TIMING
	 * (a Group object)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public RSP_K31_TIMING removeTIMING(int rep) throws HL7Exception { 
	   return (RSP_K31_TIMING)super.removeRepetition("TIMING", rep);
	}

	/**
	 * Returns RSP_K31_ORDER_DETAIL (a Group object) - creates it if necessary
	 */
	public RSP_K31_ORDER_DETAIL getORDER_DETAIL() { 
	   RSP_K31_ORDER_DETAIL ret = null;
	   try {
	      ret = (RSP_K31_ORDER_DETAIL)this.get("ORDER_DETAIL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RSP_K31_ENCODING (a Group object) - creates it if necessary
	 */
	public RSP_K31_ENCODING getENCODING() { 
	   RSP_K31_ENCODING ret = null;
	   try {
	      ret = (RSP_K31_ENCODING)this.get("ENCODING");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RXD (Pharmacy/Treatment Dispense) - creates it if necessary
	 */
	public RXD getRXD() { 
	   RXD ret = null;
	   try {
	      ret = (RXD)this.get("RXD");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RXR (Pharmacy/Treatment Route) - creates it if necessary
	 */
	public RXR getRXR() { 
	   RXR ret = null;
	   try {
	      ret = (RXR)this.get("RXR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RXR
	 * (Pharmacy/Treatment Route) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RXR getRXR(int rep) throws HL7Exception { 
	   return (RXR)this.get("RXR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RXR 
	 */ 
	public int getRXRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RXR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of RXR
	 * (Pharmacy/Treatment Route)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertRXR(RXR structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of RXR
	 * (Pharmacy/Treatment Route)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public RXR insertRXR(int rep) throws HL7Exception { 
	   return (RXR)super.insertRepetition("RXR", rep);
	}

	/**
	 * Removes a specific repetition of RXR
	 * (Pharmacy/Treatment Route)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public RXR removeRXR(int rep) throws HL7Exception { 
	   return (RXR)super.removeRepetition("RXR", rep);
	}

	/**
	 * Returns  first repetition of RXC (Pharmacy/Treatment Component Order) - creates it if necessary
	 */
	public RXC getRXC() { 
	   RXC ret = null;
	   try {
	      ret = (RXC)this.get("RXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RXC
	 * (Pharmacy/Treatment Component Order) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RXC getRXC(int rep) throws HL7Exception { 
	   return (RXC)this.get("RXC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RXC 
	 */ 
	public int getRXCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RXC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of RXC
	 * (Pharmacy/Treatment Component Order)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertRXC(RXC structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of RXC
	 * (Pharmacy/Treatment Component Order)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public RXC insertRXC(int rep) throws HL7Exception { 
	   return (RXC)super.insertRepetition("RXC", rep);
	}

	/**
	 * Removes a specific repetition of RXC
	 * (Pharmacy/Treatment Component Order)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public RXC removeRXC(int rep) throws HL7Exception { 
	   return (RXC)super.removeRepetition("RXC", rep);
	}

	/**
	 * Returns  first repetition of RSP_K31_OBSERVATION (a Group object) - creates it if necessary
	 */
	public RSP_K31_OBSERVATION getOBSERVATION() { 
	   RSP_K31_OBSERVATION ret = null;
	   try {
	      ret = (RSP_K31_OBSERVATION)this.get("OBSERVATION");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RSP_K31_OBSERVATION
	 * (a Group object) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RSP_K31_OBSERVATION getOBSERVATION(int rep) throws HL7Exception { 
	   return (RSP_K31_OBSERVATION)this.get("OBSERVATION", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RSP_K31_OBSERVATION 
	 */ 
	public int getOBSERVATIONReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("OBSERVATION").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of RSP_K31_OBSERVATION
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertOBSERVATION(RSP_K31_OBSERVATION structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of RSP_K31_OBSERVATION
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public RSP_K31_OBSERVATION insertOBSERVATION(int rep) throws HL7Exception { 
	   return (RSP_K31_OBSERVATION)super.insertRepetition("OBSERVATION", rep);
	}

	/**
	 * Removes a specific repetition of RSP_K31_OBSERVATION
	 * (a Group object)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public RSP_K31_OBSERVATION removeOBSERVATION(int rep) throws HL7Exception { 
	   return (RSP_K31_OBSERVATION)super.removeRepetition("OBSERVATION", rep);
	}

}
