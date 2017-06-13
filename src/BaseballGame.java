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
            Baserunning run = new Baserunning();
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

                }
            }
            computer = randomScore(computer);
            if (computer == player) {
                tie = true;
            } else {
                tie = false;
            }
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
    }
}