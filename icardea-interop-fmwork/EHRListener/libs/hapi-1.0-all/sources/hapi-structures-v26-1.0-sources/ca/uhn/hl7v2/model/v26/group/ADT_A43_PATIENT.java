package ca.uhn.hl7v2.model.v26.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v26.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ADT_A43_PATIENT Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PID (Patient Identification) <b></b><br>
 * 1: PD1 (Patient Additional Demographic) <b>optional </b><br>
 * 2: ARV (Access Restriction) <b>optional repeating</b><br>
 * 3: MRG (Merge Patient Information) <b></b><br>
 */
public class ADT_A43_PATIENT extends AbstractGroup {

	/** 
	 * Creates a new ADT_A43_PATIENT Group.
	 */
	public ADT_A43_PATIENT(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PID.class, true, false);
	      this.add(PD1.class, false, false);
	      this.add(ARV.class, false, true);
	      this.add(MRG.class, true, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ADT_A43_PATIENT - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PID (Patient Identification) - creates it if necessary
	 */
	public PID getPID() { 
	   PID ret = null;
	   try {
	      ret = (PID)this.get("PID");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns PD1 (Patient Additional Demographic) - creates it if necessary
	 */
	public PD1 getPD1() { 
	   PD1 ret = null;
	   try {
	      ret = (PD1)this.get("PD1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of ARV (Access Restriction) - creates it if necessary
	 */
	public ARV getARV() { 
	   ARV ret = null;
	   try {
	      ret = (ARV)this.get("ARV");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ARV
	 * (Access Restriction) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ARV getARV(int rep) throws HL7Exception { 
	   return (ARV)this.get("ARV", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ARV 
	 */ 
	public int getARVReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ARV").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of ARV
	 * (Access Restriction)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertARV(ARV structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of ARV
	 * (Access Restriction)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public ARV insertARV(int rep) throws HL7Exception { 
	   return (ARV)super.insertRepetition("ARV", rep);
	}

	/**
	 * Removes a specific repetition of ARV
	 * (Access Restriction)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public ARV removeARV(int rep) throws HL7Exception { 
	   return (ARV)super.removeRepetition("ARV", rep);
	}

	/**
	 * Returns MRG (Merge Patient Information) - creates it if necessary
	 */
	public MRG getMRG() { 
	   MRG ret = null;
	   try {
	      ret = (MRG)this.get("MRG");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}