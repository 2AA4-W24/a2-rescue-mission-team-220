package ca.mcmaster.se2aa4.island.team220;

public class Drone {

    private Integer battery;
    private Direction heading;

    public Drone(Integer battery, Direction heading) {
        this.battery = battery;
        this.heading = heading;
    }

    public Integer getBattery() { return this.battery; }

    public Direction getHeading() { return this.heading; }

    // Added 19/03
    public Integer updateBattery(Integer cost) {
        this.battery -= this.battery - cost;
        return 0;
    }
    
}
