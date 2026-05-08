package Graphs;

import java.util.*;
public class CycleDetectionInUndirected {
    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if (!vis[i]) {
                if(detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            
            //case 3 - vis[neigh]
            if(!vis[e.dest]) {
                if(detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            //case 2 - vis[neigh] and neigh != parent
            else if(vis[e.dest] && e.dest != par) {
                return true;
            }
            // case 3 - continue
        }

        return false;
    }

    public static void main(String[] args) {
        /*
                    1 ------ 3
                   /|        |
                  / |        |
                 0  |        |
                  \ |        |
                   \|        |
                    2        4
        */

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

        System.out.println(detectCycle(graph));
    }
}
