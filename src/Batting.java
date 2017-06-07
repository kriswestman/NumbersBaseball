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
            if (ball == 4) {
                ball = 0;
                return "Walk!";
            }
            return "Ball!";
        } else {
            System.out.println("Strike!");
            strike++;
            if (strike == 3) {
                return "Out";
            } else {
                strike = 0;
                return "Strike!";
            }
        }
    }
    public int randomPitch() {
        return pitch.nextInt(24) + 1;
    }

    public String hit() {
        int randomHit = pitch.nextInt(12) + 1;
        if (randomHit <= 4) {
            System.out.println("Single!");
            return "Single!";
        } else if (randomHit > 4 && randomHit < 8) {
            System.out.println("Double!");
            return "Double!";
        } else if (randomHit == 8) {
            System.out.println("Triple!");
            return "Triple!";
        } else if (randomHit > 8 && randomHit < 11){
            System.out.println("Home Run!");
            return "Home Run!";
        } else {
            System.out.println("Foul!");
            foul++;
            if (foul > 3) {
                strike++;
                return "Foul! Strike!";
            } else {
                return "Foul!";
            }
        }
    }
}