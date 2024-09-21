
package onthi1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    private ArrayList<Student> studentList;
    public StudentList(){
        studentList = new ArrayList<>();
    }
    
    public void addStudent(Student student){
        studentList.add(student);
    }
    
    public void updateStudentById(String updateId) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ID sinh vien can cap nhat: ");
        String id = sc.nextLine();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                System.out.println("Cap nhat thong tin sinh vien:");
                Student updatedStudent = studentList.get(i);

                System.out.print("Nhap Ten moi: ");
                updatedStudent.setFullName(sc.nextLine());

                System.out.print("Nhap Nganh moi: ");
                updatedStudent.setMajor(sc.nextLine());

                System.out.print("Nhap GPA moi: ");
                updatedStudent.setGpa(Float.parseFloat(sc.nextLine()));

                System.out.print("Nhap Ngay Sinh moi: ");
                String dobStr = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    updatedStudent.setDateOfBirth(sdf.parse(dobStr));
                } catch (Exception e) {
                    System.out.println("Wrong Format!");
                }

                studentList.set(i, updatedStudent);
            }
        }
    }
	public void deleteStudentById(String id) {
		Student student = findStudentByID(id);
		if (student != null) {
			studentList.remove(student);
			System.out.println("Student deleted successfully.");
		} else {
			System.out.println("Student not found.");
		}
	}

	public Student findStudentByID(String id) {
		for (Student student : studentList) {
			if (student.getId().equals(id)) {
				return student;
			}
		}
		return null;
	}

    public Student findStudentID(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student; // Trả về sinh viên nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy sinh viên
    }
    
    public void displayAllStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
	}
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println();
        }
    }
    
    public Student findTopStudent(){
        if(studentList.isEmpty()){
            System.out.println("no student available");
            return null;
        }
        Student topStudent = studentList.get(0);
        for(Student student : studentList){
            if(student.getGpa() > topStudent.getGpa()){
                topStudent = student;
            }
        }
        return topStudent;
    }
    
    public ArrayList<Student> findScholarshipStudents() {
        ArrayList<Student> scholarshipStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getGpa()>= 3.5) { // Assuming 3.5 is the scholarship GPA threshold
                scholarshipStudents.add(student);
            }
        }
        System.out.println("Debug: Number of scholarship students found: " + scholarshipStudents.size());
        return scholarshipStudents;
    }

    public double calculateTotalTuition() {
        double totalTuition = 0;
        for (Student student : studentList) {
            totalTuition += student.getTuiition();
        }
        System.out.println("Debug: Total tuition calculated: " + totalTuition);
        return totalTuition;
    }
}
