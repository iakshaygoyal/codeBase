package collections;
import java.util.*;
public class comparators {

	static class stu implements Comparable<stu>{
		String name;
		int age;
		stu(String name,int age){
			this.name=name;
			this.age=age;
		}
		public int compareTo(stu s){
			return this.name.compareTo(s.name);
		}
		@Override
		public String toString() {
			return "stu [name=" + name + ", age=" + age + "]";
		}
	}
	static class agecomparator implements Comparator<stu>{
		public int compare(stu s1,stu s2){
			return Integer.compare(s1.age, s2.age);
		}
	}
	public static void main(String[] args) {
		ArrayList<stu> list=new ArrayList<>();
		list.add(new stu("aks",21));
		list.add(new stu("thea",2));
		list.add(new stu("roy",1));
		list.add(new stu("sam",221));
		list.add(new stu("aks",21));
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, new agecomparator());
		System.out.println(list);
	}

}
