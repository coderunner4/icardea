package ca.uhn.hl7v2.model.v26.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v26.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORD_O04_ORDER_DIET Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common Order) <b></b><br>
 * 1: ORD_O04_TIMING_DIET (a Group object) <b>optional repeating</b><br>
 * 2: ODS (Dietary Orders, Supplements, and Preferences) <b>optional repeating</b><br>
 * 3: NTE (Notes and Comments) <b>optional repeating</b><br>
 */
public class ORD_O04_ORDER_DIET extends AbstractGroup {

	/** 
	 * Creates a new ORD_O04_ORDER_DIET Group.
	 */
	public ORD_O04_ORDER_DIET(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(ORD_O04_TIMING_DIET.class, false, true);
	      this.add(ODS.class, false, true);
	      this.add(NTE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORD_O04_ORDER_DIET - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of ORD_O04_TIMING_DIET (a Group object) - creates it if necessary
	 */
	public ORD_O04_TIMING_DIET getTIMING_DIET() { 
	   ORD_O04_TIMING_DIET ret = null;
	   try {
	      ret = (ORD_O04_TIMING_DIET)this.get("TIMING_DIET");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORD_O04_TIMING_DIET
	 * (a Group object) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORD_O04_TIMING_DIET getTIMING_DIET(int rep) throws HL7Exception { 
	   return (ORD_O04_TIMING_DIET)this.get("TIMING_DIET", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORD_O04_TIMING_DIET 
	 */ 
	public int getTIMING_DIETReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("TIMING_DIET").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of ORD_O04_TIMING_DIET
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertTIMING_DIET(ORD_O04_TIMING_DIET structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of ORD_O04_TIMING_DIET
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public ORD_O04_TIMING_DIET insertTIMING_DIET(int rep) throws HL7Exception { 
	   return (ORD_O04_TIMING_DIET)super.insertRepetition("TIMING_DIET", rep);
	}

	/**
	 * Removes a specific repetition of ORD_O04_TIMING_DIET
	 * (a Group object)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public ORD_O04_TIMING_DIET removeTIMING_DIET(int rep) throws HL7Exception { 
	   return (ORD_O04_TIMING_DIET)super.removeRepetition("TIMING_DIET", rep);
	}

	/**
	 * Returns  first repetition of ODS (Dietary Orders, Supplements, and Preferences) - creates it if necessary
	 */
	public ODS getODS() { 
	   ODS ret = null;
	   try {
	      ret = (ODS)this.get("ODS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ODS
	 * (Dietary Orders, Supplements, and Preferences) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ODS getODS(int rep) throws HL7Exception { 
	   return (ODS)this.get("ODS", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ODS 
	 */ 
	public int getODSReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ODS").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of ODS
	 * (Dietary Orders, Supplements, and Preferences)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertODS(ODS structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of ODS
	 * (Dietary Orders, Supplements, and Preferences)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public ODS insertODS(int rep) throws HL7Exception { 
	   return (ODS)super.insertRepetition("ODS", rep);
	}

	/**
	 * Removes a specific repetition of ODS
	 * (Dietary Orders, Supplements, and Preferences)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public ODS removeODS(int rep) throws HL7Exception { 
	   return (ODS)super.removeRepetition("ODS", rep);
	}

	/**
	 * Returns  first repetition of NTE (Notes and Comments) - creates it if necessary
	 */
	public NTE getNTE() { 
	   NTE ret = null;
	   try {
	      ret = (NTE)this.get("NTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of NTE
	 * (Notes and Comments) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public NTE getNTE(int rep) throws HL7Exception { 
	   return (NTE)this.get("NTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of NTE 
	 */ 
	public int getNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("NTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of NTE
	 * (Notes and Comments)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertNTE(NTE structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of NTE
	 * (Notes and Comments)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public NTE insertNTE(int rep) throws HL7Exception { 
	   return (NTE)super.insertRepetition("NTE", rep);
	}

	/**
	 * Removes a specific repetition of NTE
	 * (Notes and Comments)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public NTE removeNTE(int rep) throws HL7Exception { 
	   return (NTE)super.removeRepetition("NTE", rep);
	}

}