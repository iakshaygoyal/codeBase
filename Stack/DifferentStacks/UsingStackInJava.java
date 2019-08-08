package Stack.DifferentStacks;
import java.util.*;
public class UsingStackInJava {

	public static void main(String[] args) {
		Stack<Integer> stk=new Stack<>();
		Random rand=new Random();
		for(int i=0;i<10;i++){
			stk.push(rand.nextInt(100));
			System.out.print(stk.peek()+" ");
		}
		System.out.println();
		System.out.println(stk.toString());
		while(!stk.empty()){
			System.out.println(stk.pop());
		}

	}
}