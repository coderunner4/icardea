package tr.com.srdc.icardea.careplanengine.glmodel;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protegex.owl.model.*;

//~--- JDK imports ------------------------------------------------------------

import java.util.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Rectangle
 *
 * @version generated on Thu Jun 08 17:30:00 EEST 2006
 */
public interface Rectangle extends Diagram_Entity {

    // Property http://www.owl-ontologies.com/unnamed.owl#lower_right_corner
    Collection getLower_right_corner();

    RDFProperty getLower_right_cornerProperty();

    boolean hasLower_right_corner();

    Iterator listLower_right_corner();

    void addLower_right_corner(Point newLower_right_corner);

    void removeLower_right_corner(Point oldLower_right_corner);

    void setLower_right_corner(Collection newLower_right_corner);

    // Property http://www.owl-ontologies.com/unnamed.owl#upper_left_corner
    Collection getUpper_left_corner();

    RDFProperty getUpper_left_cornerProperty();

    boolean hasUpper_left_corner();

    Iterator listUpper_left_corner();

    void addUpper_left_corner(Point newUpper_left_corner);

    void removeUpper_left_corner(Point oldUpper_left_corner);

    void setUpper_left_corner(Collection newUpper_left_corner);
}


//~ Formatted by Jindent --- http://www.jindent.com
