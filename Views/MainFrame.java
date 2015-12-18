
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import game.GameLevelController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;

import java.awt.event.*;
public class MainFrame {
JFrame window=new JFrame();
BackgroundPanel mainpanel=new BackgroundPanel();
LogoPanel logopanel=new LogoPanel();
MenuPanel menupanel=new MenuPanel();
ViewscoresPanel viewscorespanel=new ViewscoresPanel();

AllScoreJPanel allscoresjpanel=new AllScoreJPanel();
GamelevelPanel gamelevelpanel=new GamelevelPanel();
CustomizePanel custompanel=new CustomizePanel();
LessonaPanel panela=new LessonaPanel();
LessonbPanel panelb=new LessonbPanel();
LessoncPanel panelc=new LessoncPanel();
LessondPanel paneld=new LessondPanel();
LessonePanel panele=new LessonePanel();
public MainFrame(){
final CardLayout c1=new CardLayout();	
mainpanel.setLayout(c1);
mainpanel.add(logopanel,"logopanel");
mainpanel.add(menupanel,"menupanel");
mainpanel.add(viewscorespanel,"viewscorespanel");
mainpanel.add(gamelevelpanel,"gamelevelpanel");
mainpanel.add(custompanel,"custompanel");
mainpanel.add(panela,"panela");
mainpanel.add(panelb,"panelb");
mainpanel.add(panelc,"panelc");
mainpanel.add(paneld,"paneld");
mainpanel.add(panele,"panele");
c1.show(mainpanel,"logopanel");
//logopanel
logopanel.jButton1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		c1.show(mainpanel,"menupanel");
	}
});
//menupanel
menupanel.selectstudent.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		final SelectStudentJpanel selectstudentjpanel=new SelectStudentJpanel();
		mainpanel.add(selectstudentjpanel,"selectstudentjpanel");
		c1.show(mainpanel,"selectstudentjpanel");

	selectstudentjpanel.selectStudentButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			String s = String.valueOf(selectstudentjpanel.selectStudentComboBox.getSelectedItem());
	    	String[] splits = s.split("-");
	    	s = splits[0];
	    	System.out.println(s);
	    	EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("PersistenceUnit");
	    	EntityManager manager = emf1.createEntityManager();
	    	EntityTransaction transaction1 = manager.getTransaction();
	    	transaction1.begin();
	    	Query query1 = manager.createQuery("UPDATE student e SET e.flag = 1 where e.student_id = :sid");
	    	query1.setParameter("sid", s);
	    	query1.executeUpdate();
	    	transaction1.commit();
	    	c1.show(mainpanel,"gamelevelpanel");
		}
	});
	selectstudentjpanel.back11.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			mainpanel.remove(selectstudentjpanel);
			c1.show(mainpanel,"menupanel");
		}
	});
		
	}
});
menupanel.students.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		
		 final StudentGUI studentgui1=new StudentGUI();
		 //studentgui1.addJTable();
		 studentgui1.revalidate();
		mainpanel.add(studentgui1,"studentgui1");
		
		c1.show(mainpanel,"studentgui1");
		
		studentgui1.backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent args0){
				
				//mainpanel.remove(studentgui1);
				
					mainpanel.remove(studentgui1);
					
				c1.show(mainpanel,"menupanel");
				


			}
		});
	}
});
menupanel.viewscores.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		c1.show(mainpanel,"viewscorespanel");
	}
});
menupanel.back1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		c1.show(mainpanel,"logopanel");
	}
});


//viewscorespanel
viewscorespanel.back2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//TopscorePanel topscorepanel=new TopscorePanel();
		c1.show(mainpanel,"menupanel");
	}
});
viewscorespanel.studentsscore.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		final AllScoreJPanel allscoresjpanel=new AllScoreJPanel();
		mainpanel.add(allscoresjpanel,"allscoresjpanel");
		c1.show(mainpanel,"allscoresjpanel");
		allscoresjpanel.back4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent args0){
				c1.removeLayoutComponent(allscoresjpanel);
				c1.show(mainpanel,"viewscorespanel");
			}
		});
	}
});
viewscorespanel.topscores.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		final TopScorePanel topscorepanel=new TopScorePanel();
		mainpanel.add(topscorepanel,"topscorepanel");
		c1.show(mainpanel,"topscorepanel");
		topscorepanel.back10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				c1.show(mainpanel,"viewscorespanel");
				mainpanel.remove(topscorepanel);
			}
		});
	}
});

//gamelevelpanel
gamelevelpanel.jButton5.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent args0){
		c1.show(mainpanel,"selectstudentjpanel");
	}
});
gamelevelpanel.aeButton.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent args0){
		c1.show(mainpanel,"panela");
		panela.setFocusable(true);
		panela.requestFocusInWindow(); 
		AudioPlayer player=new AudioPlayer(new File("C:/Users/Sony/workspace/Project1/speeches/LetsA.wav"));
		player.play();
		
	}
});

gamelevelpanel.ptButton.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent args0){
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                AlphabetGameController gameController = new AlphabetGameController();
	                gameController.showGameLevelFrame(0);
	            }
	        });
	}
});

gamelevelpanel.jButton7.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent args0){
		c1.show(mainpanel,"custompanel");
	}
});
panela.addKeyListener(new KeyAdapter() {
	public void keyPressed(KeyEvent e){
		c1.show(mainpanel,"panelb");
		 AudioPlayer player1=new AudioPlayer(new File("C:/Users/Sony/workspace/Project1/speeches/A.wav"));
			player1.play();
			panelb.setFocusable(true);
			panelb.requestFocusInWindow();
	}
	
});
panelb.addKeyListener(new KeyAdapter() {
	public void keyPressed(KeyEvent e){
		c1.show(mainpanel,"panelc");
		 AudioPlayer player1=new AudioPlayer(new File("C:/Users/Sony/workspace/Project1/speeches/bus.wav"));
			player1.play();
			panelc.setFocusable(true);
			panelc.requestFocusInWindow();
	}
	
});
panelc.addKeyListener(new KeyAdapter() {
	public void keyPressed(KeyEvent e){
		c1.show(mainpanel,"paneld");
		 AudioPlayer player1=new AudioPlayer(new File("C:/Users/Sony/workspace/Project1/speeches/cat.wav"));
			player1.play();
			paneld.setFocusable(true);
			paneld.requestFocusInWindow();
	}
	
});
paneld.addKeyListener(new KeyAdapter() {
	public void keyPressed(KeyEvent e){
		c1.show(mainpanel,"panele");
		 AudioPlayer player1=new AudioPlayer(new File("C:/Users/Sony/workspace/Project1/speeches/d.wav"));
			player1.play();
			panele.setFocusable(true);
			panele.requestFocusInWindow();
	}
	
});
panele.addKeyListener(new KeyAdapter() {
	public void keyPressed(KeyEvent e){
		c1.show(mainpanel,"gamelevelpanel");
		 AudioPlayer player1=new AudioPlayer(new File("C:/Users/Sony/workspace/Project1/speeches/e.wav"));
			player1.play();
			gamelevelpanel.setFocusable(true);
			gamelevelpanel.requestFocusInWindow();
	}
	
});
panele.gob.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
});


//custompanel
custompanel.spellButton.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent args0){
		int t=Integer.valueOf(custompanel.repeatJtextField.getText());
		String s=custompanel.customizeTextArea.getText();
		if(s.equals("")){
			String s1="you did not enter any word";
			TTScustom empty=new TTScustom(s1);
			empty.speak();
		}else{
			for(int j=0;j<t;j++){
				if(j==t-1){
					String s3="Now, spell with me";
							TTScustom tts4=new TTScustom(s3);
					tts4.speak();
				}
		for(int i=0;i<s.length();i++){
			
			String p=String.valueOf(s.charAt(i));
		TTScustom tts=new TTScustom(p);
		tts.speak();
	}
		String is="is";
		TTScustom tts1=new TTScustom(is);
		tts1.speak();
		TTScustom tts2=new TTScustom(s);
		tts2.speak();
}
			
}
		custompanel.customizeTextArea.setText("");
	}
});
custompanel.back6.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent args0){
		c1.show(mainpanel,"gamelevelpanel");
	}
});



window.setContentPane(mainpanel);
window.setSize(600,600);
window.setVisible(true);
}
public static void main(String[] args)
{
	new MainFrame();
}
}
