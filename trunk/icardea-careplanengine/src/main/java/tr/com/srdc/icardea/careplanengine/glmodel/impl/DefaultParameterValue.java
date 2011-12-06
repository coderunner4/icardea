package tr.com.srdc.icardea.careplanengine.glmodel.impl;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.impl.*;

import tr.com.srdc.icardea.careplanengine.glmodel.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#ParameterValue
 *
 * @version generated on Thu Jun 08 17:29:59 EEST 2006
 */
public class DefaultParameterValue extends DefaultParameter implements ParameterValue {
    public DefaultParameterValue() {}

    public DefaultParameterValue(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#parameter_value
    public Data_Value getParameter_value() {
        return (Data_Value) getPropertyValueAs(getParameter_valueProperty(), Data_Value.class);
    }

    public RDFProperty getParameter_valueProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#parameter_value";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasParameter_value() {
        return getPropertyValueCount(getParameter_valueProperty()) > 0;
    }

    public void setParameter_value(Data_Value newParameter_value) {
        setPropertyValue(getParameter_valueProperty(), newParameter_value);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
