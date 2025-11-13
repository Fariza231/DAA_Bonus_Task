package mst;

import mst.model.Graph;
import mst.model.MSTManager;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 5, 6);

        MSTManager mstManager = new MSTManager(g);
        mstManager.buildMST();
        mstManager.displayMST();

        mstManager.removeEdge(1);
    }
}
