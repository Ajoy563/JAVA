class Student {
    int age;
    String name;

    Student() {
        age=22; 
        name= "Aayush";
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class test {
    public static void main(String[] args) {
        Student ajoy = new Student();
        System.out.println(ajoy.age);
        System.out.println(ajoy.name);
    }
}