package Questions.Google;
import java.util.*;
public class Jumping_Numbers {

	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        int x=scn.nextInt();
	        
	        System.out.print("0 ");
	        for(int j=1;j<10;j++){
	            print(j,x);
	        }
	        System.out.println();
	    }
	    scn.close();
	}
	
	static void print(int val,int max){
	    Queue<Integer> q=new LinkedList<>();
	    q.offer(val);
	    while(!q.isEmpty()){
	        val=q.poll();
	        if(val<=max){
	            System.out.print(valz);
	            int l_digit=val%10;
	            if(l_digit!=0){
	                q.offer(val*10+(l_digit-1));
	            }
	            if(l_digit!=9){
	                q.offer(val*10+(l_digit+1));
	            }
	        }
	    }
	}
}