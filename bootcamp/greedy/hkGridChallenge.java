package bootcamp.greedy;
import java.util.*;
public class hkGridChallenge {

	//CONCEPT - TAKING STRINGS AS INPUT
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int n=s.nextInt();
			String[] b=new String[n];
			for(int j=0;j<n;j++){
				b[j]=s.next();
			}
			char[][] a=new char[n][n];
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++){
					a[j][k]=b[j].charAt(k);
				}
			}
			for(int j=0;j<n;j++){
				Arrays.sort(a[j]);
			}
			int flag=0;
			for(int j=0;j<n;j++){
				for(int k=0;k<n-1;k++){
					if(a[k][j]>a[k+1][j]){
						flag=1;
						break;
					}
				}
				if(flag==1){
					break;
				}
			}
			if(flag==1){
				System.out.println("NO");
			}
			else{
				System.out.println("YES");
			}
		}
	}
}
