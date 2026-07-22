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
public class SistemaTiquetes {

    private Cola preferencial;
    private Cola rapida;
    private Cola normal;

    public SistemaTiquetes() {

        preferencial = new Cola();
        rapida = new Cola();
        normal = new Cola();
    }

    public int crearTiquete(Tiquete t) {

        int personas;

        switch (t.getTipo()) {

            case 'P':

                personas = preferencial.getTamaño();

                t.setCajaAsignada(Configuracion.cajaPreferencial);

                preferencial.encolar(t);

                return personas;

            case 'A':

                personas = rapida.getTamaño();

                t.setCajaAsignada(Configuracion.cajaRapida);

                rapida.encolar(t);

                return personas;

            default:

                personas = normal.getTamaño();

                t.setCajaAsignada(1);

                normal.encolar(t);

                return personas;

        }

    }
    
    public Tiquete atenderTiquete(int caja){
        Tiquete tiqueteAtendido = null;
        
        if (caja == Configuracion.cajaPreferencial){
            tiqueteAtendido = preferencial.desencolar();
        }else if (caja == Configuracion.cajaRapida){
            tiqueteAtendido = rapida.desencolar();
        }else{
            tiqueteAtendido = normal.desencolar();
        }
        if (tiqueteAtendido != null){
            tiqueteAtendido.setHoraAtencion(LocalDateTime.now());
        }
        return tiqueteAtendido;
    }

    public Tiquete tiqueteSiguiente(int caja){
        if (caja == Configuracion.cajaPreferencial){
            return preferencial.primero();
        }else if (caja == Configuracion.cajaRapida){
            return rapida.primero();
        }else{
            return normal.primero();
        }
    }
}