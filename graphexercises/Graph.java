/*
 * Graph data structure provided by professor
 * 
 * I developed the following methods:
 * 1. removeEdge()
 * 2. getAdjacencyList()
 * 3. printAdjacenctList()
 */
package graphexercises;

import java.util.*;

/**
 * Generic Graph implementation
 * Vertex nodes are of type E
 * By default we make the graph directed
 * Pass a false boolean value to the constructor to specify un-directed graphs
 */

public class Graph<E> {
    /**
     * Vertices of graphs are the keys to the map
     * Edges originating at a vertex are the values to the key in the map
     * The value for each key is a LinkedList of vertices
     */
    private Map<E, List<E>> listMap;
    public boolean directed;

    public Graph() {
        directed = true;
        listMap = new HashMap<>();
    }

    public Graph(boolean directed) {
        this.directed = directed;
        listMap = new HashMap<>();
    }

    /** Add a vertex to the graph */
    public boolean addVertex(E v) throws Exception {
        if (listMap.containsKey(v)) {
            throw new Exception("Vertex exists");
        } else {
            listMap.put(v, new LinkedList<>());
            return true;
        }
    }

    /** Add an Edge between two vertices */
    public void addEdge(E source, E destination) throws Exception {
        if (!listMap.containsKey(source))
            addVertex(source);

        if (!listMap.containsKey(destination))
            addVertex(destination);

        listMap.get(source).add(destination);

        if (!this.directed) {
            /* in this case add an edge from destination to source node */
            listMap.get(destination).add(source);
        }
    }

    /** Method to return number of vertices in the graph */
    public int nodeCount() {
        return listMap.keySet().size();
    }

    /** Method to return number of edges in the graph */
    public int edgeCount() {
        int count = 0;
        for (E v : listMap.keySet()) {
            count += listMap.get(v).size();
        }
        if (!directed) {
            count = count / 2;
        }
        return count;
    }

    /** checks if graph contains given vertex */
    public boolean hasVertex(E s) {
        return listMap.containsKey(s);
    }

    /** checks if graph contains an edge between two vertices */
    public boolean hasEdge(E source, E dest) {
        return listMap.get(source).contains(dest);
    }

     /** Remove an edge between two vertices */
     public void removeEdge(E source, E destination) throws Exception {
        try {
            if (listMap.containsKey(source) && listMap.containsKey(destination)) {
                listMap.get(source).remove(destination);
                if (!directed) {
                    listMap.get(destination).remove(source);
                }
            }
        } catch (Exception e) {
            throw new Exception("At least one vertex does not exist");
        }
    }

    /** returns adjacency list for a given vertex */
    public List<E> getAdjacencyList(E vertex) throws Exception {
        try {
            List<E> adjacencyList = new ArrayList<>();
            for (E w : listMap.get(vertex)) {
                adjacencyList.add(w);
            }
            return adjacencyList;
        } catch (Exception e) {
            throw new Exception("Vertex does not exist.");
        }
    }

    /** prints adjacency list for a given vertex*/
    public String printAdjacencyList(E vertex) throws Exception {
        try {
            StringBuilder builder = new StringBuilder();
            for (E v : getAdjacencyList(vertex)) {
                builder.append(v.toString() + " ");
            }
            builder.append("\n");
            return builder.toString();
        } catch (Exception e) {
            throw new Exception("Vertex does not exist.");
        }
        
    }

    /** String representation of adjacency lists of each vertex */
    public String toString() {
        /**
         * We could append using String object, but we use a StringBuilder instead.
         * See
         * https://stackoverflow.com/questions/1532461/stringbuilder-vs-string-concatenation-in-tostring-in-java
         * for why that is better when you are appending to strings in a loop.
         */
        StringBuilder builder = new StringBuilder();
        for (E v : listMap.keySet()) {
            builder.append(v.toString() + ": ");
            for (E w : listMap.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }

}
