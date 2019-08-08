package dpCorrect;
import java.util.*;
public class UglyNumbers {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		int[] arr=new int[501];
		arr[1]=1;
		int i=1,j=1,k=1;
		int val1,val2,val3;
		int idx=2;
		while(idx<501){
			val1=2*arr[i];
			val2=3*arr[j];
			val3=5*arr[k];
			int min=Math.min(val1, Math.min(val2, val3));
			arr[idx++]=min;
			if(val1==min){
				i++;
			}
			if(val2==min){
				j++;
			}
			if(val3==min){
				k++;
			}
		}
		for(int l=0;l<t;l++){
			int n=scn.nextInt();
			System.out.println(arr[n]);
		}
	}

}