
package pl2_project;

import java.io.Serializable;

public class Department implements Serializable {
    private String departmentID;
    private String departmentName;
    private String DeptDesc;
    
    FileManager FManger = new FileManager();
    private final String DeptFileName = "Department.txt";

    public Department(String departmentID, String departmentName, String DeptDesc) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.DeptDesc = DeptDesc;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" + "departmentID=" + departmentID + ", departmentName=" + departmentName + ", DeptDesc=" + DeptDesc + '}';
    }

    public String getdepartmentID() {
        return departmentID;
    }

    public String getdepartmentName() {
        return departmentName;
    }

    public String getDeptDesc() {
        return DeptDesc;
    }

    public void setdepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public void setdepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDeptDesc(String DeptDesc) {
        this.DeptDesc = DeptDesc;
    }

    public boolean addDept() {
        if (FManger.write(DeptFileName,getDeptData())) {
            return true;
        } else {
            return false;
        }
    }

    private String getDeptData() {
        return this.departmentID + "@" + this.departmentName + "@" + this.DeptDesc + "@";
    }
}
