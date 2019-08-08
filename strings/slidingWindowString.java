package strings;
import java.util.Scanner;
class slidingWindowString{  

//	abbacbaa
//	aab
	public static void main(String args[]){  
		Scanner s=new Scanner(System.in);
		System.out.println(f(s.next(),s.next()));
	}
	
	static String f(String input,String chars){
		int m=input.length();
		int n=chars.length();
		int[] a=new int[256];
		for(int i=0;i<n;i++){
			a[chars.charAt(i)]++;
		}
		int[] b=new int[256];
		int winLen=Integer.MAX_VALUE;
		int winBegin=0;
		int winEnd=0;
		int count=0;
		for(int begin=0,end=0;end<m;end++){
			if(a[input.charAt(end)]==0){
				continue;
			}
			b[input.charAt(end)]++;
			if(b[input.charAt(end)]<=a[input.charAt(end)]){
				count++;
			}
			if(count==n){
				while(a[input.charAt(begin)]==0 || b[input.charAt(begin)]>a[input.charAt(begin)]){
					if(b[input.charAt(begin)]>a[input.charAt(begin)]){
						b[input.charAt(begin)]--;
					}
					begin++;
				}
				int len=end-begin+1;
				if(len<winLen){
					winBegin=begin;
					winEnd=end;
					winLen=len;
				}
			}
		}
		return (count==n)?input.substring(winBegin, winEnd+1):"";
	}
}  
