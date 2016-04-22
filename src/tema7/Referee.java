package tema7;

import java.util.Timer;

import javax.swing.JTextArea;

class Referee extends Thread {
	private Table table;
	public Referee(Table b, JTextArea textArea) {
		table = b;
		setDaemon(true);
		Timer timer = new Timer();
		TimeKeeper timeKeeper= new TimeKeeper(textArea);

	    timer.schedule(timeKeeper, 1000, 1000);
	}
	public void run() {
		for (int i = 0; i < 1000; i++) {
			
			table.put(i % 3);
		}
	}
}