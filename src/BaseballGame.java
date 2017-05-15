import java.util.*;
import java.awt.*;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int strike = 0;
        int swing = 0;
        System.out.print("Welcome to Probability Baseball!\nTo play, enter numbers into the console.\nCan you beat the computer?\n\n");
        Batting bat = new Batting();
        System.out.print("The computer will now pitch.\nInput a number (1-25) to bat! ");
        if (swing <= 25) {
            swing = console.nextInt();
        } while (swing > 25) {
            System.out.print("Input out of bounds. Try again! ");
            swing = console.nextInt();
        }
        while (!bat.strike().equals("Out!") || !bat.normalPitch().equals("Single!") || !bat.normalPitch().equals("Double!")
                || !bat.normalPitch().equals("Triple!") || !bat.normalPitch().equals("Home Run!") || !bat.normalPitch().equals("Walk!")) {
            bat.normalPitch();

        }
    }
}