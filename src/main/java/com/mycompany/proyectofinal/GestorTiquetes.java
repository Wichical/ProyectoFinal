/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;
import javax.swing.JOptionPane;
/**
 *
 * @author Santiago
 */
public class GestorTiquetes {

    public static void crearTiquete() {

        String nombre;
        String id;
        int edad;
        String tramite;
        char tipo;

        do {

            nombre = JOptionPane.showInputDialog("Nombre");

        } while (nombre.trim().isEmpty());

        do {

            id = JOptionPane.showInputDialog("Identificación");

        } while (id.trim().isEmpty());

        edad = Integer.parseInt(
                JOptionPane.showInputDialog("Edad"));

        tramite = JOptionPane.showInputDialog("Trámite");

        String opciones[] = {
            "Preferencial",
            "Un trámite",
            "Dos o más trámites"
        };

        int op = JOptionPane.showOptionDialog(
                null,
                "Seleccione el tipo",
                "Tipo de cliente",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        switch (op) {

            case 0:
                tipo = 'P';
                break;

            case 1:
                tipo = 'A';
                break;

            default:
                tipo = 'B';

        }

        Tiquete t = new Tiquete(
                nombre,
                id,
                edad,
                tramite,
                tipo);

        int personas = MenuSistema.sistema.crearTiquete(t);

        if (personas == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Tiquete creado correctamente\n\n"
                    + "Caja asignada: "
                    + t.getCajaAsignada()
                    + "\nEs su turno.");

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Tiquete creado correctamente\n\n"
                    + "Caja asignada: "
                    + t.getCajaAsignada()
                    + "\nTiene "
                    + personas
                    + " personas delante.");

        }

    }

}
