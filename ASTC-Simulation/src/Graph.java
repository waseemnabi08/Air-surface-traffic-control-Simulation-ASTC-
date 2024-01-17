import java.util.*;

public class Graph {
    private Map<String, Map<String, Integer>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyMap.put(vertex, new HashMap<>());
    }

    public void addEdge(String source, String destination, int weight) {
        if (!adjacencyMap.containsKey(source) || !adjacencyMap.containsKey(destination)) {
            throw new IllegalArgumentException("Vertex does not exist");
        }
        adjacencyMap.get(source).put(destination, weight);
        adjacencyMap.get(destination).put(source, weight);
    }

    public Map<String, Map<String, Integer>> getAdjacencyMap() {
        return adjacencyMap;
    }

    public String getNextVertex(String currentVertex, String destination) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (String vertex : adjacencyMap.keySet()) {
            if (vertex.equals(currentVertex)) {
                distances.put(vertex, 0);
                queue.offer(vertex);
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
            }
            previous.put(vertex, null);
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(destination)) {
                break;
            }
            for (Map.Entry<String, Integer> neighbor : adjacencyMap.get(current).entrySet()) {
                int newDistance = distances.get(current) + neighbor.getValue();
                if (newDistance < distances.get(neighbor.getKey())) {
                    distances.put(neighbor.getKey(), newDistance);
                    previous.put(neighbor.getKey(), current);
                    queue.offer(neighbor.getKey());
                }
            }
        }

        return previous.get(destination);
    }

    


}
