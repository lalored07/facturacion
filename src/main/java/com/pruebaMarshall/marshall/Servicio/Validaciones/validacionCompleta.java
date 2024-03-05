package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;
import com.pruebaMarshall.marshall.Servicio.xmlServicio;

@Service
public class validacionCompleta {
    private valTipoComprobante valTipoComprobante;
    private valExportacion valExportacion;
    private valVersion valVersion;
    private valSerie valSerie;
    private valFolio valFolio;
    private valTotal valTotal;
    private valSubtotal valSubtotal;
    private xmlServicio xmlServicio;
    private List<Comprobante> comprobantes;
    private MarshallCFDI marshallCFDI;
    private List<String> nombres;

    public validacionCompleta(xmlServicio xmlServicio, valTipoComprobante valTipoComprobante,
            valExportacion valExportacion, valVersion valVersion, valSerie valSerie, valFolio valFolio,
            valTotal valTotal, valSubtotal valSubtotal, MarshallCFDI marshallCFDI) {
        this.valTipoComprobante = valTipoComprobante;
        this.valExportacion = valExportacion;
        this.valVersion = valVersion;
        this.valSerie = valSerie;
        this.valFolio = valFolio;
        this.valTotal = valTotal;
        this.valSubtotal = valSubtotal;
        this.xmlServicio = xmlServicio;
        this.comprobantes = xmlServicio.devolverDatosXml();
        this.marshallCFDI = marshallCFDI;
    }

    /*
     * public List<String> validacionTotal() {
     * List<String> resultados = new ArrayList<>();
     * List<Boolean> validacionesComprobante =
     * valTipoComprobante.validarValidezCFDI();
     * List<String> validacionesExportacion = valExportacion.validarExportacion();
     * List<Boolean> validacionesSerie = valSerie.validarSerie();
     * List<Boolean> validacionesFolio = valFolio.validarFolio();
     * List<Boolean> validacionesTotal = valTotal.validarTotal();
     * List<Boolean> validacionesSubTotal = valSubtotal.validarSubTotal();
     * 
     * for (int i = 0; i < comprobantes.size(); i++) {
     * Boolean validacionComprobante = validacionesComprobante.get(i);
     * String validacionExport = validacionesExportacion.get(i);
     * Boolean validacionSerie = validacionesSerie.get(i);
     * Boolean validacionFolio = validacionesFolio.get(i);
     * Boolean validacionTotal = validacionesTotal.get(i);
     * Boolean validacionSubTotal = validacionesSubTotal.get(i);
     * 
     * boolean resultado = validacionComprobante &&
     * validacionExport.equals("Factura válida") && validacionSerie &&
     * validacionFolio && validacionTotal && validacionSubTotal;
     * String validado = "Factura no válida";
     * if(resultado){
     * validado = "Factura válida";
     * }
     * resultados.add(validado);
     * 
     * }
     * 
     * return resultados;
     * }
     */

    

    public Map<String, Object> validar() {
        Map<String, Object> mapa = new LinkedHashMap<>();

        List<String> validacionesExportacion = valExportacion.validarExportacion();
        List<String> validarTipoComprobante = valTipoComprobante.validarValidezCFDI();
        List<String> validarSubTotal = valSubtotal.validarSubTotal();
        List<String> validarTotal = valTotal.validarTotal();
        List<String> validarSerie = valSerie.validarSerie();
        List<String> validarFolio = valFolio.validarFolio();
        List<String> validarVersion = valVersion.validarVersion();
        List<String> nombres = marshallCFDI.obtenerNombres();
        
        for (int i = 0; i < nombres.size(); i++) {
            Map<String, String> mapaValidacion = new LinkedHashMap<>();
            mapaValidacion.put("Exportacion", validacionesExportacion.get(i));
            mapaValidacion.put("TipoDeComprobante", validarTipoComprobante.get(i));
            mapaValidacion.put("SubTotal", validarSubTotal.get(i));
            mapaValidacion.put("Total", validarTotal.get(i));
            mapaValidacion.put("Serie", validarSerie.get(i));
            mapaValidacion.put("Folio", validarFolio.get(i));
            mapaValidacion.put("Version", validarVersion.get(i));
            mapa.put(nombres.get(i), mapaValidacion);
        }

        
        return mapa;
    }

}
