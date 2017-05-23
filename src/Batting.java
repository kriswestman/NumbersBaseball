import java.util.*;

public class Batting {
    int number;
    Random pitch = new Random();

    public Batting(int swing) {
        this.number = swing;
    }

    public String normalPitch() {
        String[] result = new String[25];
        for (int i = 0; i <= 24; i++) {
            result[i] = "Strike!";
        }
        for (int i = 1; i <= 4; i++) {
            result[randomPitch()] = "Hit!";
        }
        for (int i = 1; i <= 10; i++) {
            result[randomPitch()] = "Ball!";
        }
        if (result[number].equals("Hit!")) {
            return hit();
        } else if (result[number].equals("Ball!")) {
            System.out.println("Ball!");
            return "Ball!";
        } else {
            System.out.println("Strike!");
            return "Strike!";
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
            return foul();
        }
    }

    public String strike() {
        int strike = 0;
        if (normalPitch().equals("Strike!") || foul().equals("Foul! Strike 1!") || foul().equals("Foul! Strike 2!")) {
            strike++;
            if (strike >= 3) {
                System.out.println("Out!");
                return "Out!";
            }
        }
        return "";
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

    public String foul() {
        int foul = 0;
        foul++;
        if (foul <= 2) {
            return "Foul! Strike " + foul + "!";
        } else {
            System.out.println("Foul!");
            return "Foul!";
        }
    }
}