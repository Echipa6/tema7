package tema7;

import java.io.IOException;

public class App {


	public static void main(String[] args) {
		dictionary abc=null;
		//new MainThread();
		new BagTiles();
		try {
			abc=new dictionary();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(abc.voc.getNode("zymase").isWord());
		
		Table b=new Table();
		Referee p=new Referee(b);
		Player c1=new Player(b,1);
		Player c2=new Player(b,2);
		Player c3=new Player(b,3);
		p.start();
		c1.start();
		c2.start();
		c3.start();
		//System.out.println(abc.map.get("kibbled"));
	}

}
