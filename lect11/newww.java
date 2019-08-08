import java.util.Scanner;

public class newww {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter no. of test cases : ");
        System.out.println();
        int T=s.nextInt();
        int[] a;
        int[] b;
        for(int i=0;i<T;i++)
        {
        System.out.print("Enter no. of students : ");
            int N=s.nextInt();
        a=new int[N+1];
        a[0]=0;
        for(int j=1;i<a.length;i++){
            System.out.print("Enter value : ");
            a[j]=s.nextInt();
        }
        b=new int[N];
           for(int k=0;i<b.length;i++){
            System.out.print("Enter value : ");
            a[k]=s.nextInt();
            }
        }
        int output=function(a,b,0);
        System.out.println(output);
        }


    public static int function(int[] a,int[] b,int i){
        if(i==b.length){
            return 0;
        }
        if(a[i+1]-a[i]>=b[i]){
            return 1+function(a,b,i+1);
        }
        else{
            return function(a,b,i+1);
        }
    }
   
}