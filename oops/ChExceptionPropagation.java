package oops;

import java.io.IOException;

class ABC{
	void A() throws IOException{
		throw new IOException("shit!!");
	}
	
	void B()throws IOException{
		A();
	}
	
	void C()throws IOException{
		B();
	}
}

public class ChExceptionPropagation {

	public static void main(String[] args) {
		ABC abc=new ABC();
		try{
			abc.C();
		}
		catch(IOException ioException){
			System.out.println(ioException);
		}
	}

}
