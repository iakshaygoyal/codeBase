package bootcamp.gametheory;
import java.util.*;
public class spragueGrundyTheorem {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] a=new int[n];
		int max=-1;
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
			if(a[i]>max){
				max=a[i];
			}
		}
		int x=s.nextInt();
		int[] grundy=new int[max+1];
		Arrays.fill(grundy, -1);
		for(int i=0;i<n;i++){
			calculateGrundy(a[i], x, grundy);
		}
		System.out.println("1 : A's Turn");
		System.out.println("2 : B's Turn");
		System.out.println("Turn : ");
		int turn=s.nextInt();
		declareWinner(a, grundy, turn);
	}
	
	static int calculateGrundy(int n,int x,int[] grundy){
		if(grundy[n]!=-1){
			return grundy[n];
		}
		if(n<=x){
			return grundy[n]=n;
		}
		HashSet<Integer> set=new HashSet<>();
		for(int i=1;i<=x;i++){
			set.add(calculateGrundy(n-i, x, grundy));
		}
		return grundy[n]=calculateMex(set);
	}
	
	static int calculateMex(HashSet<Integer> set){
		int mex=0;
		while(set.contains(mex)){
			mex++;
		}
		return mex;
	}
	
	static void declareWinner(int[] a,int[] grundy,int turn){
		int xor=0;
		for(int i=0;i<a.length;i++){
			xor^=grundy[a[i]];
		}
		if(xor!=0){
			if(turn==1){
				System.out.println("Winner : A");
			}
			else{
				System.out.println("Winner : B");
			}
		}
		else{
			if(turn==1){
				System.out.println("Winner : B");
			}
			else{
				System.out.println("Winner : A");
			}
		}
	}

}
