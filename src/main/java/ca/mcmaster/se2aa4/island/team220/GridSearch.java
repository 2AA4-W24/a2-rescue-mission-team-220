package ca.mcmaster.se2aa4.island.team220;

public class GridSearch implements ISearchAlgorithm {

    @Override
    public void searchArea() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'determineDecision'");
    }


    /*Gridsearch Algorithm: Assume we're facing Island
     * 1. While SITE not found:
     * 2. loop scan & fly, until SCAN = OCEAN
     * 3. echo left & fly, until echo left = OCEAN
     * 4. heading left x2
     * 5. echo straight
     * 6. if echo straight = LAND -> repeat steps 2-5
     * 7. elif echo straight = OCEAN -> heading right x3
     * from here, the next steps are similar to steps 2-4, except instead of 'left', we use 'right'
     * 8. loop scan & fly, until SCAN = OCEAN
     * 9. echo right & fly, until echo right = OCEAN
     * 10. heading right x2
     * 
     * If at any point scan = SITE, stop search and return home
    */


    /* FindIsland Algorithm:
     * While Island not found:
     * echo straight (depends on heading)
     * if echo straight = island found -> fly there (# of fly commands = # of range tiles)
     * else, continue
     * echo right (depends on heading)
     * if echo right = island found -> heading right (depends on heading), fly there
     * else, continue
     * echo left (depends on heading)
     * if echo left = island found -> heading left (depends on heading), fly there
     * else, continue
     * fly straight (if island not found after one round of echoing in all directions)
    */

}
