
package org.hl7.ctsmapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hl7.cts.types.CD;
import org.hl7.cts.types.ST;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeToFillIn" type="{urn://cts.hl7.org/types}CD"/>
 *         &lt;element name="displayLanguage_code" type="{urn://cts.hl7.org/types}ST"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codeToFillIn",
    "displayLanguageCode"
})
@XmlRootElement(name = "fillInDetails")
public class FillInDetails {

    @XmlElement(required = true)
    protected CD codeToFillIn;
    @XmlElement(name = "displayLanguage_code", required = true)
    protected ST displayLanguageCode;

    /**
     * Gets the value of the codeToFillIn property.
     * 
     * @return
     *     possible object is
     *     {@link CD }
     *     
     */
    public CD getCodeToFillIn() {
        return codeToFillIn;
    }

    /**
     * Sets the value of the codeToFillIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link CD }
     *     
     */
    public void setCodeToFillIn(CD value) {
        this.codeToFillIn = value;
    }

    /**
     * Gets the value of the displayLanguageCode property.
     * 
     * @return
     *     possible object is
     *     {@link ST }
     *     
     */
    public ST getDisplayLanguageCode() {
        return displayLanguageCode;
    }

    /**
     * Sets the value of the displayLanguageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ST }
     *     
     */
    public void setDisplayLanguageCode(ST value) {
        this.displayLanguageCode = value;
    }

}
