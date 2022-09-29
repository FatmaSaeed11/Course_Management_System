
package pl2_project;
import java.io.Serializable;

public class Exam implements Serializable {
    private String ExamName;
    private String ExamId;
    private double MaxGrade;

    FileManager FManger = new FileManager();
    private final String ExamsFileName = "Exams.txt";
    public Exam() {
    }

    public Exam(String ExamName, String ExamId, double MaxGrade) {
        this.ExamName = ExamName;
        this.ExamId = ExamId;
        this.MaxGrade = MaxGrade;
    }

    public String getExamId() {
        return ExamId;
    }

    public void setExamId(String ExamId) {
        this.ExamId = ExamId;
    }

    public String getExamName() {
        return ExamName;
    }

    public double getMaxGrade() {
        return MaxGrade;
    }

    public void setExamName(String ExamName) {
        this.ExamName = ExamName;
    }

    public void setMaxGrade(double MaxGrade) {
        this.MaxGrade = MaxGrade;
    }
    
    @Override
    public String toString() {
        return "Exam{" + "ExamName=" + ExamName + ", ExamId=" + ExamId + ", MaxGrade=" + MaxGrade + '}';
    }
    public boolean addExam() {
        if (FManger.write(ExamsFileName,getExamData())) {
            return true;
        } else {
            return false;
        }
    }
    private String getExamData() {
        return this.ExamName + "@" + this.ExamId + "@" + this.MaxGrade + "@";
    }

    
    

}
