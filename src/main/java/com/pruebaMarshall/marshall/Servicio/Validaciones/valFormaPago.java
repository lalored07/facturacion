package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;
import com.pruebaMarshall.marshall.Servicio.CodigosValidacion.c_FormaPago;

@Service
public class valFormaPago {
    private MarshallCFDI marshallCFDI;
    private c_FormaPago c_FormaPago;
    private valTipoComprobante valTipoComprobante;

    public valFormaPago(MarshallCFDI marshallCFDI, c_FormaPago c_FormaPago, valTipoComprobante valTipoComprobante){
        this.marshallCFDI = marshallCFDI;
        this.c_FormaPago = c_FormaPago;
        this.valTipoComprobante = valTipoComprobante;
    }

    public List<String> obtenerCodigos(){
        Field[] errores = c_FormaPago.getClass().getDeclaredFields();
        List<String> listaCodigos = new ArrayList<>();
        for (Field field : errores) {
            String error = field.getName().replace("_", "");
            listaCodigos.add(error);
        }

        return listaCodigos;
    }

    public List<String> validarCatalogoFormaPago(){
        List<String> listaCatalogo = new ArrayList<>();
        List<String> listaFormaPago = marshallCFDI.obtenerFormaPago();
        List<String> listaCodigoPago = obtenerCodigos();
        
        for (String formaPago : listaFormaPago) {
            boolean formaPagoEncontrada= false;
            for (String codigoPago : listaCodigoPago) {
                if (codigoPago.equals(formaPago)) {
                    formaPagoEncontrada = true;
                    break;
                }
            }
            listaCatalogo.add(formaPagoEncontrada ? "Válido" : "No válido" + CodigoError.CFDI40104 );
        }
        return listaCatalogo;
        
    }

    public List<String> validarPPD() {
        List<String> listaMetodoPago = marshallCFDI.obtenerMetodoPago();
        List<String> listaFormaPago = marshallCFDI.obtenerFormaPago();
        List<String> listaValida = new ArrayList<>();
        String patronPPD = ".*PPD.*";
        Pattern patternPPD = Pattern.compile(patronPPD);
        String patron99 = "99";
        Pattern pattern99 = Pattern.compile(patron99);
    
        for (String metodoPago : listaMetodoPago) {
            Matcher matcherPPD = patternPPD.matcher(metodoPago);
            boolean ppdPresente = matcherPPD.find();
    
            if (ppdPresente) {
                boolean formaPagoValida = false;
                for (String formaPago : listaFormaPago) {
                    Matcher matcher99 = pattern99.matcher(formaPago);
                    if (matcher99.find()) {
                        formaPagoValida = true;
                        break;
                    }
                }
                listaValida.add(formaPagoValida ? "Válido" : "No válido " + CodigoError.CFDI40105);
            } else {
                
                listaValida.add("Válido");
            }
        }
    
        return listaValida;
    }
    
    public List<String> validarExistencia(){
        List<String> listaTipos = marshallCFDI.obtenerTiposDeComprobante();
        List<String> listaFormaPago = marshallCFDI.obtenerFormaPago();
        List<String> listaValida = new ArrayList<>();
    
        for (String tipo : listaTipos) {
            boolean valido = true;
            if (tipo.equals("T") || tipo.equals("N") || tipo.equals("P")) {
                for (String formaPago : listaFormaPago) {
                    if (formaPago != null) {
                        valido = false;
                        break;
                    }else {
                        valido = true;
                }
            } 
            }
            listaValida.add(valido ? "Válido" : "No válido " + CodigoError.CFDI40103);
        }
        
        return listaValida;
    }
    

    public List<LinkedHashMap<String, Object>> agregarMapa(){
        List<String> validarPPD = validarPPD();
        List<String> validarCatalogo = validarCatalogoFormaPago();
        List<String> validarExistencia = validarExistencia();
        List<LinkedHashMap<String, Object>> listaMapa = new ArrayList<>();
        
        for(int i = 0; i < validarPPD.size(); i++){
            LinkedHashMap<String, Object> mapaFormaPago = new LinkedHashMap<>();
            mapaFormaPago.put("c_formaPago", validarCatalogo.get(i));
            mapaFormaPago.put("AtributoPPD", validarPPD.get(i));
            mapaFormaPago.put("formaPagoNula", validarExistencia.get(i));
            listaMapa.add(mapaFormaPago);
        }
        
        return listaMapa;
    }
    
    
}
