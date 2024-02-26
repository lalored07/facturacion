package com.pruebaMarshall.marshall.Modelo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "CfdiRelacionados", namespace = NAMESPACES.CFDI)
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CfdiRelacionados {
    private String TipoRelacion;
    private CfdiRelacionado CfdiRelacionado;

    public CfdiRelacionados(){
        
    }

    @XmlAttribute(name="TipoRelacion")
    public String getTipoRelacion() {
        return TipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        TipoRelacion = tipoRelacion;
    }

    public CfdiRelacionado getCfdiRelacionado() {
        return CfdiRelacionado;
    }

    @XmlElement(name = "CfdiRelacionado", namespace = NAMESPACES.CFDI)
    public void setCfdiRelacionado(CfdiRelacionado cfdiRelacionado) {
        CfdiRelacionado = cfdiRelacionado;
    }



    public CfdiRelacionados(String tipoRelacion) {
        TipoRelacion = tipoRelacion;
    }

    @Override
    public String toString() {
        return "TipoRelacion=" + TipoRelacion + ", CfdiRelacionado=" + CfdiRelacionado;
    }
    
    
    
}
