package tr.com.srdc.icardea.careplanengine.glmodel.impl;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.impl.*;

import tr.com.srdc.icardea.careplanengine.glmodel.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Let_Expression
 *
 * @version generated on Thu Jun 08 17:30:02 EEST 2006
 */
public class DefaultLet_Expression extends DefaultGuideline_Model_Entity implements Let_Expression {
    public DefaultLet_Expression() {}

    public DefaultLet_Expression(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#expression_string
    public String getExpression_string() {
        return (String) getPropertyValue(getExpression_stringProperty());
    }

    public RDFProperty getExpression_stringProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#expression_string";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasExpression_string() {
        return getPropertyValueCount(getExpression_stringProperty()) > 0;
    }

    public void setExpression_string(String newExpression_string) {
        setPropertyValue(getExpression_stringProperty(), newExpression_string);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#identifier
    public String getIdentifier() {
        return (String) getPropertyValue(getIdentifierProperty());
    }

    public RDFProperty getIdentifierProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#identifier";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasIdentifier() {
        return getPropertyValueCount(getIdentifierProperty()) > 0;
    }

    public void setIdentifier(String newIdentifier) {
        setPropertyValue(getIdentifierProperty(), newIdentifier);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com