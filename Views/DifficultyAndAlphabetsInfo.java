//package alphabetgame.models;

import java.util.ArrayList;

public class DifficultyAndAlphabetsInfo {
    public ArrayList<Character> alphabets;
    public Difficulty difficulty;
    
    public static Difficulty getDifficultyFromTableRowIndex(int index) {
        switch (index) {
            case 0:
                return Difficulty.Level1;
            case 1:
                return Difficulty.Level2;
            case 2:
                return Difficulty.Level3;
            case 3:
                return Difficulty.Level4;
            case 4:
            default:
                return Difficulty.Level5;
        }
    }
    
    public enum Difficulty {
        Level1,
        Level2,
        Level3,
        Level4,
        Level5
    }
}
