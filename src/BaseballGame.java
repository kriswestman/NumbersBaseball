import java.util.*;
import java.awt.*;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int swing = 0;
        int outs = 0;
        System.out.print("Welcome to Probability Baseball!\nTo play, enter numbers into the console.\nCan you beat the computer?\n\n");
        String action = "";
        while (outs < 3) {
            action = atBat(outs, action);
            if (action == "Out" || action == "Groundout!" || action == "Flyout!") {
                outs++;
                if (outs == 1) {
                    System.out.println(outs + " out!");
                } else {
                    System.out.println(outs + " outs!");
                }
            }
        }
        /*while (!bat.normalPitch().equals("Out!") || !bat.normalPitch().equals("Single!") || !bat.normalPitch().equals("Double!")
            || !bat.normalPitch().equals("Triple!") || !bat.normalPitch().equals("Home Run!") || !bat.normalPitch().equals("Walk!")) {
            System.out.println("before");
            //bat.normalPitch();
            System.out.println("past");
        }*/
        System.out.println("test run");
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