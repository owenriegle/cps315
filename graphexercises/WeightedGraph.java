package graphexercises;

import java.util.*;
import java.util.LinkedList;

public class WeightedGraph<E> {
    private Map<E, List<Map<E, Double>>> listMap;
    public boolean directed;

    public WeightedGraph() {
        this.directed = true;
        listMap = new HashMap<>();
    }

    public WeightedGraph(boolean directed) {
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

    public void addEdge(E source, E destination, double wt) throws Exception {
        if ((!directed) && hasEdge(destination, source)) {
            return;
        }
        if (!listMap.containsKey(source))
            addVertex(source);

        if (!listMap.containsKey(destination))
            addVertex(destination);

        HashMap<E, Double> hm = new HashMap<>();
        hm.put(destination, wt);
        listMap.get(source).add(hm);

        if (!directed) {
            HashMap<E, Double> hm2 = new HashMap<>();
            hm2.put(source, wt);
            listMap.get(destination).add(hm2);
        }
    }

    /** Remove an edge from source to destination */

    public void removeEdge(E source, E dest) throws Exception {
        if (!listMap.containsKey(source)) {
            throw new Exception();
        }
        List<Map<E, Double>> ll = listMap.get(source);
        for (Map<E, Double> m : ll) {
            if (m.containsKey(dest)) {
                m.remove(dest);
            }
        }
        if (!this.directed) {
            List<Map<E, Double>> ll2 = listMap.get(dest);
            for (Map<E, Double> m : ll2) {
                if (m.containsKey(source)) {
                    m.remove(source);
                }
            }
        }
    }

    /* Return the adjacency list of a vertex */
    public List<Map<E, Double>> getAdjacencyList(E v) {
        return listMap.get(v);
    }

    /** Print adjacency list of a vertex */
    public void printAdjacencyList(E v) {
        List<Map<E, Double>> lst = getAdjacencyList(v);
        for (Map<E, Double> m : lst) {
            System.out.print(m);
            System.out.println();
        }
    }

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

        if (!hasVertex(source) || !hasVertex(dest)) {
            return false;
        }
        return listMap.get(source).contains(dest);
    }

    /** String representation of the graph */

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (E v : listMap.keySet()) {
            builder.append(v.toString() + ": ");
            for (Map<E, Double> w : listMap.get(v)) {
                Set<Map.Entry<E, Double>> me = w.entrySet();
                for (Map.Entry<E, Double> mm : me) {
                    builder.append(mm.getKey() + "(" + mm.getValue() + ")  ");
                }
            }
            builder.append("\n");
        }
        return (builder.toString());
    }

    /** Breadth-First-Traversal */

    public Set<E> breadthFirstTraversal(E startVertex) {
        Set<E> visited = new LinkedHashSet<E>();
        Queue<E> queue = new LinkedList<E>();
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            E vertex = queue.poll();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Map<E, Double> m : this.getAdjacencyList(vertex)) {
                    Set<Map.Entry<E, Double>> me = m.entrySet();
                    for (Map.Entry<E, Double> w : me) {
                        queue.add(w.getKey());
                    }
                }
            }
        }
        return visited;
    }

    /** Iterative Depth-First-Traversal */

    public Set<E> depthFirstTraversal(E startVertex) {
        Set<E> visited = new LinkedHashSet<E>();
        Stack<E> stack = new Stack<E>();
        stack.push(startVertex);
        while (!stack.isEmpty()) {
            E vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Map<E, Double> w : listMap.get(vertex)) {
                    Set<Map.Entry<E, Double>> me = w.entrySet();
                    for (Map.Entry<E, Double> mm : me) {
                        stack.push(mm.getKey());

                    }
                }
            }
        }
        return visited;
    }
}

class TestWeightedGraph {
    public static void main(String... args) throws Exception {
        WeightedGraph<Integer> wg = new WeightedGraph<>();
        wg.addEdge(1, 2, 10);
        wg.addEdge(1, 5, 30);
        wg.addEdge(2, 4, 35);
        wg.addEdge(3, 4, 40);
        wg.addEdge(4, 5, 49);
        wg.addEdge(5, 3, 40);
        wg.addEdge(3, 2, 48);
        wg.addEdge(6, 4, 50);
        wg.addEdge(3, 6, 40);
        wg.addEdge(2, 5, 55);
        wg.addEdge(6, 1, 35);

        System.out.println(wg);
        System.out.println("Vertices: " + wg.nodeCount());
        System.out.println("Edges: " + wg.edgeCount());
        System.out.println("DFS-> " + wg.depthFirstTraversal(1));
        System.out.println("BFS-> " + wg.breadthFirstTraversal(1));
    }

}