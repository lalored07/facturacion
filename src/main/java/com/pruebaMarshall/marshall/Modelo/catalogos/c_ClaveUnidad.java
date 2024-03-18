package com.pruebaMarshall.marshall.Modelo.catalogos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="c_ClaveUnidad")
public class c_ClaveUnidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "c_ClaveUnidad")
    private String c_ClaveUnidad;
    @Column(name = "Nombre")
    private String Nombre;
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getC_ClaveUnidad() {
        return c_ClaveUnidad;
    }
    public void setC_ClaveUnidad(String c_ClaveUnidad) {
        this.c_ClaveUnidad = c_ClaveUnidad;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    
}
