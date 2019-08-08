package LL;

public class ainvay{  
	 public static void main(String args[]){  
	  try{  
	    try{  
	     System.out.println("going to divide");  
	     int b =39/0;  
	    }catch(ArithmeticException e){System.out.println(e);}  
	   
	    try{  
	    int a[]=new int[5];  
	    a[5]=4;  
	    }catch(ArrayIndexOutOfBoundsException e){System.out.println(e);}  
	     
	    System.out.println("other statement");  
	  }catch(Exception e){System.out.println("handeled");}  
	  
	  System.out.println("normal flow..");  
	  validate(19);
	 } 
	 static void validate(int age){
	     if(age<18)
	      throw new ArithmeticException("not valid");
	     else
	      System.out.println("welcome to vote");
	   }
	}  