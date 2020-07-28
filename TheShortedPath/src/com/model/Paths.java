package com.model;

public class Paths {
    private final int idCity;
    private final String city;
    private final int idNeighbour;
    private final int cost;

    public Paths(int idCity, String city, int idNeighbour, int cost) {
        this.idCity = idCity;
        this.city = city;
        this.idNeighbour = idNeighbour;
        this.cost = cost;
    }

    public int getIdCity() {
        return idCity;
    }

    public String getCity() {
        return city;
    }

    public int getIdNeighbour() {
        return idNeighbour;
    }

    public int getCost() {
        return cost;
    }
}
