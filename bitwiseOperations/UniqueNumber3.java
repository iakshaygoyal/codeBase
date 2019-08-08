package bitwiseOperations;
import java.util.*;
public class UniqueNumber3 {

	public static void main(String[] args) {
		int[] a=new int[]{1,2,4,1,7,2,2,7,1,4,7,14,4};
		System.out.println(unique(a));
		System.out.println(unique1(a));
	}
	
	static int unique(int[] a){
		int[] b=new int[32];//32-bit array
		int n=a.length;
		for(int i=0;i<n;i++){
			int j=0;
			

			//Considering each and every bit of the number
			int num=a[i];
			while(num>0){
				b[j++]+=(num&1);//this contributes 1 if the bit is set otherwise 0
				num=num>>1;//removing the last bit
			}
		}
		for(int i=0;i<32;i++){
			b[i]%=3;//taking modulus by 3 since every number in this array would be in the form of (3*n) or (3*n+1)
		}
		//The correct answer would be present in the form of binary 
		int val=0;
		for(int i=0;i<32;i++){
			val+=((1<<i)*b[i]);
		}
		return val;
	}
	
//	Better Method
//	Time : O(N)
//	Space : O(1)
	static int unique1(int[] a){
		int n=a.length;
		int result=0;
		for(int i=0;i<32;i++){
			int mask=1<<i;
			int sum=0;
			for(int j=0;j<n;j++){
				sum+=((a[j]&mask)==0?0:1);
			}
			if(sum%3!=0){
				result|=mask;
			}
		}
		return result;
	}

}
