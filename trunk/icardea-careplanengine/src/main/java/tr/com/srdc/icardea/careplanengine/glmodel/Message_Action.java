package tr.com.srdc.icardea.careplanengine.glmodel;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protegex.owl.model.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Message_Action
 *
 * @version generated on Thu Jun 08 17:30:01 EEST 2006
 */
public interface Message_Action extends Programming_Oriented_Action_Specification {

    // Property http://www.owl-ontologies.com/unnamed.owl#message
    Alarm_Entity getMessage();

    RDFProperty getMessageProperty();

    boolean hasMessage();

    void setMessage(Alarm_Entity newMessage);

    // Property http://www.owl-ontologies.com/unnamed.owl#message_destination
    String getMessage_destination();

    RDFProperty getMessage_destinationProperty();

    boolean hasMessage_destination();

    void setMessage_destination(String newMessage_destination);
}


//~ Formatted by Jindent --- http://www.jindent.com
