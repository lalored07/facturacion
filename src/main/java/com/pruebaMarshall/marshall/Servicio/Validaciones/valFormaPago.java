package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valFormaPago {
    private MarshallCFDI marshallCFDI;

    public valFormaPago(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> validarCatalogoFormaPago(){
        
        return null;
    }
}
