package exception;

public class client {
	static class customException extends Exception{
		customException(){
			super("not applicable");
		}

	}
	static void validate(int i) throws customException{
		if(i<18){
			throw new customException();
		}
		else{
			System.out.println("applicable");
		}
	}
	public static void main(String[] args) {
		try{
			validate(100);
		}
		catch(Exception e){System.out.println(e);}
		System.out.println("rest of code");

	}

}
