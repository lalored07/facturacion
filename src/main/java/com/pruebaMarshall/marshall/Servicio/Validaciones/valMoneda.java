package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valMoneda {
    private MONEDA moneda;
    private MarshallCFDI marshallCFDI;

    public valMoneda(MarshallCFDI marshallCFDI, MONEDA moneda){
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

    public List<String> validarMoneda() {
        List<String> listaMonedaValida = new ArrayList<>();
        List<String> listaMonedaCFDI = marshallCFDI.obtenerMoneda();
        List<String> listaAtributoMoneda = obtenerAtributoMoneda();
        
        for (String monedaCFDI : listaMonedaCFDI) {
            boolean monedaEncontrada = false;
            for (String divisa : listaAtributoMoneda) {
                if (divisa.equals(monedaCFDI)) {
                    monedaEncontrada = true;
                    break;
                }
            }
            listaMonedaValida.add(monedaEncontrada ? "Válido" : "No válido" + CodigoError.CFDI40113 );
        }
        
        return listaMonedaValida;
    }
    
    
    
}
