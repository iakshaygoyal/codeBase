package Questions;
import java.util.*;
public class Lexicographic_Printing {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int max=scn.nextInt();
		for(int i=1;i<10;i++){
			print(i, max);
		}
//		print(max);
		scn.close();
	}
	
//	Recursive DFS
	static void print(int val,int max){
		if(val>max){
			return;
		}
		System.out.println(val);
		for(int i=0;i<10;i++){
			print(val*10+i,max);
		}
	}
	
//	Alternative Approach
//	Iterative DFS
	static void print(int n){
		Stack<Integer> stk=new Stack<>();
        for(int i=9;i>0;i--){
        	if(i<=n){
        		stk.push(i);
        	}
        }
        while(!stk.isEmpty()){
        	int j=stk.pop();
        	System.out.println(j);
        	for(int i=9;i>=0;i--){
        		int val=j*10+i;
        		if(val<=n){
        			stk.push(val);
        		}
        	}
        }
	}
}
