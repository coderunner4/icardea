
/**
 * ValidateTranslation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package org.hl7;
            

            /**
            *  ValidateTranslation bean class
            */
        
        public  class ValidateTranslation
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn://hl7.org/CTSMAPI",
                "validateTranslation",
                "ns2");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn://hl7.org/CTSMAPI")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Parm1
                        */

                        
                                    protected org.hl7.cts.ST localParm1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.hl7.cts.ST
                           */
                           public  org.hl7.cts.ST getParm1(){
                               return localParm1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Parm1
                               */
                               public void setParm1(org.hl7.cts.ST param){
                            
                                            this.localParm1=param;
                                    

                               }
                            

                        /**
                        * field for Parm2
                        */

                        
                                    protected org.hl7.cts.CD localParm2 ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.hl7.cts.CD
                           */
                           public  org.hl7.cts.CD getParm2(){
                               return localParm2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Parm2
                               */
                               public void setParm2(org.hl7.cts.CD param){
                            
                                            this.localParm2=param;
                                    

                               }
                            

                        /**
                        * field for Parm3
                        */

                        
                                    protected org.hl7.cts.ST localParm3 ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.hl7.cts.ST
                           */
                           public  org.hl7.cts.ST getParm3(){
                               return localParm3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Parm3
                               */
                               public void setParm3(org.hl7.cts.ST param){
                            
                                            this.localParm3=param;
                                    

                               }
                            

                        /**
                        * field for Parm4
                        */

                        
                                    protected org.hl7.cts.BL localParm4 ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.hl7.cts.BL
                           */
                           public  org.hl7.cts.BL getParm4(){
                               return localParm4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Parm4
                               */
                               public void setParm4(org.hl7.cts.BL param){
                            
                                            this.localParm4=param;
                                    

                               }
                            

                        /**
                        * field for Parm5
                        */

                        
                                    protected org.hl7.cts.BL localParm5 ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.hl7.cts.BL
                           */
                           public  org.hl7.cts.BL getParm5(){
                               return localParm5;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Parm5
                               */
                               public void setParm5(org.hl7.cts.BL param){
                            
                                            this.localParm5=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       ValidateTranslation.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn://hl7.org/CTSMAPI");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":validateTranslation",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "validateTranslation",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localParm1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("parm1 cannot be null!!");
                                            }
                                           localParm1.serialize(new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI","parm1"),
                                               factory,xmlWriter);
                                        
                                            if (localParm2==null){
                                                 throw new org.apache.axis2.databinding.ADBException("parm2 cannot be null!!");
                                            }
                                           localParm2.serialize(new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI","parm2"),
                                               factory,xmlWriter);
                                        
                                            if (localParm3==null){
                                                 throw new org.apache.axis2.databinding.ADBException("parm3 cannot be null!!");
                                            }
                                           localParm3.serialize(new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI","parm3"),
                                               factory,xmlWriter);
                                        
                                            if (localParm4==null){
                                                 throw new org.apache.axis2.databinding.ADBException("parm4 cannot be null!!");
                                            }
                                           localParm4.serialize(new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI","parm4"),
                                               factory,xmlWriter);
                                        
                                            if (localParm5==null){
                                                 throw new org.apache.axis2.databinding.ADBException("parm5 cannot be null!!");
                                            }
                                           localParm5.serialize(new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI","parm5"),
                                               factory,xmlWriter);
                                        
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                
                            elementList.add(new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI",
                                                                      "parm1"));
                            
                            
                                    if (localParm1==null){
                                         throw new org.apache.axis2.databinding.ADBException("parm1 cannot be null!!");
                                    }
                                    elementList.add(localParm1);
                                
                            elementList.add(new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI",
                                                                      "parm2"));
                            
                            
                                    if (localParm2==null){
                                         throw new org.apache.axis2.databinding.ADBException("parm2 cannot be null!!");
                                    }
                                    elementList.add(localParm2);
                                
                            elementList.add(new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI",
                                                                      "parm3"));
                            
                            
                                    if (localParm3==null){
                                         throw new org.apache.axis2.databinding.ADBException("parm3 cannot be null!!");
                                    }
                                    elementList.add(localParm3);
                                
                            elementList.add(new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI",
                                                                      "parm4"));
                            
                            
                                    if (localParm4==null){
                                         throw new org.apache.axis2.databinding.ADBException("parm4 cannot be null!!");
                                    }
                                    elementList.add(localParm4);
                                
                            elementList.add(new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI",
                                                                      "parm5"));
                            
                            
                                    if (localParm5==null){
                                         throw new org.apache.axis2.databinding.ADBException("parm5 cannot be null!!");
                                    }
                                    elementList.add(localParm5);
                                

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static ValidateTranslation parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ValidateTranslation object =
                new ValidateTranslation();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"validateTranslation".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ValidateTranslation)org.hl7.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI","parm1").equals(reader.getName())){
                                
                                                object.setParm1(org.hl7.cts.ST.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI","parm2").equals(reader.getName())){
                                
                                                object.setParm2(org.hl7.cts.CD.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI","parm3").equals(reader.getName())){
                                
                                                object.setParm3(org.hl7.cts.ST.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI","parm4").equals(reader.getName())){
                                
                                                object.setParm4(org.hl7.cts.BL.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("urn://hl7.org/CTSMAPI","parm5").equals(reader.getName())){
                                
                                                object.setParm5(org.hl7.cts.BL.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                              
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          