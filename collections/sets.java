package collections;
import java.util.*;
public class sets {

	//FIRST OF ALL UR USER DEFINED CLASS MUST IMPLEMENTS COMPARABLE INTERFACE
	//HOW TO OVERRIDE COMPARETO, EQUALS AND HASHCODE METHOD
	
	static class stu implements Comparable<stu>{
		String name;
		int age;
		stu(String name,int age){
			this.name=name;
			this.age=age;
		}
		public String toString(){
			return this.name+"  "+this.age;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			stu other = (stu) obj;
			if (age != other.age) {
				return false;
			}
			if (name == null) {
				if (other.name != null) {
					return false;
				}
			} else if (!name.equals(other.name)) {
				return false;
			}
			return true;
		}
		public int compareTo(stu s){
			int retval=this.name.compareTo(s.name);
			if(retval==0){
				return Integer.compare(this.age, s.age);
			}
			return retval;
		}
//		public boolean equals(Object o){
//			if(this==o){
//				return true;
//			}
//			if(o==null || this.getClass()!=o.getClass()){
//				return false;
//			}
//			stu s=(stu)o;
//			return this.age==s.age && (this.name==s.name || (this.name!=null && this.name.equals(s.name)));
//		}
//		public int hashCode(){
//			int prime=31;
//			int retval=1;
//			retval=retval*prime+this.age;
//			retval=retval*prime+(this.name==null?0:this.name.hashCode());
//			return retval;
//		}
	}
	
	public static void main(String[] args) {
		TreeSet<stu> set=new TreeSet<>();
		set.add(new stu("a",4));
		set.add(new stu("f",3));
		set.add(new stu("d",8));
		set.add(new stu("r",6));
		set.add(new stu("s",9));
		set.add(new stu("a",9));
		set.add(new stu("s",9));
		System.out.println(set);
		if(set.contains(new stu("s",4))){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
		if(set.contains(new stu("s",9))){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
		
		System.out.println();
		
		
		HashSet<stu> set1=new HashSet<>();
		set1.add(new stu("a",4));
		set1.add(new stu("f",3));
		set1.add(new stu("d",8));
		set1.add(new stu("r",6));
		set1.add(new stu("s",9));
		set1.add(new stu("a",9));
		set1.add(new stu("s",9));
		System.out.println(set1);
		if(set1.contains(new stu("s",4))){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
		if(set1.contains(new stu("s",9))){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
		
		System.out.println();
		
		ArrayList<stu> list=new ArrayList<>();
		list.add(new stu("a",4));
		list.add(new stu("f",3));
		list.add(new stu("d",8));
		list.add(new stu("r",6));
		list.add(new stu("s",9));
		list.add(new stu("a",9));
		list.add(new stu("s",9));
		System.out.println(list);
		if(list.contains(new stu("s",4))){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}if(list.contains(new stu("s",9))){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
		
		PriorityQueue<stu> pq=new PriorityQueue<>();
		pq.add(new stu("a",4));
		pq.add(new stu("f",3));
		pq.add(new stu("d",8));
		pq.add(new stu("r",6));
		pq.add(new stu("s",9));
		pq.add(new stu("a",9));
		pq.add(new stu("s",9));
		System.out.println(pq);
		if(pq.contains(new stu("s",4))){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}if(pq.contains(new stu("s",9))){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
	}

}
