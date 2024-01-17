
public class AirplaneTest {
    public static void main(String[] args) {
      
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "E", 2);
        graph.addEdge("D", "F", 6);
        graph.addEdge("E", "F", 3);
        

        

        String initialPosition = "A";
        String destination = "F";
        Airplane airplane = new Airplane("Plane1", initialPosition, destination, graph);

        
        airplane.move(null);

        System.out.println("Flight details:");
        System.out.println("Start Position: " + initialPosition);
        System.out.println("Destination: " + destination);
        System.out.println("Total Cost: " + airplane.getTotalCost());
        System.out.println("Reached Destination: " + airplane.isReachDestination());
        System.out.println("Flight Duration: " + (airplane.getEndTime() - airplane.getStartTime()) + " milliseconds");
    }
}
