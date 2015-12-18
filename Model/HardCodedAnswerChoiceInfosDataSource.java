//package alphabetgame.models;

import java.util.ArrayList;

public class HardCodedAnswerChoiceInfosDataSource {

    public HardCodedAnswerChoiceInfosDataSource() {

    }

    public static ArrayList<AnswerChoiceInfo> getHardCodedWordChoices(DifficultyAndAlphabetsInfo info) {
        ArrayList<AnswerChoiceInfo> answerChoiceInfos = new ArrayList<AnswerChoiceInfo>();
        System.out.println(info.difficulty);
        if (info.difficulty == DifficultyAndAlphabetsInfo.Difficulty.Level1) {
            answerChoiceInfos.add(new AnswerChoiceInfo('A', 0, "Ant", "Cat", "Egg"));
            answerChoiceInfos.add(new AnswerChoiceInfo('C', 1, "Bus", "Cat", "Egg"));
            answerChoiceInfos.add(new AnswerChoiceInfo('E', 2, "Bus", "Dog", "Egg"));
            answerChoiceInfos.add(new AnswerChoiceInfo('B', 2, "Dog", "Ant", "Bus"));
            answerChoiceInfos.add(new AnswerChoiceInfo('D', 1, "Cat", "Dog", "Ant"));
        } else if (info.difficulty == DifficultyAndAlphabetsInfo.Difficulty.Level2){
            answerChoiceInfos.add(new AnswerChoiceInfo('I', 2, "Frog", "Horse", "Ice cream"));
            answerChoiceInfos.add(new AnswerChoiceInfo('F', 0, "Frog", "Horse", "Jungle"));
            answerChoiceInfos.add(new AnswerChoiceInfo('H', 1, "Good", "Horse", "Jungle"));
            answerChoiceInfos.add(new AnswerChoiceInfo('J', 0, "Jungle", "Good", "Ice cream"));
            answerChoiceInfos.add(new AnswerChoiceInfo('G', 1, "Frog", "Good", "Ice cream"));
        } else if (info.difficulty == DifficultyAndAlphabetsInfo.Difficulty.Level3){
            answerChoiceInfos.add(new AnswerChoiceInfo('L', 1, "Kangaroo", "Ladybug", "Nest"));
            answerChoiceInfos.add(new AnswerChoiceInfo('O', 2, "Ladybug", "Nest", "Orange"));
            answerChoiceInfos.add(new AnswerChoiceInfo('M', 0, "Monkey", "Orange", "Ladybug"));
            answerChoiceInfos.add(new AnswerChoiceInfo('K', 0, "Kangaroo", "Monkey", "Orange"));
            answerChoiceInfos.add(new AnswerChoiceInfo('N', 2, "Kangaroo", "Monkey", "Nest"));
        } else if (info.difficulty == DifficultyAndAlphabetsInfo.Difficulty.Level4){
            answerChoiceInfos.add(new AnswerChoiceInfo('T', 0, "Train", "Quarter", "Square"));
            answerChoiceInfos.add(new AnswerChoiceInfo('R', 2, "Train", "Quarter", "Rainbow"));
            answerChoiceInfos.add(new AnswerChoiceInfo('P', 1, "Train", "Penguin", "Rainbow"));
            answerChoiceInfos.add(new AnswerChoiceInfo('S', 2, "Penguin", "Rainbow", "Square"));
            answerChoiceInfos.add(new AnswerChoiceInfo('Q', 1, "Penguin", "Quarter", "Square"));
        } else {
            answerChoiceInfos.add(new AnswerChoiceInfo('W', 2, "Unicorn", "Yoga", "Wizard"));
            answerChoiceInfos.add(new AnswerChoiceInfo('V', 0, "Vegetable", "Zebra", "Xylophone"));
            answerChoiceInfos.add(new AnswerChoiceInfo('U', 1, "Wizard", "Unicorn", "Yoga"));
            answerChoiceInfos.add(new AnswerChoiceInfo('Z', 0, "Zebra", "Xylophone", "Vegetable"));
            answerChoiceInfos.add(new AnswerChoiceInfo('Y', 2, "Wizard", "Unicorn", "Yoga"));
            answerChoiceInfos.add(new AnswerChoiceInfo('X', 1, "Zebra", "Xylophone", "Vegetable"));
        }
        return answerChoiceInfos;
    }
}
