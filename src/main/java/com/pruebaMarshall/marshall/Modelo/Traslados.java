package com.pruebaMarshall.marshall.Modelo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "Traslados", namespace = NAMESPACES.CFDI)
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Traslados {
    private Traslado Traslado;

    public Traslado getTraslado() {
        return Traslado;
    }

    @XmlElement(name= "Traslado", namespace = NAMESPACES.CFDI)
    public void setTraslado(Traslado traslado) {
        Traslado = traslado;
    }

    public Traslados(){

    }

    @Override
    public String toString() {
        return "Traslados [Traslado=" + Traslado + "]";
    }

    
    
}
