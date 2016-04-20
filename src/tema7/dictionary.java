package tema7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class dictionary {
	public Map<String, Integer> map;
	
	dictionary() throws IOException
	{
		map = new HashMap<String, Integer>();
		
		
		FileReader fr=null;
		fr = new FileReader("word.txt");
		BufferedReader textReader= new BufferedReader(fr);
          String s;
		while ((s=textReader.readLine()) != null)
          {
        	  map.put(s, s.length());
          }
	}

}
