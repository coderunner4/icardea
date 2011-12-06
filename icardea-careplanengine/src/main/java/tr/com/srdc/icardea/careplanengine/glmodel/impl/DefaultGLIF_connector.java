package tr.com.srdc.icardea.careplanengine.glmodel.impl;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.impl.*;

import tr.com.srdc.icardea.careplanengine.glmodel.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#GLIF_connector
 *
 * @version generated on Thu Jun 08 17:29:55 EEST 2006
 */
public class DefaultGLIF_connector extends DefaultRDFIndividual implements GLIF_connector {
    public DefaultGLIF_connector() {}

    public DefaultGLIF_connector(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#name2
    public String getName2() {
        return (String) getPropertyValue(getName2Property());
    }

    public RDFProperty getName2Property() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#name2";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasName2() {
        return getPropertyValueCount(getName2Property()) > 0;
    }

    public void setName2(String newName2) {
        setPropertyValue(getName2Property(), newName2);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
