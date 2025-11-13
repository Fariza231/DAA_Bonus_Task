package mst.model;

import java.util.*;

public class MSTManager {
    private final Graph graph;
    private List<Edge> mstEdges;

    public MSTManager(Graph graph) { this.graph = graph; }

    public List<Edge> buildMST() {
        Collections.sort(graph.edges);
        DisjointSet ds = new DisjointSet(graph.V);
        mstEdges = new ArrayList<>();

        for (Edge e : graph.edges) {
            if (ds.find(e.src) != ds.find(e.dest)) {
                mstEdges.add(e);
                ds.union(e.src, e.dest);
            }
        }
        return mstEdges;
    }

    public void displayMST() {
        System.out.println("MST Edges:");
        for (Edge e : mstEdges) System.out.println("  " + e);
    }

    public void removeEdge(int index) {
        Edge removed = mstEdges.remove(index);
        System.out.println("\nRemoved Edge: " + removed);
        showComponents();
        findReplacementEdge();
    }

    private void showComponents() {
        DisjointSet ds = new DisjointSet(graph.V);
        for (Edge e : mstEdges) ds.union(e.src, e.dest);

        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < graph.V; i++)
            components.computeIfAbsent(ds.find(i), k -> new ArrayList<>()).add(i);

        System.out.println("\nComponents after removal:");
        for (List<Integer> comp : components.values()) System.out.println("  " + comp);
    }

    private void findReplacementEdge() {
        DisjointSet ds = new DisjointSet(graph.V);
        for (Edge e : mstEdges) ds.union(e.src, e.dest);

        Edge replacement = null;
        int minWeight = Integer.MAX_VALUE;

        for (Edge e : graph.edges) {
            if (ds.find(e.src) != ds.find(e.dest) && e.weight < minWeight) {
                replacement = e;
                minWeight = e.weight;
            }
        }

        if (replacement != null) {
            mstEdges.add(replacement);
            System.out.println("\nReplacement Edge Found: " + replacement);
            System.out.println("\nNew MST:");
            for (Edge e : mstEdges) System.out.println("  " + e);
        } else System.out.println("No replacement edge found. Graph disconnected.");
    }
}
