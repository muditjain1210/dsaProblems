package org.mudit.graph;

import org.mudit.user_defined_data_structures.DirectedGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This program check whether there is route between two vertices in a directed graph.
 * If there is path it will return {@code true } else {@code false}
 *
 * @author MJ
 * @see DirectedGraph
 */
public class CheckRouteBtw2Nodes {
    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(4, 5);
        g.addEdge(2, 3);
        g.addEdge(2, 0);

        g.printGraph();
        ifRoutesExists(g, 2, 5);
    }

    static boolean ifRoutesExists(DirectedGraph g, int src, int dest) {

        boolean[] visit = new boolean[g.V];
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visit[src] = true;

        while (!q.isEmpty()) {
            int vertex = q.remove();
            // visit this vertex..
            System.out.print(vertex + " ");

            // iterate over adjancency list of this vertex
            for (Integer i : g.adjListArray[vertex]) {
                if (i == dest) {
                    System.out.println(i + " ROUTE IS THERE");
                    return true; // we found the destination vertex while BFS, So there is route between src and dest
                }
                if (!visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }

        }
        System.out.println("NO ROUTE");
        return false;
    }
}
