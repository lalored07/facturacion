package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valReceptorDomicilioFIscal {
    private MarshallCFDI marshallCFDI;

    public valReceptorDomicilioFIscal(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> validarAtributoRFC(){
        List<String> atributoRFC = marshallCFDI.obtenerRfcReceptor();
        List<String> domicilioFiscal = marshallCFDI.obtenerDomicilioFiscalReceptor();
        List<String> lugarExpedicion = marshallCFDI.obtenerLugarExpedicion();
        List<String> listaRfc =  new ArrayList<>();
        String validado;
        for (int i = 0; i<atributoRFC.size(); i++) {
            if(atributoRFC.get(i).equals("XAXX010101000") || atributoRFC.get(i).equals("XEXX010101000")){
                if(domicilioFiscal.get(i).equals(lugarExpedicion.get(i))){
                    validado = "Válido";
                }else{
                    validado = "No válido. Error " + CodigoError.CFDI40149;
                }
                listaRfc.add(validado);
            }
        }
        return listaRfc;
    }
}
