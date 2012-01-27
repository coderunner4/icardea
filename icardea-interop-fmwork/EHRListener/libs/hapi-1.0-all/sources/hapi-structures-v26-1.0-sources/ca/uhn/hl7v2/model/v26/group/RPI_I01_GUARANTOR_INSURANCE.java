package ca.uhn.hl7v2.model.v26.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v26.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RPI_I01_GUARANTOR_INSURANCE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: GT1 (Guarantor) <b>optional repeating</b><br>
 * 1: RPI_I01_INSURANCE (a Group object) <b>repeating</b><br>
 */
public class RPI_I01_GUARANTOR_INSURANCE extends AbstractGroup {

	/** 
	 * Creates a new RPI_I01_GUARANTOR_INSURANCE Group.
	 */
	public RPI_I01_GUARANTOR_INSURANCE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(GT1.class, false, true);
	      this.add(RPI_I01_INSURANCE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RPI_I01_GUARANTOR_INSURANCE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns  first repetition of GT1 (Guarantor) - creates it if necessary
	 */
	public GT1 getGT1() { 
	   GT1 ret = null;
	   try {
	      ret = (GT1)this.get("GT1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of GT1
	 * (Guarantor) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public GT1 getGT1(int rep) throws HL7Exception { 
	   return (GT1)this.get("GT1", rep);
	}

	/** 
	 * Returns the number of existing repetitions of GT1 
	 */ 
	public int getGT1Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("GT1").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of GT1
	 * (Guarantor)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertGT1(GT1 structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of GT1
	 * (Guarantor)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public GT1 insertGT1(int rep) throws HL7Exception { 
	   return (GT1)super.insertRepetition("GT1", rep);
	}

	/**
	 * Removes a specific repetition of GT1
	 * (Guarantor)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public GT1 removeGT1(int rep) throws HL7Exception { 
	   return (GT1)super.removeRepetition("GT1", rep);
	}

	/**
	 * Returns  first repetition of RPI_I01_INSURANCE (a Group object) - creates it if necessary
	 */
	public RPI_I01_INSURANCE getINSURANCE() { 
	   RPI_I01_INSURANCE ret = null;
	   try {
	      ret = (RPI_I01_INSURANCE)this.get("INSURANCE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RPI_I01_INSURANCE
	 * (a Group object) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RPI_I01_INSURANCE getINSURANCE(int rep) throws HL7Exception { 
	   return (RPI_I01_INSURANCE)this.get("INSURANCE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RPI_I01_INSURANCE 
	 */ 
	public int getINSURANCEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("INSURANCE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of RPI_I01_INSURANCE
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertINSURANCE(RPI_I01_INSURANCE structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of RPI_I01_INSURANCE
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public RPI_I01_INSURANCE insertINSURANCE(int rep) throws HL7Exception { 
	   return (RPI_I01_INSURANCE)super.insertRepetition("INSURANCE", rep);
	}

	/**
	 * Removes a specific repetition of RPI_I01_INSURANCE
	 * (a Group object)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public RPI_I01_INSURANCE removeINSURANCE(int rep) throws HL7Exception { 
	   return (RPI_I01_INSURANCE)super.removeRepetition("INSURANCE", rep);
	}

}