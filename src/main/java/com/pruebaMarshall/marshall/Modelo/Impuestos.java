package com.pruebaMarshall.marshall.Modelo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Impuestos", namespace = NAMESPACES.CFDI)
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Impuestos {
    private Traslados Traslados;
   

    public Impuestos(){

    }

    public Traslados getTraslados() {
        return Traslados;
    }

    @XmlElement(name = "Traslados", namespace = NAMESPACES.CFDI)
    public void setTraslados(Traslados traslados) {
        Traslados = traslados;
    }

    
    @Override
    public String toString() {
        return "Impuestos [Traslados=" + Traslados + "]";
    }

    

    

    
}
