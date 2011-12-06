package tr.com.srdc.icardea.careplanengine.glmodel.impl;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.impl.*;

import tr.com.srdc.icardea.careplanengine.glmodel.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Duration
 *
 * @version generated on Thu Jun 08 17:29:56 EEST 2006
 */
public class DefaultDuration extends DefaultExpression implements Duration {
    public DefaultDuration() {}

    public DefaultDuration(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#display_name
    public String getDisplay_name() {
        return (String) getPropertyValue(getDisplay_nameProperty());
    }

    public RDFProperty getDisplay_nameProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#display_name";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasDisplay_name() {
        return getPropertyValueCount(getDisplay_nameProperty()) > 0;
    }

    public void setDisplay_name(String newDisplay_name) {
        setPropertyValue(getDisplay_nameProperty(), newDisplay_name);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
