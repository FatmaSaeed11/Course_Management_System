
package pl2_project;

import java.io.Serializable;

public class person implements Serializable{
    
    protected int id ;
    protected String userName;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected int age;
    Department myDept;
    protected double salary;
    
    FileManager FileManger = new FileManager();

    static Excption_project MyEX = new Excption_project("Course Exception");
    
    public person() {
    }

    public person(String user,int id, String password, String firstName, String lastName, int age, double salary) {
        if (id<0)
        {
            this.id=MyEX.checkPositive("Wrong ID");
        }
        else
        {
            this.id=id;
        }
        if (age<0)
        {
            this.id=MyEX.checkPositive("Wrong Age");
        }
        else
        {
            this.age=age;
        }
        if (!user.contains("@") || !user.contains(".")) {
            this.userName = MyEX.checkEmail("User name");
        } else {
            this.userName = user;
        }
        if (password.length() < 8) {
            this.password = MyEX.checkPassLength("Password");
        } else {
            this.password = password;
        }
        this.myDept = myDept;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary=salary;
    }
    @Override
    public String toString() {
        return "person{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastname=" + lastName + ", age=" + age + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getpassword() {
        return password;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean login(String userName, String Pass) {
        if (userName.equals("Admin@yahoo.com") && Pass.equals("12345678")) {
            return true;
        }
        return false;
    }
    
    
    

}
