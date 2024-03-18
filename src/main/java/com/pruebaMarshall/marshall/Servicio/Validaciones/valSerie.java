package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valSerie {
    private MarshallCFDI marshallCFDI;
    
    public valSerie(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> validarSerie() {
    List<String> listaValidacion = new ArrayList<>();
    
    for (String comprobante : marshallCFDI.obtenerSeries()) {
        String validado;
        String serie = comprobante;
        int longitudSerie = serie.length();
        Pattern patron = Pattern.compile("^[A-Z0-9]+$");
        Matcher matcher = patron.matcher(serie);
        boolean resultado = longitudSerie > 0 && longitudSerie <= 25 && matcher.matches();
        if (resultado) {
            validado = "Válido";
        } else {
            validado =  "No válido";
        }
        listaValidacion.add(validado);
        
    }
    
    return listaValidacion;
}

    
}
