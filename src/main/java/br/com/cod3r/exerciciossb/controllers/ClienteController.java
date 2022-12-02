package br.com.cod3r.exerciciossb.controllers;

import br.com.cod3r.exerciciossb.model.entities.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping("/qualquer")
    public Cliente obterCliente(){
        return new Cliente(28, "Pedro", "12345678-99");
    }
    @GetMapping("/{id}")
    public Cliente obterClientePorId1(@PathVariable int id){
        return new Cliente(id, "Maria","1020304050-55");
    }
    @GetMapping
    public Cliente obterClientePorId2(@RequestParam(name = "id", defaultValue = "1" +
            "") int id){
        return new Cliente(id, "Jose","1020304050-55");
    }
}
