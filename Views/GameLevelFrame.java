

import java.awt.Dimension;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class GameLevelFrame extends JFrame {

    public GameLevelFrame(ArrayList<AnswerChoiceInfo> infos, DismissGameLevelPanelListener listener, TTS tts) {
        super();
        dismissGameLevelPanelListener = listener;
        answerChoiceInfos = infos;
        this.tts = tts;

        initComponents();
        pack();

        // setup layout
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        buttonWidth = screenSize.width/4;
        choiceButton0.setSize(buttonWidth, buttonWidth);
        choiceButton1.setSize(buttonWidth, buttonWidth);
        choiceButton2.setSize(buttonWidth, buttonWidth);
        choiceButton0.setVerticalTextPosition(AbstractButton.BOTTOM);
        choiceButton0.setHorizontalTextPosition(AbstractButton.CENTER);
        choiceButton1.setVerticalTextPosition(AbstractButton.BOTTOM);
        choiceButton1.setHorizontalTextPosition(AbstractButton.CENTER);
        choiceButton2.setVerticalTextPosition(AbstractButton.BOTTOM);
        choiceButton2.setHorizontalTextPosition(AbstractButton.CENTER);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setSize(screenSize); 
        updateLabelsWithAnswerChoiceInfosArrayIndex(currentAnswerChoiceInfosArrayIndex);
        this.setVisible(true);
    }

    protected void updateLabelsWithAnswerChoiceInfosArrayIndex(int arrayIndex) {
        if (answerChoiceInfos.size() > arrayIndex && answerChoiceInfos!= null) {
            AnswerChoiceInfo info = answerChoiceInfos.get(arrayIndex);
            answerChar = info.answerCharacter;
            descriptionLabel.setText("Which one is start with '" + answerChar + "'?");
            tts.cancel();
            tts.speak(descriptionLabel.getText());
            choiceButton0.setText(info.choiceStrings[0]);
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource("/image/"+info.choiceStrings[0]+".jpg"));
                Image img = icon.getImage() ;  
                Image newimg = img.getScaledInstance( buttonWidth, buttonWidth,  java.awt.Image.SCALE_SMOOTH ) ;  
                choiceButton0.setIcon( new ImageIcon( newimg ));
            } catch (Exception ex) {
                System.out.println("cannnot find picture: "+info.choiceStrings[0]);
            }
            choiceButton1.setText(info.choiceStrings[1]);
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource("/image/"+info.choiceStrings[1]+".jpg"));
                Image img = icon.getImage() ;  
                Image newimg = img.getScaledInstance( buttonWidth, buttonWidth,  java.awt.Image.SCALE_SMOOTH ) ;  
                choiceButton1.setIcon( new ImageIcon( newimg ));
            } catch (Exception ex) {
                System.out.println("cannnot find picture: "+info.choiceStrings[1]);
            }
            choiceButton2.setText(info.choiceStrings[2]);
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource("/image/"+info.choiceStrings[2]+".jpg"));
                Image img = icon.getImage() ;  
                Image newimg = img.getScaledInstance( buttonWidth, buttonWidth,  java.awt.Image.SCALE_SMOOTH ) ;  
                choiceButton2.setIcon( new ImageIcon( newimg ));
            } catch (Exception ex) {
                System.out.println("cannnot find picture: "+info.choiceStrings[2]);
            }
            
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    manager.focusNextComponent();}
            }, 11000, 8000);
            
            choiceButton0.setFocusable(true);
            choiceButton1.setFocusable(true);
            choiceButton2.setFocusable(true);
            choiceButton0.requestFocusInWindow();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GameLevelPanel = new javax.swing.JPanel();
        descriptionLabel = new javax.swing.JLabel();
        dismissButton = new javax.swing.JButton();
        centerPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        choiceButton0 = new javax.swing.JButton();
        choiceButton1 = new javax.swing.JButton();
        choiceButton2 = new javax.swing.JButton();

        setTitle("AlphabetGamePanel");
        setName("gameFrame"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        GameLevelPanel.setBackground(new java.awt.Color(51, 255, 204));
        GameLevelPanel.setLayout(new java.awt.BorderLayout());

        descriptionLabel.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        descriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descriptionLabel.setText("Which one is start with...?");
        GameLevelPanel.add(descriptionLabel, java.awt.BorderLayout.NORTH);

        dismissButton.setText("Close");
        dismissButton.setFocusable(false);
        dismissButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dismissButtonActionPerformed(evt);
            }
        });
        GameLevelPanel.add(dismissButton, java.awt.BorderLayout.SOUTH);

        centerPanel.setOpaque(false);
        centerPanel.setLayout(new java.awt.BorderLayout());

        buttonPanel.setOpaque(false);

        choiceButton0.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                choiceButton0FocusGained(evt);
            }
        });
        choiceButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiceButton0ActionPerformed(evt);
            }
        });
        buttonPanel.add(choiceButton0);

        choiceButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                choiceButton1FocusGained(evt);
            }
        });
        choiceButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiceButton1ActionPerformed(evt);
            }
        });
        buttonPanel.add(choiceButton1);

        choiceButton2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                choiceButton2FocusGained(evt);
            }
        });
        choiceButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiceButton2ActionPerformed(evt);
            }
        });
        buttonPanel.add(choiceButton2);

        centerPanel.add(buttonPanel, java.awt.BorderLayout.CENTER);

        GameLevelPanel.add(centerPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(GameLevelPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void dismissButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dismissButtonActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_dismissButtonActionPerformed

    private void choiceButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiceButton0ActionPerformed
        tts.cancel();
        timer.cancel();
        unfocus();
        checkIfChoiceIsCorrectAtIndex(0);
    }//GEN-LAST:event_choiceButton0ActionPerformed

    private void choiceButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiceButton1ActionPerformed
        tts.cancel();
        timer.cancel();
        unfocus();
        checkIfChoiceIsCorrectAtIndex(1);
    }//GEN-LAST:event_choiceButton1ActionPerformed

    private void choiceButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiceButton2ActionPerformed
        tts.cancel();
        timer.cancel();
        unfocus();
        checkIfChoiceIsCorrectAtIndex(2);
    }//GEN-LAST:event_choiceButton2ActionPerformed

    private void choiceButton0FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_choiceButton0FocusGained
        tts.speak("if. "+choiceButton0.getText()+". start with '"+ answerChar +"'. press space .");
    }//GEN-LAST:event_choiceButton0FocusGained

    private void choiceButton1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_choiceButton1FocusGained
        tts.speak("if. "+choiceButton1.getText()+". start with '"+ answerChar +"'. press space .");
    }//GEN-LAST:event_choiceButton1FocusGained

    private void choiceButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_choiceButton2FocusGained
        tts.speak("if. "+choiceButton2.getText()+". start with '"+ answerChar +"'. press space .");
    }//GEN-LAST:event_choiceButton2FocusGained

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        tts.cancel();
        System.out.println("game window closing. correctCount = "+correctCount);
       updateScore(correctCount);
    }//GEN-LAST:event_formWindowClosing

    protected void checkIfChoiceIsCorrectAtIndex(int arrayIndex) {
        if (answerChoiceInfos.size() > arrayIndex) {
            AnswerChoiceInfo info = answerChoiceInfos.get(currentAnswerChoiceInfosArrayIndex);
            String evaluationString;
            if (info.answerStringArrayIndex == arrayIndex) {
                evaluationString = "Correct";
                correctCount++;
                tts.speak("that is correct!");
            } else {
                evaluationString = "Not Correct";
                tts.speak("it is incorrect.");
            }

            currentAnswerChoiceInfosArrayIndex++;
            int totalGameCount = answerChoiceInfos.size();
            if (totalGameCount > currentAnswerChoiceInfosArrayIndex) {
                tts.speak("press space to continue.");
                JOptionPane.showMessageDialog(null, evaluationString); //popout window for correct or 
                updateLabelsWithAnswerChoiceInfosArrayIndex(currentAnswerChoiceInfosArrayIndex);
            } else {
                tts.speak("You got " + correctCount + " out of " + totalGameCount + " correct. press space to exit.");
                JOptionPane.showMessageDialog(null, evaluationString +".  You got " + correctCount + " out of " + totalGameCount + " correct");
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        }
    }
    private void updateScore(int scr) {                                                   

        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager manager = emf1.createEntityManager();
        EntityTransaction transaction1 = manager.getTransaction();
        transaction1.begin();
        Query query1 = manager.createQuery("UPDATE student e SET e.score = :score, e.flag = 0 where e.flag = 1");
        query1.setParameter("score",scr );
        query1.executeUpdate();
        transaction1.commit();

        }

    private void unfocus(){
        choiceButton0.setFocusable(false);
        choiceButton1.setFocusable(false);
        choiceButton2.setFocusable(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GameLevelPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton choiceButton0;
    private javax.swing.JButton choiceButton1;
    private javax.swing.JButton choiceButton2;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JButton dismissButton;
    // End of variables declaration//GEN-END:variables
    public ArrayList<AnswerChoiceInfo> answerChoiceInfos;
    public int currentAnswerChoiceInfosArrayIndex = 0;
    public int correctCount = 0;
    public DismissGameLevelPanelListener dismissGameLevelPanelListener;
    public TTS tts;
    private char answerChar;
    private Timer timer;
    final KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    int buttonWidth;
    
    public interface DismissGameLevelPanelListener {
        public void didDismissGameLevelFrame(GameLevelFrame panel);
    }
}
