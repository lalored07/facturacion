package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valSubtotal {
    private MarshallCFDI marshallCFDI;

    public valSubtotal(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> validarSubTotal() {
    List<String> listaValidacion = new ArrayList<>();
    
    for (String comprobante : marshallCFDI.obtenerSubTotales()) {
        String validado;
        String subTotal = comprobante;
        int cantidadDeDecimales;
        int indicePuntoDecimal = subTotal.indexOf('.');
        
      
        if (indicePuntoDecimal >= 0) {
            cantidadDeDecimales = subTotal.length() - indicePuntoDecimal - 1;
        } else {
            cantidadDeDecimales = 0; 
        }
        
        boolean resultado = cantidadDeDecimales <= 2;
        if (resultado) {
            validado = "Válido";
        } else {
            validado =  "No válido, error : " + CodigoError.CFDI40222;
        }
        listaValidacion.add(validado);
    }
    
    return listaValidacion;
}


    
}
