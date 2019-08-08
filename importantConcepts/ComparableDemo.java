package importantConcepts;
import java.util.Arrays;
import java.util.Comparator;


public class ComparableDemo {
	
	static class Employee implements Comparable<Employee>{
		String name;
		int id,salary;
		
		Employee(String name,int id,int salary){
			this.name=name;
			this.id=id;
			this.salary=salary;
		}
		
		@Override
		public int compareTo(Employee e){
			return this.salary-e.salary;
		}
		
		@Override
		public String toString(){
			return this.name + ", "  + this.id + ", " + this.salary;
		}
	}
	
	static Comparator<Employee> nameComparator=new Comparator<Employee>() {
		
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.name.compareTo(e2.name);
		}
	};

	public static void main(String[] args) {
		Employee[] employees=new Employee[5];
		employees[0]=new Employee("b", 1, 9000);
		employees[1]=new Employee("d", 0, 1000);
		employees[2]=new Employee("a", 4, 5000);
		employees[3]=new Employee("c", 3, 4000);
		employees[4]=new Employee("e", 2, 2000);
		
		System.out.println(Arrays.toString(employees));
		Arrays.sort(employees);
		System.out.println(Arrays.toString(employees));
		Arrays.sort(employees, nameComparator);
		System.out.println(Arrays.toString(employees));
		Arrays.sort(employees, new Comparator<Employee>(){

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.id-e2.id;
			}
			
		});
		System.out.println(Arrays.toString(employees));
	}

}
