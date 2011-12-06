package tr.com.srdc.icardea.careplanengine.glmodel.impl;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.impl.*;

import tr.com.srdc.icardea.careplanengine.glmodel.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Index
 *
 * @version generated on Thu Jun 08 17:30:01 EEST 2006
 */
public class DefaultIndex extends DefaultObservation_Value implements Index {
    public DefaultIndex() {}

    public DefaultIndex(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#index
    public float getIndex() {
        return getPropertyValueLiteral(getIndexProperty()).getFloat();
    }

    public RDFProperty getIndexProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#index";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasIndex() {
        return getPropertyValueCount(getIndexProperty()) > 0;
    }

    public void setIndex(float newIndex) {
        setPropertyValue(getIndexProperty(), new Float(newIndex));
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#precision
    public int getPrecision() {
        return getPropertyValueLiteral(getPrecisionProperty()).getInt();
    }

    public RDFProperty getPrecisionProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#precision";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasPrecision() {
        return getPropertyValueCount(getPrecisionProperty()) > 0;
    }

    public void setPrecision(int newPrecision) {
        setPropertyValue(getPrecisionProperty(), new Integer(newPrecision));
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
