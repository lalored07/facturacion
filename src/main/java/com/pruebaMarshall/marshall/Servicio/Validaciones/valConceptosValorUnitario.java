package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valConceptosValorUnitario {
    private MarshallCFDI marshallCFDI;

    public valConceptosValorUnitario(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> validarValorUnitario() {
        List<List<String>> lista = marshallCFDI.obtenerValorUnitario();
        List<String> listaValida = new ArrayList<>();
        List<String> listaTipoComprobante = marshallCFDI.obtenerTiposDeComprobante();
    
        for (String comprobante : listaTipoComprobante) {
            List<String> listaValidaComprobante = new ArrayList<>(); 
    
            for (List<String> valorUnitario : lista) {
                String validado = "Válido"; 

                if (comprobante.equals("I") || comprobante.equals("E") || comprobante.equals("N")) {
                    for (String valor : valorUnitario) {
                        double numero = Double.parseDouble(valor);
                        if (numero <= 0.0) {
                            validado = "No válido. Error " + CodigoError.CFDI40166;
                            break; 
                        }
                    }
                } else {
                    
                }
    
                listaValidaComprobante.add(validado);
            }
    
            
            listaValida.addAll(listaValidaComprobante);
        }
    
        return listaValida;
    }
    
    
}
