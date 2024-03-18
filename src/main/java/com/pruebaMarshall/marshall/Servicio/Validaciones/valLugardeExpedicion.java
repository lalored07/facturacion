package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.JPA.CodigoPostalRepository;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;
import com.pruebaMarshall.marshall.Modelo.catalogos.c_CodigoPostal;

@Service
public class valLugardeExpedicion {
    private CodigoPostalRepository codigoPostalRepository;
    private MarshallCFDI marshallCFDI;
    
    public valLugardeExpedicion(CodigoPostalRepository codigoPostalRepository, MarshallCFDI marshallCFDI){
        this.codigoPostalRepository = codigoPostalRepository;
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> obtenerCodigoPostal(){
        
        List<c_CodigoPostal> queryCP = codigoPostalRepository.findAll();
        List<String> listaCodigos = new ArrayList<>();
        for (c_CodigoPostal c_CodigoPostal : queryCP) {
            String codigo = c_CodigoPostal.getC_CodigoPostal();
            listaCodigos.add(codigo);
        }
        return listaCodigos;
    }

    public List<String> validarCodigoPostal(){
        List<String> lugarDeExpedicion = marshallCFDI.obtenerLugarExpedicion();
        List<String> cpValido = new ArrayList<>();
        List<String> listaCodigos = obtenerCodigoPostal();
        for (String codigosCFDI : lugarDeExpedicion) {
            Boolean validado = false;
            for (String codigo : listaCodigos) {
                if(codigo.equals(codigosCFDI)){
                    validado = true;
                    break;
                }
            }
            cpValido.add(validado ? "Válido" : "No válido" + CodigoError.CFDI40126 );
        }   

        return cpValido;
    }
}
