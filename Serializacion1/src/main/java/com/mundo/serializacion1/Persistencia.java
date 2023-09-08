/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mundo.serializacion1;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.servlet.ServletContext;

/**
 *
 * @author Johan Ordoñez
 */
public class Persistencia {
    
        // Ubicación del archivo de datos"
        public static void leerRecomendados(ArrayList<Video> misRecomendados, ServletContext context) throws FileNotFoundException, IOException, ClassNotFoundException {

        String rutaRelativa = "/data/discosRecomendados.ser";
        String rutaAbsoluta = context.getRealPath(rutaRelativa);
        File archivo = new File(rutaAbsoluta);

            try (FileInputStream fis = new FileInputStream(archivo);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
                // Limpiar la lista actual antes de agregar nuevos elementos
                misRecomendados.clear();
                while (true) {
                    try {
                        // Leer un objeto Video del archivo
                        Video video = (Video) ois.readObject();

                        // Agregar el objeto Video a la lista
                        misRecomendados.add(video);
                    } catch (EOFException e) {
                        // Se alcanzó el final del archivo
                        break;
                    }     
                }
            }catch(IOException e){
                System.out.println("Error al leer el archivo de datos.");
            }
    }
             
 public static void escribirArchivo(ArrayList<Video> misVideos, ServletContext context) throws FileNotFoundException, IOException {
    // Ubicación del archivo de datos serializados
    String rutaRelativa = "/data/discosAgregados.ser";
    String rutaAbsoluta = context.getRealPath(rutaRelativa);
    File archivo = new File(rutaAbsoluta);

    try (FileOutputStream fos = new FileOutputStream(archivo);
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
        // Serializar y escribir cada objeto Video en el archivo
        for (Video vid : misVideos) {
                oos.writeObject(vid);
            }           
    } catch (IOException e) {
        System.out.println("Error al escribir el archivo de datos.");
    }
 }
    
    
    public static void leerArchivo(ArrayList<Video> misVideos, ServletContext context) throws IOException, ClassNotFoundException {
    
        String rutaRelativa = "/data/discosAgregados.ser";
        String rutaAbsoluta = context.getRealPath(rutaRelativa);
        File archivo = new File(rutaAbsoluta);

            try (FileInputStream fis = new FileInputStream(archivo);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
                // Limpiar la lista actual antes de agregar nuevos elementos
                misVideos.clear();

                while (true) {
                    try {
                        // Leer un objeto Video del archivo
                        Video video = (Video) ois.readObject();

                        // Agregar el objeto Video a la lista
                        misVideos.add(video);
                    } catch (EOFException e) {
                        // Se alcanzó el final del archivo
                        break;
                    }
               
                }
            }catch(IOException e){
                System.out.println("Error al leer el archivo de datos.");
            }
    }
   
}
    

