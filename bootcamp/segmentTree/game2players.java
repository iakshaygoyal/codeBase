package bootcamp.segmentTree;
import java.util.*;
public class game2players {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
//		int n=s.nextInt();
		int[] a=new int[]{6,9,9,1,4,6,5,9};
//		Random rand=new Random();
//		for(int i=0;i<n;i++){
//			a[i]=rand.nextInt(10);
//			System.out.print(a[i]+" ");
//		}
//		System.out.println();
		System.out.println(game(a,0, a.length-1).i);
		System.out.println(game(a, 0, a.length-1).s);
		System.out.println(game1(a, 0, a.length-1));
	}
	
	public static class pair implements Comparable<pair>{
		int i;
		String s;
		
		pair(int i,String s){
			this.i=i;
			this.s=s;
		}
		
		public int compareTo(pair p){
			return this.i-p.i;
		}
	}
	
	public static pair game(int[] a,int si,int ei){
		if(si>ei){
			return new pair(0,"");
		}
		pair p1=game(a, si+2, ei);
		pair p2=game(a, si+1, ei-1);
		pair p3=game(a, si+1, ei-1);
		pair p4=game(a, si, ei-2);
		
		if(a[si]+Math.min(p1.i, p2.i) > a[ei]+Math.min(p3.i, p4.i)){
			if(p1.i<p2.i){
				return new pair(a[si]+p1.i,a[si]+" "+p1.s);
			}
			else{
				return new pair(a[si]+p2.i,a[si]+" "+p2.s);
			}
		}
		else{
			if(p3.i<p4.i){
				return new pair(a[ei]+p3.i,a[ei]+" "+p3.s);
			}
			else{
				return new pair(a[ei]+p4.i,a[ei]+" "+p4.s);
			}
		}
	}
	
	public static int game1(int[] a,int si,int ei){
		if(si>ei){
			return 0;
		}
		int option1=a[si]+Math.min(game1(a, si+2, ei), game1(a, si+1, ei-1));
		int option2=a[ei]+Math.min(game1(a, si+1, ei-1), game1(a, si, ei-2));
		return Math.max(option1, option2);
	}

}
