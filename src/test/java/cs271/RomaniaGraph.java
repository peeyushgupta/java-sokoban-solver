package cs271;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class RomaniaGraph extends Graph<String> {
    private Map<String, List<String>> children;
    private Map<String, Double> pathCost;
    private Map<String, Double> straightLineCost;

    public RomaniaGraph() {
        children = new HashMap<>();
        children.put("Arad", Arrays.asList("Zerind", "Sibiu", "Timisoara"));
        children.put("Bucharest", Arrays.asList("Urziceni", "Giurgiu", "Pitesti", "Fagaras"));
        children.put("Craiova", Arrays.asList("Pitesti", "Dobreta", "RimnicuVilcea"));
        children.put("Dobreta", Arrays.asList("Mehadia", "Craiova"));
        children.put("Eforie", Arrays.asList("Hirsova"));
        children.put("Fagaras", Arrays.asList("Bucharest", "Sibiu"));
        children.put("Giurgiu", Arrays.asList("Bucharest"));
        children.put("Hirsova", Arrays.asList("Eforie", "Urziceni"));
        children.put("Iasi", Arrays.asList("Neamt", "Vaslui"));
        children.put("Lugoj", Arrays.asList("Mehadia", "Timisoara"));
        children.put("Mehadia", Arrays.asList("Dobreta", "Lugoj"));
        children.put("Neamt", Arrays.asList("Iasi"));
        children.put("Oradea", Arrays.asList("Sibiu", "Zerind"));
        children.put("Pitesti", Arrays.asList("Bucharest", "Craiova", "RimnicuVilcea"));
        children.put("RimnicuVilcea", Arrays.asList("Pitesti", "Craiova", "Sibiu"));
        children.put("Sibiu", Arrays.asList("Fagaras", "RimnicuVilcea", "Arad", "Oradea"));
        children.put("Timisoara", Arrays.asList("Arad", "Lugoj"));
        children.put("Urziceni", Arrays.asList("Vaslui", "Hirsova", "Bucharest"));
        children.put("Vaslui", Arrays.asList("Urziceni", "Iasi"));
        children.put("Zerind", Arrays.asList("Oradea", "Arad"));

        pathCost = new HashMap<>();
        pathCost.put("Arad,Zerind", 75.0);
        pathCost.put("Arad,Sibiu", 140.0);
        pathCost.put("Arad,Timisoara", 118.0);
        pathCost.put("Bucharest,Urziceni", 85.0);
        pathCost.put("Bucharest,Giurgiu", 90.0);
        pathCost.put("Bucharest,Pitesti", 101.0);
        pathCost.put("Bucharest,Fagaras", 211.0);
        pathCost.put("Craiova,Pitesti", 138.0);
        pathCost.put("Craiova,Dobreta", 120.0);
        pathCost.put("Craiova,RimnicuVilcea", 146.0);
        pathCost.put("Dobreta,Mehadia", 75.0);
        pathCost.put("Dobreta,Craiova", 120.0);
        pathCost.put("Eforie,Hirsova", 86.0);
        pathCost.put("Fagaras,Bucharest", 211.0);
        pathCost.put("Fagaras,Sibiu", 99.0);
        pathCost.put("Giurgiu,Bucharest", 90.0);
        pathCost.put("Hirsova,Eforie", 86.0);
        pathCost.put("Hirsova,Urziceni", 98.0);
        pathCost.put("Iasi,Neamt", 87.0);
        pathCost.put("Iasi,Vaslui", 92.0);
        pathCost.put("Lugoj,Mehadia", 70.0);
        pathCost.put("Lugoj,Timisoara", 111.0);
        pathCost.put("Mehadia,Dobreta", 75.0);
        pathCost.put("Mehadia,Lugoj", 70.0);
        pathCost.put("Neamt,Iasi", 87.0);
        pathCost.put("Oradea,Sibiu", 151.0);
        pathCost.put("Oradea,Zerind", 71.0);
        pathCost.put("Pitesti,Bucharest", 101.0);
        pathCost.put("Pitesti,Craiova", 138.0);
        pathCost.put("Pitesti,RimnicuVilcea", 97.0);
        pathCost.put("RimnicuVilcea,Pitesti", 97.0);
        pathCost.put("RimnicuVilcea,Craiova", 146.0);
        pathCost.put("RimnicuVilcea,Sibiu", 80.0);
        pathCost.put("Sibiu,Fagaras", 99.0);
        pathCost.put("Sibiu,RimnicuVilcea", 80.0);
        pathCost.put("Sibiu,Arad", 140.0);
        pathCost.put("Sibiu,Oradea", 151.0);
        pathCost.put("Timisoara,Arad", 118.0);
        pathCost.put("Timisoara,Lugoj", 111.0);
        pathCost.put("Urziceni,Vaslui", 142.0);
        pathCost.put("Urziceni,Hirsova", 98.0);
        pathCost.put("Urziceni,Bucharest", 85.0);
        pathCost.put("Vaslui,Urziceni", 142.0);
        pathCost.put("Vaslui,Iasi", 92.0);
        pathCost.put("Zerind,Oradea", 71.0);
        pathCost.put("Zerind,Arad", 75.0);

        straightLineCost = new HashMap<>();
        straightLineCost.put("Arad", 366.0);
        straightLineCost.put("Bucharest", 0.0);
        straightLineCost.put("Craiova", 160.0);
        straightLineCost.put("Dobreta", 242.0);
        straightLineCost.put("Eforie", 161.0);
        straightLineCost.put("Fagaras", 178.0);
        straightLineCost.put("Giurgiu", 77.0);
        straightLineCost.put("Hirsova", 151.0);
        straightLineCost.put("Iasi", 226.0);
        straightLineCost.put("Lugoj", 244.0);
        straightLineCost.put("Mehadia", 241.0);
        straightLineCost.put("Neamt", 234.0);
        straightLineCost.put("Oradea", 380.0);
        straightLineCost.put("Pitesti", 98.0);
        straightLineCost.put("RimnicuVilcea", 193.0);
        straightLineCost.put("Sibiu", 253.0);
        straightLineCost.put("Timisoara", 329.0);
        straightLineCost.put("Urziceni", 80.0);
        straightLineCost.put("Vaslui", 199.0);
        straightLineCost.put("Zerind", 374.0);
    }

    @Override
    public Node<String> get(String state) {
        return new Node<String>(null, "start", state, 0, 0);
    }

    @Override
    public boolean isGoal(Node<String> node) {
        return node.getState() == "Bucharest";
    }

    @Override
    public List<Node<String>> children(Node<String> current) {
        List<Node<String>> list = new ArrayList<>();

        List<String> stateList = children.get(current.getState());

        if (stateList == null) {
            return new ArrayList<Node<String>>();
        }

        stateList.forEach(state -> {
            double g = current.getGValue() + pathCost.get(current.getState() + "," + state);
            double h = straightLineCost.get(state);

            list.add(new Node<String>(current, "Travel", state, g, h));
        });

        return list;
    }

}
