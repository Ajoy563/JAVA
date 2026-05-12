package Graphs;

import java.util.ArrayList;

public class BellmanFordAlgorithm {
    static class Edge {
        int src, dest, wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {
        int dist[] = new int[V];
        for(int i=0; i<dist.length; i++) {
            if(i != src)
                dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<V-1; i++) { //O(V)
            //edges - O(E)
            for(int j=0; j<graph.size(); j++) {
                Edge e = graph.get(j);
                int u = e.src, v = e.dest, wt = e.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        System.out.println("Shortest distance from Source: ");
        for(int i=0; i<dist.length; i++) {
            System.out.println( src +" -> "+ i + "("+ dist[i] + ")");
        }
    }

    public static void main(String[] args) { //O(V*E)
        /*
                                  (-1)
                            1 <---------- 4
                           ^|             ^
                       (2)/ |             |
                         /  |             |
                        0   |(-4)         |(4)
                         \  |             |
                      (4) \ |             |
                           V              |
                            2 ----------> 3
                                   (2)
        */

        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
        
        int src = 0;
        bellmanFord(graph, src, V);
    }
}
