package lect9;

public class ClientA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PA obj1 = new PA(); can't make an object of abstract class
		
		PA obj2 = new CA();
		obj2.Fun();
		obj2.Fun1();
		((CA)obj2).Fun2();
		
//		CA obj3 = new PA(); never allowed
		
		CA obj4 = new CA();
		obj4.Fun();
		obj4.Fun1();
		obj4.Fun2();
	}

}
