package dev.yojanpardo.colasypilas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Dada una lista de carpetas, devuelva las carpetas después de eliminar todas las subcarpetas de esas carpetas.
 * Puede devolver la respuesta en cualquier orden.
 * <p>
 * Si una carpeta[i] se encuentra dentro de otra carpeta[j], se denomina subcarpeta de ésta.
 * <p>
 * El formato de una ruta es una o varias cadenas concatenadas de la forma ‘/’ seguida de una o varias letras inglesas
 * minúsculas.
 * <p>
 * Por ejemplo, “/carpeta1” y “/carpeta1/problemas” son rutas válidas, mientras que una cadena vacía y “/” no lo son.
 */
public class RemoverSubCarpetas {

    final static String[] carpetas = {"/a", "/a/b", "/a/b/c", "/e", "/e/d"};

    public static void main(String[] args) {

        final List<String> carpetasRaiz = encontrarCarpetasRaiz(carpetas);

        carpetasRaiz.forEach(System.out::println);
    }

    private static List<String> encontrarCarpetasRaiz(String[] carpetas) {
        final Stack<String> carpetasRaiz = new Stack<>();

        Arrays.sort(carpetas);

        for(String carpeta : carpetas){
            if (carpetasRaiz.isEmpty() || !carpeta.startsWith(carpetasRaiz.peek() + '/')){
                carpetasRaiz.push(carpeta);
            }
        }

        return new ArrayList<>(carpetasRaiz);
    }
}
