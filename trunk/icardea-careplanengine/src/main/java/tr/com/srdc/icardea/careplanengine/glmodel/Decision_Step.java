package tr.com.srdc.icardea.careplanengine.glmodel;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protegex.owl.model.*;

//~--- JDK imports ------------------------------------------------------------

import java.util.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Decision_Step
 *
 * @version generated on Thu Jun 08 17:29:55 EEST 2006
 */
public interface Decision_Step extends Guideline_Step {

    // Property http://www.owl-ontologies.com/unnamed.owl#decision_detail
    Nestable getDecision_detail();

    RDFProperty getDecision_detailProperty();

    boolean hasDecision_detail();

    void setDecision_detail(Nestable newDecision_detail);

    // Property http://www.owl-ontologies.com/unnamed.owl#duration_constraint
    Duration_Interval getDuration_constraint();

    RDFProperty getDuration_constraintProperty();

    boolean hasDuration_constraint();

    void setDuration_constraint(Duration_Interval newDuration_constraint);

    // Property http://www.owl-ontologies.com/unnamed.owl#exceptions
    Collection getExceptions();

    RDFProperty getExceptionsProperty();

    boolean hasExceptions();

    Iterator listExceptions();

    void addExceptions(Guideline_Exception newExceptions);

    void removeExceptions(Guideline_Exception oldExceptions);

    void setExceptions(Collection newExceptions);

    // Property http://www.owl-ontologies.com/unnamed.owl#iteration_info
    Iteration_Specification getIteration_info();

    RDFProperty getIteration_infoProperty();

    boolean hasIteration_info();

    void setIteration_info(Iteration_Specification newIteration_info);

    // Property http://www.owl-ontologies.com/unnamed.owl#options
    Collection getOptions();

    RDFProperty getOptionsProperty();

    boolean hasOptions();

    Iterator listOptions();

    void addOptions(Decision_Option newOptions);

    void removeOptions(Decision_Option oldOptions);

    void setOptions(Collection newOptions);

    // Property http://www.owl-ontologies.com/unnamed.owl#triggering_events
    Collection getTriggering_events();

    RDFProperty getTriggering_eventsProperty();

    boolean hasTriggering_events();

    Iterator listTriggering_events();

    void addTriggering_events(Triggering_Event newTriggering_events);

    void removeTriggering_events(Triggering_Event oldTriggering_events);

    void setTriggering_events(Collection newTriggering_events);
}


//~ Formatted by Jindent --- http://www.jindent.com
