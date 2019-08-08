package patternSearching;
import java.util.*;
public class finiteAutomata {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println(fa(s.next(), s.next()));
	}
	
	static int fa(String T,String P){
		int m=T.length();
		int n=P.length();
		int[][] a=new int[n+1][26];
		for(int i=0;i<(n+1);i++){
			for(int j=0;j<26;j++){
				a[i][j]=getNextState(P, n, i, j+'a');
			}
		}
		int state=0;
		int value=0;
		for(int i=0;i<m;i++){
			state=a[state][T.charAt(i)-'a'];
			if(state==n){
				System.out.println("idx : "+(i-n+1));
				value++;
			}
		}
		return value;
	}
	
	static int getNextState(String P,int n,int state,int j){
		if(state<n && P.charAt(state)==j){
			return state+1;
		}
		for(int i=state-1;i>=0;i--){
			if(P.charAt(i)==j){
				int k=i-1;
				int l=state-1;
				while(k!=-1){
					if(P.charAt(k--)!=P.charAt(l--)){
						break;
					}
				}
				if(k==-1){
					return i+1;
				}
			}
		}
		return 0;
	}

}
