import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Problem1_FileExist {
    public static void main(String args[]) throws Exception
    { 
         String path=System.getProperty("user.dir")+"//Dictonary.txt"; 
         if(doesFileExist(path) && isFileEmpty(path))     
         {
           String data = readFileAsString(path);
           String[] splitString = (data.split("-"));  
           System.out.println("Output:"); 
           for(String d:splitString)   //Loop for generating the required output
           {
              d=d.replace(", ","\n");
              System.out.println(d);   
           }
          }     
    }
    
    public static boolean doesFileExist(String path) throws FileNotFoundException  //Function for checking path of file
    {  
      File file = null;
      try
      {    
         file = new File(path); 
         if(file.exists()==false)
         throw new FileNotFoundException();
         else
         System.out.println("File exists at given path \n");
      } 
      catch(Exception e)
      {
         System.err.println("File does not exist at given path");
         return false;
      } 
      return true;
    }
    
    public static boolean isFileEmpty(String path)
    {
       File file=new File(path);
       if(file.length()>1)
       return true;
       else
       {
           System.out.println("File is empty");
           return false;
       }
    }
    
    public static String readFileAsString(String fileName)throws Exception 
    { 
       String data = ""; 
       data = new String(Files.readAllBytes(Paths.get(fileName))); 
       return data; 
    } 
   
}
