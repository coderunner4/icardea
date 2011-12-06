//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.03 at 01:53:59 PM EEST 
//


package org.hl7.v3;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for StreetAddressLine.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StreetAddressLine">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="BNN"/>
 *     &lt;enumeration value="BNR"/>
 *     &lt;enumeration value="BNS"/>
 *     &lt;enumeration value="DIR"/>
 *     &lt;enumeration value="POB"/>
 *     &lt;enumeration value="SAL"/>
 *     &lt;enumeration value="STB"/>
 *     &lt;enumeration value="STR"/>
 *     &lt;enumeration value="STTYP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum StreetAddressLine {

    BNN,
    BNR,
    BNS,
    DIR,
    POB,
    SAL,
    STB,
    STR,
    STTYP;

    public String value() {
        return name();
    }

    public static StreetAddressLine fromValue(String v) {
        return valueOf(v);
    }

}
