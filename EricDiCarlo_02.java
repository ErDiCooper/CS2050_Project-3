import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class EricDiCarlo_02 {

   private static List listOfStudents; // A list for all valid Student objects
   private static List listOfGradeItems; // A list for all valid GradeItem objects
   private static final String INPUT_FILE = "Project_03_Input01.txt"; // Input file to be fed into lists
   private static final String OUTPUT_FILE = "Project_03_Output01.txt"; // Output file for lists   
   
   private static File inputFile;
   private static Scanner input;
   
//****************************************************************************************

   public static void main(String[] args) throws IOException {
   
   File inputFile = new File(INPUT_FILE);
   Scanner input = new Scanner(inputFile);
      
      System.out.println("Reading data from file Project_03_Input01.txt");
      while(input.hasNext()) {
         processInput();
      }
      
      
         
   } // end of main
//*****************************************************************************************
   
   /**
      * processInput() - Processes the date from the input file and directs it depened on object type.
   */
   public static void processInput() {
      
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
   public void generateReport() {
      // STUB STUB STUB
   }
} // end of class