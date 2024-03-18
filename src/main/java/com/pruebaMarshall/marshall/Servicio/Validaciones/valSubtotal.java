package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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


    public List<String> validarComprobante(){
        List<String> tipoComprobante = marshallCFDI.obtenerTiposDeComprobante();
        List<String> subtotales = marshallCFDI.obtenerSubTotales();
        List<String> listaValida = new ArrayList<>();
        String validado;
        for (int i = 0; i<subtotales.size(); i++) {
            if(tipoComprobante.get(i).equals("T") || tipoComprobante.get(i).equals("P")){
                if(subtotales.get(i).equals("0") || subtotales.get(i).equals("0.00")){
                    validado = "Válido";
                }else{
                    validado = "No válido. Error " + CodigoError.CFDI40109;
                }
            }else{
                validado = "Válido";
            }  
            listaValida.add(validado);
        }
        return listaValida;
    }

    public List<LinkedHashMap<String, String>> devolverMapa(){
        
        List<LinkedHashMap<String, String>> lista = new ArrayList<>();
        List<String> validaComprobante = validarComprobante();
        List<String> validaSubtotal = validarSubTotal();
        for(int i = 0; i<validaComprobante.size(); i ++){
            LinkedHashMap<String, String> mapa = new LinkedHashMap<>();
            mapa.put("decimales", validaSubtotal.get(i));
            mapa.put("comprobante t o p", validaComprobante.get(i));
            lista.add(mapa);
        }
        return lista;
    }
}
