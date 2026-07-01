package com.mycompany.proyectofinal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
/**
 *
 * @author Wichical
 */
public class ProyectoFinal {

    public static void main(String[] args) {
        // Fecha actual
        LocalDateTime ahora = LocalDateTime.now();
        
        // Fecha de referencia (ejemplo: hace 2 horas)
        LocalDateTime fechaReferencia = ahora.minusHours(2);

        // Comparación
        if (ahora.isAfter(fechaReferencia)) {
            System.out.println("La fecha actual es más reciente que la referencia.");
        }

        // Formateo para mostrar al usuario
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Fecha actual: " + ahora.format(formato));
    
    
}
}

