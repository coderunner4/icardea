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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for COCT_MT080000UV.DerivedSpecimen complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="COCT_MT080000UV.DerivedSpecimen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}II"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="specimenNatural" type="{urn:hl7-org:v3}COCT_MT080000UV.Natural" minOccurs="0"/>
 *           &lt;element name="specimenManufacturedMaterial" type="{urn:hl7-org:v3}COCT_MT080000UV.ManufacturedMaterial" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element name="subjectOf1" type="{urn:hl7-org:v3}COCT_MT080000UV.Subject2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subjectOf2" type="{urn:hl7-org:v3}COCT_MT080000UV.Subject3" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productOf" type="{urn:hl7-org:v3}COCT_MT080000UV.Product" minOccurs="0"/>
 *         &lt;element name="related" type="{urn:hl7-org:v3}COCT_MT080000UV.SourceOf" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}RoleClassSpecimen" />
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCT_MT080000UV.DerivedSpecimen", propOrder = {
    "realmCode",
    "typeId",
    "templateId",
    "id",
    "code",
    "specimenNatural",
    "specimenManufacturedMaterial",
    "subjectOf1",
    "subjectOf2",
    "productOf",
    "related"
})
public class COCTMT080000UVDerivedSpecimen {

    protected List<CS> realmCode;
    protected II typeId;
    protected List<II> templateId;
    @XmlElement(required = true)
    protected II id;
    protected CE code;
    @XmlElementRef(name = "specimenNatural", namespace = "urn:hl7-org:v3", type = JAXBElement.class)
    protected JAXBElement<COCTMT080000UVNatural> specimenNatural;
    @XmlElementRef(name = "specimenManufacturedMaterial", namespace = "urn:hl7-org:v3", type = JAXBElement.class)
    protected JAXBElement<COCTMT080000UVManufacturedMaterial> specimenManufacturedMaterial;
    @XmlElement(nillable = true)
    protected List<COCTMT080000UVSubject2> subjectOf1;
    @XmlElement(nillable = true)
    protected List<COCTMT080000UVSubject3> subjectOf2;
    @XmlElementRef(name = "productOf", namespace = "urn:hl7-org:v3", type = JAXBElement.class)
    protected JAXBElement<COCTMT080000UVProduct> productOf;
    @XmlElementRef(name = "related", namespace = "urn:hl7-org:v3", type = JAXBElement.class)
    protected JAXBElement<COCTMT080000UVSourceOf> related;
    @XmlAttribute(required = true)
    protected RoleClassSpecimen classCode;
    @XmlAttribute
    protected NullFlavor nullFlavor;

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
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link II }
     *     
     */
    public II getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link II }
     *     
     */
    public void setId(II value) {
        this.id = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link CE }
     *     
     */
    public CE getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link CE }
     *     
     */
    public void setCode(CE value) {
        this.code = value;
    }

    /**
     * Gets the value of the specimenNatural property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link COCTMT080000UVNatural }{@code >}
     *     
     */
    public JAXBElement<COCTMT080000UVNatural> getSpecimenNatural() {
        return specimenNatural;
    }

    /**
     * Sets the value of the specimenNatural property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link COCTMT080000UVNatural }{@code >}
     *     
     */
    public void setSpecimenNatural(JAXBElement<COCTMT080000UVNatural> value) {
        this.specimenNatural = ((JAXBElement<COCTMT080000UVNatural> ) value);
    }

    /**
     * Gets the value of the specimenManufacturedMaterial property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link COCTMT080000UVManufacturedMaterial }{@code >}
     *     
     */
    public JAXBElement<COCTMT080000UVManufacturedMaterial> getSpecimenManufacturedMaterial() {
        return specimenManufacturedMaterial;
    }

    /**
     * Sets the value of the specimenManufacturedMaterial property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link COCTMT080000UVManufacturedMaterial }{@code >}
     *     
     */
    public void setSpecimenManufacturedMaterial(JAXBElement<COCTMT080000UVManufacturedMaterial> value) {
        this.specimenManufacturedMaterial = ((JAXBElement<COCTMT080000UVManufacturedMaterial> ) value);
    }

    /**
     * Gets the value of the subjectOf1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subjectOf1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubjectOf1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COCTMT080000UVSubject2 }
     * 
     * 
     */
    public List<COCTMT080000UVSubject2> getSubjectOf1() {
        if (subjectOf1 == null) {
            subjectOf1 = new ArrayList<COCTMT080000UVSubject2>();
        }
        return this.subjectOf1;
    }

    /**
     * Gets the value of the subjectOf2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subjectOf2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubjectOf2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link COCTMT080000UVSubject3 }
     * 
     * 
     */
    public List<COCTMT080000UVSubject3> getSubjectOf2() {
        if (subjectOf2 == null) {
            subjectOf2 = new ArrayList<COCTMT080000UVSubject3>();
        }
        return this.subjectOf2;
    }

    /**
     * Gets the value of the productOf property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link COCTMT080000UVProduct }{@code >}
     *     
     */
    public JAXBElement<COCTMT080000UVProduct> getProductOf() {
        return productOf;
    }

    /**
     * Sets the value of the productOf property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link COCTMT080000UVProduct }{@code >}
     *     
     */
    public void setProductOf(JAXBElement<COCTMT080000UVProduct> value) {
        this.productOf = ((JAXBElement<COCTMT080000UVProduct> ) value);
    }

    /**
     * Gets the value of the related property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link COCTMT080000UVSourceOf }{@code >}
     *     
     */
    public JAXBElement<COCTMT080000UVSourceOf> getRelated() {
        return related;
    }

    /**
     * Sets the value of the related property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link COCTMT080000UVSourceOf }{@code >}
     *     
     */
    public void setRelated(JAXBElement<COCTMT080000UVSourceOf> value) {
        this.related = ((JAXBElement<COCTMT080000UVSourceOf> ) value);
    }

    /**
     * Gets the value of the classCode property.
     * 
     * @return
     *     possible object is
     *     {@link RoleClassSpecimen }
     *     
     */
    public RoleClassSpecimen getClassCode() {
        return classCode;
    }

    /**
     * Sets the value of the classCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleClassSpecimen }
     *     
     */
    public void setClassCode(RoleClassSpecimen value) {
        this.classCode = value;
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

}
