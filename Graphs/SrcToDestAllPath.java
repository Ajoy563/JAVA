package Graphs;

import java.util.ArrayList;

public class SrcToDestAllPath {
    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String path) {
        if(src == dest) {
            System.out.println(path+ " " + dest);
            return;
        }

        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path+" "+src);
        }
    }

    public static void main(String[] args) { //O(V^2)
        /*
                    5          4
                    | \      / |
                    |  \    /  |
                    |   V  V   |
                    |     0    |
                    |     |    |    DAG
                    V     |    V
                    2     |    1
                     \    |    ^
                      \   |   /
                       \  |  /
                        V V /
                          3
        */

        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        int src = 5, dest = 1;
        printAllPath(graph, src, dest, "");
    }
}
