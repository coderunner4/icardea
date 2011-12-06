package tr.com.srdc.icardea.careplanengine.glmodel.impl;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.impl.*;

import tr.com.srdc.icardea.careplanengine.glmodel.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Text_Material
 *
 * @version generated on Thu Jun 08 17:29:58 EEST 2006
 */
public class DefaultText_Material extends DefaultSupplemental_Material implements Text_Material {
    public DefaultText_Material() {}

    public DefaultText_Material(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#material
    public String getMaterial() {
        return (String) getPropertyValue(getMaterialProperty());
    }

    public RDFProperty getMaterialProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#material";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasMaterial() {
        return getPropertyValueCount(getMaterialProperty()) > 0;
    }

    public void setMaterial(String newMaterial) {
        setPropertyValue(getMaterialProperty(), newMaterial);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
