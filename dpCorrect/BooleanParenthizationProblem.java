package dpCorrect;
import java.util.*;
public class BooleanParenthizationProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] operand=new char[]{'T','T','F','T'};
		char[] operator=new char[]{'|','&','^'};
	}
	
	static class Pair{
		int i;
		boolean b;
		Pair(int i,boolean b){
			this.i=i;
			this.b=b;
		}
	}
	
	static Pair evaluate(char[] operand,char[] operator,int si,int ei){
		if(si==ei){
			if(operand[si]=='T'){
				return new Pair(0,true);
			}
			return new Pair(0,false);
		}
		int retval=0;
		for(int i=si;i<ei;i++){
			Pair p1=evaluate(operand, operator, si, i);
			Pair p2=evaluate(operand, operator, i+1, ei);
			boolean v3;
			switch(operator[i]){
			case '&':
				v3=p1.b&p2.b;
				if(v3){
					retval++;
				}
				break;
			case '|':
				v3=p1.b|p2.b;
				if(v3){
					retval++;
				}
				break;
			case '^':
				v3=p1.b^p2.b;
				if(v3){
					retval++;
				}
				break;
			}
		}
		return new Pair(retval,true);
	}
}