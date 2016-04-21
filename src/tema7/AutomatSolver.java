package tema7;

import java.util.Vector;

public class AutomatSolver extends Solver{
	Vector<String> findedWords;
	public AutomatSolver()
	{
		super();
		findedWords=new Vector<String>();
	}
	@Override
	public String getWord() {
		// TODO Auto-generated method stub
		tiles=new Vector<Character>();
		this.tiles.add('a');
		this.tiles.add('b');

		this.tiles.add('c');
		this.tiles.add('d');

		this.tiles.add('d');
		this.tiles.add('f');
		this.tiles.add('g');

		//circular shifting;
		for(int i=0;i<this.tiles.size()-1;i++)
		{
			for(int j=0;j<this.tiles.size();j++)
			{

				//System.out.println(tiles.toString());
				//System.out.println(tryToFindWord());
				tryToFindWord();
				Character aux=tiles.elementAt(0);
				tiles.remove(0);
				tiles.add(tiles.size()-i, aux);
			}
			System.out.println();
		}
		
		for(int i=0;i<findedWords.size();i++)
		{
			System.out.println(findedWords.get(i));
		}
		
		
		return null;
	}
	
	public String tryToFindWord()
	{
		StringBuilder constructedWord;
		Vector<Integer> added=new Vector<Integer>();
		
		Integer used=new Integer(1);
		Integer free=new Integer(0);
		for(int i=0; i<tiles.size();i++)
		{
			added.add(free);
		}
		
		for(int index=0;index<tiles.size();index++)
		{
			constructedWord=new StringBuilder("");
			//System.out.println(tiles.get(index).toString());
			if(dictionary.voc.isPrefix(tiles.get(index).toString()))
			{
				constructedWord.append(tiles.get(index).toString());
				added.setElementAt(used, index);
				
				if(dictionary.voc.getNode(constructedWord.toString()).isWord())
				{
					findedWords.add(constructedWord.toString());
				}
				
				for(int cursor=0;cursor<tiles.size();cursor++)
				{
					if(added.get(cursor)==0)
					{
						StringBuilder newWord= new StringBuilder("");
						newWord=constructedWord;
						newWord.append(tiles.get(cursor).toString());
						if(dictionary.voc.isPrefix(newWord.toString()))
						{
							if(dictionary.voc.getNode(newWord.toString()).isWord())
							{
								findedWords.add(newWord.toString());
							}
							added.setElementAt(used, cursor);
							constructedWord=newWord;
							
						}
					}
				}
				
				for(int i=0; i<added.size();i++)
				{
					added.set(i, 0);
				}
			}
			//System.out.println(constructedWord);
			
		}
		//System.out.println(dictionary.voc.getNode(constructedWord.toString()).isWord());
		return null;
		
	}

}
