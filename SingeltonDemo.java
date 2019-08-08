class EagerInitializedSingelton{
	private static EagerInitializedSingelton instance=new EagerInitializedSingelton();
	
	private EagerInitializedSingelton(){}
	
	public static EagerInitializedSingelton getInstance(){
		return instance;
	}
}

class StaticBlockSingelton{
	private static StaticBlockSingelton instance;
	
	static{
		try{
			instance=new StaticBlockSingelton();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	private StaticBlockSingelton(){}
	
	public static StaticBlockSingelton getInstance(){
		return instance;
	}
}

class LazyInitializedSingelton{
	private static LazyInitializedSingelton instance=null;
	
	private LazyInitializedSingelton(){}
	
	public static LazyInitializedSingelton getInstance(){
		if(instance==null){
			instance=new LazyInitializedSingelton();
		}
		return instance;
	}
}

class ThreadSafeSingelton{
	private static ThreadSafeSingelton instance=null;
	
	private ThreadSafeSingelton(){}
	
	public static synchronized ThreadSafeSingelton getInstance(){
		if(instance==null){
			instance=new ThreadSafeSingelton();
		}
		return instance;
	}
}

class DoubleCheckedLockingSingelton{
	private static DoubleCheckedLockingSingelton instance=null;
	
	private DoubleCheckedLockingSingelton(){}
	
	public static DoubleCheckedLockingSingelton getInstance(){
		if(instance==null){
			synchronized (DoubleCheckedLockingSingelton.class) {
				if(instance==null){
					instance=new DoubleCheckedLockingSingelton();
				}
			}
		}
		return instance;
	}
}

class BillPughSingelton{
	private BillPughSingelton(){}
	
	public static class helper{
		private static final BillPughSingelton instance=new BillPughSingelton();
	}
	
	public static BillPughSingelton getInstance(){
		return helper.instance;
	}
}

class ABC extends Thread{
	@Override
	public void run(){
		LazyInitializedSingelton obj=LazyInitializedSingelton.getInstance();
		System.out.println(obj.hashCode());
	}
}

public class SingeltonDemo {

	public static void main(String[] args) {
//		EagerInitializedSingelton obj1=EagerInitializedSingelton.getInstance();
//		EagerInitializedSingelton obj2=EagerInitializedSingelton.getInstance();
//		System.out.println(obj1.hashCode());
//		System.out.println(obj2.hashCode());
		
//		Thread t1=new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				LazyInitializedSingelton obj3=LazyInitializedSingelton.getInstance();
//				System.out.println(obj3.hashCode());
//			}
//		});
//		
//		Thread t2=new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				LazyInitializedSingelton obj4=LazyInitializedSingelton.getInstance();
//				System.out.println(obj4.hashCode());
//			}
//		});
//		t1.start();
//		t2.start();
		
		ABC abc=new ABC();
		ABC abc2=new ABC();
		
		abc.start();
		abc2.start();
	}
}