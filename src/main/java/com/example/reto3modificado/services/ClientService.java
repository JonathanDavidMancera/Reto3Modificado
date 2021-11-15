package com.example.reto3modificado.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.reto3modificado.models.Cliente;
import com.example.reto3modificado.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public ArrayList<Cliente> obtenerUsuarios() {
        return (ArrayList<Cliente>) clientRepository.findAll();
    }

    public Cliente guardarUsuario(Cliente cliente) {
        return clientRepository.save(cliente);
    }

    public Optional<Cliente> obtenerPorId(Long id) {
        return clientRepository.findById(id);
    }

    public boolean eliminarUsuario(Long id) {
        try {
            clientRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
