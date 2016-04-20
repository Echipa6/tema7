package tema7;

public class HelloThread extends Thread {
	public int myNumber;
	public boolean avaible;
	public HelloThread thread1;
	public int index;
	
	public void setthread1(HelloThread thrd)
	{
		this.thread1=thrd;
	}
	public HelloThread getthread1()
	{
		return this.thread1;
	}
	
	HelloThread(int number, HelloThread thread)
	{
		myNumber=number;
		thread1=thread;
	}
	HelloThread(int number)
	{
		myNumber=number;
		this.avaible=false;
		index=0;
	}
	
	public void run() {
		
		while(true)
		{
			try {
				metoda();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    }

	private synchronized void metoda() throws InterruptedException
	{
		//int a=0;
		while(avaible==false)
		{
			//wait();
			//System.out.println(myNumber+"waiting...");
			//a++;
		}
		
		
		for(int i=0;i<10;i++)
		{
			System.out.println(myNumber+"Hello from a thread!"+index );
		}
		notify();
		index++;
		thread1.avaible=true;
		this.avaible=false;
		
		
	}
}
