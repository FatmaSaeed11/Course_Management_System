
package pl2_project;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileManager implements Serializable{
    
    
public boolean write(String FilePath, Object data) {

        try {
            System.out.println("Write in"+FilePath);
            ObjectOutputStream writter = new ObjectOutputStream(new FileOutputStream(FilePath));

            writter.writeObject(data);
            System.out.println("Write Done");
            writter.close();
            return true;

        } 
        catch (IOException e) 
        {
            System.out.println("Can't write" + e);
        }

        return false;
    }

    public Object read(String FilePath) {

        Object Result = null;

        try {
            System.out.println("Reading From " + FilePath);

            ObjectInputStream Reader = new ObjectInputStream(new FileInputStream(FilePath));

            Result = Reader.readObject();

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Result;

    }

}
