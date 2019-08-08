package patternSearching;
import java.util.*;
public class boyerMorre {

	//O(0.25)*(MN)
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("cnt : "+evaluate(scn.next(), scn.next()));
	}
	
	static int evaluate(String T,String P){
		int m=T.length();
		int n=P.length();
		int cnt=0;
		HashMap<Character,Integer> map=helper(P);
		int j=0;
		while(j<m-n+1){
			int k=n-1;
			while(k>=0){
				if(T.charAt(j+k)!=P.charAt(k)){
					if(map.containsKey(T.charAt(j+k))){
						int idx=map.get(T.charAt(j+k));
						if(idx>k){
							j=j+1;
						}
						else{
							j=j+k-idx;
						}
					}
					else{
						j=j+k+1;
					}
					break;
				}
				else{
					k--;
				}
			}
			if(k==-1){
				cnt++;
				System.out.println(j);
				j++;
			}
		}
		return cnt;
	}
	
	static HashMap<Character,Integer> helper(String s){
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<s.length();i++){
			map.put(s.charAt(i), i);
		}
		return map;
	}

}