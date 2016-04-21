package tema7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class BagTiles {
	Vector<Character> bag;
	
	BagTiles()
	{
		bag= new Vector<Character>();
		FileReader fr=null;
		try {
			fr = new FileReader("Distribution.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader textReader= new BufferedReader(fr);
		String textData= new String();
		for(int i=0;i<26;i++)
		{
			try {
				textData=textReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Character c= textData.charAt(0);
			int numberOfChar= Integer.parseInt(textData.substring(2));
			for(int j=0;j<numberOfChar;j++)
			{
				//System.out.println(nb);
				bag.add(c);
			}
		}
		try {
			textReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for(int i=0;i<bag.size();i++)
//		{
//			System.out.println(bag.elementAt(i));
//		}
		
	}
}
