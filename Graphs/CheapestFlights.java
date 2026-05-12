package Graphs;

import java.util.*;
public class CheapestFlights {
    static class Edge {
        int src, dest, wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Info{
        int v, path, stops;

        Info(int v, int p, int s) {
            this.v = v;
            this.path = p;
            this.stops = s;
        }
    }

    public static int createGraph(int flights[][], int src, int dst, int k, int n) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];

        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++) {
            int s = flights[i][0];
            int d = flights[i][1];
            int w = flights[i][2];

            Edge e = new Edge(s, d, w);
            graph[s].add(e);
        }

        return cheapestFlight(flights, graph, src, dst, k);
    }

    public static int cheapestFlight(int flights[][], ArrayList<Edge> graph[], int src, int dst, int k) {
        
        int dist[] = new int[graph.length];
        Queue<Info> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++) {
            if(i != src)
                dist[i] = Integer.MAX_VALUE;
        }

        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k) {
                break;
            }
            for(int i=0; i<graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src, v = e.dest, wt = e.wt;
                if(curr.path + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.path + wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return dist[dst];
        }
    }
    public static void main(String[] args) {
        /*
                                0
                              /   ^
                       (100) /     \ (100)
                            /       \
                           V  (100)  \
                           1 -------> 2
                           \          /
                            \        /
                        (600)\      / (200)
                              \    /
                               \  /
                                VV
                                 3
        */
        
        int flights[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 600}};
        int src = 0, dst = 3, k = 1, n = 4;
        int cost = createGraph(flights, src, dst, k, n);

        System.out.println("The minimum cost is: " + cost);
        
    }
}
