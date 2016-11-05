package cs271;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SearchTest {

	@Test
	public void testForNoSolutions() {
		Graph<String> graph = new RomaniaGraph();
		DepthFirst<String> dfs = new DepthFirst<>();
		Node<String> goal = dfs.search(graph, graph.get("NewYork"));
		List<String> path = graph.path(goal);

		assertThat(path, equalTo(Arrays.asList()));
	}

	@Test
	public void testForPathOfOne() {
		Graph<String> graph = new RomaniaGraph();
		DepthFirst<String> dfs = new DepthFirst<>();
		Node<String> goal = dfs.search(graph, graph.get("Bucharest"));
		List<String> path = graph.path(goal);

		assertThat(path, equalTo(Arrays.asList("Bucharest")));
	}

	@Test
	public void testForPathOfTwo() {
		Graph<String> graph = new RomaniaGraph();
		DepthFirst<String> dfs = new DepthFirst<>();
		Node<String> goal = dfs.search(graph, graph.get("Fagaras"));
		List<String> path = graph.path(goal);

		assertThat(path, equalTo(Arrays.asList("Fagaras", "Bucharest")));
	}

}
