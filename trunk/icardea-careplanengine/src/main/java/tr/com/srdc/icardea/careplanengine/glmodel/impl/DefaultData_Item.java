package tr.com.srdc.icardea.careplanengine.glmodel.impl;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.impl.*;

import tr.com.srdc.icardea.careplanengine.glmodel.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Data_Item
 *
 * @version generated on Thu Jun 08 17:29:58 EEST 2006
 */
public class DefaultData_Item extends DefaultBasic_Data_Type implements Data_Item {
    public DefaultData_Item() {}

    public DefaultData_Item(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#concept
    public Concept getConcept() {
        return (Concept) getPropertyValueAs(getConceptProperty(), Concept.class);
    }

    public RDFProperty getConceptProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#concept";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasConcept() {
        return getPropertyValueCount(getConceptProperty()) > 0;
    }

    public void setConcept(Concept newConcept) {
        setPropertyValue(getConceptProperty(), newConcept);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#data_model_class_id
    public String getData_model_class_id() {
        return (String) getPropertyValue(getData_model_class_idProperty());
    }

    public RDFProperty getData_model_class_idProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#data_model_class_id";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasData_model_class_id() {
        return getPropertyValueCount(getData_model_class_idProperty()) > 0;
    }

    public void setData_model_class_id(String newData_model_class_id) {
        setPropertyValue(getData_model_class_idProperty(), newData_model_class_id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#data_model_source_id
    public String getData_model_source_id() {
        return (String) getPropertyValue(getData_model_source_idProperty());
    }

    public RDFProperty getData_model_source_idProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#data_model_source_id";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasData_model_source_id() {
        return getPropertyValueCount(getData_model_source_idProperty()) > 0;
    }

    public void setData_model_source_id(String newData_model_source_id) {
        setPropertyValue(getData_model_source_idProperty(), newData_model_source_id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#data_value
    public Data_Item_Value getData_value() {
        return (Data_Item_Value) getPropertyValueAs(getData_valueProperty(), Data_Item_Value.class);
    }

    public RDFProperty getData_valueProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#data_value";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasData_value() {
        return getPropertyValueCount(getData_valueProperty()) > 0;
    }

    public void setData_value(Data_Item_Value newData_value) {
        setPropertyValue(getData_valueProperty(), newData_value);
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
