package Graphs;

import java.util.*;

public class DijkstraAlgorithm {
    static class Edge {
        int src, dest, wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    
    static class Pair implements Comparable<Pair> {
        int n, path;

        Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;  //return in ascending order
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length]; //storing the distance
        boolean vis[] = new boolean[graph.length]; //mark the node as visited 
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // store the distance in asce order

        //step 1 - make every node to infinity
        for(int i=0; i<graph.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove(); //curr - (n, path)
            if(!vis[curr.n]) {
                vis[curr.n] = true;

                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src, v = e.dest, wt = e.wt;
                    if(dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt; //update dist[v]
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        System.out.println("Shortest distance from Source: ");
        for(int i=0; i<dist.length; i++) {
            System.out.println( src +" -> "+ i + "("+ dist[i] + ")");
        }
        
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }
    

        /*
                               (7)
                        1 ----------> 3
                        ^             ^\ (1)
                    (2)/|             | \
                      / |             |  V
                     0  | (1)      (2)|  5
                      \ |             |  ^
                    (4)\|             | /
                        V             |/ (5)
                        2 ----------> 4
                              (3)
        */

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        int src = 0;
        dijkstra(graph, src);
    }
}
