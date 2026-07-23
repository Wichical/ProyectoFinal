package com.mycompany.proyectofinal;

import javax.swing.JOptionPane;

public class login {

    private static Usuarios[] usuarios = {
        new Usuarios("admin", "1234"),
        new Usuarios("cajero", "abcd")
    };

    public static boolean iniciarSesion() {

        String usuario = JOptionPane.showInputDialog("Usuario");

        String clave = JOptionPane.showInputDialog("Contraseña");

        for (Usuarios u : usuarios) {

            if (u.getUsuario().equals(usuario)
                    && u.getContraseña().equals(clave)) {

                JOptionPane.showMessageDialog(null,
                        "Bienvenido " + usuario);

                return true;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Usuario o contraseña incorrectos.");

        return false;
    }
}
