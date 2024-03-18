package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
        List<String> listaRegimenFiscal = marshallCFDI.obtenerRegimenFiscalReceptor();
        List<String> regimenFiscalValidado = new ArrayList<>();

        for (String regimenReal : listaRegimenFiscal) {
            boolean encontrado= false;
            for (String listaRegimen : listaObtenida) {
                if(listaRegimen.equals(regimenReal)){
                    encontrado = true;
                    break;
            }
            
        }
        regimenFiscalValidado.add(encontrado? "Válido" : "No válido" + CodigoError.CFDI40140 );
    }
    return regimenFiscalValidado;
}
   
    public List<String> valorRegimenFiscal(){
        List<String> listaValida = new ArrayList<>();
        List<String> listaRfc = marshallCFDI.obtenerRfcReceptor();
        List<String> listaRegimenFiscal = marshallCFDI.obtenerRegimenFiscalReceptor();
        String validado;
        for (int i = 0; i<listaRfc.size(); i++) {
            if(listaRfc.get(i).equals("XAXX010101000") || listaRfc.get(i).equals("XEXX010101000")){
                if(listaRegimenFiscal.get(i).equals("616")){
                    validado = "Válido";
                }else{
                    validado = "No válido. Error " + CodigoError.CFDI40159;
                }
                listaValida.add(validado);
            }
        }
        return listaValida;
    }


    public List<LinkedHashMap<String, String>> devolverMapa(){
        List<String> catalogoRegimen = validarRegimenFiscal();
        List<String> regimenFiscal = valorRegimenFiscal();
        List<LinkedHashMap<String, String>> lista = new ArrayList<>();
        
        for(int i = 0; i<catalogoRegimen.size(); i++){
            LinkedHashMap<String, String> mapa = new LinkedHashMap<>();
            mapa.put("c_regimenFiscal", catalogoRegimen.get(i));
            mapa.put("rfcREceptor", regimenFiscal.get(i));
            lista.add(mapa);
        }
        return lista;
    }
}
