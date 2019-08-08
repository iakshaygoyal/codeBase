package bootcamp.strings;
import java.util.*;
public class reversingsWords {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String s1=s.nextLine();
		int n=s1.length();
		Stack<String> stk=new Stack<>();
		int i=0;
		int j=0;
		for(j=0;j<n;j++){
			if(s1.charAt(j)==' '){
				stk.push(s1.substring(i,j));
				i=j+1;
			}
		}
		stk.push(s1.substring(i, j));
		while(!stk.isEmpty()){
			System.out.print(stk.pop()+" ");
		}
		System.out.println();
		j=n;
		i=n-1;
		for(i=n-1;i>=0;i--){
			if(s1.charAt(i)==' '){
				System.out.print(s1.substring(i+1, j)+" ");
				j=i;
			}
		}
		System.out.print(s1.substring(i+1, j)+" ");
	}

}
