package com.controller;

import com.exception.WrongDataException;
import com.model.Model;
import com.model.Vertex;
import com.view.ConsoleHelper;
import com.view.View;

import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Controller {
    private final View view;
    private final Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        view.toDo();

        for (String key : model.getRoutes().keySet()) {
            shortestPath(key);
            view.printCost(model.getRoutes().get(key));
        }
    }

    /**
     * Runs data using a specified source vertex
     * Implementation of data's algorithm using a binary heap.
     */
    public void shortestPath(String startName) {
        Map<String, Vertex> graph = model.getGraph();

        if (!graph.containsKey(startName)){
            try {
                throw new WrongDataException("Not containsKey in graph");
            } catch (WrongDataException e){
                ConsoleHelper.writeMessage(e.toString());
            }
        }

        Vertex source = graph.get(startName);
        NavigableSet<Vertex> vertices = new TreeSet<>();

        // set-up vertices
        for (Vertex vertex : graph.values()) {
            vertex.previous = vertex == source ? source : null;
            vertex.maxCost = vertex == source ? 0 : 200000;
            vertices.add(vertex);
        }

        Vertex shortestDistance = null, neighbour = null;

        while (!vertices.isEmpty()){
            // vertex with shortest distance (first iteration will return source)
            shortestDistance = vertices.pollFirst();

            //Intellij IDEA recommend to try assert.
            assert shortestDistance != null;

            // we can ignore shortestDistance (and any other remaining vertices) since they are unreachable
            if (shortestDistance.maxCost == 200000)
                break;

            //look at distances to each neighbour
            for (Map.Entry<Vertex, Integer> entry: shortestDistance.getNeighbours().entrySet()) {
                neighbour = entry.getKey(); //the neighbour in this iteration

                int alternateDist = shortestDistance.getMaxCost() + entry.getValue();
                if (alternateDist < neighbour.getMaxCost()){ // shorter path to neighbour found
                    vertices.remove(neighbour);
                    neighbour.setMaxCost(alternateDist);
                    neighbour.setPrevious(shortestDistance);
                    vertices.add(neighbour);
                }
            }
        }
    }

}
