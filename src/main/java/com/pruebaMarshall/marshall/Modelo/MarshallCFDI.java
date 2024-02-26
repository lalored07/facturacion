package com.pruebaMarshall.marshall.Modelo;

import java.lang.reflect.Field;

import com.pruebaMarshall.marshall.Servicio.xmlServicio;

public class MarshallCFDI {
    xmlServicio xmlService = new xmlServicio();
    Comprobante comprobante = xmlService.devolverDatosXml();

    public String obtenerCertificado() {
        String Certificado = comprobante.getCertificado();
        return Certificado;
    }

    public String obtenerNoCertificado() {
        String NoCertificado = comprobante.getNoCertificado();
        return NoCertificado;
    }

    public String obtenerSello(){
        String sello = comprobante.getSello();
        return sello;
    }

    public String obtenerTipoDeComprobante(){
        String TipoDeComprobante = comprobante.getTipoDeComprobante();
        return TipoDeComprobante;
    }

 
    public CfdiRelacionados obtenerCfdiRelacionados(){
        CfdiRelacionados CfdiRelacionados = comprobante.getCfdiRelacionados();
        return CfdiRelacionados;
    }

    public Emisor obtenerEmisor(){
        Emisor Emisor = comprobante.getEmisor();
        return Emisor;
    }

    public Receptor obtenerReceptor(){
        Receptor Receptor = comprobante.getReceptor();
        return Receptor;
    }
}
