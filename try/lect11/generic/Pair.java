package lect11.generic;

public class Pair<T> {
	T one;
	T two;
	
	public Pair(T one, T two){
		this.one = one;
		this.two = two;
	}
	
	public T getOne(){
		return this.one;
	}
	
	public T getTwo(){
		return this.two;
	}
}
