package com.pruebaMarshall.marshall.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaMarshall.marshall.Modelo.catalogos.c_CodigoPostal;

public interface CodigoPostalRepository extends JpaRepository<c_CodigoPostal, Integer> {
    
}
