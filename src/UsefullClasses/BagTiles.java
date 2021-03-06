package UsefullClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class BagTiles {
	public Vector<Character> bag;
	private Random rand;
	
	public BagTiles() throws IOException
	{
		rand= new Random();
		bag= new Vector<Character>();
		FileReader fr=null;
		
		fr = new FileReader("Distribution.txt");
			
		BufferedReader textReader= new BufferedReader(fr);
		String textData= new String();
		for(int i=0;i<26;i++)
		{
			textData=textReader.readLine();
			int numberOfChar= Integer.parseInt(textData.substring(2));
			for(int j=0;j<numberOfChar;j++)
			{
				bag.add(textData.charAt(0));
			}
		}
		
		textReader.close();
		
		
	}
	
	public Vector<Character> getTiles(int numberTiles)
	{
		Vector<Character> randomTiles= new Vector<Character>();
		int randomNum;
		for(int i=0;i<numberTiles;i++)
		{
			if(bag.isEmpty())
			{
				System.out.println("Bag is Empty. Game OVER!");
				break;
				
			}
			randomNum = rand.nextInt((bag.size()));
			randomTiles.add(bag.remove(randomNum));
		}
		return randomTiles;
		
	}
}
