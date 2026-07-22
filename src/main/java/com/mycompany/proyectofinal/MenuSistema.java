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

        String[] opciones = {"Configurar Banco","Crear Tiquete", "Tiquere Atendido", "Gestionar Cajas" , "Ver Reportes", "Salir"};
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
                case 2: 

                    int caja = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    "Número de caja"));

                    Tiquete atendido = sistema.atenderTiquete(caja);

                    if (atendido == null) {

                        JOptionPane.showMessageDialog(
                                null,
                                "No hay clientes en esa caja.");

                    } else {

                        String mensaje
                                = "Cliente atendido\n\n"
                                + atendido.getNombre()
                                + "\nHora: "
                                + atendido.getHoraAtencion();

                        Tiquete siguiente
                                = sistema.tiqueteSiguiente(caja);

                        if (siguiente != null) {

                            mensaje += "\n\nSiguiente cliente:\n"
                                    + siguiente.getNombre();

                        }else{
                            mensaje += "\nNo quedan clientes.";
                        }

                        JOptionPane.showMessageDialog(null,mensaje);

                    }
                    break;
                case 3:  /* Gestionar cajas */ break;
                case 4:  /* Lógica de reportes */ break;
            }
        } while (eleccion != 5 && eleccion != -1);
    }

    private static boolean autenticarUsuario() {
        String usuario = JOptionPane.showInputDialog("Usuario:");
        String password = JOptionPane.showInputDialog("Contraseña:");
        // Lógica simple de validación
        return (usuario.equals("admin") && password.equals("1234"));
    }
}