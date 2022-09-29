
package pl2_project;
import java.io.Serializable;
import java.util.ArrayList;

public class instructor extends person implements Serializable{
   
     
    private double grades;

     private final String instructorFileName = "instructor.bin";
     
        FileManager FManger = new FileManager();

     
    public static ArrayList<instructor> instructor = new ArrayList<instructor>();
    public instructor(){  
    }

    public instructor(double grades, String user, int id, String password, String firstName, String lastName, int age, double salary) {
        super(user, id, password, firstName, lastName, age, salary);
        this.grades = grades;
    }

    

    
    
      
    public void setgrades(double g){
    grades=g;
    
}
    public double getgrades(){
        return grades;
    }
    
//    public boolean addGrade() {
//        loadFromFile();
//        instructor.add(this);
//        return commitToFile();
//    }
//    
    
    public boolean addInstructor() {
        loadFromFile();
        instructor.add(this);
        return commitToFile();
    }

    public boolean commitToFile() {
        return FManger.write(instructorFileName, instructor);
    }

    public void loadFromFile() {
        instructor = (ArrayList<instructor>) FManger.read(instructorFileName);
    }

    private int getProfIndex(int id) {
        for (int i = 0; i < instructor.size(); i++) {
            if (instructor.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    public String displayAllInstructor() {
        loadFromFile();
        String S = "\nAll instructor Data:\n";
        for (instructor x : instructor) {
            S = S + x.toString();
        }
        return S;
    }

    public String searchInstructor(int id) {
        loadFromFile();
        int index = getProfIndex(id);
        if (index != -1) {
            return "\nFound" + instructor.get(index).toString();
        } else {
            return "\nNot Found";
        }
    }

    public boolean updateProf(int oldID, instructor x) {
        loadFromFile();
        int index = getProfIndex(oldID);

        if (index != -1) {
            instructor.set(index, x);

            return commitToFile();
        }

        return false;
    }

    public boolean deleteProf(int id) {
        loadFromFile();
        int index = getProfIndex(id);

        if (index != -1) {
            instructor.remove(index);

            return commitToFile();
        }

        return false;
    }
     

    @Override
    public String toString() {
        return "\nI'm instructor : " + firstName + " " + lastName + "\n" + "ID : " + id + " Age : " + age + " Salary : " + salary + "\n" + "Dept. : " + myDept.getdepartmentName() + "\nUserName: " + userName + "\t Password: " + password +"Grade"+grades+ "\n";
    }

    public void teach() {
        System.out.println("I'm Teaching all Lectures !");
    }
}
    

    
