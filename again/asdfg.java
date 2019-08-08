package again;

import java.util.ArrayList;
import java.util.Scanner;

public class asdfg {
		 public static void main(String[] args) {
		        Scanner in = new Scanner(System.in);
		        int t = in.nextInt();
		        for(int a0 = 0; a0 < t; a0++){
		            int n = in.nextInt();
		            int k = in.nextInt();
		            String s = "";
		            for(int i=1; i<=n; i++){
		                s+=i;
		            }   
		            ArrayList<String> list = permutation(s);
		            int j = -1;
		            for(j=0; j<list.size(); j++){
		                String str = list.get(j);
		                int l = -1;
		                for(l=0; l<str.length(); l++){
		                    if(Math.abs((l+1) - (str.charAt(l) - '0')) != k){
		                        break;
		                    }
		                }
		                if(l == str.length()){
		                    System.out.print(str);
		                    break;
		                }
		            }
		            if(j == list.size()){
		                System.out.print("-1");
		            }
		            System.out.println();
		        }
		    }
		    
		    public static ArrayList<String> permutation(String s){
		        if(s.length() == 1){
		            ArrayList<String> retval = new ArrayList<>();
		            retval.add(s);
		            return retval;
		        }
		        ArrayList<String> current = new ArrayList<>();
		        for(int i=0; i<s.length(); i++){
		            String rest = s.substring(0,i) + s.substring(i+1);
		            ArrayList<String> small = permutation(rest);
		            for(String x : small){
		                current.add(s.charAt(i) + x);
		            }
		        }
		        return current;
		    }

}
