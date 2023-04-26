package xyz.anomatver.dfs;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DFSTest {

    @Test
    public void testChooseStartingVertex() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.DFS(0);

        assertTrue(g.isVisited(0)); // проверяем, что начальная вершина помечена как посещенная
    }

    @Test
    public void testCurrentVertexVisited() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.DFS(0);

        assertTrue(g.isVisited(1)); // проверяем, что текущая вершина 1 помечена как посещенная
    }

    @Test
    public void testMarkCurrentVertexAsVisited() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.DFS(0);

        assertTrue(g.isVisited(2)); // проверяем, что текущая вершина 2 помечена как посещенная
    }

    @Test
    public void testProcessCurrentVertex() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.print("Expected Output: 0 1 2 3 4 ");
        System.out.print("\nActual Output: ");
        g.DFS(0);
    }

    @Test
    public void testMoveToNextUnvisitedVertex() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.DFS(0);

        assertTrue(g.isVisited(4)); // проверяем, что алгоритм перешел к вершине 4, которая является последней в графе
    }
}
