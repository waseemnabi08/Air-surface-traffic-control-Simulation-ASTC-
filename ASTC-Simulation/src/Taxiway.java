public class Taxiway {
    private String name;
    private int length;
    private boolean isOccupied;

    public Taxiway(String name, int length) {
        this.name = name;
        this.length = length;
        this.isOccupied = false;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void display() {
        System.out.println("Taxiway: " + name + " - Length: " + length + " - Occupied: " + isOccupied);
    }
}
