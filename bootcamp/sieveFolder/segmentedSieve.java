package bootcamp.sieveFolder;
import java.util.*;
import java.lang.*;
public class segmentedSieve {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int a=s.nextInt();
			int b=s.nextInt();
			List<Integer> list=new ArrayList<>();
			double size=Math.sqrt(b);
			sieve((int)size,list);
			segmentedSieve(a, b, list);
			System.out.println();
		}
	}
	
	public static void sieve(int size,List<Integer> list){
		int[] arr=new int[size+1];
		for(int i=0;i<arr.length;i++){
			arr[i]=1;
		}
		for(int i=2;i<arr.length;i++){
			if(arr[i]==1){
				list.add(i);
				for(int j=i*i;j<arr.length;j+=i){
					arr[j]=0;
				}
			}
		}
	}
	
	public static void segmentedSieve(int a,int b,List<Integer> list){
		int[] arr=new int[b-a+1];
		for(int i=0;i<arr.length;i++){
			arr[i]=1;
		}
		for(int i=0;i<list.size();i++){
			int value=list.get(i);
			int start;
			if(a%value==0){
				start=a;
			}
			else{
				start=a+(value-(a%value));
			}
			for(int j=start;j<=b;j+=value){
				if(value==j){
					continue;
				}
				else{
					if(j%value==0){
						arr[j-a]=0;
					}
				}
			}
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i]==1&&i+a!=1){
				System.out.println(i+a);
			}
		}
	}

}