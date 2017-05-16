import java.util.*;

public class Batting {
    int number;
    Random pitch = new Random();

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
        if(result[number] == "Hit!") {
            return hit();
        } else if (result[number] == "Ball!") {
            return "Ball!";
        } else {
            return "Strike!";
        }
    }

    public int randomPitch() {
        return pitch.nextInt(25) + 1;
    }

    public String hit() {
        int randomHit = pitch.nextInt(10) + 1;
        if (randomHit <= 4) {
            return "Single!";
        } else if (randomHit < 8) {
            return "Double!";
        } else if (randomHit == 8) {
            return "Triple!";
        } else {
            return "Home Run!";
        }
    }

    public String strike() {
        int strike = 0;
        if (normalPitch().equals("Strike!")) {
            strike++;
            if (strike == 3) {
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
                return "Walk!";
            }
        }
        return "";
    }
}
