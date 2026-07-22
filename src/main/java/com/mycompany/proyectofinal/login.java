package com.mycompany.proyectofinal;

import javax.swing.JOptionPane;

public class Login {

    public static boolean iniciarSesion() {

        String usuario = JOptionPane.showInputDialog("Usuario");

        String clave = JOptionPane.showInputDialog("Contraseña");

        if ((usuario.equals("admin") && clave.equals("1234"))
                || (usuario.equals("cajero") && clave.equals("abcd"))) {

            JOptionPane.showMessageDialog(null,
                    "Bienvenido " + usuario);

            return true;

        }

        JOptionPane.showMessageDialog(null,
                "Usuario o contraseña incorrectos.");

        return false;

    }

}
