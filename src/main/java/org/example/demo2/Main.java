package org.example.demo2;

import java.io.*;
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        actividad10();

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

    public static void actividad8(){

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
                File archivo = new File(directorio + "/"+nombre+"("+i+")"+".txt");

                if (archivo.createNewFile())  System.out.println("Archivo creado");
                else  System.out.println("El archivo ya existe");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileWriter archivo = new FileWriter(directorio + "/"+nombre+"("+i+")"+".txt");
                BufferedWriter mensaje = new BufferedWriter(archivo);
                mensaje.write("Este es el fichero " + nombre+"("+i+")"+".txt");
                mensaje.close();
            }catch (IOException e){
                System.out.println("Ha habido algun problema");
                e.printStackTrace();
            }
        }



    }
    public static void actividad9() {

        try {
            File archivoOriginal = new File("src/main/resources/actividad9.txt");
            File archivoTemporal = new File("src/main/resources/actividad9Temp.txt");

            BufferedReader lector = new BufferedReader(new FileReader(archivoOriginal));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String lineaActual;
            while ((lineaActual = lector.readLine()) != null) {
                String[] palabras = lineaActual.split(" ");

                for (int i = 0; i < palabras.length; i++) {
                    if (!palabras[i].isEmpty()) {
                        String primeraLetra = String.valueOf(Character.toUpperCase(palabras[i].charAt(0)));
                        String restoDeLaPalabra = palabras[i].substring(1).toLowerCase();
                        palabras[i] = primeraLetra + restoDeLaPalabra;
                    }

                    escritor.write(palabras[i]);

                    if (i < palabras.length - 1) {
                        escritor.write(" ");
                    }
                }
                escritor.newLine();
            }

            lector.close();
            escritor.close();

            if (archivoOriginal.delete()) {
                archivoTemporal.renameTo(archivoOriginal);
                System.out.println("Archivo modificado correctamente.");
            } else {
                System.out.println("No se ha podido reemplazar el archivo original.");
            }

        } catch (IOException error) {
            System.out.println("Ocurrió un error al procesar el archivo: " + error.getMessage());
            throw new RuntimeException(error);
        }
    }

    public static void actividad10() {

        try {
            File primerArchivo = new File("src/main/resources/actividad10a.txt");
            File segundoArchivo = new File("src/main/resources/actividad10b.txt");
            File archivoCombinado = new File("src/main/resources/actividad10Final.txt");

            Scanner lec1 = new Scanner(primerArchivo);
            Scanner lec2 = new Scanner(segundoArchivo);
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoCombinado));

            while (lec1.hasNext() && lec2.hasNext()) {
                escritor.write(lec1.next() + " ");
                escritor.write(lec2.next() + " ");
            }

            while (lec1.hasNext()) {
                escritor.write(lec1.next() + " ");
            }

            while (lec2.hasNext()) {
                escritor.write(lec2.next() + " ");
            }

            lec1.close();
            lec2.close();
            escritor.close();

            System.out.println("Archivo combinado  correctamente.");

        } catch (IOException error) {
            System.out.println(error.getMessage());
            throw new RuntimeException(error);
        }
    }
    }
