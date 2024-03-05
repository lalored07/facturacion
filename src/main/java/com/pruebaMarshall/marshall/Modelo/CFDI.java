package com.pruebaMarshall.marshall.Modelo;

import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;


public class CFDI {
    private Comprobante Comprobante;
    private CfdiRelacionados CfdiRelacionados;
    private Emisor Emisor;
    private Receptor Receptor;
    private Conceptos Conceptos;
    private Impuestos Impuestos;
    private Complemento Complemento;

    public CFDI(){

    }

    public CFDI(Comprobante Comprobante, CfdiRelacionados CfdiRelacionados){
        this.Comprobante = Comprobante;
        this.CfdiRelacionados = CfdiRelacionados;
    }

    @XmlAttribute(name = "Comprobante")
    public Comprobante getComprobante() {
        return Comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        Comprobante = comprobante;
    }

    
    public CfdiRelacionados getCfdiRelacionados() {
        return CfdiRelacionados;
    }

    @XmlAttribute(name = "CfdiRelacionados")
    public void setCfdiRelacionados(CfdiRelacionados cfdiRelacionados) {
        CfdiRelacionados = cfdiRelacionados;
    }

    @Override
    public String toString() {
        return "CFDI [Comprobante=" + Comprobante + ", CfdiRelacionados=" + CfdiRelacionados + "]";
    }

    
    

}
