package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;
import com.pruebaMarshall.marshall.Servicio.xmlServicio;

@Service
public class validacionCompleta {
    @Autowired
    private valTipoComprobante valTipoComprobante;
    @Autowired
    private valExportacion valExportacion;
    @Autowired
    private valVersion valVersion;
    @Autowired
    private valSerie valSerie;
    @Autowired
    private valFolio valFolio;
    @Autowired
    private valTotal valTotal;
    @Autowired
    private valSubtotal valSubtotal;
    @Autowired
    private valFecha valFecha;
    @Autowired 
    private valMoneda valMoneda;
    @Autowired
    private MarshallCFDI marshallCFDI;
    private xmlServicio xmlServicio;
    private List<Comprobante> comprobantes;
    
    public validacionCompleta(xmlServicio xmlServicio) {
        this.xmlServicio = xmlServicio;
        this.comprobantes = xmlServicio.devolverDatosXml();
    }

    public Map<String, Object> validar() {
        Map<String, Object> mapa = new LinkedHashMap<>();
       
        for (int i = 0; i < marshallCFDI.obtenerNombres().size(); i++) {
            Map<String, String> mapaValidacion = new LinkedHashMap<>();
            
            mapaValidacion.put("Exportacion", valExportacion.validarExportacion().get(i));
            mapaValidacion.put("TipoDeComprobante", valTipoComprobante.validarValidezCFDI().get(i));
            mapaValidacion.put("SubTotal", valSubtotal.validarSubTotal().get(i));
            mapaValidacion.put("Total", valTotal.validarTotal().get(i));
            mapaValidacion.put("Serie", valSerie.validarSerie().get(i));
            mapaValidacion.put("Folio", valFolio.validarFolio().get(i));
            mapaValidacion.put("Version", valVersion.validarVersion().get(i));
            mapaValidacion.put("Fecha", valFecha.validarFecha().get(i));
            mapaValidacion.put("Moneda", valMoneda.validarMoneda().get(i));
            mapa.put(marshallCFDI.obtenerNombres().get(i), mapaValidacion);
        }
        return mapa;
    }
}
