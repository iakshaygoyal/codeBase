package bootcamp.gametheory;
import java.util.*;
public class nim {
	static class move{
		int idx;
		int num;
		move(int idx,int num){
			this.idx=idx;
			this.num=num;
		}
		move(){}
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		System.out.println("0 : A's Turn");
		System.out.println("1 : B's Turn");
		int turn=s.nextInt();
		whoWillWin(a, turn);
		while(!gameOver(a)){
			showPiles(a);
			move m=makeMove(a, new move());
			if(turn==0){
				System.out.println("A  :  index - "+m.idx+"  coins - "+m.num);
				turn=1;
			}
			else{
				System.out.println("B  :  index - "+m.idx+"  coins - "+m.num);
				turn=0;
			}
		}
		showPiles(a);
		if(turn==0){
			System.out.println("B Win");
		}
		else{
			System.out.println("A Win");
		}
	}
	
	static void whoWillWin(int[] a,int turn){
		if(nimSum(a)!=0){
			if(turn==0){
				System.out.println("A Win");
			}
			else{
				System.out.println("B Win");
			}
		}
		else{
			if(turn==0){
				System.out.println("B Win");
			}
			else{
				System.out.println("A Win");
			}
		}
	}
	
	static move makeMove(int[] a,move m){
		int nimSum=nimSum(a);
		if(nimSum!=0){
			for(int i=0;i<a.length;i++){
				if((a[i]^nimSum)<a[i]){
					m.idx=i;
					m.num=a[i]-(a[i]^nimSum);
					a[i]=(a[i]^nimSum);
					break;
				}
			}
		}
		else{
			int[] b=new int[a.length];
			int cnt=0;
			for(int i=0;i<a.length;i++){
				if(a[i]!=0){
					b[cnt++]=i;
				}
			}
			Random rand=new Random();
			m.idx=b[(rand.nextInt(100))%cnt];
			m.num=1+(rand.nextInt(100)%a[m.idx]);
			a[m.idx]-=(m.num);
		}
		return m;
	}
	
	static void showPiles(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	static int nimSum(int[] a){
		int val=0;
		for(int i=0;i<a.length;i++){
			val^=(a[i]);
		}
		return val;
	}
	
	static boolean gameOver(int[] a){
		for(int i=0;i<a.length;i++){
			if(a[i]!=0){
				return false;
			}
		}
		return true;
	}

}
