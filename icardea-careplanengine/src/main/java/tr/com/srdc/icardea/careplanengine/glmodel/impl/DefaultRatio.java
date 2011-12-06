package tr.com.srdc.icardea.careplanengine.glmodel.impl;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.impl.*;

import tr.com.srdc.icardea.careplanengine.glmodel.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Ratio
 *
 * @version generated on Thu Jun 08 17:30:03 EEST 2006
 */
public class DefaultRatio extends DefaultObservation_Value implements Ratio {
    public DefaultRatio() {}

    public DefaultRatio(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#denomerator
    public int getDenomerator() {
        return getPropertyValueLiteral(getDenomeratorProperty()).getInt();
    }

    public RDFProperty getDenomeratorProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#denomerator";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasDenomerator() {
        return getPropertyValueCount(getDenomeratorProperty()) > 0;
    }

    public void setDenomerator(int newDenomerator) {
        setPropertyValue(getDenomeratorProperty(), new Integer(newDenomerator));
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

    // Property http://www.owl-ontologies.com/unnamed.owl#numerator
    public int getNumerator() {
        return getPropertyValueLiteral(getNumeratorProperty()).getInt();
    }

    public RDFProperty getNumeratorProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#numerator";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasNumerator() {
        return getPropertyValueCount(getNumeratorProperty()) > 0;
    }

    public void setNumerator(int newNumerator) {
        setPropertyValue(getNumeratorProperty(), new Integer(newNumerator));
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
