package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valConceptoTrasladosBase {
    private MarshallCFDI marshallCFDI;

    public valConceptoTrasladosBase(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> recuperarTrasladosBase(){
        List<List<String>> listaTraslados = marshallCFDI.obtenerConceptoImpuestosTraslado();
        List<String> listaValida = new ArrayList<>();
        for (List<String> list : listaTraslados) {
            for (String base : list) {
                listaValida.add(base);
            }
        }
        return listaValida;
    }
}
