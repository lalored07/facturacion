package com.pruebaMarshall.marshall.Modelo;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Receptor {
    private String Rfc;
    private String Nombre;
    private String UsoCFDI;
    private String DomicilioFiscalReceptor;
    private String RegimenFiscalReceptor;

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

    @XmlAttribute(name = "UsoCFDI")
    public String getUsoCFDI() {
        return UsoCFDI;
    }
    public void setUsoCFDI(String usoCFDI) {
        UsoCFDI = usoCFDI;
    }

    @XmlAttribute(name = "DomicilioFiscalReceptor")
    public String getDomicilioFiscalReceptor() {
        return DomicilioFiscalReceptor;
    }
    public void setDomicilioFiscalReceptor(String domicilioFiscalReceptor) {
        DomicilioFiscalReceptor = domicilioFiscalReceptor;
    }

    @XmlAttribute(name = "RegimenFiscalReceptor")
    public String getRegimenFiscalReceptor() {
        return RegimenFiscalReceptor;
    }
    public void setRegimenFiscalReceptor(String regimenFiscalReceptor) {
        RegimenFiscalReceptor = regimenFiscalReceptor;
    }
    public Receptor(String rfc, String nombre, String usoCFDI, String domicilioFiscalReceptor,
            String regimenFiscalReceptor) {
        Rfc = rfc;
        Nombre = nombre;
        UsoCFDI = usoCFDI;
        DomicilioFiscalReceptor = domicilioFiscalReceptor;
        RegimenFiscalReceptor = regimenFiscalReceptor;
    }

    public Receptor(){
        
    }
    @Override
    public String toString() {
        return "Receptor [Rfc=" + Rfc + ", Nombre=" + Nombre + ", UsoCFDI=" + UsoCFDI + ", DomicilioFiscalReceptor="
                + DomicilioFiscalReceptor + ", RegimenFiscalReceptor=" + RegimenFiscalReceptor + "]";
    }

}
