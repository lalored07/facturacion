package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;
import com.pruebaMarshall.marshall.Servicio.CodigosValidacion.c_RegimenFiscal;

@Service
public class valRegimenFiscal {
    
    private MarshallCFDI marshallCFDI;
    private c_RegimenFiscal c_RegimenFiscal;

    public valRegimenFiscal(MarshallCFDI marshallCFDI, c_RegimenFiscal c_RegimenFiscal){
        this.marshallCFDI = marshallCFDI;
        this.c_RegimenFiscal = c_RegimenFiscal;
    }

    public List<String> obtenerRegimenFiscal(){
        List<String> valores = new ArrayList<>();
        Field[] fields = c_RegimenFiscal.getClass().getDeclaredFields();
        for (Field field : fields) {
            String campo = field.getName().replace("_", "");
            valores.add(campo);
        }
        return valores;
    }

    public List<String> validarRegimenFiscal(){
        List<String> listaObtenida = obtenerRegimenFiscal();
        List<String> listaRegimenFiscal = marshallCFDI.obtenerREgimenFiscal();
        List<String> final1 = new ArrayList<>();
        String validado;
        for (String string : listaRegimenFiscal) {
            if(string.equals("a")){
                validado = "Valido";
            }else{
                validado = "No valido " + CodigoError.CFDI40182;
            }
            final1.add(validado);
        }
        return final1;
    }

   

}
