package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;
@Service
public class valExportacion {
    private MarshallCFDI marshallCFDI;
    

    public valExportacion(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
        
    }

    public List<String> validarExportacion() {
        List<String> listaExportacion = new ArrayList<>();
        List<String> listaExportaciones = marshallCFDI.obtenerExportaciones();
    
        for (int i = 0; i < listaExportaciones.size(); i++) {
            String comprobante = listaExportaciones.get(i);
            String tipoExportacion = comprobante;
            Boolean exportacion = tipoExportacion.equals("01") || tipoExportacion.equals("02") || tipoExportacion.equals("03") || tipoExportacion.equals("04");
            String validado;
    
            if (exportacion) {
                validado = "Válido";
            } else {
                validado =  "No válido, error : " + CodigoError.CFDI40222;
            }
    
            listaExportacion.add(validado);
        }
    
        return listaExportacion;
    }
    

   
}
