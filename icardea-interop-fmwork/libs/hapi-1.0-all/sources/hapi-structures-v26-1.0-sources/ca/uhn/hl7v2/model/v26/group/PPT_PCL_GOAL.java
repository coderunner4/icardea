package ca.uhn.hl7v2.model.v26.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v26.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PPT_PCL_GOAL Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: GOL (Goal Detail) <b></b><br>
 * 1: NTE (Notes and Comments) <b>optional repeating</b><br>
 * 2: VAR (Variance) <b>optional repeating</b><br>
 * 3: PPT_PCL_GOAL_ROLE (a Group object) <b>optional repeating</b><br>
 * 4: PPT_PCL_GOAL_OBSERVATION (a Group object) <b>optional repeating</b><br>
 * 5: PPT_PCL_PROBLEM (a Group object) <b>optional repeating</b><br>
 * 6: PPT_PCL_ORDER (a Group object) <b>optional repeating</b><br>
 */
public class PPT_PCL_GOAL extends AbstractGroup {

	/** 
	 * Creates a new PPT_PCL_GOAL Group.
	 */
	public PPT_PCL_GOAL(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(GOL.class, true, false);
	      this.add(NTE.class, false, true);
	      this.add(VAR.class, false, true);
	      this.add(PPT_PCL_GOAL_ROLE.class, false, true);
	      this.add(PPT_PCL_GOAL_OBSERVATION.class, false, true);
	      this.add(PPT_PCL_PROBLEM.class, false, true);
	      this.add(PPT_PCL_ORDER.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PPT_PCL_GOAL - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns GOL (Goal Detail) - creates it if necessary
	 */
	public GOL getGOL() { 
	   GOL ret = null;
	   try {
	      ret = (GOL)this.get("GOL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
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

	/**
	 * Returns  first repetition of VAR (Variance) - creates it if necessary
	 */
	public VAR getVAR() { 
	   VAR ret = null;
	   try {
	      ret = (VAR)this.get("VAR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of VAR
	 * (Variance) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public VAR getVAR(int rep) throws HL7Exception { 
	   return (VAR)this.get("VAR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of VAR 
	 */ 
	public int getVARReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("VAR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of VAR
	 * (Variance)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertVAR(VAR structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of VAR
	 * (Variance)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public VAR insertVAR(int rep) throws HL7Exception { 
	   return (VAR)super.insertRepetition("VAR", rep);
	}

	/**
	 * Removes a specific repetition of VAR
	 * (Variance)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public VAR removeVAR(int rep) throws HL7Exception { 
	   return (VAR)super.removeRepetition("VAR", rep);
	}

	/**
	 * Returns  first repetition of PPT_PCL_GOAL_ROLE (a Group object) - creates it if necessary
	 */
	public PPT_PCL_GOAL_ROLE getGOAL_ROLE() { 
	   PPT_PCL_GOAL_ROLE ret = null;
	   try {
	      ret = (PPT_PCL_GOAL_ROLE)this.get("GOAL_ROLE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPT_PCL_GOAL_ROLE
	 * (a Group object) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPT_PCL_GOAL_ROLE getGOAL_ROLE(int rep) throws HL7Exception { 
	   return (PPT_PCL_GOAL_ROLE)this.get("GOAL_ROLE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPT_PCL_GOAL_ROLE 
	 */ 
	public int getGOAL_ROLEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("GOAL_ROLE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of PPT_PCL_GOAL_ROLE
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertGOAL_ROLE(PPT_PCL_GOAL_ROLE structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of PPT_PCL_GOAL_ROLE
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public PPT_PCL_GOAL_ROLE insertGOAL_ROLE(int rep) throws HL7Exception { 
	   return (PPT_PCL_GOAL_ROLE)super.insertRepetition("GOAL_ROLE", rep);
	}

	/**
	 * Removes a specific repetition of PPT_PCL_GOAL_ROLE
	 * (a Group object)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public PPT_PCL_GOAL_ROLE removeGOAL_ROLE(int rep) throws HL7Exception { 
	   return (PPT_PCL_GOAL_ROLE)super.removeRepetition("GOAL_ROLE", rep);
	}

	/**
	 * Returns  first repetition of PPT_PCL_GOAL_OBSERVATION (a Group object) - creates it if necessary
	 */
	public PPT_PCL_GOAL_OBSERVATION getGOAL_OBSERVATION() { 
	   PPT_PCL_GOAL_OBSERVATION ret = null;
	   try {
	      ret = (PPT_PCL_GOAL_OBSERVATION)this.get("GOAL_OBSERVATION");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPT_PCL_GOAL_OBSERVATION
	 * (a Group object) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPT_PCL_GOAL_OBSERVATION getGOAL_OBSERVATION(int rep) throws HL7Exception { 
	   return (PPT_PCL_GOAL_OBSERVATION)this.get("GOAL_OBSERVATION", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPT_PCL_GOAL_OBSERVATION 
	 */ 
	public int getGOAL_OBSERVATIONReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("GOAL_OBSERVATION").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of PPT_PCL_GOAL_OBSERVATION
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertGOAL_OBSERVATION(PPT_PCL_GOAL_OBSERVATION structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of PPT_PCL_GOAL_OBSERVATION
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public PPT_PCL_GOAL_OBSERVATION insertGOAL_OBSERVATION(int rep) throws HL7Exception { 
	   return (PPT_PCL_GOAL_OBSERVATION)super.insertRepetition("GOAL_OBSERVATION", rep);
	}

	/**
	 * Removes a specific repetition of PPT_PCL_GOAL_OBSERVATION
	 * (a Group object)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public PPT_PCL_GOAL_OBSERVATION removeGOAL_OBSERVATION(int rep) throws HL7Exception { 
	   return (PPT_PCL_GOAL_OBSERVATION)super.removeRepetition("GOAL_OBSERVATION", rep);
	}

	/**
	 * Returns  first repetition of PPT_PCL_PROBLEM (a Group object) - creates it if necessary
	 */
	public PPT_PCL_PROBLEM getPROBLEM() { 
	   PPT_PCL_PROBLEM ret = null;
	   try {
	      ret = (PPT_PCL_PROBLEM)this.get("PROBLEM");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPT_PCL_PROBLEM
	 * (a Group object) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPT_PCL_PROBLEM getPROBLEM(int rep) throws HL7Exception { 
	   return (PPT_PCL_PROBLEM)this.get("PROBLEM", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPT_PCL_PROBLEM 
	 */ 
	public int getPROBLEMReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PROBLEM").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of PPT_PCL_PROBLEM
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertPROBLEM(PPT_PCL_PROBLEM structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of PPT_PCL_PROBLEM
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public PPT_PCL_PROBLEM insertPROBLEM(int rep) throws HL7Exception { 
	   return (PPT_PCL_PROBLEM)super.insertRepetition("PROBLEM", rep);
	}

	/**
	 * Removes a specific repetition of PPT_PCL_PROBLEM
	 * (a Group object)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public PPT_PCL_PROBLEM removePROBLEM(int rep) throws HL7Exception { 
	   return (PPT_PCL_PROBLEM)super.removeRepetition("PROBLEM", rep);
	}

	/**
	 * Returns  first repetition of PPT_PCL_ORDER (a Group object) - creates it if necessary
	 */
	public PPT_PCL_ORDER getORDER() { 
	   PPT_PCL_ORDER ret = null;
	   try {
	      ret = (PPT_PCL_ORDER)this.get("ORDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPT_PCL_ORDER
	 * (a Group object) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPT_PCL_ORDER getORDER(int rep) throws HL7Exception { 
	   return (PPT_PCL_ORDER)this.get("ORDER", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPT_PCL_ORDER 
	 */ 
	public int getORDERReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORDER").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of PPT_PCL_ORDER
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertORDER(PPT_PCL_ORDER structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of PPT_PCL_ORDER
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public PPT_PCL_ORDER insertORDER(int rep) throws HL7Exception { 
	   return (PPT_PCL_ORDER)super.insertRepetition("ORDER", rep);
	}

	/**
	 * Removes a specific repetition of PPT_PCL_ORDER
	 * (a Group object)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public PPT_PCL_ORDER removeORDER(int rep) throws HL7Exception { 
	   return (PPT_PCL_ORDER)super.removeRepetition("ORDER", rep);
	}

}
