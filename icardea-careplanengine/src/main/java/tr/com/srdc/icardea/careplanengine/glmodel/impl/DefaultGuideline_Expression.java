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
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Guideline_Expression
 *
 * @version generated on Thu Jun 08 17:29:56 EEST 2006
 */
public class DefaultGuideline_Expression extends DefaultExpression implements Guideline_Expression {
    private DefaultGuideline_Model_Entity gME = null;

    public DefaultGuideline_Expression() {}

    public DefaultGuideline_Expression(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
        gME = new DefaultGuideline_Model_Entity(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#Get_Data_Items
    public Collection getGet_Data_Items() {
        return getPropertyValuesAs(getGet_Data_ItemsProperty(), Get_Data_Action.class);
    }

    public RDFProperty getGet_Data_ItemsProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#Get_Data_Items";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasGet_Data_Items() {
        return getPropertyValueCount(getGet_Data_ItemsProperty()) > 0;
    }

    public Iterator listGet_Data_Items() {
        return listPropertyValuesAs(getGet_Data_ItemsProperty(), Get_Data_Action.class);
    }

    public void addGet_Data_Items(Get_Data_Action newGet_Data_Items) {
        addPropertyValue(getGet_Data_ItemsProperty(), newGet_Data_Items);
    }

    public void removeGet_Data_Items(Get_Data_Action oldGet_Data_Items) {
        removePropertyValue(getGet_Data_ItemsProperty(), oldGet_Data_Items);
    }

    public void setGet_Data_Items(Collection newGet_Data_Items) {
        setPropertyValues(getGet_Data_ItemsProperty(), newGet_Data_Items);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#Get_Knowledge_Items
    public Collection getGet_Knowledge_Items() {
        return getPropertyValuesAs(getGet_Knowledge_ItemsProperty(), Get_Knowledge_Action.class);
    }

    public RDFProperty getGet_Knowledge_ItemsProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#Get_Knowledge_Items";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasGet_Knowledge_Items() {
        return getPropertyValueCount(getGet_Knowledge_ItemsProperty()) > 0;
    }

    public Iterator listGet_Knowledge_Items() {
        return listPropertyValuesAs(getGet_Knowledge_ItemsProperty(), Get_Knowledge_Action.class);
    }

    public void addGet_Knowledge_Items(Get_Knowledge_Action newGet_Knowledge_Items) {
        addPropertyValue(getGet_Knowledge_ItemsProperty(), newGet_Knowledge_Items);
    }

    public void removeGet_Knowledge_Items(Get_Knowledge_Action oldGet_Knowledge_Items) {
        removePropertyValue(getGet_Knowledge_ItemsProperty(), oldGet_Knowledge_Items);
    }

    public void setGet_Knowledge_Items(Collection newGet_Knowledge_Items) {
        setPropertyValues(getGet_Knowledge_ItemsProperty(), newGet_Knowledge_Items);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#didactics
    public Collection getDidactics() {
        return getPropertyValuesAs(getDidacticsProperty(), Supplemental_Material_List.class);
    }

    public RDFProperty getDidacticsProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#didactics";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasDidactics() {
        return getPropertyValueCount(getDidacticsProperty()) > 0;
    }

    public Iterator listDidactics() {
        return listPropertyValuesAs(getDidacticsProperty(), Supplemental_Material_List.class);
    }

    public void addDidactics(Supplemental_Material_List newDidactics) {
        addPropertyValue(getDidacticsProperty(), newDidactics);
    }

    public void removeDidactics(Supplemental_Material_List oldDidactics) {
        removePropertyValue(getDidacticsProperty(), oldDidactics);
    }

    public void setDidactics(Collection newDidactics) {
        setPropertyValues(getDidacticsProperty(), newDidactics);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#let_expressions
    public Collection getLet_expressions() {
        return getPropertyValuesAs(getLet_expressionsProperty(), Let_Expression.class);
    }

    public RDFProperty getLet_expressionsProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#let_expressions";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasLet_expressions() {
        return getPropertyValueCount(getLet_expressionsProperty()) > 0;
    }

    public Iterator listLet_expressions() {
        return listPropertyValuesAs(getLet_expressionsProperty(), Let_Expression.class);
    }

    public void addLet_expressions(Let_Expression newLet_expressions) {
        addPropertyValue(getLet_expressionsProperty(), newLet_expressions);
    }

    public void removeLet_expressions(Let_Expression oldLet_expressions) {
        removePropertyValue(getLet_expressionsProperty(), oldLet_expressions);
    }

    public void setLet_expressions(Collection newLet_expressions) {
        setPropertyValues(getLet_expressionsProperty(), newLet_expressions);
    }

    public String getName2() {
        return gME.getName2();
    }

    public RDFProperty getName2Property() {
        return gME.getName2Property();
    }

    public boolean hasName2() {
        return gME.hasName2();
    }

    public void setName2(String newName2) {
        gME.setName2(newName2);
    }

    public String toString() {
        return gME.getName2();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
