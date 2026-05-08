package Graphs;

import java.util.*;
public class BFS {
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean visit[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!visit[i]) 
                bfsUtil(graph, visit);
        }
    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean visit[]) {
        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if(!visit[curr]) { //not visit yet - first time
                System.out.print(curr + " ");
                visit[curr] = true;
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) { //O(V+E)
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

        System.out.print("BFS Traversal: ");
        bfs(graph);
    }
}
