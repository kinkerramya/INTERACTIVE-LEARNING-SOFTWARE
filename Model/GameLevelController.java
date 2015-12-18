/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package alphabetgame.controllers;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 *
 */
public class GameLevelController {
    public GameLevelController(ArrayList<AnswerChoiceInfo> infos) {
        answerChoiceInfos = infos;
    }

    public void showChooseGameLevelFrame(JFrame parentFrame) {
        GameLevelFrame.DismissGameLevelPanelListener listener = new GameLevelFrame.DismissGameLevelPanelListener() {
            public void didDismissGameLevelFrame(GameLevelFrame panel) {
                gameLeveFrame = null; // Deallocate
            }
        };
        tts = new TTS();
        
        gameLeveFrame = new GameLevelFrame(answerChoiceInfos, listener, tts);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                gameLeveFrame.toFront();
                gameLeveFrame.repaint();
            }
        });
    }
    
    public TTS tts;
    public ArrayList<AnswerChoiceInfo> answerChoiceInfos;
    public LearningWordsDialog learningWordsDialog;
    public GameLevelFrame gameLeveFrame;
}
