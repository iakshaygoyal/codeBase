package Threads;

class ABCD extends Thread{
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

public class ThreadDemo2 {

	public static void main(String[] args) {
		ABCD thread=new ABCD();
		ABCD thread2=new ABCD();
		ABCD thread3=new ABCD();
		
		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
		thread2.start();
		thread3.start();
	}

}
