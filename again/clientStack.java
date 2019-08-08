package again;

public class clientStack {

	public static void main(String[] args) {
		stack<String> stk = new stack<>();
		stk.push("a");
		stk.push("k");
		stk.push("s");
		stk.push("h");
		stk.push("a");
		stk.push("y");
		stk.display();
		
//		System.out.println(stack.isBracketsBalanced("{a+[b+(c+d)]+(e+f)}"));
		
		stk.reverse();
		stk.display();

	}

}
