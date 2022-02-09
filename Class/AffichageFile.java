package Class;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Interfaces.IJournal;

public class AffichageFile implements IJournal{
	
    public AffichageFile(){}
    public void outPut_Msg (String message){
    try {
      FileWriter myFile = new FileWriter("filename.txt");
      myFile.write(message);
      myFile.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
