package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String [] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> lista = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int number = sc.nextInt();
		
		double additional = 0.0;
		for(int i = 0; i < number; i++) {
			System.out.println("Employee #"+(1+i)+" data:");
			System.out.print("Outsourced(y/n)? ");
			char answer = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			
			System.out.print("Value per hour: ");
			double valueHours = sc.nextDouble();
			
			if(answer == 'y') {
				System.out.print("Additional charge: ");
				additional = sc.nextDouble();
				Employee emp = new OutsourcedEmployee(name, hours, valueHours, additional);
				lista.add(emp);
			}else {
				Employee emp = new Employee(name, hours, valueHours);
				lista.add(emp);
			}
			
			System.out.println();
		}
		
		System.out.println();

		System.out.println("PAYMENTS:\n");
		for(Employee epy : lista) {
			System.out.println(epy.getName()+" - $ "+String.format("%.2f", epy.payment()));
		}
		sc.close();
	}
}
