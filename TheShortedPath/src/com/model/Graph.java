package com.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<String, Vertex> graph;

    /**
     * Builds a graph from a set of edges
     */
    public Graph(List<Edge> edges) {
        graph = new HashMap<>(edges.size());

        //one pass to find all vertices
        for (Edge edge : edges) {
            if (!graph.containsKey(edge.sourceCity))
                graph.put(edge.sourceCity, new Vertex(edge.sourceCity));

            if (!graph.containsKey(edge.destinationCity))
                graph.put(edge.destinationCity, new Vertex(edge.destinationCity));
        }

        //another pass to set neighbouring vertices
        for (Edge edge : edges) {
            Vertex vertex = graph.get(edge.sourceCity);
            vertex.putNeighbour(graph.get(edge.destinationCity), edge.cost);
        }
    }

    public Map<String, Vertex> getGraph() {
        return graph;
    }
}
