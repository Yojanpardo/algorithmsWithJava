package dev.yojanpardo.colasypilas;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Dada una cadena que representa una ruta absoluta, es decir que representa la ruta de archivo o directorio en un sistema de archivos estilo Unix (comienza con un slash ‘/’), conviértala en la ruta canónica simplificada.
 * <p>
 * En un sistema de archivos de estilo Unix, un punto ‘.’ se refiere al directorio actual, un doble punto ‘…’ se refiere al directorio de un nivel superior, y cualquier barra múltiple consecutiva (es decir, ‘//’) se trata como una sola barra ‘/’. Para este problema, cualquier otro formato de puntos como ‘…’ se tratan como nombres de archivo/directorio.
 * <p>
 * La ruta canónica debe tener el siguiente formato:
 * La ruta comienza con una sola barra ‘/’.
 * Dos directorios cualesquiera se separan con una sola barra ‘/’.
 * La ruta no termina con un “/” al final.
 * La ruta sólo contiene los directorios de la ruta desde el directorio raíz hasta el archivo o directorio de destino (es decir, sin punto ‘.’ o doble punto ‘…’)
 * Devuelve la ruta canónica simplificada.
 */
public class SimplificarRutas {

    public static void main(String[] args) {
        final String ruta = "/../Users/yojan/../documents";
        System.out.printf("Optimized path for [%s] is: [%s]", ruta, optimizePath(ruta));
    }

    private static String optimizePath(String ruta) {
        final Stack<String> optimizedRoute = new Stack<>();
        final String[] chunks = ruta.split("/");

        optimizedRoute.push("");

        for(String chunk : chunks){
            if(chunk.equals("..") && !optimizedRoute.peek().isEmpty()){
                optimizedRoute.pop();
                continue;
            }
            if(!chunk.equals("..") && !chunk.equals(".") && !chunk.equals("")){
                optimizedRoute.push(chunk);
            }
        }

        return optimizedRoute.stream()
                .reduce((acc, e) -> acc + "/" + e)
                .orElse("");
    }
}
