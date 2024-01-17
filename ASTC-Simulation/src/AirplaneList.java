import java.util.List;;

public class AirplaneList {
    private List<Airplane> airplanes;

    public AirplaneList(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    public void removeAirplane(Airplane airplane) {
        airplanes.remove(airplane);
    }

    public void display() {
        for (Airplane airplane : airplanes) {
            airplane.display();
        }
    }
}
