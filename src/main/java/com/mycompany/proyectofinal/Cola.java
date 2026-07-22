/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author Santiago
 */
public class Cola {

    private Nodo frente;
    private Nodo fin;
    private int tamaño;

    public Cola() {
        frente = null;
        fin = null;
        tamaño = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(Tiquete t) {

        Nodo nuevo = new Nodo(t);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }

        tamaño++;
    }

    public Tiquete desencolar() {

        if (estaVacia())
            return null;

        Tiquete aux = frente.dato;
        frente = frente.siguiente;

        if (frente == null)
            fin = null;

        tamaño--;

        return aux;
    }

    public int getTamaño() {
        return tamaño;
    }

    public Tiquete primero() {

        if (estaVacia())
            return null;

        return frente.dato;
    }

}