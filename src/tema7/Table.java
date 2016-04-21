package tema7;

class Table {
	private int number = -1;
	private boolean available = false;
	
	public synchronized int get(int consNumber) {
		while (!(available && number==consNumber)) {
			try {
				wait();
				// Asteapta producatorul sa puna o valoare
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		available = false;
		System.out.println(	"Consumatorul "+consNumber+" primit:\t" + number);
		
		notifyAll();
		return number;
	}
	public synchronized void put(int number) {
		while (available) {
			try {
				wait();
				// Asteapta consumatorul sa preia valoarea
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.number = number;
		available = true;
		System.out.println("Producatorul a pus:\t" + number);
		notifyAll();
	}
}