package com.example.reto3modificado.repositories;

import com.example.reto3modificado.models.Cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Cliente, Long> {
    
}