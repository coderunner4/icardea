package tr.com.srdc.icardea.careplanengine.glmodel.impl;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.impl.*;

import tr.com.srdc.icardea.careplanengine.glmodel.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Concept_Value
 *
 * @version generated on Thu Jun 08 17:29:58 EEST 2006
 */
public class DefaultConcept_Value extends DefaultInstance_Value implements Concept_Value {
    public DefaultConcept_Value() {}

    public DefaultConcept_Value(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#concept_value
    public Concept getConcept_value() {
        return (Concept) getPropertyValueAs(getConcept_valueProperty(), Concept.class);
    }

    public RDFProperty getConcept_valueProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#concept_value";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasConcept_value() {
        return getPropertyValueCount(getConcept_valueProperty()) > 0;
    }

    public void setConcept_value(Concept newConcept_value) {
        setPropertyValue(getConcept_valueProperty(), newConcept_value);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com