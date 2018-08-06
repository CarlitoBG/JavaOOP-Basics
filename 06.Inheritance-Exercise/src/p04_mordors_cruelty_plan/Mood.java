package p04_mordors_cruelty_plan;

public class Mood {

    private static final int ANGRY = -5;
    private static final int SAD = 0;
    private static final int HAPPY = 15;

    public static String getMood(int happiness){
        if (happiness > HAPPY){
            return "JavaScript";
        }

        if (happiness > SAD){
            return "Happy";
        }

        if (happiness >= ANGRY){
            return "Sad";
        }
        return "Angry";
    }
}