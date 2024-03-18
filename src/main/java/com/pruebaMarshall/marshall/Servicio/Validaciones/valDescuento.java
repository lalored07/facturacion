package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valDescuento {
    private MarshallCFDI marshallCFDI;
    private MONEDA moneda;
    public valDescuento(MarshallCFDI marshallCFDI, MONEDA moneda){
        this.marshallCFDI = marshallCFDI;
        this.moneda = moneda;
    }

    public List<String> obtenerAtributoMoneda(){
        List<String> listadoMonedas = new ArrayList<>();
        Field[] monedas = moneda.getClass().getDeclaredFields();
        for (Field field : monedas) {
            listadoMonedas.add(field.getName());
        }
        return listadoMonedas;
    }

    public List<String> compararConSubtotal(){
        List<String> subtotal = marshallCFDI.obtenerSubTotales();
        List<String> descuentos = marshallCFDI.obtenerDescuentos();
        List<String> listaValida = new ArrayList<>();
        String valido;
        for(int i = 0; i<subtotal.size(); i++){
            double subtotalNumerico = Double.parseDouble(subtotal.get(i));
            double descuentoNumerico = Double.parseDouble(descuentos.get(i));
            if(descuentoNumerico <= subtotalNumerico){
                valido = "Válido";
            }else{
                valido = "No válido " + CodigoError.CFDI40110;
            }
            listaValida.add(valido);
        }
        return listaValida;
    }

    public List<Integer> obtenerCantidadDecimales() {
        List<String> descuentos = marshallCFDI.obtenerDescuentos();
        List<Integer> puntosDecimales = new ArrayList<>();
       
        for (String descuento : descuentos) {
            String cantidadDescuento = descuento;
            int puntoDecimal = descuento.length() - cantidadDescuento.indexOf(".") - 1 ;
            puntosDecimales.add(puntoDecimal);
        }
    
        return puntosDecimales;
    }

    public List<String> obtenerNumeroDecimalesAsociados() throws IllegalArgumentException, IllegalAccessException{
        List<String> listadoDecimales = new ArrayList<>();
        Field[] monedas = moneda.getClass().getDeclaredFields();
        for (Field field : monedas) {
            field.setAccessible(true);
            String valor = (String)field.get(this);
            listadoDecimales.add(valor);
        }
        return listadoDecimales;
    }

    
    public LinkedHashMap<String,String> mapaMonedaDecimal() throws IllegalArgumentException, IllegalAccessException{
        LinkedHashMap<String, String> mapa = new LinkedHashMap<>();
        List<String> listadoDecimales = obtenerNumeroDecimalesAsociados();
        List<String> listadoMonedas = obtenerAtributoMoneda();
        for(int i = 0; i<listadoDecimales.size(); i++){
            mapa.put(listadoMonedas.get(i), listadoDecimales.get(i));
        }
        return mapa;
    }

    public List<String> validarNumeroDecimales() throws IllegalArgumentException, IllegalAccessException {
        List<Integer> puntosDecimales = obtenerCantidadDecimales();
        List<String> listadoArtibutoMoneda = obtenerAtributoMoneda();
        List<String> listadoMoneda = marshallCFDI.obtenerMoneda();
        List<String> listaValida = new ArrayList<>();
    
        LinkedHashMap<String, String> mapaMonedaDecimal = mapaMonedaDecimal();
        String validado;
        for (String moneda : listadoMoneda) {
            boolean monedaEncontrada = false;
            for (String atributoMoneda : listadoArtibutoMoneda) {
                if (atributoMoneda.equals(moneda)) {
                    monedaEncontrada = true;
                    int numeroDecimal = Integer.parseInt(mapaMonedaDecimal.get(moneda));
                    for (int numero : puntosDecimales) {
                        if (numero <= numeroDecimal) {
                            validado = "Válido";
                         
                        }else{
                            validado = "No válido " + CodigoError.CFDI40112;
                        }
                        listaValida.add(validado);
                    } 
                }
            }
            if (!monedaEncontrada) {
                
                listaValida.add("No válido " + CodigoError.CFDI40112);
            }
        }
    
        return listaValida;
    }
    
    
 
    public List<LinkedHashMap<String, String>> devolverMapa() throws IllegalArgumentException, IllegalAccessException{
        
        List<LinkedHashMap<String, String>> listaMapa = new ArrayList<>();
        List<String> validarNumerosDecimales = validarNumeroDecimales();
        List<String> compararSubtotal = compararConSubtotal();
        for(int i = 0; i<compararSubtotal.size(); i ++){
            LinkedHashMap<String, String> mapa = new LinkedHashMap<>();
            mapa.put("subtotal comparado", compararSubtotal.get(i));
            mapa.put("validar decimales", validarNumerosDecimales.get(i));
            listaMapa.add(mapa);
        }
        return listaMapa;
    }
}
