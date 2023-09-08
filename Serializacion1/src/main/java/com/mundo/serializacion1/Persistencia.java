package com.mundo.serializacion1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.servlet.ServletContext;

public class Persistencia {
    
     /**
     * Lee datos serializados de la lista de discos recomendados desde un archivo.
     *
     * @param misRecomendados ArrayList de objetos Video donde se almacenarán los discos recomendados.
     * @param context El contexto ServletContext para obtener la ruta del archivo.
     * @throws FileNotFoundException Si no se encuentra el archivo de datos.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     * @throws ClassNotFoundException Si no se encuentra la clase Video al deserializar.
     */
    public static void leerRecomendados(ArrayList<Video> misRecomendados, ServletContext context) throws FileNotFoundException, IOException, ClassNotFoundException {

        // Ruta relativa y absoluta del archivo de datos serializados
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
        } catch(IOException e) {
            System.out.println("Error al leer el archivo de datos.");
        }
    }
             
    
     /**
     * Escribe datos serializados de la lista de videos en un archivo.
     *
     * @param misVideos ArrayList de objetos Video que se van a escribir en el archivo.
     * @param context El contexto ServletContext para obtener la ruta del archivo.
     * @throws FileNotFoundException Si no se encuentra el archivo de datos.
     * @throws IOException Si ocurre un error durante la escritura en el archivo.
     */
    public static void escribirArchivo(ArrayList<Video> misVideos, ServletContext context) throws FileNotFoundException, IOException {
        // Ruta relativa y absoluta del archivo de datos serializados
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
    
    
     /**
     * Lee datos serializados desde un archivo y los agrega a la lista de videos.
     *
     * @param misVideos ArrayList de objetos Video donde se agregarán los datos leídos.
     * @param context El contexto ServletContext para obtener la ruta del archivo.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     * @throws ClassNotFoundException Si la clase del objeto leído no se encuentra.
     */
    public static void leerArchivo(ArrayList<Video> misVideos, ServletContext context) throws IOException, ClassNotFoundException {
        // Ruta relativa y absoluta del archivo de datos serializados
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
        } catch(IOException e) {
            System.out.println("Error al leer el archivo de datos.");
        }
    }
}
 

