/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class Ej1 {

    public static void main(String[] args) {
        //Recoge el numero de palaras a introducir
        int numeroPalabras = Ej1.leerNumero();
        
        //Creamos la array palabras con el tamaño antes especificado
        String[] palabras = Ej1.generarArray(numeroPalabras);
        //Mostrar el array
        mostrarArray(palabras);

        // Crear Array con palabras > 3 vocales
        String[] arrayTres = generarArrayTresVocales(palabras);
        mostrarArray(arrayTres);

        //Crear Array para las palarbas con <3 vocales
        String[] arrayDos = generarArrayDosVocales(palabras);
        mostrarArray(arrayDos);
        
        //Usamos el metodo para crear una array de enteros que recoja 
        //la posicion de una determinada letra
        int[] arrayNumerosEntero = arrayEnteros(palabras, 'e');
        
        //Mostramos
        mostrarArrayEnteros(arrayNumerosEntero);
    }

    //Metodo para leer el número de palabras
    public static int leerNumero() {

        int tamaño = 0;
        try { //Controlamos la excepcion
            tamaño = Integer.parseInt(JOptionPane.showInputDialog(
                    "¿Cúantas palabras deseas introducir?"));
        } catch (NumberFormatException nfe) {
            System.out.println("Numero introducido erroneo");
        }
        return tamaño; //Devolvemos un numero
    }

    //Método para crear la array y rellenarla
    public static String[] generarArray(int tamaño) {

        String[] palabras = new String[tamaño];

        for (int i = 0; i < tamaño; i++) {
            palabras[i] = JOptionPane.showInputDialog("Escriba una palabra");
        }

        return palabras;
    }

    //Método para mostrar la array
    public static void mostrarArray(String[] array) {
        StringBuilder texto = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            texto.append("La posicion es " + i + "- La palabra " + array[i] + "\n");
        }

        JOptionPane.showMessageDialog(null, texto);
    }

    // Contar vocales de palabras
    public static int contadorPalabras(String palabra) {
        int contador = 0;
        for (int x = 0; x < palabra.length(); x++) {
            if ((palabra.charAt(x) == 'a')
                    || (palabra.charAt(x) == 'e')
                    || (palabra.charAt(x) == 'i')
                    || (palabra.charAt(x) == 'o')
                    || (palabra.charAt(x) == 'u')) {
                contador++;
            }

        }
        return contador;
    }

    //Método que de una array devuelva otra solo con las que tiene 3 vocales o más
    public static String[] generarArrayTresVocales(String[] original) {

        //Vamos a contar el numero de palabras que hay con mas de 3 vocales
        int contador = 0;
        for (int i = 0; i < original.length; i++) {
            if (contadorPalabras(original[i]) >= 3) {
                contador++;
            }
        }

        String[] arrayTresVocales = new String[contador];

        int posicion = 0;
        for (int i = 0; i < original.length; i++) {
            if (contadorPalabras(original[i]) >= 3) {
                arrayTresVocales[posicion++] = original[i];

            }
        }

        return arrayTresVocales;
    }

    //Metodo que devuelve otro array pero con los que tienen menos de 2
    public static String[] generarArrayDosVocales(String[] original) {

        //Vamos a contar el numero de palabras que hay con mas de 3 vocales
        int contador = 0;
        for (int i = 0; i < original.length; i++) {
            if (contadorPalabras(original[i]) < 3) {
                contador++;
            }
        }

        String[] arrayDosVocales = new String[contador];

        int posicion = 0;
        for (int i = 0; i < original.length; i++) {
            if (contadorPalabras(original[i]) < 3) {
                arrayDosVocales[posicion++] = original[i];

            }
        }

        return arrayDosVocales;
    }

    // EJERCICIO 2 
    public static int[] arrayEnteros(String[] original, char letra) {
        int[] arrayEnteros = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            //Busca la letra y devuelve la posicion
            int posicion = original[i].indexOf(letra);
            //La guardamos dentro del campo de la array
            arrayEnteros[i] = posicion;
        }

        return arrayEnteros;
    }

    //Metodo para mostar el Array de enteros
    public static void mostrarArrayEnteros(int[] array) {
        StringBuilder texto = new StringBuilder();
        
        for (int i = 0; i < array.length; i++) {
            texto.append("En la posicion " + i + " la palabra contiene la letra"
                    + " en la posicion " + array[i] +"\n");
        }
        JOptionPane.showMessageDialog(null, texto);
    }

}
