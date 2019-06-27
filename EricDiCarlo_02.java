import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class EricDiCarlo_02 {

   private static List listOfStudents; // A list for all valid Student objects
   private static List listOfGradeItems; // A list for all valid GradeItem objects
   private static final String INPUT_FILE = "Project_03_Input01.txt"; // Input file to be fed into lists
   private static final String OUTPUT_FILE = "Project_03_Output01.txt"; // Output file for lists   
   
//****************************************************************************************

   public static void main(String[] args) throws IOException {
   
   listOfStudents = new List();
   listOfGradeItems = new List();
      
      System.out.println("Reading data from file Project_03_Input01.txt");
      processInput();
      generateReport();
      
   } // end of main
//*****************************************************************************************
   
   /**
      * processInput() - Processes the date from the input file and directs it depened on object type.
   */
   public static void processInput() throws IOException {
   
      File inputFile = new File(INPUT_FILE);
      Scanner input = new Scanner(inputFile);
      
      while(input.hasNext()) {
         String tempString = input.nextLine();
         String[] tempArray = tempString.split(",");
      
         if (tempArray[0].equals("STUDENT")) {
            processStudentData(tempArray);
         }
         else if(tempArray[0].equals("GRADE ITEM")) {
            processGradeItemData(tempArray);
         }
         else {
            throw new IllegalArgumentException("Please input data for either a Student or Grade Item.");
         }
      }
   }
//*****************************************************************************************   
   
   /**
      * processStudentData() - Processes input throw the Student constructor and into listOfStudents
      * @param data - The array holding the data for the student object
   */   
   public static void processStudentData(String[] data) {
      if(data[1].equals("ADD")) {
         Student student = new Student(data[2], data[3], data[4], data[5]);
         if (listOfStudents.contains(student)) {
            throw new IllegalArgumentException("The entered Student ID already exists.");  
         }
         else {
            try {
               listOfStudents.add(student);
               System.out.println("Student with Student Id " + student.getID() + " was added to the list.");
            }
            catch (IllegalArgumentException e) {
               System.err.println("The student could not be added to the list.");
            }
         }         
      }
      else if(data[1].equals("DEL")) {
         Student student = new Student(data[2], data[3], data[4], data[5]);
         try {
            listOfStudents.remove(student);
            System.out.println("Student with Student Id " + student.getID() + " was removed from the list.");
         }
         catch (IllegalArgumentException e) {
            System.err.println("The student requested does not exist in the list.");
         }
      }
      else {
         throw new IllegalArgumentException("The task requested does not exist.");
      }
   }
//*****************************************************************************************   
   
   /**
      * processGradeItemData() - Validates input code and provides data for the GradeItem constructor
      * @param data - The array holding the data for gradeItem1
   */      
   public static void processGradeItemData(String[] data) {
      if(data[0].equals("GRADE ITEM")) {
         // STUB STUB STUB
      }
   }
//*****************************************************************************************

   /**
       * Generates a report based on arrays from both Lists
       *
       * param OUTPUT_FILE - the file that the report will be written upon.
       */ 
   public static void generateReport() throws IOException {
      
      PrintWriter output = new PrintWriter(new FileWriter(OUTPUT_FILE));
      
      Object[] studentList = listOfStudents.toArray();
      GradeItem[] gradeItemArray;
      
      int sumTotal = 0;
      int sumAchieved = 0;
      double percent = 0;
      String insert = ("=========================================================");
      
      for(int i = 0; i < studentList.length; i++) {
         Student student = (Student)studentList[i];
         output.println(student.getID());
         // output.println("   Grade Items");

        /* for(int j = 0; i > 10; j++) {
            // toArray() loop for Grade Items
         } 
         output.println(insert);
         output.println("   Total                               " + sumTotal +
                           "   " + sumAchieved + "    " + percent + "%");
         output.println(""); */
      }
      output.close();
   }
} // end of class