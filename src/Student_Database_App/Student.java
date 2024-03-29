package Student_Database_App;

import java.util.Scanner;

public class Student {
	
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses =  null;
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;

	//Constructor prompt user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("What is the students first name: ");
		this.firstName = in.nextLine();
		
		System.out.println("What is the students last name: ");
		this.lastName = in.nextLine();
		
		System.out.println("1 - Freshmen\n2 for Sohpmore\n3 - Junior\n4 - Senior\nWhat is the students grade year: ");
		this.gradeYear = in.nextInt();
		
		setStudentID();
			
	}
	
	//Generate an Id
	private void setStudentID() {
		//Grade Level + ID
		this.studentID = gradeYear + "" + id;
		id++;
	}
	
	//Enroll in courses
	public void enroll() {
		//Get inside a loop, user hits 0
		do {
			System.out.println("Enter courese to entroll (Q to quit)");
			
			Scanner in = new Scanner(System.in);
			
			String course = in.nextLine();
			
			if(!course.equals("Q")) {
				courses = courses + "\n " + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			} else {break;}
		} while (1 != 0);
			
		
	}
	
	//View balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	//Pay Tuition
	
	public void payTuition() {
		viewBalance();
		System.out.println("Enter your payment");
		Scanner in = new Scanner(System.in);
		
		int prevTuitionBalance = tuitionBalance;
		int payment = in.nextInt();
		
		tuitionBalance = tuitionBalance - payment;
		System.out.println("You have successfully paid : $" + payment + " of $" + prevTuitionBalance);
		viewBalance();
	}
	
	//Show status
	public String showInfo() {
		return "Name: " + firstName + " " + lastName +
				"\nGrade Level: " + gradeYear +
				"\nStudentID: " +  studentID +
				"\nCourses Enrolled:" + courses + 
				"\nBalance: $" + tuitionBalance;
	}
}
