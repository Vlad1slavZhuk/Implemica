package com.model;

import java.util.HashMap;
import java.util.Map;

/**
 * One vertex of the graph, complete with mappings to neighbouring vertices
 */
public class Vertex implements Comparable<Vertex> {
    public final String name;
    public int maxCost = 200000;
    public Vertex previous = null;
    private final Map<Vertex, Integer> neighbours;

    public Vertex(String name) {
        this.name = name;
        neighbours = new HashMap<>();
    }

    public Map<Vertex, Integer> getNeighbours() {
        return neighbours;
    }

    public int getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(int maxCost) {
        this.maxCost = maxCost;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    public void putNeighbour(Vertex vertex, int cost){
        neighbours.put(vertex, cost);
    }

    public int compareTo(Vertex other) {
        return Integer.compare(maxCost, other.maxCost);
    }
}
