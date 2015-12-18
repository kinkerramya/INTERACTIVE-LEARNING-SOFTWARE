
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AlphabetGameController {
    
    public static void main(String[] args) {
        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AlphabetGameController gameController = new AlphabetGameController();
                //gameController.showChooseGameLeveFrame(); // entrance for ChooseGameLevelFrame
                gameController.showGameLevelFrame(0);
            }
        });
    }
    
    ChooseGameLevelFrame chooseGameLeveFrame;
    DifficultyAndAlphabetsInfo selectedDifficultyAndAlphabetsInfo;

    public AlphabetGameController() {

    }

    public void showChooseGameLeveFrame() {
        ChooseGameLevelFrame.SelectGameLevelListener selectGameLevelListener = new ChooseGameLevelFrame.SelectGameLevelListener() {
            public void didSelectGameLevel(final DifficultyAndAlphabetsInfo difficultyAndAlphabetsInfo) {
                selectedDifficultyAndAlphabetsInfo = difficultyAndAlphabetsInfo;
                DidDismissViewListener dismissViewListener = new DidDismissViewListener() {
                    @Override
                    public void didDismissView() {
                        showLearningWordsDialog();
                    }
                };
                // Ask user to confirm before starting a new game
                StartGameLevelDialog dialog = new StartGameLevelDialog(chooseGameLeveFrame, dismissViewListener);
                dialog.setVisible(true);
            }
        };
        chooseGameLeveFrame = new ChooseGameLevelFrame(selectGameLevelListener);
        chooseGameLeveFrame.setVisible(true);
    }
    
    public void showLearningWordsDialog() {
        DidDismissViewListener listener = new DidDismissViewListener() {
            @Override
            public void didDismissView() {
                showGameLevelFrame();
            }
        };
        LearningWordsDialog learningWordsDialog = new LearningWordsDialog(chooseGameLeveFrame, listener);
        learningWordsDialog.setVisible(true);
    }
    
    public void showGameLevelFrame() {
        ArrayList<AnswerChoiceInfo> answerChoiceInfos = HardCodedAnswerChoiceInfosDataSource.getHardCodedWordChoices(selectedDifficultyAndAlphabetsInfo);
        GameLevelController gameLevelController = new GameLevelController(answerChoiceInfos);
        gameLevelController.showChooseGameLevelFrame(chooseGameLeveFrame);
    }
    
    public void showGameLevelFrame(int i) {
        DifficultyAndAlphabetsInfo difficultyInfo = new DifficultyAndAlphabetsInfo();
        difficultyInfo.difficulty = DifficultyAndAlphabetsInfo.getDifficultyFromTableRowIndex(i);
        ArrayList<AnswerChoiceInfo> answerChoiceInfos = HardCodedAnswerChoiceInfosDataSource.getHardCodedWordChoices(difficultyInfo);
        GameLevelController gameLevelController = new GameLevelController(answerChoiceInfos);
        gameLevelController.showChooseGameLevelFrame(chooseGameLeveFrame);
    }
}
