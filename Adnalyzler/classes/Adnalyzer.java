import java.util.*;

public class Adnalyzer {
   public String prompt () {
      Scanner in = new Scanner(System.in);
      
      System.out.println("Please enter the filename, including the file extension, of the ad you wish to be analyzed;");
      System.out.println("i.e. fileName.jpg;");
      System.out.println("If you wish to exit the program, enter \"exit\" without the quotation marks:");
      return in.nextLine();
   }
    public static void main(String[] args) {
      Adnalyzer program = new Adnalyzer();
      System.out.println("Welcome to the Adnalyzer!");
      System.out.println("Before continuing, please ensure that all images you intend to have analyzed have been saved in the images folder.");
      while(true){
         String fileName=program.prompt();
         if (fileName.equals("exit"))
            break;
         Picture pic = new Picture(fileName);
         System.out.println(pic.output(pic.mostCommonColor())+"\n");
      }
      System.out.println("Thank you for using the Adnalyzer!");
   }
}