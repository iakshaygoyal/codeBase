package bootcamp.greedy;
import java.util.*;
import java.lang.*;
public class spojloadBalancing {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		while(true){
			int n=s.nextInt();
			if(n!=-1){
				int[] a=new int[n];
				int sum=0;
				for(int i=0;i<n;i++){
					a[i]=s.nextInt();
					sum+=a[i];
				}
				if(sum%n==0){
					int avg=sum/n;
					int max=Integer.MIN_VALUE;
					int cs=0;
					for(int j=0;j<n-1;j++){
						cs+=a[j];
						if(Math.abs(cs-((j+1)*avg))>max){
							max=Math.abs(cs-((j+1)*avg));
						}
					}
					System.out.println(max);
				}
				else{
					System.out.println("-1");
				}
			}
			else{
				break;
			}
			System.out.println();
		}
	}

}
