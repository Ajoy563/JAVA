package Graphs;

import java.util.ArrayList;

public class HasPath {
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static boolean haspath(ArrayList<Edge> graph[], int src, int dest, boolean visit[]) {
        if(src == dest) {
            return true;
        }
        visit[src] = true;
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!visit[e.dest] && haspath(graph, e.dest, dest, visit)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        /*
                        1---------3
                       /          | \
                      /           |  \
                     0            |    5-------6
                      \           |   /
                       \          |  /
                        2---------4 
        */
        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

        System.out.print("Path exist: " + haspath(graph, 0, 6, new boolean[V]));
        
    }
}
