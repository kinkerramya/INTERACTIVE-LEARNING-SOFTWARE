
public class CustomizePanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomizePanel
     */
    public CustomizePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
setOpaque(false);
        customizeLabel = new javax.swing.JLabel();
        back6 = new javax.swing.JButton();
        spellButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customizeTextArea = new javax.swing.JTextArea();
        repeatJtextField = new javax.swing.JTextField();
        nor = new javax.swing.JLabel();

        customizeLabel.setFont(new java.awt.Font("Aharoni", 1, 16)); // NOI18N
        customizeLabel.setForeground(new java.awt.Color(0, 51, 255));
        customizeLabel.setText("LEARN SOME NEW WORDS");

        back6.setBackground(new java.awt.Color(204, 204, 255));
        back6.setFont(new java.awt.Font("Aharoni", 1, 10)); // NOI18N
        back6.setText("Back");
        back6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        spellButton.setBackground(new java.awt.Color(255, 153, 153));
        spellButton.setFont(new java.awt.Font("Aharoni", 3, 18)); // NOI18N
        spellButton.setText("SPELL THIS");
        spellButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        customizeTextArea.setBackground(new java.awt.Color(51, 255, 204));
        customizeTextArea.setColumns(20);
        customizeTextArea.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        customizeTextArea.setRows(5);
        jScrollPane1.setViewportView(customizeTextArea);

        repeatJtextField.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        repeatJtextField.setForeground(new java.awt.Color(255, 0, 0));
        repeatJtextField.setText("2");
        repeatJtextField.setBackground(new java.awt.Color(51, 255, 204));
        
        nor.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        nor.setForeground(new java.awt.Color(0, 51, 255));
        nor.setText("REPEAT FOR:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 209, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(customizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197))
                    .addComponent(back6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(nor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(repeatJtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(spellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(customizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repeatJtextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nor))
                .addGap(47, 47, 47)
                .addComponent(spellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    public javax.swing.JButton back6;
    public javax.swing.JLabel customizeLabel;
    public javax.swing.JTextArea customizeTextArea;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel nor;
    public javax.swing.JTextField repeatJtextField;
    public javax.swing.JButton spellButton;
    // End of variables declaration                   
}
