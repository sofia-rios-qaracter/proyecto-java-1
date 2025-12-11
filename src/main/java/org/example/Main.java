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
        boolean falloLectura = false;
        boolean repetir = true;

        do{
            falloLectura = false;
            System.out.println();
            System.out.println("--------------------------------------------------");
            System.out.println("Welcome to the video club. What do you want to do?");
            System.out.println("1. Show all films.");
            System.out.println("2. Look for film.");
            System.out.println("3. Look for films in a category.");
            System.out.println("4. Add a new film.");
            System.out.println("5. Close the program.");

            try {
                userSelection = sc.nextInt();
                System.out.println("User selection: "+userSelection);
                sc.nextLine();

                if(userSelection > 5 || userSelection < 1){
                    falloLectura = true;
                    System.out.println("Please just type a number between the avaibale options");
                }
            }catch (InputMismatchException e){
                falloLectura = true;
                System.out.println("--------------------------------------------------");
                System.out.println("Please type a number.");
                sc.nextLine();
            }
        }while(falloLectura);

        if (userSelection == 5){
            repetir = false;
        }

        return repetir;
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
}