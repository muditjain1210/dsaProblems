package org.mudit.user_defined_data_structures;

import java.util.LinkedList;

/**
 * A user define class to represent a directed graph.
 * A graph is an array of adjacency lists.
 * Size of array will be V (number of vertices
 * in graph)
 *
 * @author MJ
 */
public class DirectedGraph {
    public int V;
    public LinkedList<Integer>[] adjListArray;

    /**
     * @param V number of vertices in graph
     */
    public DirectedGraph(int V) {
        this.V = V;

        // define the size of array as
        // number of vertices
        adjListArray = new LinkedList[V];

        // Create a new list for each vertex
        // such that adjacent nodes can be stored
        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    /**
     * Adds an edge between src & dest vertex in graph.
     *
     * @param src
     * @param dest
     */
    public void addEdge(int src, int dest) {
        // Add an edge from src to dest.
        adjListArray[src].add(dest);

    }

    /**
     * A utility function to print the adjacency list
     * representation of graph
     */
    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.println("Adjacency list of vertex " + v);

            for (Integer edge : adjListArray[v]) {
                System.out.print(" -> " + edge);
            }
            System.out.println("\n");
        }
    }
}
