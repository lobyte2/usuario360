package com.botilleria.usuarios.service;

import com.botilleria.usuarios.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private List<Usuario> listaDeUsuarios = new ArrayList<>();

    public UsuarioService() {
        // Usuarios quemados en código para la botillería
        listaDeUsuarios.add(new Usuario(1L, "admin", "admin123"));
        listaDeUsuarios.add(new Usuario(2L, "luis", "luis123"));
        listaDeUsuarios.add(new Usuario(3L, "l.uribe@duocuc.cl", "azure123"));
    }

    public Usuario buscarPorNombre(String nombreUsuario) {
        return listaDeUsuarios.stream()
                .filter(u -> u.getNombreUsuario().equals(nombreUsuario))
                .findFirst()
                .orElse(null);
    }
}