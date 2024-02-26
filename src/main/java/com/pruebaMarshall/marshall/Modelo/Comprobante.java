package com.pruebaMarshall.marshall.Modelo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;


@XmlRootElement(name="Comprobante", namespace = NAMESPACES.CFDI)
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Comprobante {
    
    protected String Certificado;
    private String noCertificado;
    private String sello;
    private String tipoDeComprobante;
    private String exportacion;
    private String version;
    private String serie;
    private String folio;
    private String total;
    private String subTotal;
    private String fecha;
    private String moneda;
    private String lugarExpedicion;
    private String metodoPago;
    private String formaPago;
    private String descuento;
    private String condicionesDePago;
    private CfdiRelacionados CfdiRelacionados;
    private Emisor Emisor;
    private Receptor Receptor;

    public Comprobante() {}

    public Comprobante(String certificado, String noCertificado, String sello, String tipoDeComprobante, String exportacion, String version,
            String serie, String folio, String total, String subTotal, String fecha, String moneda, String lugarExpedicion,
            String metodoPago, String formaPago, String descuento, String condicionesDePago, CfdiRelacionados cfdiRelacionados, Emisor Emisor, Receptor Receptor) {
        this.Certificado = certificado;
        this.noCertificado = noCertificado;
        this.sello = sello;
        this.tipoDeComprobante = tipoDeComprobante;
        this.exportacion = exportacion; 
        this.version = version;
        this.serie = serie;
        this.folio = folio;
        this.total = total;
        this.subTotal = subTotal;
        this.fecha = fecha;
        this.moneda = moneda;
        this.lugarExpedicion = lugarExpedicion;
        this.metodoPago = metodoPago;
        this.formaPago = formaPago;
        this.descuento = descuento;
        this.condicionesDePago = condicionesDePago;
        this.CfdiRelacionados = cfdiRelacionados;
        this.Emisor = Emisor;
        this.Receptor = Receptor;
            }
   
            public Comprobante(String certificado, String noCertificado, String sello, CfdiRelacionados cfdiRelacionados, Emisor Emisor, Receptor Receptor) {
                Certificado = certificado;
                this.noCertificado = noCertificado;
                this.sello = sello;
                this.CfdiRelacionados = cfdiRelacionados;
                this.Emisor = Emisor;
                this.Receptor = Receptor;
            }        
   
    
    @XmlAttribute(name ="Certificado")
    public String getCertificado() {
        return Certificado;
    }
    
    public void setCertificado(String certificado) {
        this.Certificado = certificado;
    }
    @XmlAttribute(name ="NoCertificado")
    public String getNoCertificado() {
        return noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    @XmlAttribute(name = "Sello")
    public String getSello() {
        return sello;
    }

    public void setSello(String sello) {
        this.sello = sello;
    }

    @XmlAttribute(name ="TipoDeComprobante")
    public String getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    public void setTipoDeComprobante(String tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    

    @XmlAttribute(name ="Version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlAttribute(name ="Serie")
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @XmlAttribute(name ="Folio")
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    @XmlAttribute(name ="Total")
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @XmlAttribute(name ="SubTotal")
    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    @XmlAttribute(name ="Fecha")
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @XmlAttribute(name ="Moneda")
    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @XmlAttribute(name ="LugarExpedicion")
    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    @XmlAttribute(name ="MetodoPago")
    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @XmlAttribute(name ="FormaPago")
    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    @XmlAttribute(name ="Descuento")
    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    @XmlAttribute(name ="CondicionesDePago")
    public String getCondicionesDePago() {
        return condicionesDePago;
    }

    public void setCondicionesDePago(String condicionesDePago) {
        this.condicionesDePago = condicionesDePago;
    }

    @XmlAttribute(name = "exportacion")
    public String getExportacion() {
        return exportacion;
    }

    public void setExportacion(String exportacion) {
        this.exportacion = exportacion;
    }



    @Override
    public String toString() {
        return "Comprobante [Certificado=" + Certificado + ", noCertificado=" + noCertificado + ", sello=" + sello
                + ", CfdiRelacionados=" + CfdiRelacionados + "]";
    }

    public CfdiRelacionados getCfdiRelacionados() {
        return CfdiRelacionados;
    }

    @XmlElement(name = "CfdiRelacionados", namespace = NAMESPACES.CFDI)
    public void setCfdiRelacionados(CfdiRelacionados cfdiRelacionados) {
        CfdiRelacionados = cfdiRelacionados;
    }

    public Emisor getEmisor() {
        return Emisor;
    }

    @XmlElement(name = "Emisor", namespace = NAMESPACES.CFDI)
    public void setEmisor(Emisor emisor) {
        Emisor = emisor;
    }

    public Receptor getReceptor() {
        return Receptor;
    }

    @XmlElement(name = "Receptor", namespace = NAMESPACES.CFDI)
    public void setReceptor(Receptor receptor) {
        Receptor = receptor;
    }

    
    
}
