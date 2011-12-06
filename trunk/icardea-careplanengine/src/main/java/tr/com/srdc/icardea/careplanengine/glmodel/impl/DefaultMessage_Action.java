package tr.com.srdc.icardea.careplanengine.glmodel.impl;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protege.model.FrameID;
import edu.stanford.smi.protegex.owl.model.*;
import edu.stanford.smi.protegex.owl.model.impl.*;

import tr.com.srdc.icardea.careplanengine.glmodel.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Message_Action
 *
 * @version generated on Thu Jun 08 17:30:01 EEST 2006
 */
public class DefaultMessage_Action extends DefaultProgramming_Oriented_Action_Specification implements Message_Action {
    public DefaultMessage_Action() {}

    public DefaultMessage_Action(OWLModel owlModel, FrameID id) {
        super(owlModel, id);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#message
    public Alarm_Entity getMessage() {
        return (Alarm_Entity) getPropertyValueAs(getMessageProperty(), Alarm_Entity.class);
    }

    public RDFProperty getMessageProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#message";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasMessage() {
        return getPropertyValueCount(getMessageProperty()) > 0;
    }

    public void setMessage(Alarm_Entity newMessage) {
        setPropertyValue(getMessageProperty(), newMessage);
    }

    // Property http://www.owl-ontologies.com/unnamed.owl#message_destination
    public String getMessage_destination() {
        return (String) getPropertyValue(getMessage_destinationProperty());
    }

    public RDFProperty getMessage_destinationProperty() {
        final String uri  = "http://www.owl-ontologies.com/unnamed.owl#message_destination";
        final String name = getOWLModel().getResourceNameForURI(uri);

        return getOWLModel().getRDFProperty(name);
    }

    public boolean hasMessage_destination() {
        return getPropertyValueCount(getMessage_destinationProperty()) > 0;
    }

    public void setMessage_destination(String newMessage_destination) {
        setPropertyValue(getMessage_destinationProperty(), newMessage_destination);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
