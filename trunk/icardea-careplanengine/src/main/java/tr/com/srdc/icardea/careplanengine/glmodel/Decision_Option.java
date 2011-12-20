package tr.com.srdc.icardea.careplanengine.glmodel;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protegex.owl.model.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Decision_Option
 *
 * @version generated on Thu Jun 08 17:30:03 EEST 2006
 */
public interface Decision_Option extends GLIF_Entity {

    // Property http://www.owl-ontologies.com/unnamed.owl#condition_value
    Decision_Condition getCondition_value();

    RDFProperty getCondition_valueProperty();

    boolean hasCondition_value();

    void setCondition_value(Decision_Condition newCondition_value);

    // Property http://www.owl-ontologies.com/unnamed.owl#destination
    Guideline_Step getDestination();

    RDFProperty getDestinationProperty();

    boolean hasDestination();

    void setDestination(Guideline_Step newDestination);

    // Property http://www.owl-ontologies.com/unnamed.owl#display_name
    String getDisplay_name();

    RDFProperty getDisplay_nameProperty();

    boolean hasDisplay_name();

    void setDisplay_name(String newDisplay_name);

    // Property http://www.owl-ontologies.com/unnamed.owl#name2
    String getName2();

    RDFProperty getName2Property();

    boolean hasName2();

    void setName2(String newName2);

    // Property http://www.owl-ontologies.com/unnamed.owl#strength_of_recommendation
    Strength_Of_Evidence_Or_Recommendation getStrength_of_recommendation();

    RDFProperty getStrength_of_recommendationProperty();

    boolean hasStrength_of_recommendation();

    void setStrength_of_recommendation(Strength_Of_Evidence_Or_Recommendation newStrength_of_recommendation);
}


//~ Formatted by Jindent --- http://www.jindent.com