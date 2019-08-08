package Questions.Samsung;
import java.util.*;

public class Samsung_1 {

	static class Point{
		int x,y;
		
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int n;
	static Point d;
    public static void main(String[] args) {
    	Scanner scn=new Scanner(System.in);
    	int t=scn.nextInt();
    	for(int i=0;i<t;i++){
    		n=scn.nextInt();
    		Point s=new Point(scn.nextInt(), scn.nextInt());
    		d=new Point(scn.nextInt(), scn.nextInt());
    		
    		Point[] arr=new Point[n];
    		for(int j=0;j<n;j++){
    			arr[j]=new Point(scn.nextInt(), scn.nextInt());
    		}
    		boolean[] visited=new boolean[n];
    		System.out.println(shortestPath(arr, s, visited, 0));
    	}
    	scn.close();
    }
    
    static int shortestPath(Point[] arr,Point s,boolean[] visited,int m){
    	if(m==n){
    		return Math.abs(s.x-d.x) + Math.abs(s.y-d.y);
    	}
    	
    	int retval=Integer.MAX_VALUE;
    	for(int i=0;i<arr.length;i++){
    		if(!visited[i]){
    			visited[i]=true;
    			retval=Math.min(retval,  Math.abs(s.x-arr[i].x) + Math.abs(s.y-arr[i].y) + shortestPath(arr, arr[i], visited, m+1));
    			visited[i]=false;
    		}
    	}
    	return retval;
    }
    
}