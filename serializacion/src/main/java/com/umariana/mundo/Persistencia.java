/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umariana.mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Johan Ordoñez
 */
public class Persistencia {
    public static void escribirArchivo(ArrayList<Video> misVideos) throws FileNotFoundException {
        
        // Ubicación del archivo de datos
        File archivo = new File("C:\\Users\\Johan Ordoñez\\Desktop\\Proyecto Videos\\Discossss-main\\Discossss-main\\Laboratorio_3-master\\serializacion\\data\\discosAgregados.txt");

        try (PrintWriter pluma = new PrintWriter(archivo)) {
            // Iterar a través de la lista de alumnos y escribir sus datos en el archivo
            for (Video vid : misVideos) {
                // Formatear los datos del alumno en una línea y escribir en el archivo
                String linea = vid.getIdVideo() + "," + vid.getTitulo() + ","
                              + vid.getAutor() + "," + vid.getAnio() + ","
                              + vid.getCategoria() + "," + vid.getUrl() + ","
                              + vid.getLetra();
                pluma.println(linea);
            }
      
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo de datos.");
        }
    }
    
    public static void leerArchivo(ArrayList<Video> misVideos) throws FileNotFoundException, IOException {
        
        
        // Ubicación del archivo de datos
        File archivo = new File("C:\\Users\\Johan Ordoñez\\Desktop\\Proyecto Videos\\Discossss-main\\Discossss-main\\Laboratorio_3-master\\serializacion\\data\\discosAgregados.txt");

        
        try (FileReader fr = new FileReader(archivo);
             BufferedReader lector = new BufferedReader(fr)) {

            String linea;
            // Leer cada línea del archivo y procesar los datos
      
               while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                
                String idVideo = datos[0].trim();
                String titulo = datos[1].trim();
                String autor = datos[2].trim();
                String anio = datos[3].trim();
                String categoria = datos[4].trim();
                String url = datos[5].trim();
                String letra = datos[6].trim();

                // Crear un objeto Alumno con los datos leídos y agregarlo a la lista
                Video video = new Video(Integer.parseInt(idVideo), titulo, autor, anio, categoria, url, letra);
                misVideos.add(video);
            }
      
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo de datos.");
        } catch (IOException e) {
            System.out.println("Error durante la lectura del archivo.");
        }

    }
}
