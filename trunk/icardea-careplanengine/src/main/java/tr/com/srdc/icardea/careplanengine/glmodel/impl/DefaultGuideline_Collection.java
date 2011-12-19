package tr.com.srdc.icardea.careplanengine.glmodel.impl;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.impl.*;

import tr.com.srdc.icardea.careplanengine.glmodel.*;

//~--- JDK imports ------------------------------------------------------------

import java.util.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Guideline_Collection
 *
 * @version generated on Thu Jun 08 17:30:02 EEST 2006
 */
public class DefaultGuideline_Collection extends DefaultGuideline_Model_Entity implements Guideline_Collection {
    public DefaultGuideline_Collection() {}

    public DefaultGuideline_Collection(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#guidelines
    public Collection getGuidelines() {
        return getPropertyValuesAs(getGuidelinesProperty(), Guideline.class);
    }

    public RDFProperty getGuidelinesProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#guidelines";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasGuidelines() {
        return getPropertyValueCount(getGuidelinesProperty()) > 0;
    }

    public Iterator listGuidelines() {
        return listPropertyValuesAs(getGuidelinesProperty(), Guideline.class);
    }

    public void addGuidelines(Guideline newGuidelines) {
        addPropertyValue(getGuidelinesProperty(), newGuidelines);
    }

    public void removeGuidelines(Guideline oldGuidelines) {
        removePropertyValue(getGuidelinesProperty(), oldGuidelines);
    }

    public void setGuidelines(Collection newGuidelines) {
        setPropertyValues(getGuidelinesProperty(), newGuidelines);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com