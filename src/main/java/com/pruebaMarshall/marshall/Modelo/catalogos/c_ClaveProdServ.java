package com.pruebaMarshall.marshall.Modelo.catalogos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="c_ClaveProdServ")
public class c_ClaveProdServ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "c_ClaveProdServ")
    private String c_ClaveProdServ;
    @Column(name = "Descripcion")
    private String Descripcion;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getC_ClaveProdServ() {
        return c_ClaveProdServ;
    }
    public void setC_ClaveProdServ(String c_ClaveProdServ) {
        this.c_ClaveProdServ = c_ClaveProdServ;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    
}
