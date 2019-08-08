package hk;

import java.util.Scanner;

public class simpletexteditor {

	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        int q = s.nextInt();
	        String str = "";
	        String[] stk = new String[q];
	        int tos = -1;
	        
	        for(int i=0; i<q; i++){
	            int operation = s.nextInt();
	            
	            switch(operation){
	                case 1:
	                String str1 = s.next();
//	                str1 = str1.substring(1);
	                stk[++tos] = str;
	                str = str + str1;
	                break;
	                
	                case 2:
	                int k = s.nextInt();
	                int len = str.length();
	                stk[++tos] = str;
	                str = str.substring(0, len-k);
	                break;
	                
	                case 3:
	                int l = s.nextInt();
	                System.out.println(str.charAt(l-1));
	                break;
	                
	                case 4:
	                str = stk[tos--];
	                break;
	            }
	        }
	    }
	 
}
