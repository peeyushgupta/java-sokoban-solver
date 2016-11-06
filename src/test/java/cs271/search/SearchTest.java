package cs271.search;

import cs271.romania.RomaniaGraph;
import cs271.sokoban.GameState;
import cs271.sokoban.Initializer;
import cs271.sokoban.SokobanGraph;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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


    @Test
    public void sokobanDFS() {
        File file = new File("resources/config.txt");
        Initializer init = new Initializer(file);
        SokobanGraph graph = new SokobanGraph(init.getGame());
        Search<GameState> search = new Search<>();

        GameState startState = init.getGameState();
        Node<GameState> goal = search.depthFirst(graph, graph.get(startState));
        List<GameState> path = graph.path(goal);

        //5 3 12 0 0 0 1 0 2 1 0 1 2 2 0 2 2 3 0 3 2 4 0 4 1 4 2 1 2 1 1 3 1 1 1
        assertThat(graph.getMovesFromPath(path), equalTo(Arrays.asList('R')));
    }

    @Test
    public void sokobanBFS() {
        File file = new File("resources/input3.txt");
        Initializer init = new Initializer(file);
        SokobanGraph graph = new SokobanGraph(init.getGame());
        Search<GameState> search = new Search<>();

        GameState startState = init.getGameState();
        Node<GameState> goal = search.breadthFirst(graph, graph.get(startState));
        List<GameState> path = graph.path(goal);

        assertThat(graph.getMovesFromPath(path), equalTo(Arrays.asList('R', 'D', 'R', 'D', 'D', 'D', 'R')));
    }
}
