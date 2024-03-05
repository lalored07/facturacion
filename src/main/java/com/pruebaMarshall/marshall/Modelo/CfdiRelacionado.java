package com.pruebaMarshall.marshall.Modelo;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

public class CfdiRelacionado {
    private String UUID;
    
    @XmlAttribute(name ="UUID")
    public String getUUID() {
        return UUID;
    }
 
    public void setUUID(String uUID) {
        UUID = uUID;
    }

    @Override
    public String toString() {
        return "UUID=" + UUID ;
    }
    
    
}
