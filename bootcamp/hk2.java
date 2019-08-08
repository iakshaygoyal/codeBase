package bootcamp;
import java.util.*;
public class hk2 {

	public static class pair implements Comparable<pair>{
		int i1;
		int i2;
		pair(int i1,int i2){
			this.i1=i1;
			this.i2=i2;
		}
		pair(){}
		@Override
		public int compareTo(pair arg0) {
			return this.i2-arg0.i2;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[][] crate = new int[c][2];
        for(int crate_i=0; crate_i < c; crate_i++){
            for(int crate_j=0; crate_j < 2; crate_j++){
                crate[crate_i][crate_j] = in.nextInt();
            }
        }
        pair[] a=new pair[c];
        for(int i=0;i<c;i++){
        	a[i]=new pair();
        }
        for(int i=0;i<c;i++){
        	a[i].i1=crate[i][0];
        	a[i].i2=crate[i][1];
        }
        Arrays.sort(a);
        long max=0;
        for(int i=c-1;i>=0;i--){
        	if(n==0){
        		break;
        	}
        	if(n>=a[i].i1){
        		max+=(a[i].i1*a[i].i2);
        		n-=a[i].i1;
        	}
        	else{
        		max+=(n*a[i].i2);
        		n=0;
        	}
        }
        System.out.println(max);
	}

}
