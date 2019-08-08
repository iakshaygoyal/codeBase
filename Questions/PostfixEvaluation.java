package Questions;
import java.util.*;
public class PostfixEvaluation {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			String s=scn.next();
			System.out.println(evaluate(s));
		}
	}
	
	static int evaluate(String s){
		Stack<Integer> stk=new Stack<>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(Character.isLetterOrDigit(c)){
				stk.push(c-'0');
			}
			else{
				int a=stk.pop();
				int b=stk.pop();
				
				switch(c){
				case '+':
					stk.push(b+a);
					break;
					
				case '-':
					stk.push(b-a);
					break;
					
				case '*':
					stk.push(b*a);
					break;
					
				case '/':
					stk.push(b/a);
					break;
				}
			}
		}
	return stk.pop();
	}
	
}
