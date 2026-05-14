package Graphs;

import java.util.*;
public class KruskalsAlgorithm {

    static class Edge implements Comparable<Edge>{
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;  //asce
        }
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for(int i=0; i<n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if(par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA, parB;

        parA = find(a);
        parB = find(b);

        if(parA == parB) {
            par[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA] > rank[parB]) {
            par[parB] = parA;
        }
        else {
            par[parA] = parB;
        }
    }

    public static int kruskal(ArrayList<Edge> edges, int V) {
        ArrayList<Edge> mst = new ArrayList<>();
        Collections.sort(edges);

        int mstCost = 0, count = 0;

        for(int i=0; count < V-1; i++) {
            Edge e = edges.get(i);
            int parA = find(e.src), parB = find(e.dest);
            if(parA != parB) {
                union(e.src, e.dest);
                mst.add(new Edge(e.src, e.dest, e.wt));
                mstCost += e.wt;
                count++;
            }
        }

        System.out.println("Minimum spanning Tree : ");
        for (Edge e : mst) {
            System.out.println(e.src + " -> " + e.dest + " : " + e.wt);
        }
        System.out.println();
        return mstCost;
    }

    public static void main(String[] args) {
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

        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();

        init();

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
                                
        System.out.println("Minimum Cost : " + kruskal(edges, V));
    }
}
