package com.mycompany.proyectofinal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class ProyectoFinal {

    public static void main(String[] args) {

        // Mostrar fecha y hora de inicio del sistema
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("Sistema iniciado: " + ahora.format(formato));

        // Login
        if (Login.iniciarSesion()) {

            // Si existe un método para cargar la configuración
            // Configuracion.cargarConfiguracion();

            // Inicia el menú principal
            MenuSistema.menu();

        } else {

            JOptionPane.showMessageDialog(null,
                    "No fue posible ingresar al sistema.");

        }

    }

}
