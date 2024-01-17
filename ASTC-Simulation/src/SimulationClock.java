import java.time.LocalTime;

public class SimulationClock {
    private LocalTime time;

    public SimulationClock() {
        this.time = LocalTime.of(0, 0);
    }

    public void tick() {
        this.time = this.time.plusMinutes(1);
    }

    public LocalTime getTime() {
        return this.time;
    }
}
