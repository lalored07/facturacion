package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;

@Service
public class valTipoComprobante {
    private MarshallCFDI marshallCFDI;

    public valTipoComprobante(MarshallCFDI marshallCFDI) {
        this.marshallCFDI = marshallCFDI;
    }
    
    /*public String validarTipoComprobante() {
        StringBuilder tipoComprobantes = new StringBuilder();
        
        for (String comprobante : marshallCFDI.obtenerTiposDeComprobante()) {
            String tipo = comprobante;
            switch (tipo) {
                case "I":
                    tipoComprobantes.append("Ingreso, ");
                    break;
                case "E":
                    tipoComprobantes.append("Egreso, ");
                    break;
                case "T":
                    tipoComprobantes.append("Traslado, ");
                    break;
                case "N":
                    tipoComprobantes.append("Nómina, ");
                    break;
                case "P":
                    tipoComprobantes.append("Pago, ");
                    break;
                default:
                    tipoComprobantes.append("Tipo de comprobante no válido, ");
                    break;
            }
        }
        
        // Eliminar la última coma y el espacio
        if (tipoComprobantes.length() > 0) {
            tipoComprobantes.delete(tipoComprobantes.length() - 2, tipoComprobantes.length());
        }
        
        return tipoComprobantes.toString();
    }
*/
    public List<String> validarValidezCFDI() {
    List<String> listaValidacion = new ArrayList<>();
    
    for (String comprobante : marshallCFDI.obtenerTiposDeComprobante()) {
        String tipo = comprobante;
        boolean resultado = tipo.equals("I") || tipo.equals("E") || tipo.equals("T") || tipo.equals("N") || tipo.equals("P");
        String validado = "No válido, error: " + CodigoError.CFDI40202;
            if(resultado){
                validado = "Válido";
            }
            
            
        listaValidacion.add(validado);
    }
    
    return listaValidacion;
}

}
