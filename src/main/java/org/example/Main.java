package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Pelicula> peliculas = new ArrayList<>();

    public static void main(String[] args) {
        peliculas.add(new Pelicula("El Señor de los Anillos: La Comunidad del Anillo", 9.0,"Accion", "Un grupo de héroes se embarca en una misión para destruir un anillo maligno."));
        peliculas.add(new Pelicula("Inception", 8.8,"Ciencia ficción","Un ladrón especializado en entrar en los sueños intenta realizar el golpe definitivo."));
        peliculas.add(new Pelicula("Interstellar", 8.6,"Ciencia ficción","Exploradores viajan a través de un agujero de gusano en busca de un nuevo hogar para la humanidad."));
        peliculas.add(new Pelicula("The Dark Knight", 9.0,"Superheroes","Batman enfrenta su mayor desafío cuando surge el caótico Joker."));
        peliculas.add(new Pelicula("Pulp Fiction", 8.9,"Accion","Historias entrelazadas de crimen, humor negro y personajes memorables en Los Ángeles."));
        peliculas.add(new Pelicula("Forrest Gump", 8.8,"Drama","Un hombre con gran corazón presencia momentos clave de la historia estadounidense."));
        peliculas.add(new Pelicula("Matrix", 8.7,"Accion","Un hacker descubre la verdadera naturaleza de la realidad y se une a la rebelión."));
        peliculas.add(new Pelicula("Gladiator", 8.5,"Acción","Un general romano traicionado busca venganza convertiéndose en gladiador."));
        peliculas.add(new Pelicula("La La Land", 8.0,"Musical","Un músico y una actriz luchan por sus sueños en Los Ángeles."));
        peliculas.add(new Pelicula("Parasite", 8.6,"Drama","Una familia pobre se infiltra astutamente en la vida de una familia rica."));
        peliculas.add(new Pelicula("Toy Story", 8.3,"Infantil","Los juguetes de un niño cobran vida cuando no está cerca."));
        peliculas.add(new Pelicula("Coco", 8.4,"Drama","Un niño viaja al Mundo de los Muertos para descubrir el verdadero significado de la familia."));
        peliculas.add(new Pelicula("Jurassic Park", 8.1,"Accion","Un parque temático con dinosaurios clonados se convierte en un caos."));
        peliculas.add(new Pelicula("Titanic", 7.9,"Drama", "Una historia de amor florece a bordo del famoso barco condenado."));
        peliculas.add(new Pelicula("The Avengers", 8.0,"Superheroes","Un grupo de héroes debe unirse para salvar al mundo de una amenaza alienígena."));


    }

    public List<Pelicula> filtrarPorRate(double rate) {
        List<Pelicula> resultado = new ArrayList<>();

        for (Pelicula p : peliculas) {
            if (p.rate >= rate) {   // ACCESO DIRECTO AL ATRIBUTO
                resultado.add(p);
            }
        }

        return resultado;
    }

    public List<Pelicula> filtrarPorNombre(List<Pelicula> pelis, String nombreBuscado) {

        List<Pelicula> resultado = new ArrayList<>();

        for (Pelicula p : pelis) {
            // Usamos equalsIgnoreCase para ignorar mayúsculas/minúsculas
            if (p.name.equalsIgnoreCase(nombreBuscado)) {
                resultado.add(p);
            }
        }

        return resultado;
    }

    public List<Pelicula> filtrarPorCategoria(String categoriaBuscada) {

        List<Pelicula> resultado = new ArrayList<>();

        for (Pelicula p : peliculas) {
            // equalsIgnoreCase → ignora mayúsculas/minúsculas
            if (p.category.equalsIgnoreCase(categoriaBuscada)) {
                resultado.add(p);
            }
        }

        return resultado;
    }

    public void mostrarPeliculas() {
        System.out.println("\n===== LISTA DE PELÍCULAS =====");

        for (Pelicula p : peliculas) {
            System.out.println("Título: " + p.name);
            System.out.println("Rate: " + p.rate);
            System.out.println("Categoría: " + p.category);
            System.out.println("Descripción: " + p.description);
            System.out.println("-------------------------------");
        }
    }

}