package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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

        Scanner sc = new Scanner(System.in);
        boolean repeat = true;

        while (repeat){
            repeat = userUI(sc);
        }

        sc.close();
    }

    public static boolean userUI(Scanner sc){
        int userSelection = 0;
        boolean posibleOption = true;
        boolean repetir = true;

        String message = (new StringBuilder("\n--------------------------------------------------\n")
                .append("Welcome to the video club. What do you want to do?\n")
                .append("1. Show all films.\n")
                .append("2. Look for a film.\n")
                .append("3. Look for films in a category.\n"))
                .append("4. Add a new film\n")
                .append("5. Close the program.\n")
                .toString();

        do{
            posibleOption = true;

            userSelection = readInt(sc, message, "Please type a number.");

            if(userSelection > 5 || userSelection < 1){
                posibleOption = false;
                System.out.println("Please just type a number between the available options");
            }
        }while(!posibleOption);

        if (userSelection == 5){ // 5. Close the program
            repetir = false;
        } else if(userSelection == 1){ // 1. Show all films.
            mostrarPeliculas();
        }else if(userSelection == 2){ // 2. Look for a film.
            String nombre = readString(sc, "Type the film name:", "Please enter a valid text.");

            List<Pelicula> resultado = filtrarPorNombre(peliculas, nombre);
        }else if(userSelection == 3){ // 3. Look for films in a category.
            List<Pelicula> pelisFiltradas = filtrarPorCategoria(readString(sc, "What's the category you want to look for?", "There is some issue with what you have typed, please try again"));
            if(pelisFiltradas.isEmpty()){
                System.out.println("There is no films about this category");
            } else{
                pelisFiltradas.forEach(peli -> {
                    System.out.println("Título: " + peli.name);
                    System.out.println("Rate: " + peli.rate);
                    System.out.println("Categoría: " + peli.category);
                    System.out.println("Descripción: " + peli.description);
                    System.out.println("-------------------------------");
                });
            }
        }else if(userSelection == 4){ // 4. Add a new film
            peliculas.add(new Pelicula(
                    readString(sc, "What's the name of the film?", "An error has happened please try again"),
                    readDouble(sc, "What's the score of the film?", "Must be a number with decimals for example 6.7"),
                    readString(sc, "What category is in?", "Must be a String"),
                    readString(sc, "What's the description of this film?", "Must be a String")
            ));
        }
        return repetir;
    }

    public static int readInt(Scanner sc, String message, String errorMessage){
        int readedNumber = 0;
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try{
                System.out.println(message);
                readedNumber = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        }while (repeatQuestion);

        return readedNumber;
    }

    public static double readDouble(Scanner sc, String message, String errorMessage){
        double readedNumber = 0;
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try{
                System.out.println(message);
                readedNumber = sc.nextDouble();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        }while (repeatQuestion);

        return readedNumber;
    }

    public static String readString(Scanner sc, String message, String errorMessage){
        StringBuilder readedText = new StringBuilder();
        boolean repeatQuestion = false;

        do {
            repeatQuestion = false;
            try{
                readedText.setLength(0);
                System.out.println(message);
                readedText.append(sc.nextLine());
                //sc.nextLine();
            } catch (InputMismatchException e) {
                //sc.nextLine();
                repeatQuestion = true;
                System.out.println(errorMessage);
            }
        }while (repeatQuestion);

        return readedText.toString();
    }

    public static List<Pelicula> filtrarPorRate(double rate) {
        List<Pelicula> resultado = new ArrayList<>();

        for (Pelicula p : peliculas) {
            if (p.rate >= rate) {   // ACCESO DIRECTO AL ATRIBUTO
                resultado.add(p);
            }
        }

        return resultado;
    }

    public static List<Pelicula> filtrarPorNombre(List<Pelicula> pelis, String nombreBuscado) {
        List<Pelicula> resultado = new ArrayList<>();
        boolean encontrada = false;

        for (Pelicula p : pelis) {
            // Usamos equalsIgnoreCase para ignorar mayúsculas/minúsculas
            if (p.name.equalsIgnoreCase(nombreBuscado)) {
                System.out.println("------------");
                System.out.println("Título: " + p.name);
                System.out.println("Rate: " + p.rate);
                System.out.println("Categoría: " + p.category);
                System.out.println("Descripción: " + p.description);

                encontrada = true;
                resultado.add(new Pelicula(p.name, p.rate, p.category, p.description));
            }
        }

        if (!encontrada) {
            System.out.println("No films found with that name.");
        }

        return resultado;
    }

    public static List<Pelicula> filtrarPorCategoria(String categoriaBuscada) {

        List<Pelicula> resultado = new ArrayList<>();

        for (Pelicula p : peliculas) {
            // equalsIgnoreCase → ignora mayúsculas/minúsculas
            if (p.category.equalsIgnoreCase(categoriaBuscada)) {
                resultado.add(p);
            }
        }

        return resultado;
    }

    public static void mostrarPeliculas() {
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