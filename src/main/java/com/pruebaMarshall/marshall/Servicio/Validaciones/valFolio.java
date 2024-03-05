package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valFolio {
    private MarshallCFDI marshallCFDI;
    public valFolio(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    public List<String> validarFolio() {
    List<String> listaValidacion = new ArrayList<>();
    
    for (String comprobante : marshallCFDI.obtenerFolios()) {
        String validado;
        String folio = comprobante;
        int longitudFolio = folio.length();
        Pattern patron = Pattern.compile("^[A-Z0-9]+$");
        Matcher matcher = patron.matcher(folio);
        boolean resultado = longitudFolio > 0 && longitudFolio <= 40 && matcher.matches();
        if (resultado) {
            validado = "Válido";
        } else {
            validado =  "No válido, error : " + CodigoError.CFDI40222;
        }
        listaValidacion.add(validado);
        
    }
    
    return listaValidacion;
}

}
