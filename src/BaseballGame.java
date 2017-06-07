import java.util.*;
import java.awt.*;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int swing = 0;
        System.out.print("Welcome to Probability Baseball!\nTo play, enter numbers into the console.\nCan you beat the computer?\n\n");
        Batting bat = new Batting(swing);
        bat.normalPitch();
        while (!bat.normalPitch().equals("Out!") || !bat.normalPitch().equals("Single!") || !bat.normalPitch().equals("Double!")
            || !bat.normalPitch().equals("Triple!") || !bat.normalPitch().equals("Home Run!") || !bat.normalPitch().equals("Walk!")) {
            bat.normalPitch();

        }
    }
}