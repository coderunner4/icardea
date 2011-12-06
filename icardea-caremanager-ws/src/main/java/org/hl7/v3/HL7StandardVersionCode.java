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
 * <p>Java class for HL7StandardVersionCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HL7StandardVersionCode">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="V3-2003-12"/>
 *     &lt;enumeration value="V3-2005N"/>
 *     &lt;enumeration value="V3-2006N"/>
 *     &lt;enumeration value="V3-2007N"/>
 *     &lt;enumeration value="V3PR1"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum HL7StandardVersionCode {

    @XmlEnumValue("V3-2003-12")
    V_3_2003_12("V3-2003-12"),
    @XmlEnumValue("V3-2005N")
    V_3_2005_N("V3-2005N"),
    @XmlEnumValue("V3-2006N")
    V_3_2006_N("V3-2006N"),
    @XmlEnumValue("V3-2007N")
    V_3_2007_N("V3-2007N"),
    @XmlEnumValue("V3PR1")
    V_3_PR_1("V3PR1");
    private final String value;

    HL7StandardVersionCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HL7StandardVersionCode fromValue(String v) {
        for (HL7StandardVersionCode c: HL7StandardVersionCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
