package ca.mcmaster.se2aa4.island.team220;

import org.json.JSONObject;

public class GridSearch implements IDecisionHandler {

    @Override
    public void determineDecision(AreaMap map, Drone drone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'determineDecision'");

        //--------------------------------------------------------------------------------------------------------

        JSONObject decision = new JSONObject();
        JSONObject parameters = new JSONObject();    
        
        boolean islandFound = false;

        if (islandFound == false) {
        decision.put("action", "echo");
        decision.put("parameters", parameters.put("direction", "E"));
            
            
        }

        
        while (true) {
            if (islandFound == false) {
                decision.put("action", "echo");
                decision.put("parameters", parameters.put("direction", "E"));
                break;
            } 

            /*
            translator.processEcho(decision);
            if (translator.found == "found") {
                logger.info("The island has been found up North!");
                decision.put("action", "fly");
            }
            break;
            decision.put("action", "echo");
            decision.put("parameters", parameters.put("direction", "E"));
            if (translator.found == "found") {
                logger.info("The island has been found to the right!");
                break;
            }
            decision.put("action", "echo");
            decision.put("parameters", parameters.put("direction", "W"));
            if (translator.found == "found") {
                logger.info("The island has been found to the left!");
                break;
            }
            decision.put("action", "fly");
            */
        }
    //--------------------------------------------------------------------------------------------------------
    }
    
}
