package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int col[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<col.length; i++) 
            col[i] = -1;  //no color

        //0 - yellow, 1 - blue, -1 - no color
        for(int i=0; i<graph.length; i++) {
            if(col[i] == -1) {
                q.add(i); //Initial src
                col[i] = 0; //yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        
                        if(col[e.dest] == -1) { // case 3
                            int newCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = newCol;
                            q.add(e.dest);
                        }
                        else if(col[e.dest] == col[curr]) { //case 2
                            return false;
                        }
                        // case 1 - do nothing
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }
        /*
                                0
                              /   \
                             /     \
                            /       \
                           1         2 Is Bipartite = False
                           \         /
                            \       /
                             3-----4        
                               
        */

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 2));

        System.out.println("Is Bipartite: " + isBipartite(graph));

        //Note: If graphs don't have cycles - Bipartite graph
        // Even cycle - True      Odd cycle = False
    }
}
