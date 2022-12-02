package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metodos")
public class MetodosHttpController {
    @GetMapping
    public String get(){
        return "Requisição Get";
    }
    @PostMapping
    public String post(){
        return "Requisição Post";
    }
    @PutMapping
    public String put(){
        return "Requisição Put";
    }
    @PatchMapping
    public String patch(){
        return "Requisição Patch";
    }
    @DeleteMapping
    public String delete(){
        return "Requisição Delete";
    }
}
