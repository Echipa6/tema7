package tema7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App {


	public static void main(String[] args) {
		Dictionary abc=null;
		//new MainThread();
		//new BagTiles();
		try {
			abc=new Dictionary();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println(abc.voc.getNode("gr").isWord());
		
		Table b=new Table();
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
	      
	      JPanel controlPanel = new JPanel();
	      mainFrame.add(new JLabel("ABCD"), BorderLayout.CENTER);
	      mainFrame.add(new JLabel("USER1"), BorderLayout.EAST);
	      mainFrame.add(new JLabel("USER1"), BorderLayout.WEST);
	      mainFrame.add(new JLabel("USER1"), BorderLayout.NORTH);
	      mainFrame.add(new JLabel("USER1"), BorderLayout.SOUTH);
	      mainFrame.setVisible(true); 
		
		AutomatSolver automatSolver=new AutomatSolver();
		System.out.println(automatSolver.getWord());
	}

}
