import java.util.ArrayList;
import java.util.Scanner;


public class Gate {
    private String id;
    private GateState state;
    private ArrayList<Airplane> airplanes;

    public Gate(String id, GateState state) {
        this.id = id;
        this.state = state;
        airplanes = new ArrayList<>();
    }

    public Gate(String id, Point position) {
        this(id, GateState.EMPTY);
    }

    public Gate(String id) {
        this(id,  GateState.EMPTY);
    }

    public Gate() {
        this("00", GateState.EMPTY);
    }

   

    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    public void removeAirplane(Airplane airplane) {
        airplanes.remove(airplane);
    }

    public void display() {
        System.out.println("Gate ID: " + id);
        System.out.println("Gate Position: ");
        System.out.println("Gate State: " + state);
        System.out.println("Airplanes: ");
        for (Airplane airplane : airplanes) {
            System.err.println("AirplaneP: " + airplane);
        }
    }

    public void input(Scanner scanner) {
        System.out.println("Enter Gate ID: ");
        id = scanner.nextLine();
        System.out.println("Enter Gate Position: ");
        System.out.println("Enter x: ");
        int x = scanner.nextInt();
        System.out.println("Enter y: ");
        int y = scanner.nextInt();
        new Point(x, y);
        System.out.println("Enter Gate State: ");
        state = GateState.valueOf(scanner.next());
    }
    public void update(Scanner scanner) {
        input(scanner); // Reusing the input method for updating
    }

    public boolean isFree() {
        return state == GateState.EMPTY;
    }

    public boolean isOccupied() {
        return state == GateState.OCCUPIED;
    }

    public void setFree(boolean b) {
        if (b) {
            state = GateState.EMPTY;
        } else {
            state = GateState.OCCUPIED;
        }
    }
}


