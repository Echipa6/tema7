package tema7;

public class MainThread extends Thread{
	 HelloThread thread1;
	 HelloThread thread2;
	 HelloThread thread3;
	 
	 MainThread()
	 {
		 thread1= new HelloThread(0);
		thread2= new HelloThread(1);
		thread3= new HelloThread(2);
		
		thread1.avaible=true;
		
		thread1.setthread1(thread2);
		thread2.setthread1(thread3);
		thread3.setthread1(thread1);
			
		thread2.start();
		thread3.start();
			thread1.start();
			//thread1.notify();
			
	 }

}
