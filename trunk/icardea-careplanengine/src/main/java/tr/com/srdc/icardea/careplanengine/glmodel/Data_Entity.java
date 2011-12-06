package tr.com.srdc.icardea.careplanengine.glmodel;

//~--- non-JDK imports --------------------------------------------------------

import edu.stanford.smi.protegex.owl.model.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.owl-ontologies.com/unnamed.owl#Data_Entity
 *
 * @version generated on Thu Jun 08 17:29:57 EEST 2006
 */
public interface Data_Entity extends Medical_Knowledge_Layer {

    // Property http://www.owl-ontologies.com/unnamed.owl#input
    Data_Item getInput();

    RDFProperty getInputProperty();

    boolean hasInput();

    void setInput(Data_Item newInput);

    // Property http://www.owl-ontologies.com/unnamed.owl#is_critical
    boolean getIs_critical();

    RDFProperty getIs_criticalProperty();

    boolean hasIs_critical();

    void setIs_critical(boolean newIs_critical);

    // Property http://www.owl-ontologies.com/unnamed.owl#is_synchronous
    boolean getIs_synchronous();

    RDFProperty getIs_synchronousProperty();

    boolean hasIs_synchronous();

    void setIs_synchronous(boolean newIs_synchronous);

    // Property http://www.owl-ontologies.com/unnamed.owl#output
    Data_Item getOutput();

    RDFProperty getOutputProperty();

    boolean hasOutput();

    void setOutput(Data_Item newOutput);

    // Property http://www.owl-ontologies.com/unnamed.owl#semantic_category
    Concept getSemantic_category();

    RDFProperty getSemantic_categoryProperty();

    boolean hasSemantic_category();

    void setSemantic_category(Concept newSemantic_category);

    // Property http://www.owl-ontologies.com/unnamed.owl#service_owls
    String getService_owls();

    RDFProperty getService_owlsProperty();

    boolean hasService_owls();

    void setService_owls(String newService_owls);

    // Property http://www.owl-ontologies.com/unnamed.owl#service_wsdl
    String getService_wsdl();

    RDFProperty getService_wsdlProperty();

    boolean hasService_wsdl();

    void setService_wsdl(String newService_wsdl);

    // Property http://www.owl-ontologies.com/unnamed.owl#service_xsd
    String getService_xsd();

    RDFProperty getService_xsdProperty();

    boolean hasService_xsd();

    void setService_xsd(String newService_xsd);
}


//~ Formatted by Jindent --- http://www.jindent.com
