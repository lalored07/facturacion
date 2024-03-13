package com.pruebaMarshall.marshall.Modelo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Servicio.xmlServicio;

@Service
public class MarshallCFDI {
    private final xmlServicio xmlService;
    private final List<Comprobante> comprobante;

    
    public MarshallCFDI(xmlServicio xmlService) {
        this.xmlService = xmlService;
        this.comprobante = xmlService.devolverDatosXml();
    }

    public List<String> obtenerCertificados() {
        List<String> certificados = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            certificados.add(comprobante.getCertificado());
        }
        return certificados;
    }

    public List<String> obtenerNoCertificados() {
        List<String> noCertificados = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            noCertificados.add(comprobante.getNoCertificado());
        }
        return noCertificados;
    }

    public List<String> obtenerSellos() {
        List<String> sellos = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            sellos.add(comprobante.getSello());
        }
        return sellos;
    }

    public List<String> obtenerTiposDeComprobante() {
        List<String> tiposDeComprobante = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            tiposDeComprobante.add(comprobante.getTipoDeComprobante());
        }
        return tiposDeComprobante;
    }

    public List<String> obtenerExportaciones() {
        List<String> exportaciones = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            exportaciones.add(comprobante.getExportacion());
        }
        return exportaciones;
    }

    public List<String> obtenerVersiones() {
        List<String> versiones = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            versiones.add(comprobante.getVersion());
        }
        return versiones;
    }

    public List<String> obtenerSeries() {
        List<String> series = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            series.add(comprobante.getSerie());
        }
        return series;
    }

    public List<String> obtenerFolios() {
        List<String> folios = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            folios.add(comprobante.getFolio());
        }
        return folios;
    }

    public List<String> obtenerTotales() {
        List<String> totales = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            totales.add(comprobante.getTotal());
        }
        return totales;
    }

    public List<String> obtenerSubTotales() {
        List<String> subTotales = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            subTotales.add(comprobante.getSubTotal());
        }
        return subTotales;
    }

    public List<String> obtenerFecha(){
        List<String> fechas = new ArrayList<>();
        for(Comprobante comprobante : comprobante){
            fechas.add(comprobante.getFecha());
        }
        return fechas;
    }

    public List<String> obtenerMoneda(){
        List<String> monedas = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            monedas.add(comprobante.getMoneda());
        }
        return monedas;
    }

    public List<String> obtenerFormaPago(){
        List<String> formaPago = new ArrayList<>();
        for (Comprobante comprobante: comprobante) {
            formaPago.add(comprobante.getFormaPago());
        }
        return formaPago;
    }

    public List<String> obtenerMetodoPago(){
        List<String> metodoPago = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            metodoPago.add(comprobante.getMetodoPago());
        }    
        return metodoPago;
    }

    public List<CfdiRelacionados> obtenerCfdiRelacionados() {
        List<CfdiRelacionados> cfdiRelacionadosList = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            cfdiRelacionadosList.add(comprobante.getCfdiRelacionados());
        }
        return cfdiRelacionadosList;
    }



    public List<Emisor> obtenerEmisores() {
        List<Emisor> emisores = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            emisores.add(comprobante.getEmisor());
        }
        return emisores;
    }

    public List<String> obtenerDescuentos(){
        List<String> descuentos = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            descuentos.add(comprobante.getDescuento());
        }
        return descuentos;
    }

    public List<String> obtenerREgimenFiscal(){
        List<String> lista = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            lista.add(comprobante.getEmisor().getRegimenFiscal());
        }
        return lista;
    }

    public List<Receptor> obtenerReceptores() {
        List<Receptor> receptores = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            receptores.add(comprobante.getReceptor());
        }
        return receptores;
    }

    public List<Conceptos> obtenerConceptos() {
        List<Conceptos> conceptosList = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            conceptosList.add(comprobante.getConceptos());
        }
        return conceptosList;
    }

    public List<Impuestos> obtenerImpuestos() {
        List<Impuestos> impuestosList = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            impuestosList.add(comprobante.getImpuestos());
        }
        return impuestosList;
    }

    public List<Complemento> obtenerComplementos() {
        List<Complemento> complementosList = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            complementosList.add(comprobante.getComplemento());
        }
        return complementosList;
    }

    public List<String> obtenerNombres(){
        List<String> nombres = new ArrayList<>();
        for (Comprobante comprobante : comprobante) {
            nombres.add(comprobante.getNombre());
        }
        return nombres;
    }
    
}
