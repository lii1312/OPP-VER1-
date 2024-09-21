
package onthi1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person {
    public Student(String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
    }
    
    public Student() {
        super();
    }

    private float gpa;
    private String major;
    private double tuiition;
    private boolean schoolarship;
    
    public Student(float gpa, String major, double tuiition, boolean schoolarship) {
        this.gpa = gpa;
        this.major = major;
        this.tuiition = tuiition;
        this.schoolarship = schoolarship;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getTuiition() {
        return tuiition;
    }

    public void setTuiition(double tuiition) {
        this.tuiition = tuiition;
    }

    public boolean isSchoolarship() {
        return schoolarship;
    }

    public void setSchoolarship(boolean schoolarship) {
        this.schoolarship = schoolarship;
    }

    
    
    public void inputInfo()throws ParseException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID: ");
        id = sc.nextLine();
        System.out.println("Enter student full name: ");
        fullName = sc.nextLine();
        System.out.println("date of birth: ");
        String dateOfBirthString = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dateOfBirth = sdf.parse(dateOfBirthString);
        } catch (Exception e) {
            System.out.println("wrong fomat");
        }
        System.out.println("Enter GPA: ");
        gpa = Float.parseFloat(sc.nextLine());
        // Calculate tuition and scholarship status based on GPA
        if (gpa >= 4.0) {
        schoolarship = true;
        tuiition = 5000000; // 50% discount
        } else {
        schoolarship = false;
        tuiition = 10000000; // Full tuition
        }
        System.out.println("Enter major: ");
        major = sc.nextLine();  
        System.out.println("Enter tuiition: ");
        tuiition = sc.nextDouble();
      
    }
    
    
    public void displayInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("id: "+ id + ", full Name: "+ fullName + ", dateOfBirth:"
                + sdf.format(dateOfBirth)+", GPA: "+ gpa + ", major "+ major + ", tuiiton: "+ tuiition );
    }
    
    
}
