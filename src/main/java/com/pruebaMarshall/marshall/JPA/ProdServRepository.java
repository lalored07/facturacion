package com.pruebaMarshall.marshall.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaMarshall.marshall.Modelo.catalogos.c_ClaveProdServ;


public interface ProdServRepository extends JpaRepository<c_ClaveProdServ, Integer>{
    
}
