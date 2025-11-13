package mst.model;

import java.util.*;

public class Graph {
    public int V;
    public List<Edge> edges = new ArrayList<>();

    public Graph(int V) { this.V = V; }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }
}
