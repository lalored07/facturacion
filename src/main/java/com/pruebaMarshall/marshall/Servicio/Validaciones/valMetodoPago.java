package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valMetodoPago {
    private MarshallCFDI marshallCFDI;

    public valMetodoPago(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> validarMetodoPago(){
        List<String> metodoPago =  marshallCFDI.obtenerMetodoPago();
        List<String> pagoValidado = new ArrayList<>();
        String validado;
        for (String metodo : metodoPago) {
            if(metodo.equals("PPD") || metodo.equals("PUE")){
                validado = "Válido";
            }else{
                validado = "No válido.Error " + CodigoError.CFDI40123;
            }
            pagoValidado.add(validado);
        }
        return pagoValidado;
    }

    public List<String> tipoComprobante(){
        List<String> tipoComprobante = marshallCFDI.obtenerTiposDeComprobante();
        List<String> metodoPago =  marshallCFDI.obtenerMetodoPago();
        List<String> pagoValidado = new ArrayList<>();
        String validado;
        for (int i =0; i<tipoComprobante.size(); i++) {
            if(tipoComprobante.get(i).equals("T") || tipoComprobante.get(i).equals("P")){
                if(metodoPago.get(i) == null){
                    validado = "Válido";
                }else{
                    validado = "No válido. Error " + CodigoError.CFDI40125;
                }
            }else{
                validado = "Válido";
            }
            pagoValidado.add(validado);
        }
        return pagoValidado;
    }

    
    public List<LinkedHashMap<String, Object>> agregarMapa() {
        List<LinkedHashMap<String, Object>> listaMapa = new ArrayList<>();
        List<String> tipoComprobante = tipoComprobante();
        List<String> pagoValidado = validarMetodoPago();
        for(int i = 0; i < tipoComprobante.size(); i++){
            LinkedHashMap<String, Object> mapaFormaPago = new LinkedHashMap<>();
            mapaFormaPago.put("metodoPago", pagoValidado.get(i));
            mapaFormaPago.put("tipoComprobante", tipoComprobante.get(i));
            listaMapa.add(mapaFormaPago);
        }
        return listaMapa;
    }

    
   
  
}



