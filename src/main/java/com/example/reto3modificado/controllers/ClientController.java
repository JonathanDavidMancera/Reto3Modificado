package com.example.reto3modificado.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.reto3modificado.models.Cliente;
import com.example.reto3modificado.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ClientController {
    
    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public ArrayList<Cliente> obtenerUsuarios() {
        return clientService.obtenerUsuarios();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente guardarUsuario(@RequestBody Cliente cliente) {
        return this.clientService.guardarUsuario(cliente);
    }

    @GetMapping( path = "/{id}")
    public Optional<Cliente> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.clientService.obtenerPorId(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente actualizarCliente(@RequestBody Cliente cliente) {
        return this.clientService.guardarUsuario(cliente);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String eliminarPorId(@PathVariable("id")Long id) {
        boolean ok = this.clientService.eliminarUsuario(id);

        if(ok) {
            return "";
        } else {
            return "";
        }
    }
}
