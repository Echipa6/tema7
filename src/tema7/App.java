package tema7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class App {

	public static int width=900;
	public static int height=600;
	
	static JLabel statusLabel;

	public static JFrame mainFrame;
	private static JTextArea textArea;
	private static JLabel labelPlayer1;
	private static JLabel labelPlayer2;
	private static JLabel labelPlayer3;
	private static JLabel labelPlayer4;
	
	private static JTextField  wordToSubmit;
	private static JButton submit;
	public static void setGUI(){

		mainFrame = new JFrame("Word Game");
		mainFrame.setSize(width,height);
		mainFrame.setResizable(false);
		mainFrame.setLayout(new BorderLayout());


		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});

		
	   
	   
		ImageIcon imageIcon = new ImageIcon("PlayerLeft.png");
		labelPlayer1=new JLabel("Player1",imageIcon,JLabel.CENTER);
		labelPlayer1.setHorizontalAlignment(JLabel.CENTER);

		
		
		imageIcon = new ImageIcon("PlayerTop.png");
		labelPlayer2=new JLabel("Player2",imageIcon,JLabel.CENTER);
		labelPlayer2.setHorizontalAlignment(JLabel.CENTER);

		
		imageIcon = new ImageIcon("PlayerRight.png");
		labelPlayer3=new JLabel("Player3",imageIcon,JLabel.CENTER);
		labelPlayer3.setHorizontalAlignment(JLabel.CENTER);

		
		JPanel playerBottomPanel =new JPanel();
		
		labelPlayer4=new JLabel("Player4");
		labelPlayer4.setHorizontalAlignment(JLabel.CENTER);
		
		wordToSubmit= new JTextField(10);
		wordToSubmit.setVisible(true);
		submit=new JButton("submit");
			
		playerBottomPanel.add(wordToSubmit);
		playerBottomPanel.add(submit);
		
		playerBottomPanel.add(labelPlayer4);
		
		
		
		JPanel middlePanel=new JPanel();
		middlePanel.setPreferredSize(new Dimension(300,300));
		textArea= new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);



		middlePanel.add(scroll);
		scroll.setPreferredSize(scroll.getParent().getPreferredSize());
		scroll.setBorder(new TitledBorder(new EtchedBorder(), "GameTable"));
		mainFrame.add(middlePanel, BorderLayout.CENTER);
		middlePanel.setPreferredSize(middlePanel.getParent().getPreferredSize());
		
		statusLabel = new JLabel("",JLabel.RIGHT);
		
		JPanel northPlayer= new JPanel();
		northPlayer.add(labelPlayer2);
		northPlayer.add(statusLabel,BorderLayout.EAST);

		//mainFrame.add(statusLabel,BorderLayout.NORTH);
		mainFrame.add(labelPlayer1, BorderLayout.WEST);
		mainFrame.add(northPlayer, BorderLayout.NORTH);
		mainFrame.add(labelPlayer3, BorderLayout.EAST);
		
		mainFrame.add(playerBottomPanel, BorderLayout.SOUTH);


	}
	public static void main(String[] args) {
		Dictionary abc=null;
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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

		
		
		
		setGUI();
				
		
		Table b=new Table(textArea);
		Referee p=new Referee(b, statusLabel);
		Player c1=new Player(b,1,labelPlayer1);
		Player c2=new Player(b,2,labelPlayer2);
		Player c3=new Player(b,3,labelPlayer3);
		Player c4=new Player(b,4,labelPlayer4);
		b.addPlayer(c1);
		b.addPlayer(c2);
		b.addPlayer(c3);
		b.addPlayer(c4);
			
		submit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		        String word=wordToSubmit.getText();
		        ((ManualSolver)c4.solver).setWordToValidate(word.toUpperCase());
		    }
		}
		);
		
		
		p.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		System.out.println(abc.map.get("kibbled"));


		mainFrame.setVisible(true); 

		AutomatSolver automatSolver=new AutomatSolver();
		//System.out.println(automatSolver.getWord());


		
//	    TimerTask myTask = new TimerTask() {
//	        @Override
//	        public void run() {
//	            System.out.println("merge");
//	        }
//	    };
		
	}

}
