package task2.steps;

import task2.model.GameInterface;

/**
 * This class generates the playing field of our second game.
 * It also handles the player movement.
 * 
 * @author Schirin Bub
 * @version 23.05.22
 */
public class Steps implements GameInterface{

    private static final int width = 20;
    private static final int height = 20;
    private static final int coin_count = 20;
    private static final int wall_count = 40;

    String grid[][] = new String[width][height];
    String gridCopy[][] = new String[width][height];

    private int coins = 0;
    private int steps = 10;
    String player = "o";

    int pX = 0;
    int pY = 0;

    /**
     * This method gets the collected coins.
     * @return collected coins.
     */
    public int getCoins(){
        return coins;
    }

    /**
     * This method generates random player coordinates.
     */
    private void createPlayerCoordinates(){
        pX = (int) (Math.random() * width);
        pY = (int) (Math.random() * height);
    }


    public Steps(){
        createWorld();
        createPlayerCoordinates();
        grid[pX][pY] = player;
    }

    /**
     * This method generates the playing field of the game.
     */
    private String[][] createWorld(){
        //Ground
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = " ";
                gridCopy[i][j] = " ";
            }
        }
        //Walls
        for (int i = 0; i < wall_count; i++)
        {
            int posX = (int) (Math.random() * width);
            int posY = (int) (Math.random() * height);
            grid[posX][posY] = "#";
            gridCopy[posX][posY] = "#";
        }
        //Coins    
        for (int i = 0; i < coin_count; i++)
        {
            int posX = (int) (Math.random() * width);
            int posY = (int) (Math.random() * height);
            grid[posX][posY] = ".";
            gridCopy[posX][posY] = ".";
        }
        return grid;
        
    }


    /**
     * This method puts the playing field into a string, so it can be printed.
     * It also prints the current amount of collected coins plus the steps the player has left.
     */
    @Override
    public String getGameState() {

        //so the playing field is overwritten and not printed new each time
        StringBuilder sb = new StringBuilder();

        if (isRunning()) {
            //Border
            for (int i = 0; i < width + 2; i++){
                sb.append("#");
            }

            sb.append("\n");

            for (int i = 0; i < height; i++){
                sb.append("#");
                for (int j = 0; j < width; j++){
                    sb.append(grid[i][j]);
                }
                sb.append("#\n");
            }

            for (int i = 0; i < width + 2; i++){
                sb.append("#");
            }
            sb.append("\n");
            System.out.println(steps);
            System.out.println("collected coins: " + getCoins());
            return sb.toString();
        } else {
            return "You lost!";
        }
        
    }

    /**
     * This method decides what happens when the player moves, reaches a wall or
     * steps on a coin.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    private void movePlayer(int x, int y){
        steps -= 1;

        if (grid[pX][pY] == "#"){
            grid[pX][pY] = player;
        }else {
            if(gridCopy[pX][pY] == "."){
                grid[pX][pY] = ".";
                pX += x;
                pY += y;
                grid[pX][pY] = player;
            }else{
                grid[pX][pY] = " ";
                pX += x;
                pY += y;
                grid[pX][pY] = player;
            }
            
        }
    }

    /**
     * Moves the player -1 on height
     */    
    @Override
    public void pressUpButton() {
        movePlayer(-1, 0);
        
    }

    /**
     * Moves the player +1 on height
     */    
    @Override
    public void pressDownButton() {
        movePlayer(1, 0);
        
    }

    /**
     * Moves the player -1 on width
     */  
    @Override
    public void pressLeftButton() {
        movePlayer(0, -1 );
        
    }


    /**
     * Moves the player +1 on width
     */  
    @Override
    public void pressRightButton() {
        movePlayer(0, 1);
        
    }


    /**
     * Resets the tile to nothing if a coin is collected
     */  
    @Override
    public void pressAButton() {
        if(gridCopy[pX][pY] == "."){
            //Reset steps to 10 after collecting
            steps = 10;
            coins ++;
            gridCopy[pX][pY] = " ";
        }
    }

    /**
     * Not used in this game.
     * @return nothing.
     */  
    @Override
    public void pressBButton() {
        return;
        
    }

    /**
     * Return the label for the UP button
     */  
    @Override
    public String getUpLabel() {
        return "Up";
    }


    /**
     * Return the label for the DOWN button
     */ 
    @Override
    public String getDownLabel() {
        return "Down";
    }

    /**
     * Return the label for the LEFT button
     */ 
    @Override
    public String getLeftLabel() {
        return "Left";
    }


    /**
     * Return the label for the RIGHT button
     */ 
    @Override
    public String getRightLabel() {
        return "Right";
    }


    /**
     * Return the label for the A button
     */ 
    @Override
    public String getALabel() {
        return "to collect coins";
    }

    /**
     * Return the label for the B button
     */ 
    @Override
    public String getBLabel() {
        return "B (not used)";
    }

    /**
     * This method returns false when step reaches 0, because that is when the player lost.
     * @return true
     */ 
    @Override
    public boolean isRunning() {
        if(steps == 0){
            return false;
        }
        return true;
    }
    
}
