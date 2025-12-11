package org.example;

public class Pelicula {
    String name;
    String description;
    double rate;

    public Pelicula(String name, double rate, String description){
        this.name = name;
        this.rate = rate;
        this.description = description;
    }

    @Override
    public String toString(){
        return "";
    }
}
