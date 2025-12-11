package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pelicula> peliculas = new ArrayList<>();
        Pelicula peli1 = new Pelicula("Avatar", 7.7, "");

        peliculas.add(new Pelicula("loque sea", 6.6, ""));
    }

    public List<Pelicula> filtrarPorRate(List<Pelicula> pelis, double rate) {
        List<Pelicula> resultado = new ArrayList<>();

        for (Pelicula p : pelis) {
            if (p.rate >= rate) {   // ACCESO DIRECTO AL ATRIBUTO
                resultado.add(p);
            }
        }

        return resultado;
    }


}