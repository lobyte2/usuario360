package com.botilleria.usuarios;

import com.botilleria.usuarios.controller.UsuarioController;
import com.botilleria.usuarios.model.Usuario;
import com.botilleria.usuarios.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    void obtenerPerfil_UsuarioExiste_RetornaOk() {
        // Arrange
        // Nota: Si quitaste la contraseña del modelo Usuario, ajusta el constructor
        Usuario mockUsuario = new Usuario(2L, "luis", "luis123");
        when(usuarioService.buscarPorNombre("luis")).thenReturn(mockUsuario);

        // Act
        ResponseEntity<Usuario> response = usuarioController.obtenerPerfil("luis");

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void obtenerPerfil_UsuarioNoExiste_RetornaNotFound() {
        // Arrange
        when(usuarioService.buscarPorNombre("desconocido")).thenReturn(null);

        // Act
        ResponseEntity<Usuario> response = usuarioController.obtenerPerfil("desconocido");

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}