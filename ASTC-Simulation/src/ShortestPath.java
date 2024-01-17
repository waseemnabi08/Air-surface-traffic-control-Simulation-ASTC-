import java.util.*;

public class ShortestPath {
    private final Map<String, Map<String, Integer>> adjacencyMap;

    public ShortestPath(Graph graph) {
        adjacencyMap = graph.getAdjacencyMap();
    }




    public int shortestDistance(String source, String destination) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (String vertex : adjacencyMap.keySet()) {
            if (vertex.equals(source)) {
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

        return distances.get(destination);
    }

    public List<String> shortestPath(String source, String destination) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (String vertex : adjacencyMap.keySet()) {
            if (vertex.equals(source)) {
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

        List<String> path = new ArrayList<>();
        String current = destination;
        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }

        return path;
    }

    


}
