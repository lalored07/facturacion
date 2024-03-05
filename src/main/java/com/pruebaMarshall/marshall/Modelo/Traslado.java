package com.pruebaMarshall.marshall.Modelo;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Traslado {
    private String Base;
    private String Importe;
    private String Impuesto;
    private String TasaOCuota;
    private String TipoFactor;

    @XmlAttribute(name="Base")
    public String getBase() {
        return Base;
    }

    public void setBase(String base) {
        Base = base;
    }


    @XmlAttribute(name="Importe")
    public String getImporte() {
        return Importe;
    }

    public void setImporte(String importe) {
        Importe = importe;
    }

    @XmlAttribute(name = "Impuesto")
    public String getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(String impuesto) {
        Impuesto = impuesto;
    }

    @XmlAttribute(name = "TasaOCuota")
    public String getTasa0Cuota() {
        return TasaOCuota;
    }

    public void setTasa0Cuota(String tasaOCuota) {
        TasaOCuota = tasaOCuota;
    }

    @XmlAttribute(name = "TipoFactor")
    public String getTipoFactor() {
        return TipoFactor;
    }

    public void setTipoFactor(String tipoFactor) {
        TipoFactor = tipoFactor;
    }

    @Override
    public String toString() {
        return "Traslado [Base=" + Base + ", Importe=" + Importe + ", Impuesto=" + Impuesto + ", Tasa0Cuota="
                + TasaOCuota + ", TipoFactor=" + TipoFactor + "]";
    }
    
    
}
