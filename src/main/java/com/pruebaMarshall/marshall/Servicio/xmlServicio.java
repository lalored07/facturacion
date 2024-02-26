package com.pruebaMarshall.marshall.Servicio;

import java.io.File;

import com.pruebaMarshall.marshall.Modelo.CfdiRelacionados;
import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.Emisor;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class xmlServicio {

    public Comprobante devolverDatosXml(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Comprobante.class); 
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            
            Comprobante comprobante = (Comprobante) unmarshaller.unmarshal(new File("src/main/java/com/pruebaMarshall/marshall/Modelo/Invoice_632282102_Factura.xml"));
            return comprobante;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    
}
