package tr.com.srdc.icardea.careplanengine.glmodel;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protegex.owl.model.*;

//~--- JDK imports ------------------------------------------------------------

import java.util.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#DataModelClass
 *
 * @version generated on Thu Jun 08 17:30:00 EEST 2006
 */
public interface DataModelClass extends Core_GLIF_Class {

    // Property http://www.owl-ontologies.com/unnamed.owl#attributes
    Collection getAttributes();

    RDFProperty getAttributesProperty();

    boolean hasAttributes();

    Iterator listAttributes();

    void addAttributes(AttributeDescription newAttributes);

    void removeAttributes(AttributeDescription oldAttributes);

    void setAttributes(Collection newAttributes);

    // Property http://www.owl-ontologies.com/unnamed.owl#data_model_class_id
    String getData_model_class_id();

    RDFProperty getData_model_class_idProperty();

    boolean hasData_model_class_id();

    void setData_model_class_id(String newData_model_class_id);

    // Property http://www.owl-ontologies.com/unnamed.owl#data_model_source_id
    String getData_model_source_id();

    RDFProperty getData_model_source_idProperty();

    boolean hasData_model_source_id();

    void setData_model_source_id(String newData_model_source_id);

    // Property http://www.owl-ontologies.com/unnamed.owl#name2
    String getName2();

    RDFProperty getName2Property();

    boolean hasName2();

    void setName2(String newName2);

    // Property http://www.owl-ontologies.com/unnamed.owl#parent_class_id
    String getParent_class_id();

    RDFProperty getParent_class_idProperty();

    boolean hasParent_class_id();

    void setParent_class_id(String newParent_class_id);

    // Property http://www.owl-ontologies.com/unnamed.owl#parent_source_id
    String getParent_source_id();

    RDFProperty getParent_source_idProperty();

    boolean hasParent_source_id();

    void setParent_source_id(String newParent_source_id);
}


//~ Formatted by Jindent --- http://www.jindent.com
