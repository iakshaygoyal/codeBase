package Questions.Samsung;
import java.util.*;
public class Next_Greater_Element_Same_Digits {

	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        String s=scn.next();
	        char[] arr=s.toCharArray();
	        int flag=0;
	        
	        for(int j=arr.length-2;j>=0;j--){
	            for(int k=arr.length-1;k>j;k--){
	                if(arr[j]<arr[k]){
	                    char temp=arr[j];
	                    arr[j]=arr[k];
	                    arr[k]=temp;
	                    Arrays.sort(arr,j+1,arr.length);
	                    flag=1;
	                    break;
	                }
	            }
	            if(flag==1){
	                break;
	            }
	        }
	        
	        if(flag==0){
	            System.out.println("not possible");
	        }
	        else{
	            System.out.println(new String(arr));
	        }
	    }
	    scn.close();
	}
}