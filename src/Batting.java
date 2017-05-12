/**
 * Created by ros_kjwestman on 5/12/2017.
 */
import java.util.*;

public class Batting {
    int number;
    Random pitch = new Random();

    public String normalPitch() {
        String[] result = new String[25];
        for (int i = 0; i <= 24; i++) {
            result[i] = "strike";
            for (int j = 1; j <= 4; j++) {
                result[pitch.nextInt(25) + 1] = "hit";
            }
            for (int k = 5; k <= 14; k++) {
                result[pitch.nextInt(25) + 1] = "ball";
            }
            if (result[number].equals("hit")) {
                return hit();
            } else if (result[number].equals("ball")) {
                return "ball";
            } else  {
                return "strike";
            }
        }
        return "";
    }

    public String hit() {
        int randomHit = pitch.nextInt(10) + 1;
        if(randomHit <= 4) {
            return "single";
        } else if(randomHit <= 7) {
            return "dub";
        } else if(randomHit == 8) {
            return "triple";
        } else {
            return "homeRun";
        }
    }


}
