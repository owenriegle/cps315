/*
 * test case provided by professor for Graph data structure
 */
package graphexercises;

public class TestG {
    public static void main(String[] args) throws Exception {
        /** create a directed graph */
        Graph<Integer> g = new Graph<>();
        /** Add some edges */
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 1);
        g.addEdge(5, 2);
        // Print a string representation of the graph
        System.out.println("**********The adjacency list representation of the graph:\n" + g.toString());
        // print the number of vertices in the graph.
        System.out.println("Graph has " + g.nodeCount() + " vertices");
        // print the number of edges in the graph.
        System.out.println("Graph has " + g.edgeCount() + " directed edges");
        // Is there an edge ?
        System.out.println("Graph has an edge from 1 to 3: " + g.hasEdge(1, 3));
        // Is there an edge from Chicago to Seattle ?
        System.out.println("Graph has an edge from 2 to 5: " + g.hasEdge(2, 5));
        // Is vertex present?
        System.out.println("Graph has vertex 5: " + g.hasVertex(5));
        System.out.println("Graph has vertex 6: " + g.hasVertex(6));
        // Show adjacency list
        System.out.println("--------Adjacency List of 2: " + g.printAdjacencyList(2));
        g.removeEdge(2, 3);
        System.out.println("**********The graph after deleting 2 to 3 edge:\n" + g.toString());
        g.removeEdge(2, 5);
        System.out.println("**********The graph after deleting 2 to 5 edge:\n" + g.toString());
    }
}