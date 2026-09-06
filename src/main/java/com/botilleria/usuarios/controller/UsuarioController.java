package com.botilleria.usuarios.controller;

import com.botilleria.usuarios.model.Usuario;
import com.botilleria.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/perfil/{nombreUsuario}")
    public ResponseEntity<Usuario> obtenerPerfil(@PathVariable String nombreUsuario) {
        Usuario usuarioEncontrado = usuarioService.buscarPorNombre(nombreUsuario);

        if (usuarioEncontrado != null) {
            return ResponseEntity.ok(usuarioEncontrado);
        }

        return ResponseEntity.notFound().build();
    }

}