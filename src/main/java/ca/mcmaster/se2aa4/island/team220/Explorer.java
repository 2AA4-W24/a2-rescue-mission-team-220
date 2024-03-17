package ca.mcmaster.se2aa4.island.team220;

import java.io.StringReader;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;
import scala.annotation.tailrec;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    private Drone drone;
    private Translator translator;
    private AreaMap map;

    private String currentState = "start";

    // start
    private int startCount = 0;

    // findExtreme1Land
    private int secondCount = 0;
    private Direction turnDir = Direction.NORTH; // Make this more readable later

    // findExtreme1Water

    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject context = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n {}", context.toString(2));

        map = new AreaMap();
        translator = new Translator();

        // Initialize the drone's heading and battery level
        Direction heading = Direction.toDirection(context.getString("heading"));
        Integer batteryLevel = context.getInt("budget");
        drone = new Drone(batteryLevel, heading);

        logger.info("The drone is facing {}", drone.getHeading());
        logger.info("Battery level is {}", drone.getBattery());
    }

    @Override
    public String takeDecision() {
        switch (currentState) {

            case ("start"):

                if (this.startCount == 0) {
                    this.startCount++;
                    return this.drone.echoForward();
                } else {

                    if (map.getForward() == Direction.LAND) {
                        this.currentState = "findExtreme1Land";
                    } else {
                        this.currentState = "findExtreme1Water";
                    }

                    return this.drone.scan();
                }

            case ("findExteme1Land"):

                if (this.secondCount == 0) {

                    this.secondCount++;
                    return this.drone.echoLeft();

                } else if (this.secondCount == 1) {

                    this.secondCount++;
                    return this.drone.echoRight();

                } else if (this.secondCount == 2) {

                    Integer leftDistance = map.getLeft();
                    Integer rightDistance = map.getRight();

                    this.secondCount++;
                    if (leftDistance <= rightDistance) {
                        this.turnDir = Direction.WEST;
                        return this.drone.turnLeft();
                    } else {
                        this.turnDir = Direction.EAST;
                        return this.drone.turnRight();
                    }

                } else if (this.secondCount > 2) {

                    if (this.secondCount % 2 != 0) {
                        this.secondCount++;
                        if (this.turnDir == Direction.WEST) {
                            return this.drone.echoRight();
                        } else {
                            return this.drone.echoLeft();
                        }
                    } else {
                        this.secondCount++;
                        return this.drone.fly();
                    }
                }

        }

        // logger.info("** Decision: {}", decision.toString());

    }

    @Override
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Response received:\n" + response.toString(2));
        Integer cost = response.getInt("cost");
        logger.info("The cost of the action was {}", cost);
        String status = response.getString("status");
        logger.info("The status of the drone is {}", status);
        JSONObject extraInfo = response.getJSONObject("extras");
        logger.info("Additional information received: {}", extraInfo);
    }

    @Override
    public String deliverFinalReport() {
        return "no creek found";
    }
}
