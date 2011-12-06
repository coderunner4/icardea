//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.03 at 01:53:04 PM EEST 
//


package org.hl7.v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for ManagedParticipationStatusActive.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ManagedParticipationStatusActive">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="active"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ManagedParticipationStatusActive {

    @XmlEnumValue("active")
    ACTIVE("active");
    private final String value;

    ManagedParticipationStatusActive(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ManagedParticipationStatusActive fromValue(String v) {
        for (ManagedParticipationStatusActive c: ManagedParticipationStatusActive.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
