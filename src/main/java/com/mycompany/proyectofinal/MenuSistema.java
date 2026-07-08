package com.mycompany.proyectofinal;

import javax.swing.JOptionPane;

/**
 *
 * @author Wichical
 */
public class MenuSistema {
    public static SistemaTiquetes sistema = new SistemaTiquetes();
    public static void main(String[] args) {
        // Simulación de login previo
        if (!autenticarUsuario()) {
            JOptionPane.showMessageDialog(null, "Acceso denegado.");
            return;
        }
        //Módulo 0: Configuración
        if (Configuracion.existeConfiguracion()){
            Configuracion.cargarConfiguracion();
        }else {
            Configuracion.configurarSistema();
            Configuracion.guardarConfiguracion();
        }

        String[] opciones = {"Configurar Banco","Crear Tiquete", "Gestionar Cajas", "Ver Reportes", "Salir"};
        int eleccion;

        do {
            eleccion = JOptionPane.showOptionDialog(null, 
                "Bienvenido al Sistema de Gestión Bancaria", 
                "Menú Principal - Empresa ABC", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, opciones, opciones[0]);

            switch (eleccion) {
                case 0: /* Lógica de configuración (escritura en prod.txt) */ 
                    JOptionPane.showMessageDialog(null, 
                            "La configuracion ya fue realizada");
                    break;
                case 1: 
                    GestorTiquetes.crearTiquete();
                    /* Lógica de gestión de cajas */ break;
                case 2: /* Lógica de reportes */ break;
            }
        } while (eleccion != 4 && eleccion != -1);
    }

    private static boolean autenticarUsuario() {
        String usuario = JOptionPane.showInputDialog("Usuario:");
        String password = JOptionPane.showInputDialog("Contraseña:");
        // Lógica simple de validación
        return (usuario.equals("admin") && password.equals("1234"));
    }
}