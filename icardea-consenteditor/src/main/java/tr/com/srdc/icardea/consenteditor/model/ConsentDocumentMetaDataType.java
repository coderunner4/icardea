//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.11.23 at 04:13:06 PM EET 
//


package tr.com.srdc.icardea.consenteditor.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for consentDocumentMetaDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consentDocumentMetaDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="patientId" type="{model.consenteditor.srdc.com.tr}non_empty_string" minOccurs="0"/>
 *         &lt;element name="definition" type="{model.consenteditor.srdc.com.tr}non_empty_string" minOccurs="0"/>
 *         &lt;element name="creationDate" type="{model.consenteditor.srdc.com.tr}non_empty_string" minOccurs="0"/>
 *         &lt;element name="modificationDate" type="{model.consenteditor.srdc.com.tr}non_empty_string" minOccurs="0"/>
 *         &lt;element name="expirationDate" type="{model.consenteditor.srdc.com.tr}non_empty_string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consentDocumentMetaDataType", propOrder = {
    "patientId",
    "definition",
    "creationDate",
    "modificationDate",
    "expirationDate"
})
@Entity(name = "ConsentDocumentMetaDataType")
@Table(name = "CONSENTDOCUMENTMETADATATYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class ConsentDocumentMetaDataType
    implements Serializable, Equals, HashCode
{

    protected String patientId;
    protected String definition;
    protected String creationDate;
    protected String modificationDate;
    protected String expirationDate;
    @XmlTransient
    protected Long hjid;

    /**
     * Gets the value of the patientId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "PATIENTID", length = 255)
    public String getPatientId() {
        return patientId;
    }

    /**
     * Sets the value of the patientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientId(String value) {
        this.patientId = value;
    }

    /**
     * Gets the value of the definition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "DEFINITION", length = 255)
    public String getDefinition() {
        return definition;
    }

    /**
     * Sets the value of the definition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefinition(String value) {
        this.definition = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "CREATIONDATE", length = 255)
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDate(String value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the modificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "MODIFICATIONDATE", length = 255)
    public String getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the value of the modificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModificationDate(String value) {
        this.modificationDate = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "EXPIRATIONDATE", length = 255)
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationDate(String value) {
        this.expirationDate = value;
    }

    /**
     * 
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Id
    @Column(name = "HJID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getHjid() {
        return hjid;
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHjid(Long value) {
        this.hjid = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ConsentDocumentMetaDataType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ConsentDocumentMetaDataType that = ((ConsentDocumentMetaDataType) object);
        {
            String lhsPatientId;
            lhsPatientId = this.getPatientId();
            String rhsPatientId;
            rhsPatientId = that.getPatientId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "patientId", lhsPatientId), LocatorUtils.property(thatLocator, "patientId", rhsPatientId), lhsPatientId, rhsPatientId)) {
                return false;
            }
        }
        {
            String lhsDefinition;
            lhsDefinition = this.getDefinition();
            String rhsDefinition;
            rhsDefinition = that.getDefinition();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "definition", lhsDefinition), LocatorUtils.property(thatLocator, "definition", rhsDefinition), lhsDefinition, rhsDefinition)) {
                return false;
            }
        }
        {
            String lhsCreationDate;
            lhsCreationDate = this.getCreationDate();
            String rhsCreationDate;
            rhsCreationDate = that.getCreationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "creationDate", lhsCreationDate), LocatorUtils.property(thatLocator, "creationDate", rhsCreationDate), lhsCreationDate, rhsCreationDate)) {
                return false;
            }
        }
        {
            String lhsModificationDate;
            lhsModificationDate = this.getModificationDate();
            String rhsModificationDate;
            rhsModificationDate = that.getModificationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "modificationDate", lhsModificationDate), LocatorUtils.property(thatLocator, "modificationDate", rhsModificationDate), lhsModificationDate, rhsModificationDate)) {
                return false;
            }
        }
        {
            String lhsExpirationDate;
            lhsExpirationDate = this.getExpirationDate();
            String rhsExpirationDate;
            rhsExpirationDate = that.getExpirationDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "expirationDate", lhsExpirationDate), LocatorUtils.property(thatLocator, "expirationDate", rhsExpirationDate), lhsExpirationDate, rhsExpirationDate)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String thePatientId;
            thePatientId = this.getPatientId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "patientId", thePatientId), currentHashCode, thePatientId);
        }
        {
            String theDefinition;
            theDefinition = this.getDefinition();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "definition", theDefinition), currentHashCode, theDefinition);
        }
        {
            String theCreationDate;
            theCreationDate = this.getCreationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "creationDate", theCreationDate), currentHashCode, theCreationDate);
        }
        {
            String theModificationDate;
            theModificationDate = this.getModificationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "modificationDate", theModificationDate), currentHashCode, theModificationDate);
        }
        {
            String theExpirationDate;
            theExpirationDate = this.getExpirationDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "expirationDate", theExpirationDate), currentHashCode, theExpirationDate);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}