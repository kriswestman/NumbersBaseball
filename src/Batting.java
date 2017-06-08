import java.util.*;

public class Batting {
    int number;
    Random pitch = new Random();
    int strike;
    int foul;
    int ball;

    public Batting(int swing) {
        this.number = swing;
    }

    public String normalPitch() {
        Scanner input = new Scanner(System.in);
        System.out.print("The computer will now pitch.\nInput a number (1-25) to bat! ");
        number = input.nextInt();
        while (number > 25 || number < 1) {
            System.out.print("Input out of bounds. Try again! ");
            number = input.nextInt();
        }
        int pitch = randomPitch();
        if (pitch > 0 && pitch < 9) {
            return hit();
        }
        else if (pitch > 8 && pitch < 16) {
            System.out.println("Ball!");
            ball++;
            System.out.println("Ball count is " + ball + ".");
            if (ball == 4) {
                ball = 0;
                System.out.println("Walk!");
                return "Walk!";
            }
            return "Ball!";
        } else {
            System.out.println("Strike!");
            strike++;
            System.out.println("Strike count is " + strike + ".");
            if (strike == 3) {
                strike = 0;
                System.out.println("Out!");
                return "Out";
            } else {
                return "Strike!";
            }
        }
    }
    public int randomPitch() {
        return pitch.nextInt(24) + 1;
    }

    public String hit() {
        int randomHit = pitch.nextInt(16) + 1;
        if (randomHit <= 4) {
            System.out.println("Single!");
            return "Single!";
        } else if (randomHit > 4 && randomHit < 8) {
            System.out.println("Double!");
            return "Double!";
        } else if (randomHit == 8) {
            System.out.println("Triple!");
            return "Triple!";
        } else if (randomHit > 8 && randomHit < 11) {
            System.out.println("Home Run!");
            return "Home Run!";
        } else if (randomHit >= 11 && randomHit <= 12) {
            System.out.println("Flyout!");
            return "Flyout!";
        } else if (randomHit >= 13 && randomHit <= 14) {
            System.out.println("Groundout!");
            return "Groundout!";
        } else {
            foul++;
            if (strike < 2) {
                strike++;
                System.out.println("Foul! Strike " + strike + "!");
                return "Strike!";
            } else {
                System.out.println("Foul!");
                return "Foul!";
            }
        }
    }
}