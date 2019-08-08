package dpCorrect;
import java.util.*;
public class BoxStacking {

	static class Triple implements Comparable<Triple>{
		int height;
		int width;
		int length;
		Triple(int height,int width,int length){
			this.height=height;
			this.width=width;
			this.length=length;
		}
		Triple(){};
		public int compareTo(Triple t){
			return (this.width*this.length)-(t.width*t.length);
		}
	}
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			Triple[] arr=new Triple[3*n];
			for(int j=0;j<(3*n);j++){
				arr[j]=new Triple();
			}
			int k=0;
			for(int j=0;j<n;j++){
				int height=scn.nextInt();
				int width=scn.nextInt();
				int length=scn.nextInt();
				arr[k].height=height;
				if(width>length){
					arr[k].width=width;
					arr[k].length=length;
				}
				else{
					arr[k].width=length;
					arr[k].length=width;
				}
				k++;
				arr[k].height=width;
				if(height>length){
					arr[k].width=height;
					arr[k].length=length;
				}
				else{
					arr[k].width=length;
					arr[k].length=height;
				}
				k++;
				arr[k].height=length;
				if(width>height){
					arr[k].width=width;
					arr[k].length=height;
				}
				else{
					arr[k].width=height;
					arr[k].length=width;
				}
				k++;
			}
			Arrays.sort(arr);
			int[] dp=new int[3*n];
			for(int j=0;j<(3*n);j++){
				dp[j]=arr[j].height;
			}
			for(int j=1;j<(3*n);j++){
				for(k=0;k<j;k++){
					if(arr[k].width<arr[j].width && arr[k].length<arr[j].length && dp[k]+arr[j].height>dp[j]){
						dp[j]=dp[k]+arr[j].height;
					}
				}
			}
			int max=dp[0];
			for(int j=1;j<(3*n);j++){
				if(dp[j]>max){
					max=dp[j];
				}
			}
			System.out.println(max);
		}
	}

}
