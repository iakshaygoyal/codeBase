package lect11.generic;

public class Car implements Comparable<Car>{
	int speed;
	int price;
	
	public Car(int speed, int price){
		this.speed = speed;
		this.price = price;
	}

	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		return this.speed - o.speed;
	}
	
	public boolean equals(Car o){
		return this.speed == o.speed && this.price == o.price;
	}
	
	public String toString(){
		String retVal = "";
		
		retVal += "Speed = " + this.speed + ", Price = " + this.price;
		
		return retVal;
	}
}
