package Graphs;

import java.util.*;

public class PrimsAlgorithm {
    static class Edge {
        int src, dest, wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int v, cost, parent;

        public Pair(int v, int c, int p) {
            this.v = v;
            this.cost = c;
            this.parent = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;  //asce
        }

    }

    public static void prims(ArrayList<Edge> graph[], int src) {
        boolean vis[] = new boolean[graph.length];
        ArrayList<Edge> mst = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0, -1));

        int finalCost = 0; //MST Cost/total min weights

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                if(curr.parent != -1) {
                    mst.add(new Edge(curr.parent, curr.v, curr.cost));
                }
                for(int i=0; i<graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt, curr.v));
                }
            }
        }
        System.out.println("Edges in MST:");
        for (Edge e : mst) {
            System.out.println(e.src + " -> " + e.dest + " : " + e.wt);
        }

        System.out.println("Final(min) cost of MST: " + finalCost);
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
                              / | \
                        (10) /  |  \ (15)
                            /   |   \
                           1(30)|    2
                            \   |   /
                        (40) \  |  / (50)
                              \ | /
                                3
        */

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        int src = 0;
        prims(graph, src);
    }
}
