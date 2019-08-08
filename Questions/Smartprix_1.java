package Questions;
import java.util.*;

//4
//x
//asdf#q#pqr^^23
//asdf1#@qwe^23
//asdf1#@qwe<<<//23

public class Smartprix_1 {

	public static void main(String[] args) {
    	Scanner scn=new Scanner(System.in);
    	int t=scn.nextInt();
    	for(int a=0;a<t;a++){
    		String s=scn.next();
        	ArrayList<StringBuilder> list=new ArrayList<>();
        	list.add(new StringBuilder());
        	int row=0,col=0,org_col=-1;
        	boolean caps=false;
        	
        	for(int i=0;i<s.length();i++){
        		char c=s.charAt(i);
        		if(c=='@'){
        			caps=(caps==true?false:true);
        		}
        		else if(c=='#'){
        			list.add(new StringBuilder(" "));
        			row++;
        			col=1;
        		}
        		else if(c=='<'){
        			if(row==0 && col==0){
        				continue;
        			}
        			
        			if(col!=0){
        				col--;
        			}
        			else{
        				row--;
        				col=list.get(row).length();
        			}
        		}
        		else if(c=='>'){
        			if(row==list.size()-1 && col==list.get(row).length()){
        				continue;
        			}
        			
        			if(col!=list.get(row).length()){
        				col++;
        			}
        			else{
        				row++;
        				col=0;
        			}
        		}
        		else if(c=='/'){
        			if(row==0 && col==0){
        				continue;
        			}
        			
        			if(col!=0){
        				list.get(row).deleteCharAt(col-1);
        				col--;
        			}
        			else{
        				col=list.get(row-1).length();
        				list.get(row-1).append(list.get(row));
        				list.remove(row);
        				row--;
        			}
        		}
        		else if(c=='?'){
        			if(row==list.size()-1){
        				continue;
        			}
        			
        			if(org_col==-1){
        				org_col=col;
        			}
        			
        			if(list.get(row+1).length()>=org_col){
        				row++;
        				col=org_col;
        			}
        			else{
        				row++;
        				col=list.get(row).length();
        			}
        			continue;
        		}
        		else if(c=='^'){
        			if(row==0){
        				continue;
        			}
        			
        			if(org_col==-1){
        				org_col=col;
        			}
        			
        			if(list.get(row-1).length()>=org_col){
        				row--;
        				col=org_col;
        			}
        			else{
        				row--;
        				col=list.get(row).length();
        			}
        			continue;
        		}
        		else{
        			if(caps){
        				list.get(row).insert(col, Character.toUpperCase(c));
        				col++;
        			}
        			else{
        				list.get(row).insert(col, Character.toLowerCase(c));
        				col++;
        			}
        		}
        		org_col=-1;
        	}
        	
        	for(int i=0;i<list.size();i++){
    			System.out.println(list.get(i));
    		}
        	System.out.println();
    	}
    	scn.close();
    }
}
