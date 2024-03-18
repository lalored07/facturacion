package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;
import com.pruebaMarshall.marshall.Servicio.CodigosValidacion.c_UsoCFDI;

@Service
public class valConceptosUsoCfdi {
    private MarshallCFDI marshallCFDI;
    private c_UsoCFDI c_UsoCFDI;

    public valConceptosUsoCfdi(MarshallCFDI marshallCFDI, c_UsoCFDI c_UsoCFDI){
        this.marshallCFDI = marshallCFDI;
        this.c_UsoCFDI = c_UsoCFDI;
    }

    public List<String> obtenerUsoCfdi(){
        List<String> listaUsoCfdi = new ArrayList<>();
        Field[] campos = c_UsoCFDI.getClass().getDeclaredFields();
        for (Field field : campos) {
            String campo = field.getName();
            listaUsoCfdi.add(campo);
        }
        return listaUsoCfdi;
    }

    public List<String> validarUsoCfdi(){
        List<String> listaValida = new ArrayList<>();
        List<String> listaUsoCfdi= obtenerUsoCfdi();
        List<String> listaUsoCfdiEncontrados = marshallCFDI.obtenerUsoCfdi();

        for (String usocfdi: listaUsoCfdiEncontrados) {
            Boolean validado = false;
            for (String cfdiListado : listaUsoCfdi) {
                if(cfdiListado.equals(usocfdi)){
                    validado = true;
                    break; 
                }
            }
            listaValida.add(validado ? "Válido" : "No válido" + CodigoError.CFDI40160 );
        }
        return listaValida;
    }

    
}
