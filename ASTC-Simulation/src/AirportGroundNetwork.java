import java.util.List;

public class AirportGroundNetwork {
    private List<Gate> gates;
    private List<Runway> runways;
    private List<Taxiway> taxiways;

    public AirportGroundNetwork(List<Gate> gates, List<Runway> runways, List<Taxiway> taxiways) {
        this.gates = gates;
        this.runways = runways;
        this.taxiways = taxiways;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public List<Taxiway> getTaxiways() {
        return taxiways;
    }

    public void addGate(Gate gate) {
        gates.add(gate);
    }

    public void removeGate(Gate gate) {
        gates.remove(gate);
    }

    public void addRunway(Runway runway) {
        runways.add(runway);
    }

    public void removeRunway(Runway runway) {
        runways.remove(runway);
    }

    public void addTaxiway(Taxiway taxiway) {
        taxiways.add(taxiway);
    }

    public void removeTaxiway(Taxiway taxiway) {
        taxiways.remove(taxiway);
    }

    public void display() {
        System.out.println("Gates: ");
        for (Gate gate : gates) {
            gate.display();
        }
        System.out.println("Runways: ");
        for (Runway runway : runways) {
            runway.display();
        }
        System.out.println("Taxiways: ");
        for (Taxiway taxiway : taxiways) {
            taxiway.display();
        }
    }

    public boolean isAvailable() {
        for (Gate gate : gates) {
            if (gate.isFree()) {
                return true;
            }
        }
        for (Runway runway : runways) {
            if (!runway.isOccupied()) {
                return true;
            }
        }

        for (Taxiway taxiway : taxiways) {
            if (!taxiway.isOccupied()) {
                return true;
            }
        }

        return false;
    }

    public void updateObjectState(Object targetObject) {
        if (targetObject instanceof Gate) {
            Gate gate = (Gate) targetObject;
            gate.setFree(false);
        } else if (targetObject instanceof Runway) {
            Runway runway = (Runway) targetObject;
            runway.setOccupied(true);
        } else if (targetObject instanceof Taxiway) {
            Taxiway taxiway = (Taxiway) targetObject;
            taxiway.setOccupied(true);
        }
    }

    public void resetObjectState(Object targetObject) {
        if (targetObject instanceof Gate) {
            Gate gate = (Gate) targetObject;
            gate.setFree(true);
        } else if (targetObject instanceof Runway) {
            Runway runway = (Runway) targetObject;
            runway.setOccupied(false);
        } else if (targetObject instanceof Taxiway) {
            Taxiway taxiway = (Taxiway) targetObject;
            taxiway.setOccupied(false);
        }
    }
}