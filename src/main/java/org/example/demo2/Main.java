package org.example.demo2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        actividad4();

    }

    public static void actividad1(){
        File archivo = new File("src/main/resources/prueba.txt");

        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo " + archivo.getName() + " ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ha habido algún problema.");
            e.printStackTrace();
        }


    }

    public static void actividad2(){
        File fichero = new File("src/main/resources/ejemplo1.txt");
        if(fichero.exists()) System.out.println("El fichero " + fichero.getName() + " existe");
        else System.out.println("El fichero " + fichero.getName() + " no existe");
        System.out.println("Nombre: " + fichero.getName());
        System.out.println("Longitud: " + fichero.length());
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());

        File carpeta = new File("src/main/resources");
        if(carpeta.exists()) System.out.println("La carpeta " + carpeta.getName() + " existe");
        else System.out.println("La carpeta " + carpeta.getName() + " no existe");
        System.out.println("Nombre: " + carpeta.getName());
        System.out.println("Longitud: " + carpeta.length());
        System.out.println("Ruta absoluta: " + carpeta.getAbsolutePath());
    }


    public static void actividad4 (){

        System.out.print("En que carpeta quieres crear el archivo:");
        File directorio = new File(entrada.next());
        if (directorio.mkdir())  System.out.println("Directorio creado");
        else  System.out.println("No se pudo crear el directorio");

        System.out.print("Cuantos archivos quieres crear:");
        int cantidad = entrada.nextInt();

        System.out.println("Como se va a llamar el archivo");
        String nombre = entrada.next();

        for(int i = 0; i < cantidad; i++){
            try {
                File archivo = new File(directorio.toString() + "/"+nombre+"("+i+")"+".txt");
                if (archivo.createNewFile())  System.out.println("Archivo creado");
                else  System.out.println("El archivo ya existe");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    }
