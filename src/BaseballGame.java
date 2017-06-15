import java.util.*;
import java.awt.*;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int swing = 0;
        int outs = 0;
        System.out.print("Welcome to Probability Baseball!\nTo play, enter numbers into the console.\nCan you beat the computer?\n\n");
        String action = "";
        int inning = 1;
        boolean tie = false;
        int computer = 0;
        int player = 0;
        while (inning <= 3 || tie) {
            System.out.println("Inning #" + inning + "!");
            Baserunning run = new Baserunning();
            outs = 0;
            while (outs < 3) {
                action = atBat(outs, action);
                if (action == "Out" || action == "Groundout!" || action == "Flyout!") {
                    outs++;
                    if (outs == 1) {
                        System.out.println(outs + " out!");
                    } else {
                        System.out.println(outs + " outs!");
                    }
                } else {
//baserunning stuff here, using our input from the action variable
                    int add = 0;
                    if (action == "Single!") {
                        add = run.single();
                    } else if (action == "Double!") {
                        add = run.dub();
                    } else if (action == "Triple!") {
                        add = run.triple();
                    } else {
                        add = run.homer();
                    }
                    if (add > 0) {
                        System.out.println("You score" + add);
                        player = player + add;
                        add = 0;
                    }
                }
            }
            int counter = computer;
            computer = randomScore(computer);
            int change = computer - counter;
            System.out.println("Computer scores " + change + "! \nScore: You: " + player + " CPU: " + computer);
            if (computer == player) {
                tie = true;
            } else {
                tie = false;
            }
            inning++;
        }
    }

    //completes one atBat, calling the batting class, returning the action as a string
    public static String atBat(int outs, String action) {
        boolean test = true;
        int swing = 0;
        Batting bat = new Batting(swing);
        action = bat.normalPitch();
        while (test) {
            test = true;
            if (action != "Ball!" && action != "Strike!") {
                test = false;
            } else {
                action = bat.normalPitch();
            }
        }
        return action;
    }

    public static int randomScore(int oldScore) {
        Random score = new Random();
        int random = score.nextInt(10);
        if (random < 2) {
            return oldScore;
        } else if (random < 4) {
            return oldScore + 1;
        } else if (random < 6) {
            return oldScore + 2;
        } else if (random < 8) {
            return oldScore + 3;
        } else if (random < 9) {
            return oldScore + 4;
        } else {
            return oldScore + 5;
        }

    }
}