package strings;
import java.util.*;
public class combination {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		f(s.nextInt(), s.nextInt(), "");
	}
	
	static void f(int n,int k,String s){
		if(k==0){
			System.out.println(s);
			return;
		}
		for(int i=n;i>=k;i--){
			f(i-1, k-1, s+i+" ");
		}
	}

}
