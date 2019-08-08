package Questions.GS;
import java.util.*;

public class Intersection_2_Lines {
    static class Point{
        int x,y;
        
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        Point p1=new Point(scn.nextInt(), scn.nextInt());
	        Point p2=new Point(scn.nextInt(), scn.nextInt());
	        Point p3=new Point(scn.nextInt(), scn.nextInt());
	        Point p4=new Point(scn.nextInt(), scn.nextInt());
	        
	        if(isIntersect(p1,p2,p3,p4)){
	            System.out.println("1");
	        }
	        else{
	            System.out.println("0");
	        }
	    }
	    scn.close();
	}
	
	static boolean isIntersect(Point p1,Point p2,Point p3,Point p4){
	    int o1=orientation(p1,p2,p3);
	    int o2=orientation(p1,p2,p4);
	    int o3=orientation(p3,p4,p1);
	    int o4=orientation(p3,p4,p2);
	    
	    if(o1!=o2 && o3!=o4){
	        return true;
	    }
	    
	    if(o1==0 && onSegment(p1,p3,p2)){
	        return true;
	    }
	    if(o2==0 && onSegment(p1,p4,p2)){
	        return true;
	    }
	    if(o3==0 && onSegment(p3,p1,p4)){
	        return true;
	    }
	    if(o4==0 && onSegment(p3,p2,p4)){
	        return true;
	    }
	    return false;
	}
	
	static int orientation(Point p1,Point p2,Point p3){
	    int val=((p2.y-p1.y)*(p3.x-p2.x) - (p3.y-p2.y)*(p2.x-p1.x));
	    if(val==0) return 0;
	    
	    return (val>0)?1:-1;
	}
	
	static boolean onSegment(Point p1,Point p2,Point p3){
	    if((p2.x<=Math.max(p1.x,p3.x) && p2.x>=Math.min(p1.x,p3.x))
	    && (p2.y<=Math.max(p1.y,p3.y) && p2.y>=Math.min(p1.y,p3.y))){
	        return true;
	    }
	    return false;
	}
}