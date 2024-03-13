package com.pruebaMarshall.marshall.Controlador;

import org.springframework.web.bind.annotation.RestController;

import com.pruebaMarshall.marshall.Servicio.Validaciones.valTipoComprobante;
import com.pruebaMarshall.marshall.Servicio.Validaciones.validacionCompleta;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class FacturacionController {
    private valTipoComprobante valTipoComprobante;
    private validacionCompleta validacionCompleta;
    public FacturacionController(validacionCompleta validacionCompleta){
        this.validacionCompleta = validacionCompleta;
    }

    @GetMapping("/validarFactura")
    public Map<String,Object> validarTipoFactura() throws IllegalArgumentException, IllegalAccessException {
       return validacionCompleta.validar();
    }
    
}
