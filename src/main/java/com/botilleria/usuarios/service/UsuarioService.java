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
        listaDeUsuarios.add(new Usuario(4L, "rod.ruiz@duocuc.cl", "azure123"));
    }

    public Usuario buscarPorNombre(String nombreUsuario) {
        for (Usuario u : listaDeUsuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return u;
            }
        }
        // Si entra un usuario nuevo de Cognito o Azure que no estaba en la lista,
        // le asigna un ID correlativo y lo registra automáticamente al vuelo:
        Long nuevoId = (long) (listaDeUsuarios.size() + 1);
        Usuario nuevo = new Usuario(nuevoId, nombreUsuario, "cognito123");
        listaDeUsuarios.add(nuevo);
        return nuevo;
    }
}