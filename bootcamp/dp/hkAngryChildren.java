package bootcamp.dp;
import java.util.*;
public class hkAngryChildren {

	public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        Arrays.sort(a);
        System.out.println(f(a,0,k,new ArrayList<>()));
    }
    
    public static long f(int[] a,int idx,int k,ArrayList<Integer> list){
        if(k==0){
            long value=0;
            for(int i=0;i<list.size()-1;i++){
            	for(int j=i+1;j<list.size();j++){
            		value+=(Math.abs(list.get(i)-list.get(j)));
            	}
            }
            return value;
        }
        if(idx==a.length){
            return Integer.MAX_VALUE;
        }
        ArrayList<Integer> list1=new ArrayList<>(list);
        ArrayList<Integer> list2=new ArrayList<>(list);
        list2.add(a[idx]);
        return Math.min(f(a,idx+1,k,list1),f(a,idx+1,k-1,list2));
    }
}
