package org.example;

public class Pelicula {
    String name;
    String description;
    double rate;
    String category;

    public Pelicula(String name, double rate, String category, String description){
        this.name = name;
        this.rate = rate;
        this.category = category;
        this.description = description;
    }

    @Override
    public String toString(){
        return "";
    }
}
