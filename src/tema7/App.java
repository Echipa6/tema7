package tema7;

import java.io.IOException;

public class App {


	public static void main(String[] args) {
//		Dictionary abc=null;
//		//new MainThread();
//		new BagTiles();
//		try {
//			abc=new Dictionary();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(abc.voc.getNode("gr").isWord());
		
		Table b=new Table();
		Referee p=new Referee(b);
		Player c1=new Player(b,1);
		Player c2=new Player(b,2);
		Player c3=new Player(b,3);
//		p.start();
//		c1.start();
//		c2.start();
//		c3.start();
		//System.out.println(abc.map.get("kibbled"));
		
		AutomatSolver automatSolver=new AutomatSolver();
		automatSolver.getWord();
	}

}
