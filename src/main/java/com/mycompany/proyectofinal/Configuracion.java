/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 *
 * @author nayel
 */
public class Configuracion {
    public static String nombreBanco;
    public static int cantidadCajas;
    public static int cajaPreferencial;
    public static int cajaRapida;
    
    // Comprueba si existe un archivo de configuración
    public static boolean existeConfiguracion(){
        File archivo = new File ("prod.txt");
        return archivo.exists();
    }
    // Solicita la configuración del sistema
    public static void configurarSistema(){
        nombreBanco = JOptionPane.showInputDialog("Ingrese el nombre del banco: ");
        
        do {
            cantidadCajas = Integer.parseInt(JOptionPane.showInputDialog(
            "Ingrese la cantidad de cajas (minimo 3): "));
            
            if  (cantidadCajas < 3){
                JOptionPane.showMessageDialog(null, "Tiene que ingresar minimo 3 cajas.");
            }
        } while (cantidadCajas < 3);
        do{
            cajaPreferencial = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese el número de la caja preferencial (1- " + cantidadCajas + "):"));
            if (cajaPreferencial < 1 || cajaPreferencial > cantidadCajas){
                JOptionPane.showMessageDialog(null, "Número de caja incorrecto.");
            }
        }while (cajaPreferencial < 1 || cajaPreferencial > cantidadCajas);
        do {
            cajaRapida = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese el número de las cajas de trámites rápidos (1 -" + cantidadCajas + "):"));
            if (cajaRapida < 1 || cajaRapida > cantidadCajas){
                JOptionPane.showMessageDialog(null, 
                        "Número de caja incorrecto");
            }else if ( cajaRapida == cajaPreferencial){
                JOptionPane.showMessageDialog(null, "La caja rápida no puede ser la misma que la caja preferencial");
            }
        }while (cajaRapida < 1 || cajaRapida > cantidadCajas || cajaRapida == cajaPreferencial);
    }
    
    public static void guardarConfiguracion(){
        try {
            FileWriter archivo = new FileWriter("prod.txt");
            PrintWriter salida = new  PrintWriter(archivo);
            salida.println(nombreBanco);
            salida.println(cantidadCajas);
            salida.println(cajaPreferencial);
            salida.println(cajaRapida);
            
            salida.close();
            JOptionPane.showMessageDialog(null,
                    "Se guardó la configuración correctamente");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,
                    "Error al guardar la información.");
        }
    }
    public static void cargarConfiguracion(){
        try{
            FileReader archivo = new FileReader("prod.txt");
            BufferedReader leer = new BufferedReader(archivo);
            nombreBanco = leer.readLine();
            cantidadCajas = Integer.parseInt(leer.readLine());
            cajaPreferencial = Integer.parseInt(leer.readLine());
            cajaRapida = Integer.parseInt(leer.readLine());
            
            leer.close();
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al cargar la configuración");
        }
    }
}
