/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikacja;
import java.io.*;
/**
 *
 * @author Slawek
 */
public class Sciezka {
    public static void main( String[] args )
    {	
    	try {
 
    	  String filename = "zamowienie.jrxml";
    	  String finalfile = "";
    	  String workingDir = System.getProperty("user.dir");
 
    	  String your_os = System.getProperty("os.name").toLowerCase();
    	  if(your_os.indexOf("win") >= 0){
    		  finalfile = workingDir + "\\" + filename;
    	  }else if(your_os.indexOf( "nix") >=0 || your_os.indexOf( "nux") >=0){
    		  finalfile = workingDir + "/" + filename;
    	  }else{
    		  finalfile = workingDir + "{others}" + filename;
    	  }
 
    	  System.out.println("Final filepath : " + finalfile);
    	  File file = new File(finalfile);
 
	  if (file.createNewFile()){
	     System.out.println("Done");
	  }else{
	     System.out.println("File already exists!");
	  }
 
    	} catch (IOException e) {
	     e.printStackTrace();
	}
    }
}

