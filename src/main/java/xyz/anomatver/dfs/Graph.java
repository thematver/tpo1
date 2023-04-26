package xyz.anomatver.dfs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int V; // количество вершин
    private List<List<Integer>> adj; // список смежности
    private boolean[] visited; // флаги посещенных вершин

    public Graph(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean[V];
    }

    // добавить ребро
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    // пометить вершину как посещенную
    public void setVisited(int v) {
        visited[v] = true;
    }

    // проверить, была ли вершина посещена
    public boolean isVisited(int v) {
        return visited[v];
    }

    // поиск в глубину с рекурсией
    public void DFSUtil(int v) {
        setVisited(v);
        System.out.print(v + " ");

        List<Integer> neighbors = adj.get(v);
        for (int i = 0; i < neighbors.size(); i++) {
            int n = neighbors.get(i);
            if (!isVisited(n)) {
                DFSUtil(n);
            }
        }
    }

    // поиск в глубину
    public void DFS(int v) {
        DFSUtil(v);
    }
}
