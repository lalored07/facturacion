package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.JPA.ClaveUnidadRepository;
import com.pruebaMarshall.marshall.Modelo.Concepto;
import com.pruebaMarshall.marshall.Modelo.Conceptos;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;
import com.pruebaMarshall.marshall.Modelo.catalogos.c_ClaveUnidad;

@Service
public class valConceptosClaveUnidad {
    private MarshallCFDI marshallCFDI;
    private ClaveUnidadRepository claveUnidadRepository;

    public valConceptosClaveUnidad(MarshallCFDI marshallCFDI, ClaveUnidadRepository claveUnidadRepository){
        this.marshallCFDI = marshallCFDI;
        this.claveUnidadRepository = claveUnidadRepository;
    }

    public List<String> queryClaveUnidad(){
        List<c_ClaveUnidad> claveUnidad = claveUnidadRepository.findAll();
        List<String> listaQuery = new ArrayList<>();
        for (c_ClaveUnidad clave:claveUnidad) {
            listaQuery.add(clave.getC_ClaveUnidad());
        }
        return listaQuery;
    }
    public List<String> devolverClaveUnidad() {
        List<List<String>> lista = marshallCFDI.obtenerListasClaveUnidad();
        List<String> listaQuery = queryClaveUnidad();
        List<String> listaValida = new ArrayList<>();
    
        for (List<String> sublist : lista) {
            boolean valido = true;
            for (String descripcion : sublist) {
                if (!listaQuery.contains(descripcion)) {
                    valido = false;
                    break; 
                }
            }
            if (valido) {
                listaValida.add("Válido");
            } else {
                listaValida.add("No válido " + CodigoError.CFDI40165);
            }
        }
    
        return listaValida;
    }
    
    
    
}
