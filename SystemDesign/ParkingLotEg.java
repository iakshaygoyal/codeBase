package SystemDesign;
import java.util.*;

enum Size{
	S,M,L;
}

abstract class Vehicle{
	String license;
	Size size;
	
	Vehicle(String license){
		this.license=license;
	}
}

class Bike extends Vehicle{
	Bike(String license){
		super(license);
		this.size=Size.S;
	}
}

class Car extends Vehicle{
	Car(String license) {
		super(license);
		this.size=Size.M;
	}
}

class Truck extends Vehicle{
	Truck(String license) {
		super(license);
		this.size=Size.L;
	}
}

class Spot{
	int id;
	Size size;
	
	Spot(int id,Size size){
		this.id=id;
		this.size=size;
	}
	
	public String toString(){
		return this.id + " = " + this.size;
	}
}

class ParkingLot{
	HashMap<String, Spot> map=new HashMap<>();
	Stack<Integer> small=new Stack<>();
	Stack<Integer> medium=new Stack<>();
	Stack<Integer> large=new Stack<>();
	
	Spot placeVehicle(Vehicle vehicle){
		int id=-1;
		Spot spot=null;
		if(vehicle.size==Size.S){
			if(!small.isEmpty()){
				id=small.pop();
				spot=new Spot(id, Size.S);
			}
			else if(!medium.isEmpty()){
				id=medium.pop();
				spot=new Spot(id, Size.M);
			}
			else if(!large.isEmpty()){
				id=large.pop();
				spot=new Spot(id, Size.L);
			}
		}
		else if(vehicle.size==Size.M){
			if(!medium.isEmpty()){
				id=medium.pop();
				spot=new Spot(id, Size.M);
			}
			else if(!large.isEmpty()){
				id=large.pop();
				spot=new Spot(id, Size.L);
			}
		}
		else{
			if(!large.isEmpty()){
				id=large.pop();
				spot=new Spot(id, Size.L);
			}
		}
		
		if(id==-1){
			
		}
		
		map.put(vehicle.license, spot);
		return spot;
	}
	
	Spot removeVehicle(Vehicle vehicle){
		Spot spot=map.remove(vehicle.license);
		if(spot.size==Size.S){
			small.push(spot.id);
		}
		else if(spot.size==Size.M){
			medium.push(spot.id);
		}
		else{
			large.push(spot.id);
		}
		return spot;
	}
}

public class ParkingLotEg{
	
	public static void main(String[] args){
		ParkingLot lot=new ParkingLot();
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		for(int i=0;i<n;i++){
			if(i<n/3){
				lot.small.push(i);
			}
			else if(i<(2*n)/3){
				lot.medium.push(i);
			}
			else{
				lot.large.push(i);
			}
		}
		
		Vehicle vehicle=new Bike("1000");
		Vehicle vehicle2=new Car("2000");
		Vehicle vehicle3=new Truck("3000");
		
		Vehicle vehicle4=new Car("2001");
		Vehicle vehicle5=new Bike("1001");
		Vehicle vehicle6=new Bike("1002");
		
		System.out.println(lot.placeVehicle(vehicle));
		System.out.println(lot.placeVehicle(vehicle2));
		System.out.println(lot.placeVehicle(vehicle3));
		System.out.println(lot.placeVehicle(vehicle4));
		System.out.println(lot.placeVehicle(vehicle5));
		System.out.println(lot.placeVehicle(vehicle6));

		System.out.println(lot.removeVehicle(vehicle2));
		System.out.println(lot.removeVehicle(vehicle));
		System.out.println(lot.removeVehicle(vehicle5));
//		System.out.println(lot.removeVehicle(vehicle6));
		
		Vehicle vehicle7=new Car("2002");
		Vehicle vehicle8=new Truck("3002");
		
		System.out.println(lot.placeVehicle(vehicle7));
		System.out.println(lot.placeVehicle(vehicle8));
		
		
		scn.close();
	}
}