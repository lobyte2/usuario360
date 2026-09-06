package com.botilleria.usuarios;

import com.botilleria.usuarios.model.Usuario;
import com.botilleria.usuarios.service.UsuarioService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UsuarioServiceTest {

    @Test
    void buscarPorNombre_UsuarioExistente_RetornaUsuario() {
        // Arrange
        UsuarioService usuarioService = new UsuarioService();

        // Act
        Usuario resultado = usuarioService.buscarPorNombre("luis");

        // Assert
        assertNotNull(resultado);
        assertEquals("luis", resultado.getNombreUsuario());
        assertEquals("luis123", resultado.getContrasena());
    }

    @Test
    void buscarPorNombre_UsuarioInexistente_RetornaNull() {
        // Arrange
        UsuarioService usuarioService = new UsuarioService();

        // Act
        Usuario resultado = usuarioService.buscarPorNombre("desconocido");

        // Assert
        assertNull(resultado);
    }
}