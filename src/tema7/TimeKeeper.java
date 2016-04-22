package tema7;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * Simple demo that uses java.util.Timer to schedule a task to execute once 5
 * seconds have passed.
 */

public class TimeKeeper extends TimerTask {

	int seconds;
	int minuts;
	JLabel textArea;
	
	TimeKeeper(JLabel textArea)
	{
		seconds=0;
		minuts=0;
		this.textArea=textArea;
	}


	@Override
	public void run() {
		seconds++;
		if(seconds==60)
		{
			this.seconds=0;
			this.minuts++;
		}
		textArea.setText(minuts+":"+seconds);
		
		

	}
}