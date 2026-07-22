package com.mycompany.proyectofinal;

public class Banco {

    private String nombre;
    private Caja[] cajas;
    private Caja cajaPreferencial;
    private Caja cajaRapida;

    public Banco(String nombre, int cantidadCajas) {

        this.nombre = nombre;

        cajas = new Caja[cantidadCajas];

        for (int i = 0; i < cantidadCajas; i++) {
            cajas[i] = new Caja(i + 1);
        }

        cajaPreferencial = new Caja(Configuracion.cajaPreferencial);
        cajaRapida = new Caja(Configuracion.cajaRapida);

    }

    public Caja asignarCajaNormal() {

        Caja menor = cajas[0];

        for (int i = 1; i < cajas.length; i++) {

            if (cajas[i].getCola().getTamaño() < menor.getCola().getTamaño()) {
                menor = cajas[i];
            }

        }

        return menor;

    }

    public void agregarTiquete(Tiquete t) {

        switch (t.getTipo()) {

            case 'P':

                cajaPreferencial.getCola().encolar(t);
                t.setCajaAsignada(cajaPreferencial.getNumero());
                break;

            case 'A':

                cajaRapida.getCola().encolar(t);
                t.setCajaAsignada(cajaRapida.getNumero());
                break;

            default:

                Caja caja = asignarCajaNormal();

                caja.getCola().encolar(t);

                t.setCajaAsignada(caja.getNumero());

        }

    }

    public Tiquete atenderCaja(int numeroCaja) {

        if (numeroCaja == Configuracion.cajaPreferencial)
            return cajaPreferencial.getCola().desencolar();

        if (numeroCaja == Configuracion.cajaRapida)
            return cajaRapida.getCola().desencolar();

        return cajas[numeroCaja - 1].getCola().desencolar();

    }

}
