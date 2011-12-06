package tr.com.srdc.icardea.careplanengine.glmodel.impl;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.impl.*;

import tr.com.srdc.icardea.careplanengine.glmodel.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Concept_Relationship
 *
 * @version generated on Thu Jun 08 17:30:02 EEST 2006
 */
public class DefaultConcept_Relationship extends DefaultCore_GLIF_Class implements Concept_Relationship {
    public DefaultConcept_Relationship() {}

    public DefaultConcept_Relationship(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#concept_from
    public Concept getConcept_from() {
        return (Concept) getPropertyValueAs(getConcept_fromProperty(), Concept.class);
    }

    public RDFProperty getConcept_fromProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#concept_from";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasConcept_from() {
        return getPropertyValueCount(getConcept_fromProperty()) > 0;
    }

    public void setConcept_from(Concept newConcept_from) {
        setPropertyValue(getConcept_fromProperty(), newConcept_from);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#concept_to
    public Concept getConcept_to() {
        return (Concept) getPropertyValueAs(getConcept_toProperty(), Concept.class);
    }

    public RDFProperty getConcept_toProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#concept_to";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasConcept_to() {
        return getPropertyValueCount(getConcept_toProperty()) > 0;
    }

    public void setConcept_to(Concept newConcept_to) {
        setPropertyValue(getConcept_toProperty(), newConcept_to);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#directionality
    public String getDirectionality() {
        return (String) getPropertyValue(getDirectionalityProperty());
    }

    public RDFProperty getDirectionalityProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#directionality";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasDirectionality() {
        return getPropertyValueCount(getDirectionalityProperty()) > 0;
    }

    public void setDirectionality(String newDirectionality) {
        setPropertyValue(getDirectionalityProperty(), newDirectionality);
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

    // Property http://www.owl-ontologies.com/unnamed.owl#relationship_id
    public String getRelationship_id() {
        return (String) getPropertyValue(getRelationship_idProperty());
    }

    public RDFProperty getRelationship_idProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#relationship_id";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasRelationship_id() {
        return getPropertyValueCount(getRelationship_idProperty()) > 0;
    }

    public void setRelationship_id(String newRelationship_id) {
        setPropertyValue(getRelationship_idProperty(), newRelationship_id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#relationship_source
    public String getRelationship_source() {
        return (String) getPropertyValue(getRelationship_sourceProperty());
    }

    public RDFProperty getRelationship_sourceProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#relationship_source";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasRelationship_source() {
        return getPropertyValueCount(getRelationship_sourceProperty()) > 0;
    }

    public void setRelationship_source(String newRelationship_source) {
        setPropertyValue(getRelationship_sourceProperty(), newRelationship_source);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#relationship_type
    public String getRelationship_type() {
        return (String) getPropertyValue(getRelationship_typeProperty());
    }

    public RDFProperty getRelationship_typeProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#relationship_type";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasRelationship_type() {
        return getPropertyValueCount(getRelationship_typeProperty()) > 0;
    }

    public void setRelationship_type(String newRelationship_type) {
        setPropertyValue(getRelationship_typeProperty(), newRelationship_type);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
