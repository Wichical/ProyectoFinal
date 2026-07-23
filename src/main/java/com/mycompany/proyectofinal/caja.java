package com.mycompany.proyectofinal;

public class caja {

    private int numero;
    private Cola cola;

    public Caja(int numero) {
        this.numero = numero;
        this.cola = new Cola();
    }

    public int getNumero() {
        return numero;
    }

    public Cola getCola() {
        return cola;
    }

}
