//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.03 at 01:53:59 PM EEST 
//


package org.hl7.v3;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for ActRelationshipSequel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipSequel">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="APND"/>
 *     &lt;enumeration value="COMPLY"/>
 *     &lt;enumeration value="DOC"/>
 *     &lt;enumeration value="FLFS"/>
 *     &lt;enumeration value="GEN"/>
 *     &lt;enumeration value="GEVL"/>
 *     &lt;enumeration value="INST"/>
 *     &lt;enumeration value="MOD"/>
 *     &lt;enumeration value="MTCH"/>
 *     &lt;enumeration value="OCCR"/>
 *     &lt;enumeration value="OPTN"/>
 *     &lt;enumeration value="OREF"/>
 *     &lt;enumeration value="RCHAL"/>
 *     &lt;enumeration value="REV"/>
 *     &lt;enumeration value="RPLC"/>
 *     &lt;enumeration value="SCH"/>
 *     &lt;enumeration value="SEQL"/>
 *     &lt;enumeration value="SUCC"/>
 *     &lt;enumeration value="UPDT"/>
 *     &lt;enumeration value="VRXCRPT"/>
 *     &lt;enumeration value="XCRPT"/>
 *     &lt;enumeration value="XFRM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ActRelationshipSequel {

    APND,
    COMPLY,
    DOC,
    FLFS,
    GEN,
    GEVL,
    INST,
    MOD,
    MTCH,
    OCCR,
    OPTN,
    OREF,
    RCHAL,
    REV,
    RPLC,
    SCH,
    SEQL,
    SUCC,
    UPDT,
    VRXCRPT,
    XCRPT,
    XFRM;

    public String value() {
        return name();
    }

    public static ActRelationshipSequel fromValue(String v) {
        return valueOf(v);
    }

}
