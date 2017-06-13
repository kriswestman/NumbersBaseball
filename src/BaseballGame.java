import java.util.*;
import java.awt.*;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int swing = 0;
        int outs = 0;
        System.out.print("Welcome to Probability Baseball!\nTo play, enter numbers into the console.\nCan you beat the computer?\n\n");
        String action = "";
        int runSet = 0;
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
                int runnerOne = 0;
                int runnerTwo = 0;
                int runnerThree = 0;
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
}