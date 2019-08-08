package Threads;

class ABC extends Thread{
	public void run(){
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}
}

public class ThreadSleepDemo {

	public static void main(String[] args) {
		ABC thread=new ABC();
		ABC thread2=new ABC();
		
		//Different call stack
//		thread.start();
//		thread2.start();

		//Same call stack
		thread.run();
		thread2.run();
	}	
}