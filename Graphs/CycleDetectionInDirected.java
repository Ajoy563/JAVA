package Graphs;

import java.util.ArrayList;

public class CycleDetectionInDirected {
    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;

        return false;
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(isCycleUtil(graph, i, vis, stack)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }
        /*
                            0
                           /  \
                          /    \
                         v      v
                         2       1 No cycle
                          \     /
                           \   /
                            v v
                             3
         */

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        
        graph[2].add(new Edge(2, 3));

        /*  
                        1 ----> 0 <---- 3
                                    |   ^
                                    |  /       Cycle
                                    | /
                                    V
                                    2
         */

        // graph[0].add(new Edge(0, 2));

        // graph[1].add(new Edge(1, 0));

        // graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(3, 0));

        System.out.println("Cycle exist: " + isCycle(graph));
    }
}
