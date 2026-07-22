package com.mycompany.proyectofinal;

public class Usuarios {

    private String usuario;
    private String contraseña;

    public Usuarios(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

}
