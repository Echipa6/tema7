package tema7;

class Referee extends Thread {
	private Table table;
	public Referee(Table b) {
		table = b;
	}
	public void run() {
		for (int i = 0; i < 1000; i++) {
			
			table.put(i % 3);
		}
	}
}