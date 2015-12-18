//package alphabetgame.views;

//import alphabetgame.models.DifficultyAndAlphabetsInfo;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChooseGameLevelFrame extends JFrame {
	 static DifficultyAndAlphabetsInfo selectedDifficultyAndAlphabetsInfo;

    public ChooseGameLevelFrame(SelectGameLevelListener listener) {
        super();
        selectGameLevelListener = listener;
        
        initComponents();
        pack();
        
        // Center in the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(400, 300);
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                              (screenSize.height - frameSize.width) / 2));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gameLevelTable = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(400, 300));

        gameLevelTable.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {
                {"Level 1", "Level 1", "Level 1", "Level 1", "Level 1", "Level 1"},
                {"Level 2", "Level 2", "Level 2", "Level 2", "Level 2", "Level 2"},
                {"Level 3", "Level 3", "Level 3", "Level 3", "Level 3", "Level 3"}
            },
            new String [] {
                "A E", "F J", "K P", "Q U", "V Z", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        gameLevelTable.setMinimumSize(new java.awt.Dimension(300, 200));
        gameLevelTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameLevelTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gameLevelTable);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void gameLevelTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameLevelTableMouseClicked
        Point p = evt.getPoint();
        int row = gameLevelTable.rowAtPoint(p);
        int column = gameLevelTable.columnAtPoint(p);

        ArrayList<Character> alphabets = new ArrayList<Character>();
        alphabets.add('A');
        alphabets.add('B');
        alphabets.add('C');
        alphabets.add('D');
        alphabets.add('E');

        DifficultyAndAlphabetsInfo info = new DifficultyAndAlphabetsInfo();
        info.alphabets = alphabets;
        info.difficulty = DifficultyAndAlphabetsInfo.getDifficultyFromTableRowIndex(row);

        selectGameLevelListener.didSelectGameLevel(info);
    }//GEN-LAST:event_gameLevelTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable gameLevelTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    public SelectGameLevelListener selectGameLevelListener;
    
    public interface SelectGameLevelListener {
        public void didSelectGameLevel(DifficultyAndAlphabetsInfo info);
    }
    
}
