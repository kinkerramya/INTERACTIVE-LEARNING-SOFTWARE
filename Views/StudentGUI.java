import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User1
 */
public class StudentGUI extends javax.swing.JPanel {

	private JTable jtable1; // the table displayed on the GUI
	private StudentTableController studentTableController; 


	/**
     * Creates new form studentGUI
     */
    public StudentGUI() {
        initComponents();
     // creates a controller for the table        
   	 studentTableController = new StudentTableController(this); 
         // add a JTable to the GUI
          addJTable();
   	// make primary key non-editable 
          // studentIdTextField.setEditable(false);  

    }
 // creates a table and adds it to the GUI. 
    // Attaches the controller as a listener to the table
    public void addJTable() {
    		// add the data and column names to a JTable
    	//StudentTableController studentTableController=new StudentTableController(this);
    	    jtable1 = new JTable(studentTableController.getTableModel());
    		jPanel2.setBackground(new java.awt.Color(0, 255, 204));
	// add a ListSelectionListener to the table
	jtable1.getSelectionModel().addListSelectionListener(studentTableController);
    		
    		// add the table to a scrollpane
    		JScrollPane scrollpane = new JScrollPane(jtable1);
    		
		// create a window
    		jPanel2.setLayout(new BorderLayout());
    		jPanel2.setOpaque(false);
    		jPanel2.add(scrollpane, BorderLayout.CENTER);
    } 
    
    public void updateTable() {
    	StudentTableController studentTableController=new StudentTableController(this);
    	jtable1.setModel(studentTableController.getTableModel());
}
    
    
    // display data on the studentIdTextField
    public void setstudentIdTextField(String value) {
    	studentIdTextField.setText(value);
    }
    public void setstudentNameTextField(String value) {
    	studentNameTextField.setText(value);
    }
    public void setdobTextField(String value) {
    	dobTextField.setText(value);
    }
    public void setageTextField(String value) {
    	ageTextField.setText(value);
    }
    public void setscoreTextField(String value) {
    	scoreTextField.setText(value);
    }
 // code for the Add button
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        //add a row to the table
    	String[] array = new String[jtable1.getColumnCount()];
    	array[0] = studentNameTextField.getText();
    	array[1] = studentIdTextField.getText();
    	array[2] = dobTextField.getText();
    	array[3] = ageTextField.getText();
    	array[4] = scoreTextField.getText();
    	// send data to the controller to add it to the model
   	    studentTableController.addRow( array);
    }

    
    




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	 //setOpaque(false);
        jPanel1 = new javax.swing.JPanel();
        studentNameLabel = new javax.swing.JLabel();
        studentIdLabel = new javax.swing.JLabel();
        dobLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        scoreLabel = new javax.swing.JLabel();
        studentNameTextField = new javax.swing.JTextField();
        studentIdTextField = new javax.swing.JTextField();
        dobTextField = new javax.swing.JTextField();
        ageTextField = new javax.swing.JTextField();
        scoreTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                backButtonActionPerformed(evt);
            }
        });

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        studentNameLabel.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        studentNameLabel.setText("STUDENT NAME:");

        studentIdLabel.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        studentIdLabel.setText("STUDENT_ID:");

        dobLabel.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        dobLabel.setText("DATE OF BIRTH:");

        ageLabel.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        ageLabel.setText("AGE:");

        studentNameTextField.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N

        studentIdTextField.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N

        dobTextField.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        

        ageTextField.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N

        scoreLabel.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        scoreLabel.setText("SCORE:");

        scoreTextField.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N

        addButton.setBackground(new java.awt.Color(255, 255, 0));
        addButton.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        addButton.setText("ADD");
        addButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backButton.setBackground(new java.awt.Color(204, 0, 0));
        backButton.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        backButton.setText("Go BACK");
        backButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateButton.setBackground(new java.awt.Color(255, 255, 0));
        updateButton.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        deleteButton.setBackground(new java.awt.Color(255, 255, 0));
        deleteButton.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        scoreLabel.setText("Score");

        studentNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1.setOpaque(false);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                    		.addGap(50,50,50)
                        .addComponent(addButton)
                        .addGap(10, 10, 10)
                        .addComponent(deleteButton)
							.addGap(10, 10, 10)                        
                        .addComponent(updateButton)
                        .addGap(130, 130, 130)
                        .addComponent(backButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentIdLabel)
                            .addComponent(dobLabel)
                            .addComponent(ageLabel)
                            .addComponent(scoreLabel)
                            .addComponent(studentNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentNameTextField)
                            .addComponent(studentIdTextField)
                            .addComponent(dobTextField)
                            .addComponent(ageTextField)
                            .addComponent(scoreTextField)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNameLabel)
                    .addComponent(studentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentIdTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dobLabel)
                    .addComponent(dobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ageLabel)
                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreLabel)
                    .addComponent(scoreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton)
                    .addComponent(backButton))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2.setOpaque(false);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        this.setBackground(new java.awt.Color(0, 255, 204));
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(34, 34, 34)
//                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addContainerGap(68, Short.MAX_VALUE)
//                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(77, 77, 77))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(42, 42, 42)
//                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//        );

//        pack();
    }// </editor-fold>                        

                                             

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	String[] array = new String[jtable1.getColumnCount()];
    	int rowNum = jtable1.getSelectedRow();
    	array[0] = studentNameTextField.getText();
    	array[1] = studentIdTextField.getText();
    	array[2] = dobTextField.getText();
    	array[3] = ageTextField.getText();
    	array[4] = scoreTextField.getText();
    	// send data to the controller to add it to the model
   	    studentTableController.deleteRow(rowNum,array);	  
    }                                            

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {   
    	String[] array = new String[jtable1.getColumnCount()];
    	int rowNum = jtable1.getSelectedRow();
    	array[0] = studentNameTextField.getText();
    	array[1] = studentIdTextField.getText();
    	array[2] = dobTextField.getText();
    	array[3] = ageTextField.getText();
    	array[4] = scoreTextField.getText();
   	    studentTableController.updateRow(rowNum,array);
    }                                            

    private void studentNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

//    	JFrame window = new JFrame("Test");
//    	window.setSize(500,500);
    	StudentGUI allScorePanel = new StudentGUI();
//    	window.setContentPane(allScorePanel);
//  	  	window.setVisible(true);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton addButton;
    private javax.swing.JLabel studentNameLabel;
    private javax.swing.JTextField studentNameTextField;
    private javax.swing.JLabel studentIdLabel;
    private javax.swing.JTextField studentIdTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JTextField scoreTextField;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JTextField dobTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JButton updateButton;
    public javax.swing.JButton backButton;
    // End of variables declaration           

}