package com.pruebaMarshall.marshall.Modelo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Concepto", namespace = NAMESPACES.CFDI)
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Concepto {
    private String Cantidad;
    private String Descripcion;
    private String ClaveProdServ;
    private String ClaveUnidad;
    private String ObjetoImp; 
    private String NoIdentificacion;
    private String Unidad; 
    private String Importe;
    private String ValorUnitario;
    private String Descuento; 
    private Impuestos Impuestos;

    public Concepto(){

    }

    @XmlAttribute(name = "Cantidad")
    public String getCantidad() {
        return Cantidad;
    }
    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    @XmlAttribute(name = "Descripcion")
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @XmlAttribute(name = "ClaveProdServ")
    public String getClaveProdServ() {
        return ClaveProdServ;
    }
    public void setClaveProdServ(String claveProdServ) {
        ClaveProdServ = claveProdServ;
    }
    @XmlAttribute(name = "ClaveUnidad")
    public String getClaveUnidad() {
        return ClaveUnidad;
    }
    public void setClaveUnidad(String claveUnidad) {
        ClaveUnidad = claveUnidad;
    }
    @XmlAttribute(name = "ObjetoImp")
    public String getObjetoImp() {
        return ObjetoImp;
    }
    public void setObjetoImp(String objetoImp) {
        ObjetoImp = objetoImp;
    }

    @XmlAttribute(name = "NoIdentificacion")
    public String getNoIdentificacion() {
        return NoIdentificacion;
    }
    public void setNoIdentificacion(String noIdentificacion) {
        NoIdentificacion = noIdentificacion;
    }
    @XmlAttribute(name = "Unidad")
    public String getUnidad() {
        return Unidad;
    }
    public void setUnidad(String unidad) {
        Unidad = unidad;
    }

    @XmlAttribute(name = "Importe")
    public String getImporte() {
        return Importe;
    }
    public void setImporte(String importe) {
        Importe = importe;
    }

    @XmlAttribute(name = "ValorUnitario")
    public String getValorUnitario() {
        return ValorUnitario;
    }
    public void setValorUnitario(String valorUnitario) {
        ValorUnitario = valorUnitario;
    }

    @XmlAttribute(name = "Descuento")
    public String getDescuento() {
        return Descuento;
    }
    public void setDescuento(String descuento) {
        Descuento = descuento;
    }

    public Impuestos getImpuestos() {
        return Impuestos;
    }
    @XmlElement(name = "Impuestos", namespace = NAMESPACES.CFDI)
    public void setImpuestos(Impuestos impuestos) {
        Impuestos = impuestos;
    }

    @Override
    public String toString() {
        return "Concepto [Cantidad=" + Cantidad + ", Descripcion=" + Descripcion + ", ClaveProdServ=" + ClaveProdServ
                + ", ClaveUnidad=" + ClaveUnidad + ", ObjetoImp=" + ObjetoImp + ", NoIdentificacion=" + NoIdentificacion
                + ", Unidad=" + Unidad + ", Importe=" + Importe + ", ValorUnitario=" + ValorUnitario + ", Descuento="
                + Descuento + ", Impuestos=" + Impuestos + "]";
    }

    
}
