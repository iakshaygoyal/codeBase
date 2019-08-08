package bitwiseOperations;
import java.util.*;
public class LuckySeries {
//	14
//	4 7 44 47 74 77 444 447 474 477 744 747 774 777

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(luckyNo(n));
		}
	}
	
	static int luckyNo(int n){
		int i=0;
		int j;
		int res=0;
		while(n>0){
			int val=n%10;
			if(val==4){
				j=1;
			}
			else{
				j=2;
			}
			res+=((1<<i)*j);
			i++;
			n/=10;
		}
		return res;
	}

}