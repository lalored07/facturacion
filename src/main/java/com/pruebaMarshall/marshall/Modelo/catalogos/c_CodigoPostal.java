package com.pruebaMarshall.marshall.Modelo.catalogos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "c_CodigoPostal")
public class c_CodigoPostal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="c_CodigoPostal")
    private String c_CodigoPostal;
    @Column(name="c_Estado")
    private String c_Estado;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getC_CodigoPostal() {
        return c_CodigoPostal;
    }
    public void setC_CodigoPostal(String c_CodigoPostal) {
        this.c_CodigoPostal = c_CodigoPostal;
    }
    public String getC_Estado() {
        return c_Estado;
    }
    public void setC_Estado(String c_Estado) {
        this.c_Estado = c_Estado;
    }
    
}
