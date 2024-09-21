
package onthi1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

		while (true) {
			System.out.println("1. Add a new student");
			System.out.println("2. Update a student by ID");
			System.out.println("3. Delete a student by ID");
			System.out.println("4. Display all students");
			System.out.println("5. Find the student with the highest GPA");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				Student student = new Student();
				student.inputInfo();
				studentList.addStudent(student);
				break;

			case 2:
				String updateId = scanner.nextLine();
				studentList.updateStudentById(updateId);
				break;

			case 3:
				System.out.print("Enter student ID to delete: ");
				String deleteId = scanner.nextLine();
				studentList.deleteStudentById(deleteId);
				break;
                                
                        case 4:
                               // Display all students
                                System.out.println("List of all students: ");
                                studentList.displayAllStudent();
                                break;

			case 5:
				Student topStudent = studentList.findTopStudent();
				if (topStudent != null) {
					System.out.println("Student with the highest GPA: ");
					topStudent.displayInfo();
				}
				break;

			case 6:
				System.out.println("Exiting program...");
				scanner.close();
				return;

			default:
				System.out.println("Invalid choice, please try again.");
			}
		}
	}
    
}
