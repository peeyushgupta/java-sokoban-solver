package cs271;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class RomaniaGraph implements Graph<String> {
	private Map<String, List<String>> children;
	
	public RomaniaGraph() {
		children = new HashMap<>();
		children.put("Fagaras", Arrays.asList("Bucharest", "Sibiu"));
	}
	
	@Override
	public Node<String> get(String state) {
		// TODO Auto-generated method stub
		return new Node<String>(null, "travel", state);
	}

	@Override
	public List<String> path(Node<String> goal) {
		List<String> path = new ArrayList<>();
		
		Node<String> temp = goal;
		while(temp != null) {
			path.add(temp.getState());
			temp = temp.getParent();
		}
		
		return path;
	}

	@Override
	public boolean isGoal(Node<String> node) {
		// TODO Auto-generated method stub
		return node.getState() == "Bucharest";
	}

	@Override
	public List<Node<String>> children(Node<String> current) {		
		List<Node<String>> list = new ArrayList<>();
		
		List<String> stateList = children.get(current.getState()); 
		
		if(stateList == null) {
			return new ArrayList<Node<String>>();
		}
		
		stateList.forEach(state -> {
			list.add(new Node<String>(current, "Travel", state));
		});
		
		return list;
	}

}
