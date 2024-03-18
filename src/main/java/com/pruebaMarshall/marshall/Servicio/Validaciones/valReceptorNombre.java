package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;


@Service
public class valReceptorNombre {
    private MarshallCFDI marshallCFDI;

    public valReceptorNombre(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> validarReceptor() {
        List<String> receptores = marshallCFDI.obtenerNombresReceptores();
        List<String> rfcReceptor = marshallCFDI.obtenerRfcReceptor();
        List<String> nombresValidados = new ArrayList<>();
    
        for (int i = 0; i < receptores.size(); i++) {
            String receptor = receptores.get(i);
            String rfc = rfcReceptor.get(i);
            String validado;
    
            if (receptor.equals("PUBLICO EN GENERAL")) {
                if(rfc.equals("XAXX010101000")){
                    validado = "Válido";
                }else{
                    validado = "No válido. Error " + CodigoError.CFDI40146;
                }
            } else {
                validado = "Válido";
            }
    
            nombresValidados.add(validado);
        }
    
        return nombresValidados;
    }
    
}
