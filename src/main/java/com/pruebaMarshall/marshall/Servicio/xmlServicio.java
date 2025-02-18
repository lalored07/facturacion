package com.pruebaMarshall.marshall.Servicio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pruebaMarshall.marshall.Modelo.CfdiRelacionados;
import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.Emisor;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class xmlServicio {

    public List<Comprobante> devolverDatosXml() {
        List<Comprobante> comprobantes = new ArrayList<>();
        try {
            File carpeta = new File("/home/albertalv/Documentos/Facturas/");
            if (carpeta.exists() && carpeta.isDirectory()) {
                File[] archivos = carpeta.listFiles((dir, nombre) -> nombre.toLowerCase().endsWith(".xml"));
                if (archivos != null) {
                    JAXBContext jaxbContext = JAXBContext.newInstance(Comprobante.class); 
                    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                    for (File archivo : archivos) {
                        Comprobante comprobante = (Comprobante) unmarshaller.unmarshal(archivo);
                        comprobante.setNombre(archivo.getName());
                        comprobantes.add(comprobante);
                      
                    }
                  
                } else {
                    
                }
            } else {
                
            }
        } catch (JAXBException e) {
           
        }
        return comprobantes;
    }

    
}
