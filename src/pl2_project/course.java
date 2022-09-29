
package pl2_project;

import java.io.Serializable;
import java.util.ArrayList;

public class course implements Serializable {
    private String CourseName;
    private int CreditHours;
    private String CourseId;
    public static ArrayList<course> course = new ArrayList<course>();
    
    FileManager FManger = new FileManager();
    private final String CourseFileName = "Courses.bin";

    Department dept;
    Exam finalExame;

    public course() {
    }

    public course(String CourseName, int CreditHours, String CourseId, Department dept) {
        this.CourseName = CourseName;
        this.CreditHours = CreditHours;
        this.CourseId = CourseId;
        this.dept = dept;
        
        finalExame = new Exam(CourseName + " Final Exam", CourseId + " 01", 100);
        System.out.println("\n" + finalExame.toString() + "Added Successfully ... !");
        finalExame.addExam();
    }
    
    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public void setCourseId(String CourseId) {
        this.CourseId = CourseId;
    }

    public void setCreditHours(int CreditHours) {
        this.CreditHours = CreditHours;
    }

    public String getCourseId() {
        return CourseId;
    }

    public String getCourseFileName() {
        return CourseFileName;
    }

    public int getCreditHours() {
        return CreditHours;
    }

    public String getCourseName() {
        return CourseName;
    }
    

    @Override
    public String toString() {
        return "course{" + "CourseName=" + CourseName + ", CreditHours=" + CreditHours + ", CourseId=" + CourseId + ", FManger=" + FManger + ", CourseFileName=" + CourseFileName + ", dept=" + dept + ", finalExame=" + finalExame + '}';
    }
    public boolean addCourse() {
        loadFromFile();
        course.add(this);
        return commitToFile();
    }
    public boolean commitToFile() {
        return FManger.write(CourseFileName, course);
    }

    public void loadFromFile() {
        course = (ArrayList<course>) FManger.read(CourseFileName);
    }
    private int getCourseIndex(String id) {
        for (int i = 0; i < course.size(); i++) {
            if (course.get(i).getCourseId().equals(id)) {
                return i;
            }
        }

        return -1;
    }

    public String displayAllCourses() {
        loadFromFile();
        String S = "\nAll Courses Data:\n";
        for (course x : course) {
            S = S + x.toString();
        }
        return S;
    }

    public String searchCourse(String id) {
        loadFromFile();
        int index = getCourseIndex(id);
        if (index != -1) {
            return "\nFound ...!" + course.get(index).toString();
        } else {
            return "\nNot Found ...!";
        }
    }

    public boolean updateCourse(String oldID, course x) {
        loadFromFile();
        int index = getCourseIndex(oldID);

        if (index != -1) {
            course.set(index, x);

            return commitToFile();
        }

        return false;
    }

    public boolean deleteCourse(String id) {
        loadFromFile();
        int index = getCourseIndex(id);

        if (index != -1) {
            course.remove(index);

            return commitToFile();
        }

        return false;
    }

    
}
