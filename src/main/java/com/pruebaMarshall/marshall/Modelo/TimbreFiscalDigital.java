package com.pruebaMarshall.marshall.Modelo;

import jakarta.xml.bind.annotation.XmlAttribute;

public class TimbreFiscalDigital {
    private String Version;
    private String UUID;
    private String RfcProvCertif;
    private String FechaTimbrado;
    private String SelloCFD;
    private String NoCertificadoSAT;
    private String SelloSAT;

    @XmlAttribute(name = "Version")
    public String getVersion() {
        return Version;
    }
    public void setVersion(String version) {
        Version = version;
    }

    @XmlAttribute(name = "UUID")
    public String getUUID() {
        return UUID;
    }
    public void setUUID(String uUID) {
        UUID = uUID;
    }

    @XmlAttribute(name = "RfcProvCertif")
    public String getRfcProvCertif() {
        return RfcProvCertif;
    }
    public void setRfcProvCertif(String rfcProvCertif) {
        RfcProvCertif = rfcProvCertif;
    }

    @XmlAttribute(name = "FechaTimbrado")
    public String getFechaTimbrado() {
        return FechaTimbrado;
    }
    public void setFechaTimbrado(String fechaTimbrado) {
        FechaTimbrado = fechaTimbrado;
    }

    @XmlAttribute(name = "SelloCFD")
    public String getSelloCFD() {
        return SelloCFD;
    }
    public void setSelloCFD(String selloCFD) {
        SelloCFD = selloCFD;
    }

    @XmlAttribute(name = "NoCertificadoSAT")
    public String getNoCertificadoSAT() {
        return NoCertificadoSAT;
    }
    public void setNoCertificadoSAT(String noCertificadoSAT) {
        NoCertificadoSAT = noCertificadoSAT;
    }

    @XmlAttribute(name = "SelloSAT")
    public String getSelloSat() {
        return SelloSAT;
    }
    public void setSelloSat(String selloSat) {
        SelloSAT = selloSat;
    }

    @Override
    public String toString() {
        return "Complemento [Version=" + Version + ", UUID=" + UUID + ", RfcProvCertif=" + RfcProvCertif
                + ", FechaTimbrado=" + FechaTimbrado + ", SelloCFD=" + SelloCFD + ", NoCertificadoSAT="
                + NoCertificadoSAT + ", SelloSat=" + SelloSAT + "]";
    }

}
