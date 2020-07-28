package com.view;

import com.exception.WrongDataException;
import com.model.Graph;
import com.model.Model;
import com.model.Paths;
import com.model.Vertex;

import java.util.Map;

public class View {
    private final Model model;

    public View(Model model) {
        this.model = model;
    }

    public void toDo() {
        try {
            ConsoleHelper.writeMessage("Enter s — [the number of tests <= 10].");
            int s = ConsoleHelper.readInteger(); // the number of tests
            if (s <= 10 && s > 0){
                for (int i = 0; i < s; i++) {
                    ConsoleHelper.writeMessage("Enter n — [the number of cities <= 10000].");
                    int n = ConsoleHelper.readInteger(); //the number of cities
                    if (n <= 10000 && n > 0){
                        // read the name of city and the numbers of neighbors of this city
                        for (int j = 0; j < n; j++) {
                            ConsoleHelper.writeMessage("Enter NAME_" + (j+1) + " city.");
                            String NAME = ConsoleHelper.readString(); // name city
                            ConsoleHelper.writeMessage("Enter p [the number of neighbors of city NAME]. ");
                            int p = ConsoleHelper.readInteger(); //the number of neighbors of city NAME
                            if (p > 0){
                                for (int k = 0; k < p; k++) {
                                    ConsoleHelper.writeMessage("Enter nr cost - [nr - index of a city connected " +
                                            "to NAME (the index of the first city is 1)]" +
                                            "[cost - the transportation cost].");
                                    String nr_cost = ConsoleHelper.readString().trim();
                                    if (nr_cost.matches("^\\d+ \\d+$")){ //regex check
                                        String[] word = nr_cost.split(" ");
                                        int nr = Integer.parseInt(word[0]);
                                        int cost = Integer.parseInt(word[1]);
                                        model.addPaths(new Paths(j + 1, NAME, nr, cost));
                                    }
                                    else
                                        throw new WrongDataException("nr cost - wrong data.");
                                }
                            } else
                                throw new WrongDataException("p - wrong data.");
                        }
                        model.addEdges(model.getListPaths());
                    } else {
                        throw new WrongDataException("n - wrong data.");
                    }
                }

                model.setGraph(new Graph(model.getListEdge()));

                ConsoleHelper.writeMessage("Enter r [the number of paths to find <= 100].");
                int r = ConsoleHelper.readInteger();
                if (r <= 100 && r > 0){
                    for (int i = 0; i < r; i++) {
                        ConsoleHelper.writeMessage("Enter NAME1 NAME2 - [sourceCity destinationCity].");
                        String name1_name2 = ConsoleHelper.readString().trim();

                        if (name1_name2.matches("^[a-zA-Z]+ [a-zA-Z]+$")){ //regex check
                            String[] word1 = name1_name2.split(" ");
                            String sourceCity = word1[0].trim();
                            String destinationCity = word1[1].trim();
                            model.putPaths(sourceCity, destinationCity);
                        }
                    }
                } else
                    throw new WrongDataException("r - wrong data.");
            } else
                throw new WrongDataException("s - wrong data.");
        } catch (WrongDataException e){
            System.out.println(e.toString());
        }
    }

    /**
     * Prints a cost from the source to the specified vertex.
     *
     * @param key
     */
    public void printCost(String key) {
        Map<String, Vertex> graph = model.getGraph();
        if (!graph.containsKey(key)){
            try {
                throw new WrongDataException("Error in method printCost().");
            } catch (WrongDataException e){
                ConsoleHelper.writeMessage(e.toString());
            }
        }

        Vertex current = graph.get(key);
        if (current != current.previous)
            ConsoleHelper.writeMessage(current.maxCost + "");
    }
}
