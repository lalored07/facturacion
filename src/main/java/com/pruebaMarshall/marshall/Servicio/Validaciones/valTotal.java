package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valTotal {
    private MarshallCFDI marshallCFDI;
    
    public valTotal(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

     public List<String> validarTotal() {
    List<String> listaValidacion = new ArrayList<>();
    
    for (String comprobante : marshallCFDI.obtenerTotales()) {
        String validado;
        String total = comprobante;
        int cantidadDeDecimales;
        int indicePuntoDecimal = total.indexOf('.');
        if (indicePuntoDecimal >= 0) {
            cantidadDeDecimales = total.length() - indicePuntoDecimal - 1;
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
