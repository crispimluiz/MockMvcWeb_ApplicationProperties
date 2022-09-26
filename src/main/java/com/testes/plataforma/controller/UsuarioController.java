package com.testes.plataforma.controller;

import com.testes.plataforma.model.UsuarioModel;
import com.testes.plataforma.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> exibirUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.todosUsuarios());
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody UsuarioModel usuarioModel){
        UsuarioModel usuario = usuarioService.cadastrar(usuarioModel);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    //Teste MockWeb
    @RequestMapping(path = "/informar")
    public @ResponseBody String Informar(){
        return usuarioService.informar();
    }

}
