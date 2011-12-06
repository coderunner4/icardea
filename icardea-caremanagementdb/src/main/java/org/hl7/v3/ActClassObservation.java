//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.03 at 01:53:04 PM EEST 
//


package org.hl7.v3;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for ActClassObservation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassObservation">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ALRT"/>
 *     &lt;enumeration value="CASE"/>
 *     &lt;enumeration value="CLNTRL"/>
 *     &lt;enumeration value="CNOD"/>
 *     &lt;enumeration value="COND"/>
 *     &lt;enumeration value="DETPOL"/>
 *     &lt;enumeration value="DGIMG"/>
 *     &lt;enumeration value="EXP"/>
 *     &lt;enumeration value="GEN"/>
 *     &lt;enumeration value="INVSTG"/>
 *     &lt;enumeration value="LLD"/>
 *     &lt;enumeration value="LOC"/>
 *     &lt;enumeration value="OBS"/>
 *     &lt;enumeration value="OBSCOR"/>
 *     &lt;enumeration value="OBSSER"/>
 *     &lt;enumeration value="OUTB"/>
 *     &lt;enumeration value="PHN"/>
 *     &lt;enumeration value="POL"/>
 *     &lt;enumeration value="POS"/>
 *     &lt;enumeration value="POSACC"/>
 *     &lt;enumeration value="POSCOORD"/>
 *     &lt;enumeration value="PRN"/>
 *     &lt;enumeration value="RLD"/>
 *     &lt;enumeration value="ROIBND"/>
 *     &lt;enumeration value="ROIOVL"/>
 *     &lt;enumeration value="RTRD"/>
 *     &lt;enumeration value="SEQ"/>
 *     &lt;enumeration value="SEQVAR"/>
 *     &lt;enumeration value="SFWL"/>
 *     &lt;enumeration value="SIT"/>
 *     &lt;enumeration value="SPCOBS"/>
 *     &lt;enumeration value="STN"/>
 *     &lt;enumeration value="SUP"/>
 *     &lt;enumeration value="TRD"/>
 *     &lt;enumeration value="VERIF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ActClassObservation {

    ALRT,
    CASE,
    CLNTRL,
    CNOD,
    COND,
    DETPOL,
    DGIMG,
    EXP,
    GEN,
    INVSTG,
    LLD,
    LOC,
    OBS,
    OBSCOR,
    OBSSER,
    OUTB,
    PHN,
    POL,
    POS,
    POSACC,
    POSCOORD,
    PRN,
    RLD,
    ROIBND,
    ROIOVL,
    RTRD,
    SEQ,
    SEQVAR,
    SFWL,
    SIT,
    SPCOBS,
    STN,
    SUP,
    TRD,
    VERIF;

    public String value() {
        return name();
    }

    public static ActClassObservation fromValue(String v) {
        return valueOf(v);
    }

}
