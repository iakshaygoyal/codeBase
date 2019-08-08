package Questions;
import java.util.*;

//4 4 
//0 1 1 0 1 1 1 1 1 1 1 1 1 1 0 0

public class Max_Rect_Binary_Array {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int m=scn.nextInt();
		int n=scn.nextInt();
		int[][] a=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				a[i][j]=scn.nextInt();
			}
		}
		System.out.println(maxArea(a, m, n));
		scn.close();
	}

	static int maxArea(int a[][],int m,int n){
        int[] arr=new int[n+1];
        arr[n]=0;
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==1){
                    arr[j]+=1;
                }
                else{
                    arr[j]=0;
                }
            }
            max=Math.max(max,maxArea(arr,n));
        }
        return max;
    }
    
    static int maxArea(int[] arr,int n){
        int max=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<(n+1);i++){
            while(!stk.isEmpty() && arr[i]<arr[stk.peek()]){
                int ridx=i;
                int x=arr[stk.pop()];
                int lidx=-1;
                if(!stk.isEmpty()){
                    lidx=stk.peek();
                }
                max=Math.max(max,x*(ridx-lidx-1));
            }
            stk.push(i);
        }
        return max;
    }
}
