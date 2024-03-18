package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.JPA.ProdServRepository;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;
import com.pruebaMarshall.marshall.Modelo.catalogos.c_ClaveProdServ;

import jakarta.xml.bind.MarshalException;

@Service
public class valConceptosClaveProdServ {
    private MarshallCFDI marshallCFDI;
    private ProdServRepository prodServRepository;
    public valConceptosClaveProdServ(MarshallCFDI marshallCFDI, ProdServRepository prodServRepository){
        this.marshallCFDI = marshallCFDI;
        this.prodServRepository = prodServRepository;
    }

    public List<String> queryProdServ(){
        List<c_ClaveProdServ> queryProd = prodServRepository.findAll();
        List<String> listaProdServ = new ArrayList<>();
        for (c_ClaveProdServ clave : queryProd) {
            listaProdServ.add(clave.getC_ClaveProdServ());
        }
        return listaProdServ;
    }

    public List<String> validarProdServ(){
        List<List<String>> listaClavesObtenidas = marshallCFDI.obtenerClaveProdServ();
        List<String> listaProdServ = queryProdServ();
        List<String> listaValida = new ArrayList<>();
        for (List<String> sublist : listaClavesObtenidas) {
            boolean valido = true;
            for (String clave : sublist) {
                if (!listaProdServ.contains(clave)) {
                    valido = false;
                    break; 
                }
            }
            if (valido) {
                listaValida.add("Válido");
            } else {
                listaValida.add("No válido " + CodigoError.CFDI40162);
            }
        }
        return listaValida;
    }
}
