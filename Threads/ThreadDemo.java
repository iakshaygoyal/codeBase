package Threads;

class Multi extends Thread{
	@Override
	public void run(){
		System.out.println("running");
	}
}

class Multi2 implements Runnable{

	@Override
	public void run() {
		System.out.println("running wild");
	}
	
}

public class ThreadDemo{
	
	public static void main(String[] args){
		Thread thread=new Multi();
		thread.start();
		
		Multi2 multi2=new Multi2();
		Thread thread2=new Thread(multi2);
		thread2.start();
	}

}
