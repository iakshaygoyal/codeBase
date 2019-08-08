package Questions.Facebook;
import java.util.*;
public class Word_Boggle {

	static int[] xarr={-1,-1,-1,0,0,1,1,1};
    static int[] yarr={-1,0,1,-1,1,-1,0,1};
    static int n,m;
	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        int x=scn.nextInt();
	        HashSet<String> set=new HashSet<>();
	        for(int j=0;j<x;j++){
	            set.add(scn.next());
	        }
	        n=scn.nextInt();
	        m=scn.nextInt();
	        char[][] boggle=new char[n][m];
	        for(int j=0;j<n;j++){
	            for(int k=0;k<m;k++){
	                boggle[j][k]=scn.next().charAt(0);
	            }
	        }
	        
	        boolean[][] visited=new boolean[n][m];
	        ArrayList<String> list=new ArrayList<>();
	        for(String str:set){
	            int flag=0;
	            for(int k=0;k<n;k++){
	                for(int l=0;l<m;l++){
	                    if(boggle[k][l]==str.charAt(0)){
	                    	visited[k][l]=true;
	                    	if(isPresent(boggle,visited,k,l,str,1)){
	                    		list.add(str);
		                        flag=1;
		                        visited=new boolean[n][m];
		                        break;
	                    	}
	                    	visited[k][l]=false;;
	                    }
	                }
	                if(flag==1){
	                    break;
	                }
	            }
	        }
	        
	        if(list.size()==0){
	            System.out.println("-1");
	        }
	        else{
	            Collections.sort(list);
	            for(int j=0;j<list.size();j++){
	                System.out.print(list.get(j)+" ");
	            }
	            System.out.println();
	        }
	    }
	    scn.close();
	}
	
	static boolean isPresent(char[][] boggle,boolean[][] visited,int i,int j,String s,int idx){
	    if(idx==s.length()){
	        return true;
	    }
	    for(int k=0;k<8;k++){
	        int next_i=i+xarr[k];
	        int next_j=j+yarr[k];
	        if(isSafe(boggle,visited,next_i,next_j,s,idx)){
	            visited[next_i][next_j]=true;
	            if(isPresent(boggle,visited,next_i,next_j,s,idx+1)){
	                return true;
	            }
	            visited[next_i][next_j]=false;;
	        }
	    }
	    return false;
	}
	
	static boolean isSafe(char[][] boggle,boolean[][] visited,int i,int j,String s,int idx){
	    if(i>=0 && i<n && j>=0 && j<m && !visited[i][j] && boggle[i][j]==s.charAt(idx)){
	        return true;
	    }
	    return false;
	}
}