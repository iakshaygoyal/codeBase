package Questions;
import java.util.*;
public class InfixToPostfix {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			String infix=scn.next();
			System.out.println(convert(infix));
		}
	}
	
	static String convert(String infix){
		String postfix="";
		Stack<Character> stk=new Stack<>();
		for(int i=0;i<infix.length();i++){
			char c=infix.charAt(i);
			if(Character.isLetterOrDigit(c)){
				postfix+=c;
			}
			else if(c=='('){
				stk.push(c);
			}
			else if(c==')'){
				while(!stk.isEmpty() && stk.peek()!='('){
					postfix+=(stk.pop());
				}
				stk.pop();
			}
			else{
				while(!stk.isEmpty() && precedence(c)<=precedence(stk.peek())){
					postfix+=(stk.pop());
				}
				stk.push(c);
			}
		}
		while(!stk.isEmpty()){
			postfix+=(stk.pop());
		}
		return postfix;
	}
	
	static int precedence(char c){
		if(c=='+' || c=='-'){
			return 1;
		}
		else if(c=='*' || c=='/'){
			return 2;
		}
		else if(c=='^'){
			return 3;
		}
		return -1;
	}

}
