package com.pruebaMarshall.marshall.Modelo;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


public class Emisor {
    private String Rfc;
    private String Nombre; 
    private String RegimenFiscal;

    @XmlAttribute(name = "Rfc")
    public String getRfc() {
        return Rfc;
    }
    public void setRfc(String rfc) {
        Rfc = rfc;
    }

    @XmlAttribute(name = "Nombre")
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @XmlAttribute(name = "RegimenFiscal")
    public String getRegimenFiscal() {
        return RegimenFiscal;
    }
    public void setRegimenFiscal(String regimenFiscal) {
        RegimenFiscal = regimenFiscal;
    }

    public Emisor(){

    }
    public Emisor(String rfc, String nombre, String regimenFiscal) {
        Rfc = rfc;
        Nombre = nombre;
        RegimenFiscal = regimenFiscal;
    }

    
    
}
