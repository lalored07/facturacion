package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;
import com.pruebaMarshall.marshall.Servicio.CodigosValidacion.c_TipoRelacion;

@Service
public class valCfdiRelacionadosTipoRelacion {
    private MarshallCFDI marshallCFDI;
    private c_TipoRelacion c_TipoRelacion;
    public valCfdiRelacionadosTipoRelacion(MarshallCFDI marshallCFDI, c_TipoRelacion c_TipoRelacion){
        this.marshallCFDI = marshallCFDI;
        this.c_TipoRelacion = c_TipoRelacion;
    }

    public List<String> obtenerTiposRelacion(){
        List<String> listaTipoRelacion = new ArrayList<>();
        Field[] field = c_TipoRelacion.getClass().getDeclaredFields();
        for (Field fields : field) {
            String campo = fields.getName().replace("_", "");
            listaTipoRelacion.add(campo);
        }
        return listaTipoRelacion;
    }
    public List<String> validarCTipoRelacion(){
        List<String> listaTipoRelacion = obtenerTiposRelacion();
        List<String> listaValida = new ArrayList<>();
        List<String> listaRelacionCFDI = marshallCFDI.obtenerTipoRelacion();
        for (String relacion : listaRelacionCFDI) {
            boolean relacionEncontrada = false;
            for (String listaRelacion : listaTipoRelacion) {
                if(listaRelacion.equals(relacion)){
                    relacionEncontrada = true;
                    break;
                }
            }
            listaValida.add(relacionEncontrada ? "Válido" : "No válido" + CodigoError.CFDI40137 );
        }

        return listaValida;
    }
}
