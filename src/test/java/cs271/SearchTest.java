package cs271;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SearchTest {

    @Test
    public void testNoSolutions() {
        Graph<String> graph = new RomaniaGraph();
        Search<String> search = new Search<>();
        Node<String> goal = search.depthFirst(graph, graph.get("NewYork"));
        List<String> path = graph.statePath(goal);

        assertThat(path, equalTo(Arrays.asList()));
    }

    @Test
    public void depthFirstFullTest() {
        Graph<String> graph = new RomaniaGraph();
        Search<String> search = new Search<>();
        Node<String> goal = search.depthFirst(graph, graph.get("Arad"));
        List<String> path = graph.statePath(goal);

        assertThat(path, equalTo(Arrays.asList("Arad", "Timisoara", "Lugoj", "Mehadia", "Dobreta", "Craiova",
                "RimnicuVilcea", "Sibiu", "Fagaras", "Bucharest")));
    }

    @Test
    public void breadthFirstFullTest() {
        Graph<String> graph = new RomaniaGraph();
        Search<String> search = new Search<>();
        Node<String> goal = search.breadthFirst(graph, graph.get("Arad"));
        List<String> path = graph.statePath(goal);

        assertThat(path, equalTo(Arrays.asList("Arad", "Sibiu", "Fagaras", "Bucharest")));
    }

    @Test
    public void uniformCostFullTest() {
        Graph<String> graph = new RomaniaGraph();
        Search<String> search = new Search<>();
        Node<String> goal = search.uniformCost(graph, graph.get("Arad"));
        List<String> path = graph.statePath(goal);

        assertThat(path, equalTo(Arrays.asList("Arad", "Sibiu", "RimnicuVilcea", "Pitesti", "Bucharest")));
    }

    @Test
    public void greedyBestFirstFullTest() {
        Graph<String> graph = new RomaniaGraph();
        Search<String> search = new Search<>();
        Node<String> goal = search.greedyBestFirst(graph, graph.get("Arad"));
        List<String> path = graph.statePath(goal);

        assertThat(path, equalTo(Arrays.asList("Arad", "Sibiu", "Fagaras", "Bucharest")));
    }

    @Test
    public void aStarFullTest() {
        Graph<String> graph = new RomaniaGraph();
        Search<String> search = new Search<>();
        Node<String> goal = search.aStar(graph, graph.get("Arad"));
        List<String> path = graph.statePath(goal);

        assertThat(path, equalTo(Arrays.asList("Arad", "Sibiu", "RimnicuVilcea", "Pitesti", "Bucharest")));
    }
}
