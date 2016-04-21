package tema7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {


	public static void main(String[] args) {
		Dictionary abc=null;
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//new MainThread();
		//new BagTiles();
		try {
			abc=new Dictionary();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println(abc.voc.getNode("gr").isWord());
		
		
		
		JFrame mainFrame;
		
		mainFrame = new JFrame("Java Swing Examples");
	      mainFrame.setSize(500,400);
	      mainFrame.setLayout(new BorderLayout());


	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });
	      
//	     JPanel controlPanel = new JPanel();
//	      controlPanel.setLayout(new FlowLayout());
//	      controlPanel.add(new JLabel("ABCD"));
	      
	      //JPanel controlPanel = new JPanel();
	      JLabel labelTable=new JLabel();
	      labelTable.setHorizontalAlignment(JLabel.CENTER);
	      
	      JLabel labelPlayer1=new JLabel("Player1");
	      labelPlayer1.setHorizontalAlignment(JLabel.CENTER);
	      
	      JLabel labelPlayer2=new JLabel("Player2");
	      labelPlayer2.setHorizontalAlignment(JLabel.CENTER);
	      
	      JLabel labelPlayer3=new JLabel("Player3");
	      labelPlayer3.setHorizontalAlignment(JLabel.CENTER);
	      
	      JLabel labelPlayer4=new JLabel("Player4");
	      labelPlayer4.setHorizontalAlignment(JLabel.CENTER);
	      
	      JTextArea textArea = new JTextArea ("Test");
	      textArea.setLineWrap(true);
	      textArea.setWrapStyleWord(true);
	      
	      JScrollPane scrollV = new JScrollPane ();
	      scrollV.getViewport().setView(textArea);

	      scrollV.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);   
	      labelTable.add(textArea);
	      
	      
	      mainFrame.add(textArea, BorderLayout.CENTER);
	      mainFrame.add(labelPlayer1, BorderLayout.WEST);
	      mainFrame.add(labelPlayer2, BorderLayout.NORTH);
	      mainFrame.add(labelPlayer3, BorderLayout.EAST);
	      mainFrame.add(labelPlayer4, BorderLayout.SOUTH);
	      
	      Table b=new Table(textArea);
			Referee p=new Referee(b);
			Player c1=new Player(b,1);
			Player c2=new Player(b,2);
			Player c3=new Player(b,3);
			
			b.addPlayer(c1);
			b.addPlayer(c2);
			b.addPlayer(c3);
			
			p.start();
			c1.start();
			c2.start();
			c3.start();
			System.out.println(abc.map.get("kibbled"));
	      
	      
	      mainFrame.setVisible(true); 
		
		AutomatSolver automatSolver=new AutomatSolver();
		System.out.println(automatSolver.getWord());
		
		
	}

}
