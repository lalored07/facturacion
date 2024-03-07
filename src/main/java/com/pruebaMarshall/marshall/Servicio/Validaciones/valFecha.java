package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valFecha {
    private MarshallCFDI marshallCFDI;

    public valFecha(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> validarFecha(){
        String validado;
        List<String> listaFechas = new ArrayList<>();
        String pattern = "\\b\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\b";

        for(String fecha : marshallCFDI.obtenerFecha()){
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(fecha);
            boolean resultado = matcher.matches();
            if (resultado) {
                validado = "Válido";
            } else {
                validado =  "No válido, error : " + CodigoError.CFDI40101;
            }
            listaFechas.add(validado);
            
        }
        return listaFechas;
    }
}
