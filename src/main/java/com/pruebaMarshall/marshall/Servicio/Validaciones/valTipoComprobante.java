package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valTipoComprobante {
    private MarshallCFDI marshallCFDI;

    public valTipoComprobante(MarshallCFDI marshallCFDI) {
        this.marshallCFDI = marshallCFDI;
    }
    
    public List<String> validarTipoComprobante() {
        
        List<String> listaTipos = new ArrayList<>();
        String validado;
        for (String comprobante : marshallCFDI.obtenerTiposDeComprobante()) {
            String tipo = comprobante;
            if(tipo.equals("I") || tipo.equals("E")|| tipo.equals("T") || tipo.equals("N") || tipo.equals("P")){
                validado = "Válido";
            }else{
                validado = "No válido " + CodigoError.CFDI40121;
            }
            listaTipos.add(validado);
        }
        return null;
        
    }  
    public List<String> validarValidezCFDI() {
    List<String> listaValidacion = new ArrayList<>();
    
    for (String comprobante : marshallCFDI.obtenerTiposDeComprobante()) {
        String tipo = comprobante;
        boolean resultado = tipo.equals("I") || tipo.equals("E") || tipo.equals("T") || tipo.equals("N") || tipo.equals("P");
        String validado = "No válido, error: " + CodigoError.CFDI40121;
            if(resultado){
                validado = "Válido";
            }
            
            
        listaValidacion.add(validado);
    }
    
    return listaValidacion;
}

}
