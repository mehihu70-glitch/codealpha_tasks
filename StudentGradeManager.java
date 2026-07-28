import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;

    Student(String name, double marks){
        this.name=name;
        this.marks=marks;
    }
}

public class StudentGradeManager {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> students=new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n=sc.nextInt();
        sc.nextLine();

        double total=0;
        double highest=Double.MIN_VALUE;
        double lowest=Double.MAX_VALUE;

        for(int i=0;i<n;i++){
            System.out.print("Enter Name: ");
            String name=sc.nextLine();

            System.out.print("Enter Marks: ");
            double marks=sc.nextDouble();
            sc.nextLine();

            students.add(new Student(name,marks));
            total+=marks;

            if(marks>highest) highest=marks;
            if(marks<lowest) lowest=marks;
        }

        System.out.println("\n===== STUDENT REPORT =====");
        for(Student s:students){
            System.out.println(s.name+" : "+s.marks);
        }

        System.out.println("--------------------------");
        System.out.println("Average Marks : "+(total/n));
        System.out.println("Highest Marks : "+highest);
        System.out.println("Lowest Marks  : "+lowest);

        sc.close();
    }
}
