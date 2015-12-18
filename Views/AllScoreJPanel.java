import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;




/**
 *
 * @author Sony
 */
public class AllScoreJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AllScoresPanel
     */
    public AllScoreJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
                           
    private void initComponents() {
    	setOpaque(false);
        allScoresLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allScoreTextArea = new javax.swing.JTextArea();
        back4 = new javax.swing.JButton();

        allScoresLabel.setFont(new java.awt.Font("Aharoni", 3, 18)); // NOI18N
        allScoresLabel.setForeground(new java.awt.Color(0, 0, 204));
        allScoresLabel.setText("         ALL STUDENTS SCORES");

        allScoreTextArea.setBackground(new java.awt.Color(153, 255, 255));
        allScoreTextArea.setColumns(20);
        allScoreTextArea.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        allScoreTextArea.setRows(5);
        jScrollPane1.setViewportView(allScoreTextArea);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    	EntityManager manager = emf.createEntityManager();
    	EntityTransaction transaction = manager.getTransaction();

    	transaction.begin();
		TypedQuery<Object []> query = manager.createQuery("SELECT e.student_name, e.score FROM student e", Object[].class);
    	List<Object []> result1 = query.getResultList();
		for (Object[] data : result1){
			allScoreTextArea.append(String.valueOf(data[0]));
			allScoreTextArea.append("     ");
			allScoreTextArea.append(String.valueOf(data[1]));
			allScoreTextArea.append("\n");
		}
        back4.setBackground(new java.awt.Color(204, 204, 255));
        back4.setFont(new java.awt.Font("Aharoni", 1, 10)); // NOI18N
        back4.setText("Back");
        back4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(back4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(allScoresLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(144, 144, 144))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(allScoresLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JTextArea allScoreTextArea;
    private javax.swing.JLabel allScoresLabel;
    public javax.swing.JButton back4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}

    
    