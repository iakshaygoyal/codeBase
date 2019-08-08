package Graphs.Interfaces;

public class negativeCycleException extends Exception{
	public negativeCycleException(){
		super("Negative Cycle Present");
	}
	
	public String toString(){
		return super.getMessage();
	}

}
