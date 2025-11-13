package mst;

import mst.model.Edge;
import mst.model.Graph;
import mst.model.MSTManager;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MSTTest {

    @Test
    void testMSTConstruction() {
        Graph g = new Graph(4);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 3, 15);
        g.addEdge(2, 3, 4);

        MSTManager manager = new MSTManager(g);
        List<Edge> mst = manager.buildMST();

        assertEquals(3, mst.size(), "MST must contain V-1 edges");

        boolean hasEdge = mst.stream().anyMatch(e -> e.src == 2 && e.dest == 3 && e.weight == 4);
        assertTrue(hasEdge, "MST should contain the smallest edge (2-3, 4)");
    }
}
