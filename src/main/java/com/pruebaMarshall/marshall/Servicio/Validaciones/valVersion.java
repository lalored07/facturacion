package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valVersion {
    private MarshallCFDI marshallCFDI;

    public valVersion(MarshallCFDI marshallCFDI){
        this.marshallCFDI = marshallCFDI;
    }

    /*public String validarVersion(){
        for (Comprobante comprobante : marshallCFDI.obtenerComprobantes()) {
            String version = comprobante.getVersion();
            if (version.equals("4.0")) {
                return "Validado";
            }
        }
        return "Versión no válida";
    }*/

    public List<String> validarVersion(){
        String validado;
        List<String> listaVersion = new ArrayList<>();
        List<String> listaVersiones = marshallCFDI.obtenerVersiones();

        for (String comprobante : listaVersiones) {
            if (comprobante.equals("4.0")) {
                validado = "Válido";
            }else {
                validado =  "No válido, error : " + CodigoError.CFDI40222;
            }
            listaVersion.add(validado);
        }
        return listaVersion;
    }
}
