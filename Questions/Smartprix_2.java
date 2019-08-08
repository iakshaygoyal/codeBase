package Questions;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//SET a 0
//LABEL 100
//ADD a 1 a
//ECHO a
//IF a 5
//EXIT
//END
//GOTO 100

//SET a 1
//SET b 2
//SET goal 5
//SET flag 0
//IF flag 0
//ADD a b c
//IF a goal
//ADD a a a
//SET flag 1
//END
//ECHO a
//SET a b
//SET b c
//CONTINUE
//END

public class Smartprix_2 {
	public static void main(String[] args) {
    	Scanner scn=new Scanner(System.in);
    	ArrayList<ArrayList<String>> list=new ArrayList<>();
    	String s=scn.nextLine();
    	int idx=0;
    	while(s!=null && !s.equals("")){
    		s+=(" ");
    		int i=0;
    		list.add(new ArrayList<>());
    		for(int j=0;j<s.length();j++){
    			if(s.charAt(j)==' '){
    				list.get(idx).add(s.substring(i, j));
    				i=j+1;
    			}
    		}
    		idx++;
    		s=scn.nextLine();
    	}
    	
    	HashMap<String,Integer> map_label=new HashMap<>();
    	int i=0;
    	while(i<list.size()){
    		ArrayList<String> list1=list.get(i);
    		s=list1.get(0);
    		if(s.equals("LABEL")){
    			map_label.put(list1.get(1), i);
    		}
    		i++;
    	}
    	
    	HashMap<Integer,Integer> map_ifend=new HashMap<>();
    	HashMap<Integer,Integer> map_continue=new HashMap<>();
    	int[] arr=new int[100000000];
    	i=0;
    	int j=-1;
    	while(i<list.size()){
    		ArrayList<String> list1=list.get(i);
    		s=list1.get(0);
    		if(s.equals("IF")){
    			arr[++j]=i;
    		}
    		else if(s.equals("END")){
    			map_ifend.put(arr[j--], i);
    		}
    		else if(s.equals("CONTINUE")){
    			map_continue.put(i, arr[j]);
    		}
    		i++;
    	}
    	
    	HashMap<String,Integer> map=new HashMap<>();
    	i=0;
    	while(i<list.size()){
    		ArrayList<String> list1=list.get(i);
    		s=list1.get(0);
    		if(s.equals("ECHO")){
    			if(isInteger(list1.get(1))){
    				System.out.println(Integer.parseInt(list1.get(1)));
    			}
    			else{
    				System.out.println(map.get(list1.get(1)));
    			}
    		}
    		else if(s.equals("EXIT")){
    			System.exit(0);
    		}
    		else if(s.equals("SET")){
    			if(isInteger(list1.get(2))){
    				map.put(list1.get(1), Integer.parseInt(list1.get(2)));
    			}
    			else{
    				map.put(list1.get(1), map.get(list1.get(2)));
    			}
    		}
    		else if(s.equals("ADD")){
    			int val=0;
    			if(isInteger(list1.get(1))){
    				val+=(Integer.parseInt(list1.get(1)));
    			}
    			else{
    				val+=(map.get(list1.get(1)));
    			}
    			if(isInteger(list1.get(2))){
    				val+=(Integer.parseInt(list1.get(2)));
    			}
    			else{
    				val+=(map.get(list1.get(2)));
    			}
    			map.put(list1.get(3), val);
    		}
    		else if(s.equals("GOTO")){
    			i=map_label.get(list1.get(1));
    			continue;
    		}
    		else if(s.equals("IF")){
    			int val1,val2;
    			if(isInteger(list1.get(1))){
    				val1=Integer.parseInt(list1.get(1));
    			}
    			else{
    				val1=map.get(list1.get(1));
    			}
    			if(isInteger(list1.get(2))){
    				val2=Integer.parseInt(list1.get(2));
    			}
    			else{
    				val2=map.get(list1.get(2));
    			}
    			if(val1!=val2){
    				i=map_ifend.get(i);
    				continue;
    			}
    		}
    		else if(s.equals("CONTINUE")){
    			i=map_continue.get(i);
    			continue;
    		}
    		i++;
    	}
    	
    	scn.close();
    }
    
    static boolean isInteger(String s){
    	try{
    		Integer.parseInt(s);
    	}
    	catch(NumberFormatException e){
    		return false;
    	}
    	return true;
    }
}
