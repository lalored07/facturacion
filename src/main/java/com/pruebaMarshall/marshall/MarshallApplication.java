package com.pruebaMarshall.marshall;

import java.io.File;
import java.lang.reflect.Field;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pruebaMarshall.marshall.Modelo.CFDI;
import com.pruebaMarshall.marshall.Modelo.CfdiRelacionados;
import com.pruebaMarshall.marshall.Modelo.Comprobante;
import com.pruebaMarshall.marshall.Modelo.Emisor;
import com.pruebaMarshall.marshall.Modelo.MarshallCFDI;
import com.pruebaMarshall.marshall.Servicio.xmlServicio;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

@SpringBootApplication
public class MarshallApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarshallApplication.class, args);
		MarshallCFDI marshallCFDI = new MarshallCFDI();
		Comprobante comprobante = new Comprobante(marshallCFDI.obtenerCertificado(),marshallCFDI.obtenerNoCertificado(), marshallCFDI.obtenerSello(), marshallCFDI.obtenerCfdiRelacionados(), marshallCFDI.obtenerEmisor(), marshallCFDI.obtenerReceptor());
		System.out.print(comprobante.getReceptor().getNombre());
		
	}

}
