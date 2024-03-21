package ca.mcmaster.se2aa4.island.team220;

import static eu.ace_design.island.runner.Runner.run;

import java.io.File;

public class Runner { // Runner is the Main class

    public static void main(String[] args) {
        String filename = args[0]; // where we get the map argument
        try {
            run(Explorer.class) // then we run the whole Explorer class (aka Command Centre gets the map for the mission)
                    .exploring(new File(filename))
                    .withSeed(42L)
                    .startingAt(1, 1, "EAST")
                    .backBefore(20000) // Original: 7000
                    .withCrew(5)
                    .collecting(1000, "WOOD")
                    .storingInto("./outputs")
                    .withName("Island")
                    .fire();
        } catch(Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

}
