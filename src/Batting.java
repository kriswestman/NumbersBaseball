import java.util.*;

public class Batting {
    int number;
    Random pitch = new Random();
    int strike;
    int foul;

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
        randomPitch();
        if (randomPitch() > 0 && randomPitch() < 9) {

        }
//        String[] result = new String[26];
//        for (int i = 0; i <= 25; i++) {
//            result[i] = "Strike!";
//        }
//        for (int i = 1; i <= 8; i++) {
//            result[randomPitch()] = "Hit!";
//        }
//        for (int i = 1; i <= 8; i++) {
//            result[randomPitch()] = "Ball!";
//        }
//
//
//        if (result[number].equals("Hit!")) {
//            return hit();
//        } else if (result[number].equals("Ball!")) {
//            walk();
//            System.out.println("Ball!");
//            return "Ball!";
//        } else {
//            System.out.println("Strike!");
//            strike++;
//            if (strike == 3) {
//                return "Out";
//            } else {
//                return "Strike!";
//            }
//        }
//    }
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
                if (strike == 3) {
                    return "Out";
                } else {
                    return "Foul! Strike!";
                }
            } else {
                return "Foul!";
                }
        }
    }

    public String walk() {
        int walk = 0;
        if (normalPitch().equals("Ball!")) {
            walk++;
            if (walk == 3) {
                System.out.println("Walk!");
                return "Walk!";
            }
        }
        return "";
    }
}