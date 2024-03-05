package com.pruebaMarshall.marshall.Modelo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Complemento", namespace = NAMESPACES.CFDI)
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Complemento {
    private TimbreFiscalDigital TimbreFiscalDigital;

    public Complemento(){

    }

    public TimbreFiscalDigital getTimbreFiscalDigital() {
        return TimbreFiscalDigital;
    }

    @XmlElement(name = "TimbreFiscalDigital", namespace = NAMESPACES.TFD)
    public void setTimbreFiscalDigital(TimbreFiscalDigital timbreFiscalDigital) {
        TimbreFiscalDigital = timbreFiscalDigital;
    }

    @Override
    public String toString() {
        return "Complemento [TimbreFiscalDigital=" + TimbreFiscalDigital + "]";
    }
    
    
}
