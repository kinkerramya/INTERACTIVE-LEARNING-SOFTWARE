//package alphabetgame.models;

public class AnswerChoiceInfo {
    public char answerCharacter; 
    public int answerStringArrayIndex;
    public String[] choiceStrings;
    
    public AnswerChoiceInfo(char character, int answerArrayIndex, String choiceString1, String choiceString2, String choiceString3) {
        super();
        setChoicesAndAnswerIndex(character, answerArrayIndex, choiceString1, choiceString2, choiceString3);
    }
    public void setChoicesAndAnswerIndex(char character, int answerArrayIndex, String choiceString1, String choiceString2, String choiceString3) {
        answerCharacter = character;
        answerStringArrayIndex = answerArrayIndex;
        
        choiceStrings = new String[3];
        choiceStrings[0] = choiceString1;
        choiceStrings[1] = choiceString2;
        choiceStrings[2] = choiceString3;
    }
}
