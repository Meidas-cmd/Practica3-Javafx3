package org.example.demo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        actividad5();

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

    public static void actividad5(){

        System.out.println("Dame la ruta de la carpeta que quieras ver los archivos: ");
        String ruta = entrada.nextLine();



        File carpeta = new File(ruta);
        String[] archivos = carpeta.list();

        if (archivos != null && archivos.length > 0){

            for (String a : archivos){

                System.out.println(a);

            }

        }else {
            System.out.println("No hay archivos");
        }

    }

    public static  void actividad6(){

        int cont = 0;
        System.out.println("Que palabra quieres buscar:");
        String pal = entrada.nextLine();

        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/resources/actividad6.txt"));
            String linea;

            while ((linea = lector.readLine()) != null){
                String[] palabras = linea.split(" ");
                for (String p : palabras){
                    if (pal.equalsIgnoreCase(p)){

                        cont++;
                    }
                }
            }
            lector.close();
        }catch (IOException e){

            System.out.println(e.getMessage());

            throw  new RuntimeException(e);

        }

        System.out.println("La palabra " + pal + " aparece " + cont + " veces.");




    }

    public static void actividad7(){

        int cont = 0;
        System.out.println("Que palabra quieres buscar:");
        String pal = entrada.nextLine();

        try {
            File archivo = new File("src/resources/actividad6.txt");
            Scanner lector = new Scanner(archivo);

            while (lector.hasNextLine()){
                String linea = lector.nextLine();
                String[] partes = linea.split(" ");
                for (int i = 0; i < partes.length; i++) {
                    if (pal.equalsIgnoreCase(partes[i])){
                        cont++;
                    }
                }
            }
            lector.close();
        }catch (IOException e){

            System.out.println(e.getMessage());

            throw  new RuntimeException(e);

        }

        System.out.println("La palabra " + pal + " aparece " + cont + " veces.");




    }
    }
