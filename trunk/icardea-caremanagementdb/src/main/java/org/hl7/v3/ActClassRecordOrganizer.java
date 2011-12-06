//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.03 at 01:53:04 PM EEST 
//


package org.hl7.v3;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for ActClassRecordOrganizer.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassRecordOrganizer">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="COMPOSITION"/>
 *     &lt;enumeration value="DOC"/>
 *     &lt;enumeration value="DOCCLIN"/>
 *     &lt;enumeration value="CDALVLONE"/>
 *     &lt;enumeration value="CONTAINER"/>
 *     &lt;enumeration value="CATEGORY"/>
 *     &lt;enumeration value="DOCBODY"/>
 *     &lt;enumeration value="DOCSECT"/>
 *     &lt;enumeration value="TOPIC"/>
 *     &lt;enumeration value="EXTRACT"/>
 *     &lt;enumeration value="EHR"/>
 *     &lt;enumeration value="FOLDER"/>
 *     &lt;enumeration value="GROUPER"/>
 *     &lt;enumeration value="BATTERY"/>
 *     &lt;enumeration value="CLUSTER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ActClassRecordOrganizer {

    COMPOSITION,
    DOC,
    DOCCLIN,
    CDALVLONE,
    CONTAINER,
    CATEGORY,
    DOCBODY,
    DOCSECT,
    TOPIC,
    EXTRACT,
    EHR,
    FOLDER,
    GROUPER,
    BATTERY,
    CLUSTER;

    public String value() {
        return name();
    }

    public static ActClassRecordOrganizer fromValue(String v) {
        return valueOf(v);
    }

}
