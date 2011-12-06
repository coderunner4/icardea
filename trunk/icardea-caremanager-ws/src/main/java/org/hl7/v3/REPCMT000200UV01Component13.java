//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.03 at 01:53:59 PM EEST 
//


package org.hl7.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for REPC_MT000200UV01.Component13 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="REPC_MT000200UV01.Component13">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="sequenceNumber" type="{urn:hl7-org:v3}INT" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="actDefinition" type="{urn:hl7-org:v3}REPC_MT000200UV01.ActDefinition"/>
 *           &lt;element name="encounterDefinition" type="{urn:hl7-org:v3}REPC_MT000200UV01.EncounterDefinition"/>
 *           &lt;element name="observationDefinition" type="{urn:hl7-org:v3}REPC_MT000200UV01.ObservationDefinition"/>
 *           &lt;element name="procedureDefinition" type="{urn:hl7-org:v3}REPC_MT000200UV01.ProcedureDefinition"/>
 *           &lt;element name="substanceAdministrationDefinition" type="{urn:hl7-org:v3}REPC_MT000200UV01.SubstanceAdministrationDefinition"/>
 *           &lt;element name="supplyEvent" type="{urn:hl7-org:v3}REPC_MT000200UV01.SupplyEvent"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="contextConductionInd" type="{urn:hl7-org:v3}bl" default="false" />
 *       &lt;attribute name="contextControlCode" type="{urn:hl7-org:v3}ContextControl" />
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="typeCode" use="required" type="{urn:hl7-org:v3}ActRelationshipHasComponent" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REPC_MT000200UV01.Component13", propOrder = {
    "realmCode",
    "typeId",
    "templateId",
    "sequenceNumber",
    "actDefinition",
    "encounterDefinition",
    "observationDefinition",
    "procedureDefinition",
    "substanceAdministrationDefinition",
    "supplyEvent"
})
public class REPCMT000200UV01Component13 {

    protected List<CS> realmCode;
    protected II typeId;
    protected List<II> templateId;
    protected INT sequenceNumber;
    @XmlElementRef(name = "actDefinition", namespace = "urn:hl7-org:v3", type = JAXBElement.class)
    protected JAXBElement<REPCMT000200UV01ActDefinition> actDefinition;
    @XmlElementRef(name = "encounterDefinition", namespace = "urn:hl7-org:v3", type = JAXBElement.class)
    protected JAXBElement<REPCMT000200UV01EncounterDefinition> encounterDefinition;
    @XmlElementRef(name = "observationDefinition", namespace = "urn:hl7-org:v3", type = JAXBElement.class)
    protected JAXBElement<REPCMT000200UV01ObservationDefinition> observationDefinition;
    @XmlElementRef(name = "procedureDefinition", namespace = "urn:hl7-org:v3", type = JAXBElement.class)
    protected JAXBElement<REPCMT000200UV01ProcedureDefinition> procedureDefinition;
    @XmlElementRef(name = "substanceAdministrationDefinition", namespace = "urn:hl7-org:v3", type = JAXBElement.class)
    protected JAXBElement<REPCMT000200UV01SubstanceAdministrationDefinition> substanceAdministrationDefinition;
    @XmlElementRef(name = "supplyEvent", namespace = "urn:hl7-org:v3", type = JAXBElement.class)
    protected JAXBElement<REPCMT000200UV01SupplyEvent> supplyEvent;
    @XmlAttribute
    protected Boolean contextConductionInd;
    @XmlAttribute
    protected ContextControl contextControlCode;
    @XmlAttribute
    protected NullFlavor nullFlavor;
    @XmlAttribute(required = true)
    protected ActRelationshipHasComponent typeCode;

    /**
     * Gets the value of the realmCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the realmCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRealmCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CS }
     * 
     * 
     */
    public List<CS> getRealmCode() {
        if (realmCode == null) {
            realmCode = new ArrayList<CS>();
        }
        return this.realmCode;
    }

    /**
     * Gets the value of the typeId property.
     * 
     * @return
     *     possible object is
     *     {@link II }
     *     
     */
    public II getTypeId() {
        return typeId;
    }

    /**
     * Sets the value of the typeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link II }
     *     
     */
    public void setTypeId(II value) {
        this.typeId = value;
    }

    /**
     * Gets the value of the templateId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the templateId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemplateId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link II }
     * 
     * 
     */
    public List<II> getTemplateId() {
        if (templateId == null) {
            templateId = new ArrayList<II>();
        }
        return this.templateId;
    }

    /**
     * Gets the value of the sequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link INT }
     *     
     */
    public INT getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link INT }
     *     
     */
    public void setSequenceNumber(INT value) {
        this.sequenceNumber = value;
    }

    /**
     * Gets the value of the actDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link REPCMT000200UV01ActDefinition }{@code >}
     *     
     */
    public JAXBElement<REPCMT000200UV01ActDefinition> getActDefinition() {
        return actDefinition;
    }

    /**
     * Sets the value of the actDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link REPCMT000200UV01ActDefinition }{@code >}
     *     
     */
    public void setActDefinition(JAXBElement<REPCMT000200UV01ActDefinition> value) {
        this.actDefinition = ((JAXBElement<REPCMT000200UV01ActDefinition> ) value);
    }

    /**
     * Gets the value of the encounterDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link REPCMT000200UV01EncounterDefinition }{@code >}
     *     
     */
    public JAXBElement<REPCMT000200UV01EncounterDefinition> getEncounterDefinition() {
        return encounterDefinition;
    }

    /**
     * Sets the value of the encounterDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link REPCMT000200UV01EncounterDefinition }{@code >}
     *     
     */
    public void setEncounterDefinition(JAXBElement<REPCMT000200UV01EncounterDefinition> value) {
        this.encounterDefinition = ((JAXBElement<REPCMT000200UV01EncounterDefinition> ) value);
    }

    /**
     * Gets the value of the observationDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link REPCMT000200UV01ObservationDefinition }{@code >}
     *     
     */
    public JAXBElement<REPCMT000200UV01ObservationDefinition> getObservationDefinition() {
        return observationDefinition;
    }

    /**
     * Sets the value of the observationDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link REPCMT000200UV01ObservationDefinition }{@code >}
     *     
     */
    public void setObservationDefinition(JAXBElement<REPCMT000200UV01ObservationDefinition> value) {
        this.observationDefinition = ((JAXBElement<REPCMT000200UV01ObservationDefinition> ) value);
    }

    /**
     * Gets the value of the procedureDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link REPCMT000200UV01ProcedureDefinition }{@code >}
     *     
     */
    public JAXBElement<REPCMT000200UV01ProcedureDefinition> getProcedureDefinition() {
        return procedureDefinition;
    }

    /**
     * Sets the value of the procedureDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link REPCMT000200UV01ProcedureDefinition }{@code >}
     *     
     */
    public void setProcedureDefinition(JAXBElement<REPCMT000200UV01ProcedureDefinition> value) {
        this.procedureDefinition = ((JAXBElement<REPCMT000200UV01ProcedureDefinition> ) value);
    }

    /**
     * Gets the value of the substanceAdministrationDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link REPCMT000200UV01SubstanceAdministrationDefinition }{@code >}
     *     
     */
    public JAXBElement<REPCMT000200UV01SubstanceAdministrationDefinition> getSubstanceAdministrationDefinition() {
        return substanceAdministrationDefinition;
    }

    /**
     * Sets the value of the substanceAdministrationDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link REPCMT000200UV01SubstanceAdministrationDefinition }{@code >}
     *     
     */
    public void setSubstanceAdministrationDefinition(JAXBElement<REPCMT000200UV01SubstanceAdministrationDefinition> value) {
        this.substanceAdministrationDefinition = ((JAXBElement<REPCMT000200UV01SubstanceAdministrationDefinition> ) value);
    }

    /**
     * Gets the value of the supplyEvent property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link REPCMT000200UV01SupplyEvent }{@code >}
     *     
     */
    public JAXBElement<REPCMT000200UV01SupplyEvent> getSupplyEvent() {
        return supplyEvent;
    }

    /**
     * Sets the value of the supplyEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link REPCMT000200UV01SupplyEvent }{@code >}
     *     
     */
    public void setSupplyEvent(JAXBElement<REPCMT000200UV01SupplyEvent> value) {
        this.supplyEvent = ((JAXBElement<REPCMT000200UV01SupplyEvent> ) value);
    }

    /**
     * Gets the value of the contextConductionInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isContextConductionInd() {
        if (contextConductionInd == null) {
            return false;
        } else {
            return contextConductionInd;
        }
    }

    /**
     * Sets the value of the contextConductionInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContextConductionInd(Boolean value) {
        this.contextConductionInd = value;
    }

    /**
     * Gets the value of the contextControlCode property.
     * 
     * @return
     *     possible object is
     *     {@link ContextControl }
     *     
     */
    public ContextControl getContextControlCode() {
        return contextControlCode;
    }

    /**
     * Sets the value of the contextControlCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextControl }
     *     
     */
    public void setContextControlCode(ContextControl value) {
        this.contextControlCode = value;
    }

    /**
     * Gets the value of the nullFlavor property.
     * 
     * @return
     *     possible object is
     *     {@link NullFlavor }
     *     
     */
    public NullFlavor getNullFlavor() {
        return nullFlavor;
    }

    /**
     * Sets the value of the nullFlavor property.
     * 
     * @param value
     *     allowed object is
     *     {@link NullFlavor }
     *     
     */
    public void setNullFlavor(NullFlavor value) {
        this.nullFlavor = value;
    }

    /**
     * Gets the value of the typeCode property.
     * 
     * @return
     *     possible object is
     *     {@link ActRelationshipHasComponent }
     *     
     */
    public ActRelationshipHasComponent getTypeCode() {
        return typeCode;
    }

    /**
     * Sets the value of the typeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActRelationshipHasComponent }
     *     
     */
    public void setTypeCode(ActRelationshipHasComponent value) {
        this.typeCode = value;
    }

}
