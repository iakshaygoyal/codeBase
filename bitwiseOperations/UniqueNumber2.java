package bitwiseOperations;
import java.util.*;
public class UniqueNumber2 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=scn.nextInt();
		}
		findUnique2(a);
	}

	static void findUnique2(int[] a){
		int n=a.length;
		int val=0;
		for(int i=0;i<n;i++){
			val=(val^a[i]);
		}
		int temp=val;
		int i=0;
		while(temp>0){
			if((temp&1)==1){
				break;
			}
			i++;
			temp=(temp>>1);
		}
		int first=0;
		int mask=1<<i;
		for(int j=0;j<n;j++){
			if((a[j]&mask)==0){
				first=(first^a[j]);
			}
		}
		int second=val^first;
		System.out.println(first+"  "+second);
	}
}
