package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Impuestos;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valConceptosObjetoImp {
    private MarshallCFDI marshallCFDI;

    public valConceptosObjetoImp(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> validarCatalogoObjetoImp(){
        List<List<String>> listaObjetoImp = marshallCFDI.obtenerObjetoImp();
        
        List<String> listaValida = new ArrayList<>();
        
        for (List<String> sublist : listaObjetoImp) {
            boolean sublistValida = true;
            for (String objetoImp : sublist) {
                if(!(objetoImp.equals("01") || objetoImp.equals("02") || objetoImp.equals("03") || objetoImp.equals("04") || objetoImp.equals("05"))){
                    sublistValida = false;
                    break;
                }
            }
            String validado = sublistValida ? "Válido" : "No válido. Error " + CodigoError.CFDI40170;
            listaValida.add(validado);
        }
        
        return listaValida;
    }
    
    public List<String> validarNodoHijo(){
        List<String> listaValida = new ArrayList<>();
        List<List<String>> listaObjetoImp = marshallCFDI.obtenerObjetoImp();
        List<List<Impuestos>> listaImpuestos = marshallCFDI.obtenerConceptoImpuestos();
    
        for (int i = 0; i < listaObjetoImp.size(); i++) {
            boolean sublistValida = true; 
            List<String> sublist = listaObjetoImp.get(i); 
            String objetoImp = sublist.get(sublist.size() - 1); 
            if (objetoImp.equals("02")) { 
                List<Impuestos> impuestos = listaImpuestos.get(i); 
                if (impuestos != null) { 
                    for (Impuestos impuesto : impuestos) { 
                        if (impuesto == null) { 
                            sublistValida = false; 
                            break; 
                        }
                    }
                } else {
                    sublistValida = false; 
                }
            }else if(objetoImp.equals("01") ||  objetoImp.equals("03") || objetoImp.equals("04") || objetoImp.equals("05")){
                List<Impuestos> impuestos = listaImpuestos.get(i);
                if (impuestos != null) { 
                    for (Impuestos impuesto : impuestos) { 
                        if (impuesto == null) { 
                            sublistValida = true; 
                            break; 
                        }
                    }
                } else {
                    sublistValida = false; 
                }
            }
            String validado = sublistValida ? "Válido" : "No válido. Error " + CodigoError.CFDI40171;
            listaValida.add(validado);
        }
        
        return listaValida;
    }
    
    
    

     public List<LinkedHashMap<String, Object>> agregarMapa(){
        
        List<String> validarCatalogo = validarCatalogoObjetoImp();
        List<String> validarNodoHijo = validarNodoHijo();
        List<LinkedHashMap<String, Object>> listaMapa = new ArrayList<>();
        
        for(int i = 0; i < validarCatalogoObjetoImp().size(); i++){
            LinkedHashMap<String, Object> mapa = new LinkedHashMap<>();
            mapa.put("c_objetoImp", validarCatalogo.get(i));
            mapa.put("Nodo hijo", validarNodoHijo.get(i));
            listaMapa.add(mapa);
        }
        
        return listaMapa;
    }
    
}
