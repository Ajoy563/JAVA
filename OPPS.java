public class OPPS {
    public static void main(String args[]) {
        Student s1 = new Student();
        Student s2 = new Student("Ajoy");
        Student s3 = new Student(16);
    }
}
class Student {
    String name;
    int roll;
    Student() {
        System.out.println("Constructor is caled...");
    }
    Student(String name) {
        this.name = name;
    }
    Student(int roll) {
        this.roll = roll;
    }
}
