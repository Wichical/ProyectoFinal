/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;
import java.time.LocalDateTime;

/**
 *
 * @author Santiago
 */
public class Tiquete {

    private String nombre;
    private String id;
    private int edad;
    private String tramite;
    private char tipo;

    private LocalDateTime horaCreacion;
    private LocalDateTime horaAtencion;

    public Tiquete(String nombre, String id, int edad,
                   String tramite, char tipo) {

        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.tramite = tramite;
        this.tipo = tipo;

        horaCreacion = LocalDateTime.now();
        horaAtencion = null;
    }

    public String getNombre() {
        return nombre;
    }

    public char getTipo() {
        return tipo;
    }

    public LocalDateTime getHoraCreacion() {
        return horaCreacion;
    }

    public LocalDateTime getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(LocalDateTime horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    @Override
    public String toString() {
        return nombre + " - " + tramite + " (" + tipo + ")";
    }
}
