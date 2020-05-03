import java.io.*;

public class byteStream
{
  public static void main(String[] args)
  {
    FileInputStream file_input = null;
    FileOutputStream file_output = null;
    try
    {
      file_input = new FileInputStream("F:/java_practice/java io stream/inputFile.txt");
      file_output = new FileOutputStream("F:/java_practice/java io stream/outputFile.txt");
      int dk;
      while((dk = file_input.read()) != -1)
      {
        file_output.write(dk);
      }
    }
    catch (IOException ex) {
         ex.printStackTrace();
      }
    finally
    {
      try{
      if(file_input!=null)
      {
        file_input.close();
      }
      if(file_output!=null)
      {
        file_output.close();
      }
    }
    catch (IOException ex) {
         ex.printStackTrace();
      }
    }

  }
}
