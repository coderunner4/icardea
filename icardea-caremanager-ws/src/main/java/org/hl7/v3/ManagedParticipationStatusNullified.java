//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.03 at 01:53:59 PM EEST 
//


package org.hl7.v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for ManagedParticipationStatusNullified.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ManagedParticipationStatusNullified">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="nullified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ManagedParticipationStatusNullified {

    @XmlEnumValue("nullified")
    NULLIFIED("nullified");
    private final String value;

    ManagedParticipationStatusNullified(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ManagedParticipationStatusNullified fromValue(String v) {
        for (ManagedParticipationStatusNullified c: ManagedParticipationStatusNullified.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
