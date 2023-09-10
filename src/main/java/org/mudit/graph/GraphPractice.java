package org.mudit.graph;


//Java Program to demonstrate adjacency list 
//representation of graphs 

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphPractice {
    // Adds an edge to an undirected graph
    static void addEdge(Graph graph, int src, int dest) {
        // Add an edge from src to dest.
        graph.adjListArray[src].add(dest);
        // dest to source
        graph.adjListArray[dest].add(src);

    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(Graph graph) {
        for (int v = 0; v < graph.V; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : graph.adjListArray[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    public static void DepthFirstSearch(Graph g) {
        // Stack of graph Vertices..
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[g.V];
        st.push(3); // push 0 vertex on stack
        while (!st.isEmpty()) {
            int vertex = st.pop();
            System.out.print(vertex + "->");
            visited[vertex] = true;
            LinkedList<Integer> list = g.adjListArray[vertex];
            Iterator<Integer> it = list.iterator();

            while (it.hasNext()) {
                int vert = it.next();
                if (!visited[vert]) {
                    // this vertex is not visited
                    visited[vert] = true;
                    st.push(vert);
                }
            }
        }
    }

    public static void DFSRecursive(Graph g) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        boolean[] visited = new boolean[5];
        visited[1] = true;
        DepthFirstSearchRecursive(g, st, visited);
    }

    public static void DepthFirstSearchRecursive(Graph g, Stack<Integer> st, boolean[] visited) {
        if (st.empty()) {
            return;
        }

        int vertex = st.pop();
        System.out.print(vertex + "->");
        LinkedList<Integer> list = g.adjListArray[vertex];
        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            int vert = it.next();
            if (!visited[vert]) {
                // this vertex is not visited
                visited[vert] = true;
                st.push(vert);
            }
        }
        DepthFirstSearchRecursive(g, st, visited);
    }

    public static void BreadthFirstSearch(Graph g) {
        // Stack of graph Vertices..
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[g.V];
        q.add(3); // add vertex on queue
        while (!q.isEmpty()) {
            int vertex = q.remove();
            System.out.print(vertex + "->");
            visited[vertex] = true;
            LinkedList<Integer> list = g.adjListArray[vertex];
            Iterator<Integer> it = list.iterator();

            while (it.hasNext()) {
                int vert = it.next();
                if (!visited[vert]) {
                    // this vertex is not visited
                    visited[vert] = true;
                    q.add(vert);
                }
            }
        }
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        // create the graph given in above figure
        int V = 5;
        Graph graph = new Graph(V);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        // print the adjacency list representation of
        // the above graph
        // printGraph(graph);
        // DepthFirstSearch(graph);
        // System.out.println();
        // BreadthFirstSearch(graph);
        DFSRecursive(graph);
    }

    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices
    // in graph)
    static class Graph {
        int V;
        LinkedList<Integer>[] adjListArray;

        // constructor
        Graph(int V) {
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
    }

}
