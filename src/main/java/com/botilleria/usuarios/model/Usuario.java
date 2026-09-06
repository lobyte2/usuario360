package com.botilleria.usuarios.model;

public class Usuario {
    private Long identificador;
    private String nombreUsuario;
    private String contrasena;

    public Usuario(Long identificador, String nombreUsuario, String contrasena) {
        this.identificador = identificador;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public Long getIdentificador() { return identificador; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getContrasena() { return contrasena; }
}