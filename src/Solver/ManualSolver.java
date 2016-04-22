package Solver;

import java.util.Vector;

import javax.swing.JOptionPane;

import MainPackage.App;

public class ManualSolver extends Solver {
	public String wordToValidate="";
	boolean valid=false;
	public void setWordToValidate(String wordToValidate) {
		
		validate(wordToValidate);
		
		if(!valid)
		{
			JOptionPane.showMessageDialog(App.mainFrame,
					"Cuvantul scris de tine nu e bun.");
		}
		else
		{
			this.wordToValidate=wordToValidate;
			//System.out.println(wordToValidate);
			
		}
	}
	@Override
	public String getWord(Vector<Character> tiles) {
		this.tiles=tiles;
		
		return wordToValidate;
	}
	private void validate(String wordToValidate) {
		boolean ok=true;
		String auxWord=wordToValidate;
		Vector<Character> auxTiles=new Vector<Character>(this.tiles);
		if(dictionary.voc.isPrefix(wordToValidate))
		{
			for(int i=0;i<auxWord.length();i++)
			{
				int index_nr=auxTiles.indexOf(auxWord.charAt(i));
				if(index_nr==-1)
				{
					//System.out.println(auxTiles.toString());
					System.out.println("nu avem litera"+auxWord.charAt(i));
					ok=false;
				}
				else
				{
					auxTiles.remove(index_nr);
				}


			}

			valid=ok && dictionary.voc.getNode(wordToValidate).isWord();
			System.out.println("e cuvint?"+dictionary.voc.getNode(wordToValidate).isWord());
			//System.out.println(tiles.toString());
		}
	}


}
