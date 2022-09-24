import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class Employee{
	private int empno;
	private String empname;
	private int salary;
	
	public Employee(int empno,String empname,int salary) {
		this.empno=empno;
		this.empname=empname;
		this.salary=salary;
	}
	
	public int getEmpno() {
		return empno;
	}
	public int getSalary() {
		return salary;
	}
	public String getEmpName() {
		return empname;
	}
	
	public String toString() {
		return empno+"   "+empname+"    "+salary;
	}
}
public class operationCRUD {
	public static void main(String[] args) {
		List<Employee> c=new ArrayList<Employee>();
		Scanner s=new Scanner(System.in);
		Scanner sc=new Scanner(System.in);
		int ch;
		
		do {
			System.out.println("1.Insert");
			System.out.println("2.Display");
			System.out.println("3.Search");
			System.out.println("4.Delete");
			System.out.println("5.Update");
			System.out.println("Enter Your Choice :");
			ch=s.nextInt();
			
			switch(ch) {
			case 1:													//Insert 
				System.out.print("Enter Employee No :");
				int empno=s.nextInt();
				System.out.print("Enter Employee Name :");
				String empName=sc.nextLine();
				System.out.print("Enter Employee Salary :");
				int empSalary=s.nextInt();
	
				c.add(new Employee(empno,empName,empSalary));
				break;
			case 2:													//Display
				System.out.println("---------------------------");
				System.out.println("EmpNo EmpName Salary");
				Iterator<Employee> iterator=c.iterator();
				while (iterator.hasNext()) {
					Employee e=iterator.next();
					System.out.println(e);
				}
				System.out.println("---------------------------");
				break;
			case 3:													//Search
				Boolean found=false;
				System.out.println("Enter Employee No to Search");
				int empno1=s.nextInt();
				System.out.println("---------------------------");
				 iterator=c.iterator();
				 while (iterator.hasNext()) {
					Employee e=iterator.next();
					if(e.getEmpno()==empno1) {
						System.out.println(e);
						found=true;
					}
				 	
				 }
				 if(!found) {
					 System.out.println("Record Not Found");
				 }
				
				System.out.println("---------------------------");
				break;
				
			case 4:													//Delete
				 found=false;
				System.out.println("Enter Employee to Delete");
				 empno1=s.nextInt();
				System.out.println("---------------------------");
				 iterator=c.iterator();
				 while (iterator.hasNext()) {
					Employee e=iterator.next();
					if(e.getEmpno()==empno1) {
						iterator.remove();
						found=true;
					}
				 	
				 }
				 if(!found) {
					 System.out.println("Record Not Found");
				 }
				 else {
					 System.out.println("Record is Deleted Susccessfully.......");

				}
				
				System.out.println("---------------------------");
				break;
				
			case 5:													//Update
				 found=false;
				System.out.println("Enter Employee to update");
				 empno1=s.nextInt();
				System.out.println("---------------------------");
				ListIterator<Employee>	listIterator=c.listIterator()	;
				while (listIterator.hasNext()) {
					
					Employee e=listIterator.next();
					if(e.getEmpno()==empno1) {
						System.out.println("Enter new Name");
						empName=sc.nextLine();
						System.out.println("Enter new salary");
						empSalary=sc.nextInt();
						
						listIterator.set(new Employee(empno1, empName, empSalary));
						found=true;
					}
				 	
				 }
				 if(!found) {
					 System.out.println("Record Not Found");
				 }
				 else {
					 System.out.println("Record is Updated Susccessfully.......");

				}
				
				System.out.println("---------------------------");
				break;
			
			}

		} while (ch!=0);
	}
}
