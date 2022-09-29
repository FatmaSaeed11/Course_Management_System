
package pl2_project;
import java.io.Serializable;
import java.util.ArrayList;

public class Student extends person implements Serializable {
    private int level;
    private double GPA;
    
    FileManager FManger = new FileManager();

    private final String studentFileName = "Students.bin";
    
    public static ArrayList<Student> Students = new ArrayList<Student>();

    public Student() {

    }

    public Student(int level, double GPA, String user, int id, String password, String firstName, String lastName, int age, double salary) {
        super(user, id, password, firstName, lastName, age, salary);
        this.level = level;
        this.GPA = GPA;
    }

   

    

    public void setLevel(int level) {
        this.level = level;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getLevel() {
        return this.level;
    }

    public double getGPA() {
        return this.GPA;
    }

    public boolean addStudent() {
        if (FManger.write(studentFileName,getStudentData())) {
            return true;
        } else {
            return false;
        }
    }

    private String getStudentData() {
        return this.id + "@" + this.firstName + "@" + this.lastName + "@" + this.age + "@" + this.level + "@" + this.GPA + "@" + myDept.getdepartmentName() + "@" + this.userName + "@" + this.password + "@";
    }

    public boolean commitToFile() {
        return FManger.write(studentFileName, Students);
    }


    private int getStudentIndex(int id){
        for (int i = 0; i < Students.size(); i++)
            if(Students.get(i).getId() == id)
                return i;
        
        return -1;
    }
    
    private void loadFromFile() {
            Students = (ArrayList<Student>) (Object) FManger.read(studentFileName);
    }

    public String displayAllStudents() {
        loadFromFile();
        String S = "\nAll Student Data:\n";
        for (Student x : Students) {
            S = S + x.toString();
        }
        return S;
    }
    
    public String searchStudent(int id){
        loadFromFile();
        int index = getStudentIndex(id);
        if(index != -1)
            return "\nFound ...!" + Students.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    
    public boolean updateStudent(int oldID, Student x) {
        loadFromFile();
        int index = getStudentIndex(oldID);

        if (index != -1) {
            Students.set(index, x);

            return commitToFile();
        }

        return false;
    }
    
    public boolean deleteStudent(int id) {
        loadFromFile();
        int index = getStudentIndex(id);

        if (index != -1) {
            Students.remove(index);

            return commitToFile();
        }

        return false;
    }
    
    @Override
    public String toString() {
        return "\nI'm Eng : " + firstName + " " + lastName + "\n" + "ID : " + id + " Age : " + age + "\n"
                + "Level : " + level + " GPA : " + GPA + "\nDept: " + myDept.getdepartmentName() + "\nUserName: " + userName + "\t Password: " + password + "\n";
    }

   
}

