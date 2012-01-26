package ca.uhn.hl7v2.model.v26.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v26.group.*;

import ca.uhn.hl7v2.model.v26.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a MFN_M08 message structure (see chapter 8.8.3). This structure contains the 
 * following elements: </p>
 * 0: MSH (Message Header) <b></b><br>
 * 1: SFT (Software Segment) <b>optional repeating</b><br>
 * 2: UAC (User Authentication Credential Segment) <b>optional </b><br>
 * 3: MFI (Master File Identification) <b></b><br>
 * 4: MFN_M08_MF_TEST_NUMERIC (a Group object) <b>repeating</b><br>
 */
public class MFN_M08 extends AbstractMessage  {

	/** 
	 * Creates a new MFN_M08 Group with custom ModelClassFactory.
	 */
	public MFN_M08(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new MFN_M08 Group with DefaultModelClassFactory. 
	 */ 
	public MFN_M08() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(SFT.class, false, true);
	      this.add(UAC.class, false, false);
	      this.add(MFI.class, true, false);
	      this.add(MFN_M08_MF_TEST_NUMERIC.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFN_M08 - this is probably a bug in the source code generator.", e);
	   }
	}

	/** {@inheritDoc} */
	public String getVersion() {
	   return "2.6";
	}

	/**
	 * Returns MSH (Message Header) - creates it if necessary
	 */
	public MSH getMSH() { 
	   MSH ret = null;
	   try {
	      ret = (MSH)this.get("MSH");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of SFT (Software Segment) - creates it if necessary
	 */
	public SFT getSFT() { 
	   SFT ret = null;
	   try {
	      ret = (SFT)this.get("SFT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SFT
	 * (Software Segment) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SFT getSFT(int rep) throws HL7Exception { 
	   return (SFT)this.get("SFT", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SFT 
	 */ 
	public int getSFTReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("SFT").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of SFT
	 * (Software Segment)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertSFT(SFT structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of SFT
	 * (Software Segment)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public SFT insertSFT(int rep) throws HL7Exception { 
	   return (SFT)super.insertRepetition("SFT", rep);
	}

	/**
	 * Removes a specific repetition of SFT
	 * (Software Segment)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public SFT removeSFT(int rep) throws HL7Exception { 
	   return (SFT)super.removeRepetition("SFT", rep);
	}

	/**
	 * Returns UAC (User Authentication Credential Segment) - creates it if necessary
	 */
	public UAC getUAC() { 
	   UAC ret = null;
	   try {
	      ret = (UAC)this.get("UAC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns MFI (Master File Identification) - creates it if necessary
	 */
	public MFI getMFI() { 
	   MFI ret = null;
	   try {
	      ret = (MFI)this.get("MFI");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of MFN_M08_MF_TEST_NUMERIC (a Group object) - creates it if necessary
	 */
	public MFN_M08_MF_TEST_NUMERIC getMF_TEST_NUMERIC() { 
	   MFN_M08_MF_TEST_NUMERIC ret = null;
	   try {
	      ret = (MFN_M08_MF_TEST_NUMERIC)this.get("MF_TEST_NUMERIC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of MFN_M08_MF_TEST_NUMERIC
	 * (a Group object) - creates it if necessary
	 * @throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public MFN_M08_MF_TEST_NUMERIC getMF_TEST_NUMERIC(int rep) throws HL7Exception { 
	   return (MFN_M08_MF_TEST_NUMERIC)this.get("MF_TEST_NUMERIC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of MFN_M08_MF_TEST_NUMERIC 
	 */ 
	public int getMF_TEST_NUMERICReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("MF_TEST_NUMERIC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Inserts a specific repetition of MFN_M08_MF_TEST_NUMERIC
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public void  insertMF_TEST_NUMERIC(MFN_M08_MF_TEST_NUMERIC structure, int rep) throws HL7Exception { 
	   super.insertRepetition( structure, rep);
	}

	/**
	 * Inserts a specific repetition of MFN_M08_MF_TEST_NUMERIC
	 * (a Group object)
	 * @see AbstractGroup#insertRepetition(Structure, int) 
	 */
	public MFN_M08_MF_TEST_NUMERIC insertMF_TEST_NUMERIC(int rep) throws HL7Exception { 
	   return (MFN_M08_MF_TEST_NUMERIC)super.insertRepetition("MF_TEST_NUMERIC", rep);
	}

	/**
	 * Removes a specific repetition of MFN_M08_MF_TEST_NUMERIC
	 * (a Group object)
	 * @see AbstractGroup#insertremoveRepetition(String, int) 
	 */
	public MFN_M08_MF_TEST_NUMERIC removeMF_TEST_NUMERIC(int rep) throws HL7Exception { 
	   return (MFN_M08_MF_TEST_NUMERIC)super.removeRepetition("MF_TEST_NUMERIC", rep);
	}

}
