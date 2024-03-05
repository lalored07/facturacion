package com.pruebaMarshall.marshall.Modelo;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


public class Conceptos {
    private List<Concepto> Concepto;
    

    public Conceptos(){

    }

    public List<Concepto> getConcepto() {
        return Concepto;
    }

    @XmlElement(name = "Concepto", namespace = NAMESPACES.CFDI)
    public void setConcepto(List<Concepto> concepto) {
        Concepto = concepto;
    }

    @Override
    public String toString() {
        return "Conceptos [Concepto=" + Concepto + "]";
    }


  

   
    
    
    
}
