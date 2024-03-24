package ca.mcmaster.se2aa4.island.team220;

import org.json.JSONObject;
import scala.Int;

public class Drone {

    private Integer battery;
    private Compass compass;

    public Drone(Integer battery, Direction heading) {
        this.battery = battery;
        this.compass = new Compass(heading);
    }

    public Integer getBattery() {
        return this.battery;
    }

    public void updateBattery(Integer drain) {
        this.battery -= drain;
    }

    public Direction getHeading() {
        return this.compass.getHeading();
    }

    public Direction getPrevHeading() { return  this.compass.getPrevHeading(); }
    public Direction getInitialHeading() { return this.compass.getInitialHeading(); }

    public String echoRight() {
        JSONObject decision = new JSONObject();
        JSONObject parameters = new JSONObject();

        decision.put("action", "echo");
        decision.put("parameters", parameters.put("direction", "" + this.compass.getRight()));

        return decision.toString();
    }

    public String echoLeft() {
        JSONObject decision = new JSONObject();
        JSONObject parameters = new JSONObject();

        decision.put("action", "echo");
        decision.put("parameters", parameters.put("direction", "" + this.compass.getLeft()));

        return decision.toString();
    }

    public String echoForward() {
        JSONObject decision = new JSONObject();
        JSONObject parameters = new JSONObject();

        decision.put("action", "echo");
        decision.put("parameters", parameters.put("direction", "" + this.getHeading()));

        return decision.toString();
    }

    public String scan() {
        JSONObject decision = new JSONObject();
        decision.put("action", "scan");
        return decision.toString();
    }

    public String fly() {
        JSONObject decision = new JSONObject();
        decision.put("action", "fly");
        this.compass.updatePrevHeading();
        return decision.toString();
    }

    public String turnLeft() {
        JSONObject decision = new JSONObject();
        JSONObject parameters = new JSONObject();

        decision.put("action", "heading");
        decision.put("parameters", parameters.put("direction", "" + this.compass.turnLeft()));

        return decision.toString();
    }

    public String turnRight() {
        JSONObject decision = new JSONObject();
        JSONObject parameters = new JSONObject();

        decision.put("action", "heading");
        decision.put("parameters", parameters.put("direction", "" + this.compass.turnRight()));

        return decision.toString();
    }

    public String stop() {
        JSONObject decision = new JSONObject();
        decision.put("action", "stop");
        return decision.toString();
    }

}
