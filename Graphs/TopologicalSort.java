package Graphs;
import java.util.*;
public class TopologicalSort {
    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void topSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        System.out.print("Topological Sort: ");
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.add(curr);
    }

    public static void main(String[] args) {
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

        topSort(graph);
    }
}
