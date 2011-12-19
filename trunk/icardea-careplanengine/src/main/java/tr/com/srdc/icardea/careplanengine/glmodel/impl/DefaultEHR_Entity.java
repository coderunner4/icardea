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
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#EHR_Entity
 *
 * @version generated on Thu Jun 08 17:29:57 EEST 2006
 */
public class DefaultEHR_Entity extends DefaultData_Entity implements EHR_Entity {
    public DefaultEHR_Entity() {}

    public DefaultEHR_Entity(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#agent_id
    public String getAgent_id() {
        return (String) getPropertyValue(getAgent_idProperty());
    }

    public RDFProperty getAgent_idProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#agent_id";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasAgent_id() {
        return getPropertyValueCount(getAgent_idProperty()) > 0;
    }

    public void setAgent_id(String newAgent_id) {
        setPropertyValue(getAgent_idProperty(), newAgent_id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#object_ids
    public Collection getObject_ids() {
        return getPropertyValues(getObject_idsProperty());
    }

    public RDFProperty getObject_idsProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#object_ids";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasObject_ids() {
        return getPropertyValueCount(getObject_idsProperty()) > 0;
    }

    public Iterator listObject_ids() {
        return listPropertyValues(getObject_idsProperty());
    }

    public void addObject_ids(String newObject_ids) {
        addPropertyValue(getObject_idsProperty(), newObject_ids);
    }

    public void removeObject_ids(String oldObject_ids) {
        removePropertyValue(getObject_idsProperty(), oldObject_ids);
    }

    public void setObject_ids(Collection newObject_ids) {
        setPropertyValues(getObject_idsProperty(), newObject_ids);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#type
    public String getType() {
        return (String) getPropertyValue(getTypeProperty());
    }

    public RDFProperty getTypeProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#type";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasType() {
        return getPropertyValueCount(getTypeProperty()) > 0;
    }

    public void setType(String newType) {
        setPropertyValue(getTypeProperty(), newType);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com