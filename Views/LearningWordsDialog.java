//package alphabetgame.views;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class LearningWordsDialog extends JDialog {

    public LearningWordsDialog(JFrame parent, DidDismissViewListener listener) {
        super(parent,true);
        didDismissViewListener = listener;
        
        initComponents();
        pack();
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        // Center in the parent
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        //System.out.println("(x, y)= "+x +", "+y);
        setLocation(new Point(x, y));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        skipButton = new javax.swing.JButton();
        textLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Learn Words");

        jPanel1.setLayout(new java.awt.BorderLayout());

        skipButton.setMnemonic('C');
        skipButton.setText("Skip");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });
        jPanel1.add(skipButton, java.awt.BorderLayout.PAGE_END);

        textLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        textLabel.setText("jLabel1");
        jPanel1.add(textLabel, java.awt.BorderLayout.PAGE_START);

        imageLabel.setText("jLabel2");
        jPanel1.add(imageLabel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        if (didDismissViewListener != null) {
            didDismissViewListener.didDismissView();
        }
        setVisible(false);
        dispose();
    }//GEN-LAST:event_skipButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton skipButton;
    private javax.swing.JLabel textLabel;
    // End of variables declaration//GEN-END:variables
    public DidDismissViewListener didDismissViewListener = null;
}
