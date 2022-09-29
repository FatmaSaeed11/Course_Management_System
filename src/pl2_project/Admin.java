
package pl2_project;


public class Admin extends person {

    public Admin() {

    }

    public Admin(String user, int id, String password, String firstName, String lastName, int age, double salary) {
        super(user, id, password, firstName, lastName, age, salary);
    }

    
    
    

    public void addNewStudent(String user, String password, int id, String firstName, String lastName, int age, int level, double GPA, Department dept) {
        Student x = new Student( level,  GPA,  user,  id,  password,  firstName,  lastName,  age, salary);
        if (x.addStudent()) {
            System.out.println("Student:"+x.toString() + "Added Successfully");
        } else {
            System.out.println("Failed to insert");
        }
    }

    public void displayStudents() {
        Student x = new Student();
        System.out.println(x.displayAllStudents());
    }

    public void searchForStudent(int id) {
        Student x = new Student();
        System.out.println(x.searchStudent(id));
    }

    public void updateStudent(int oldID, Student newStudentValues) {
        Student x = new Student();
        if (x.updateStudent(oldID, x)) 
        {
            System.out.println("Student: "+newStudentValues.toString() + "Updated Successfully");
        } else {
            System.out.println("Failed to Updated");
        }
    }

    public void deleteStudent(int Id) {
        Student x = new Student();
        if (x.deleteStudent(Id)) {
           System.out.println("Student: "+ Id + " Deleted Successfully");
        } else {
            System.out.println("Failed to Deleted");
        }
    }

    public void addNewinstructor(String user, String password,int grades , int id, String firstName, String lastName, int age, double salary, String officeHours, Department dept) {
        instructor x = new instructor( grades,user,  id,  password,  firstName,  lastName,  age, salary);
        if (x.addInstructor()) {
            System.out.println("Professor:"+x.toString() + "Added Successfully");
        } else {
            System.out.println("Failed to insert");
        }
    }

    public void displayProfs() {
        instructor x = new instructor();
        System.out.println(x.displayAllInstructor());
    }

    public void searchForProf(int id) {
        instructor x = new instructor();
        System.out.println(x.searchInstructor(id));
    }

    public void updateProf(int oldID, instructor newProfValues) {
        instructor x = new instructor();
        if (x.updateProf(oldID, newProfValues)) {
            System.out.println("Professor: "+newProfValues.toString() + "Updated Successfully");
        } else {
            System.out.println("Failed to Updated");
        }
    }

    public void deleteProf(int Id) {
        instructor x = new instructor();
        if (x.deleteProf(Id)) {
            System.out.println("Professor: "+ Id + " Deleted Successfully");
        } else {
            System.out.println("Failed to Deleted");
        }
    }

//    public void addNewCourse(String Cname, String CId, int CreditHours) {
//        instructor x = new instructor(Cname, CId, CreditHours, Main.cs);
//        if (x.addCourse()) {
//            System.out.println("Course: "+x.toString() + "Added Successfully ... !");
//        } else {
//            System.out.println("Failed to insert ... !");
//        }
//    }

    public void displayCourses() {
        course x = new course();
        System.out.println(x.displayAllCourses());
    }

    public void searchForCourse(String id) {
        course x = new course();
        System.out.println(x.searchCourse(id));
    }

    public void updateCourse(String oldID, course newCourseValues) {
        course x = new course();
        if (x.updateCourse(oldID, newCourseValues)) {
            System.out.println("Course: "+newCourseValues.toString() + "Updated Successfully");
        } else {
            System.out.println("Failed to Updated");
        }

    }

    public void deleteCourse(String Id) {
        course x = new course();
        if (x.deleteCourse(Id)) {
            System.out.println("Course: "+ Id + " Deleted Successfully");
        } else {
            System.out.println("Failed to Deleted");
        }
    }
    public String toString() {
        return "I'm Manager : " + firstName + " " + lastName + "\n" + "ID : " + id + " Age : " + age + " Salary : " + salary + "\n" + "Departement. : " + myDept.getdepartmentName() + "\nUserName: " + userName + "\t Password: " + password + "\n";
    }

}