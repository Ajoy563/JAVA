package Graphs;

import java.util.*;
public class KahnsAlgorithm {
    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createIndeg(ArrayList<Edge> graph[], int curr, int indeg[]) {
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            indeg[e.dest]++;
        }
    }

    public static void kahnAlgo(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        //find in-degrees of nodes
        for(int i=0; i<graph.length; i++) {
            createIndeg(graph, i, indeg);
        }

        //add 0 in-degrees in queue
        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        //bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest] --;
                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) { //O(V+E)
        /*
                    5          4
                    | \      / |
                    |  \    /  |
                    |   V  V   |
                    |     0    |
                    |          |    DAG
                    V          V
                    2          1
                     \         ^
                      \       /
                       \     /
                        V   /
                          3
        */

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        System.out.print("Topological Sort Using BFS: ");
        kahnAlgo(graph);
    }
}

