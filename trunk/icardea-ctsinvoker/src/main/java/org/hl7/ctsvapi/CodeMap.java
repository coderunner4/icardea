
package org.hl7.ctsvapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CodeMap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CodeMap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="map_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mapDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fromCodeSystem_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fromCodeSystem_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fromCodeSystem_version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toCodeSystem_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toCodeSystem_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toCodeSystem_version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodeMap", propOrder = {
    "mapName",
    "mapDescription",
    "fromCodeSystemId",
    "fromCodeSystemName",
    "fromCodeSystemVersion",
    "toCodeSystemId",
    "toCodeSystemName",
    "toCodeSystemVersion"
})
public class CodeMap {

    @XmlElement(name = "map_name", required = true, nillable = true)
    protected String mapName;
    @XmlElement(required = true, nillable = true)
    protected String mapDescription;
    @XmlElement(name = "fromCodeSystem_id", required = true, nillable = true)
    protected String fromCodeSystemId;
    @XmlElement(name = "fromCodeSystem_name", required = true, nillable = true)
    protected String fromCodeSystemName;
    @XmlElement(name = "fromCodeSystem_version", required = true, nillable = true)
    protected String fromCodeSystemVersion;
    @XmlElement(name = "toCodeSystem_id", required = true, nillable = true)
    protected String toCodeSystemId;
    @XmlElement(name = "toCodeSystem_name", required = true, nillable = true)
    protected String toCodeSystemName;
    @XmlElement(name = "toCodeSystem_version", required = true, nillable = true)
    protected String toCodeSystemVersion;

    /**
     * Gets the value of the mapName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapName() {
        return mapName;
    }

    /**
     * Sets the value of the mapName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapName(String value) {
        this.mapName = value;
    }

    /**
     * Gets the value of the mapDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapDescription() {
        return mapDescription;
    }

    /**
     * Sets the value of the mapDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapDescription(String value) {
        this.mapDescription = value;
    }

    /**
     * Gets the value of the fromCodeSystemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromCodeSystemId() {
        return fromCodeSystemId;
    }

    /**
     * Sets the value of the fromCodeSystemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromCodeSystemId(String value) {
        this.fromCodeSystemId = value;
    }

    /**
     * Gets the value of the fromCodeSystemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromCodeSystemName() {
        return fromCodeSystemName;
    }

    /**
     * Sets the value of the fromCodeSystemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromCodeSystemName(String value) {
        this.fromCodeSystemName = value;
    }

    /**
     * Gets the value of the fromCodeSystemVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromCodeSystemVersion() {
        return fromCodeSystemVersion;
    }

    /**
     * Sets the value of the fromCodeSystemVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromCodeSystemVersion(String value) {
        this.fromCodeSystemVersion = value;
    }

    /**
     * Gets the value of the toCodeSystemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToCodeSystemId() {
        return toCodeSystemId;
    }

    /**
     * Sets the value of the toCodeSystemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToCodeSystemId(String value) {
        this.toCodeSystemId = value;
    }

    /**
     * Gets the value of the toCodeSystemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToCodeSystemName() {
        return toCodeSystemName;
    }

    /**
     * Sets the value of the toCodeSystemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToCodeSystemName(String value) {
        this.toCodeSystemName = value;
    }

    /**
     * Gets the value of the toCodeSystemVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToCodeSystemVersion() {
        return toCodeSystemVersion;
    }

    /**
     * Sets the value of the toCodeSystemVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToCodeSystemVersion(String value) {
        this.toCodeSystemVersion = value;
    }

}