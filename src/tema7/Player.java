package tema7;

class Player extends Thread {
	private Table table;
	private int number; 
	public Player(Table b, int nr) {
		table = b;
		number=nr;
	}
	public void run() {
		int value = 0;
		for (int i = 0; i < 300; i++)
		{	
			value = table.get(this.number-1);
			
		}
	}
}
