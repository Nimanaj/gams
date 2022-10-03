package task2;

import java.util.Scanner;
import task2.model.*;
import task2.steps.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
                
        System.out.println("Do u want to play? (yes) (no)");
        String likePlay = scan.nextLine();

        if(likePlay.equals("yes")){
            while(true){

                SnakeGame gameOne = new SnakeGame();
                Steps gameTwo = new Steps();

                System.out.println("Choose a game to play: \n (1) Snake, \n (2) Step, \n do u want to 'leave'.");
                String chose =  scan.nextLine();
                if (chose.equals("1")) {
                    while (gameOne.isRunning()) { 
                        System.out.print("Use the following keys to move: \n w for " + gameOne.getUpLabel() + " \n s for " + gameOne.getDownLabel() + "\n a for " + gameOne.getLeftLabel() + "\n d for " + gameOne.getRightLabel() + "\n");
                        System.out.print(gameOne.getGameState()+ "\n");
                        String move = scan.nextLine();
                        if (move.equals( "w")) {
                            gameOne.pressUpButton();
                        } else if(move.equals("a")) {
                            gameOne.pressLeftButton();
                        } else if(move.equals("s")) {
                            gameOne.pressDownButton();
                        } else if(move.equals("d")) {
                            gameOne.pressRightButton();
                        }else{
                            System.out.print("This is not one of the keys. Try again: \n");
                        } 
                        System.out.println("\n");  
                    }
                }else if (chose.equals("2")) {
                    while (gameTwo.isRunning()) { 
                        System.out.println("Use the following keys to move: \n w for " + gameOne.getUpLabel() + " \n s for " + gameOne.getDownLabel() + "\n a for " + gameOne.getLeftLabel() + "\n d for " + gameOne.getRightLabel() + "\n x " + gameTwo.getALabel());

                        System.out.println(gameTwo.getGameState()+ "\n");
                        String move = scan.nextLine();
                        if (move.equals( "w")) {
                            gameTwo.pressUpButton();
                        } else if(move.equals("a")) {
                            gameTwo.pressLeftButton();
                        } else if(move.equals("s")) {
                            gameTwo.pressDownButton();
                        } else if(move.equals("d")) {
                            gameTwo.pressRightButton();
                        } else if(move.equals("x")) {
                            gameTwo.pressAButton();
                        }else{
                            System.out.print("This is not one of the keys. Try again: \n");
                        } 
                        
                        System.out.println("\n");  
                    }
                } 
                else if(chose.equals("exit")){
                    System.out.print("See you next time.");
                    break;
                }
                else {
                    System.out.println("Error");
                }
            }
        }else if(likePlay.equals("no")){
            System.out.print("See you next time.");
            scan.close();
        }else{
            System.out.print("Scusi?");
        }
        
    }
}
