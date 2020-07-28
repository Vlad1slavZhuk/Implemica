package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private List<Paths> listPaths;
    private List<Edge> listEdge;
    private Map<String, String> routes;
    private Graph graph;

    public Model() {
        listPaths = new ArrayList<>();
        listEdge = new ArrayList<>();
        routes = new HashMap<>();
    }

    public List<Paths> getListPaths() {
        return listPaths;
    }

    public List<Edge> getListEdge() {
        return listEdge;
    }

    public Map<String, Vertex> getGraph() {
        return graph.getGraph();
    }

    public Map<String, String> getRoutes() {
        return routes;
    }

    public void addPaths(Paths paths) {
        listPaths.add(paths);
    }

    public void addEdges(List<Paths> paths) {
        for (Paths path : paths) {
            String sourceCity = path.getCity();
            int id = path.getIdNeighbour();
            String destinationCity = null;
            for (Paths otherPath : paths) {
                if (otherPath.getIdCity() == id) {
                    destinationCity = otherPath.getCity();
                }
            }
            listEdge.add(new Edge(sourceCity, destinationCity, path.getCost()));
        }
    }

    public void setGraph(Graph graph){
        this.graph = graph;
    }

    public void putPaths(String NAME1, String NAME2) {
        routes.put(NAME1, NAME2);
    }
}
