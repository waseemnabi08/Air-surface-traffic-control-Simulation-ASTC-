import java.util.List;


 enum State {
    MOVE, HOLD, PARK;

    public boolean isCompatibleWith(ActionType actionType) {
        switch (actionType) {
            case MOVE:
                return true;
            case HOLD:
                return true;
            case PARK:
                return this == PARK;
            default:
                return false;
        }
    }
}




public class Airplane {
    private String ID;
    private String orientation;
    private String destination;
    private double totalCost;
    private boolean reachDestination;
    private Graph path;
    private long startTime;
    private long endTime;
    private State state;

    public Airplane(String ID, String orientation, String destination, Graph path) {
        this.ID = ID;
        this.orientation = orientation;
        this.destination = destination;
        this.reachDestination = false;
        this.path = path;
        this.startTime = System.currentTimeMillis();
    }

    public String getID() {
        return ID;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isReachDestination() {
        return reachDestination;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void move(AirportGroundNetwork targetObject) {
      
        ShortestPath path = new ShortestPath(this.path);

        List<String> shortestPath = path.shortestPath(orientation, destination);

        for (String vertex : shortestPath) {
            String nextPosition = vertex;
            orientation = nextPosition;
            totalCost += calculateCost(nextPosition);
            System.out.println("Moving to: " + nextPosition);

            if (nextPosition.equals(destination)) {
                reachDestination = true;
                endTime = System.currentTimeMillis();
                System.out.println("Reached");
                break;
            }
        }


    }

    public void stop() {
        System.out.println("Airplane has successfully stopped.");
        reachDestination = false;
        
    }

    public void setPath(Graph path) {
        this.path = path;
    }

    public String getNextPosition() {
        return path.getNextVertex(orientation, destination);
    }
    
    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

   
    private double calculateCost(String nextPosition) {
        ShortestPath shortestPath = new ShortestPath(path);
        double distance = shortestPath.shortestDistance(orientation, destination);
        return distance * 0.1;
    }
/*
    private String convertPointToVertex(Point point) {
        // Placeholder code, adapt based on your implementation
        return "V" + point.getX() + "_" + point.getY();
    }

    private Point convertVertexToPoint(String vertex) {
        // Placeholder code, adapt based on your implementation
        String[] coordinates = vertex.substring(1).split("_");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        return new Point(x, y);
    }
*/

    public void display() {
        System.out.println("Airplane details:");
        System.out.println("ID: " + ID);
        System.out.println("Orientation: " + orientation);
        System.out.println("Destination: " + destination);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Reached Destination: " + reachDestination);
        System.out.println("Flight Duration: " + (endTime - startTime) + " milliseconds");
    }

   public void hold() {
        System.out.println("Airplane is holding.");
    }

    public void parkAt(AirportGroundNetwork targetObject) {
        System.out.println("Airplane is parking at " + targetObject);
    }

    
}
