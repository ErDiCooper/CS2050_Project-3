import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.text.DecimalFormat;

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
               System.out.println("Student with Student ID " + student.getID() + " was added to the list.");
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
            System.out.println("Student with Student ID " + student.getID() + " was removed from the list.");
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
      if(data[1].equals("ADD")) {
         GradeItem gradeItem = new GradeItem(data[2], data[3], data[4], data[5],
                                             data[6], data[7], data[8]);
         if (listOfGradeItems.contains(gradeItem)) {
            throw new IllegalArgumentException("The entered Student ID already exists.");  
         }
         else {
            try {
               listOfGradeItems.add(gradeItem);
               System.out.println("Assignment with GradeItem ID " + gradeItem.getGradeItemID() + " was added to the list.");
            }
            catch (IllegalArgumentException e) {
               System.err.println("The GradeItem could not be added to the list.");
            }
         }         
      }
      else if(data[1].equals("DEL")) {
         GradeItem gradeItem = new GradeItem(data[2], data[3], data[4], data[5],
                                             data[6], data[7], data[8]);
         try {
            listOfGradeItems.remove(gradeItem);
            System.out.println("Assignment with GradeItem ID " + gradeItem.getGradeItemID() + 
                               " was removed from the list.");
         }
         catch (IllegalArgumentException e) {
            System.err.println("The GradeItem requested does not exist in the list.");
         }
      }
      else {
         throw new IllegalArgumentException("The task requested does not exist.");
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
      Object[] gradeItemList = listOfGradeItems.toArray();
      
      DecimalFormat pointZero = new DecimalFormat("##0.0%");
      
      int sumTotal = 0;
      int sumAchieved = 0;
      double percent = 0.0;
      String idOne;
      String idTwo;
      
      String insert = ("=========================================================");
      
      for(int i = 0; i < studentList.length; i++) {
         Student student = (Student)studentList[i];
         idOne = student.getID();
         output.println(student.getID() + "  " + student.getFirstName() + " " +
                        student.getLastName() + " " + student.getEmail());
         output.println("   Grade Items");
         for(int j = 0; j < gradeItemList.length; j++) {
            GradeItem gradeItem = (GradeItem)gradeItemList[j];
            idTwo = gradeItem.getID();
            
            if (idOne.equals(idTwo)) {
               sumTotal += gradeItem.getMaxScore();
               sumAchieved += gradeItem.getActualScore();
               
               output.print("   " + gradeItem.getGradeItemID() + "   " +
                              gradeItem.getCourseID() + "   ");
                              
               if ((gradeItem.getItemType()).equals("HW")) {
                  output.print(gradeItem.getItemType() + "           ");
               }
               else if ((gradeItem.getItemType()).equals("Class Work")) {
                  output.print(gradeItem.getItemType() + "   ");
               }
               else if ((gradeItem.getItemType()).equals("Test")) {
                  output.print(gradeItem.getItemType() + "         ");
               }
               else if ((gradeItem.getItemType()).equals("Final")) {
                  output.print(gradeItem.getItemType() + "        ");
               }
               output.print(gradeItem.getDate() + "   " + gradeItem.getMaxScore());
               
               if (gradeItem.getActualScore() < 100) {
                  output.print("    " + gradeItem.getActualScore() + "\n");
               }
               else if (gradeItem.getActualScore() > 99) {
                  output.print("   " + gradeItem.getActualScore() + "\n");
               }
            }
         percent = (double)sumAchieved / sumTotal;
         output.println(insert);         
         output.println("   Total                               " + sumTotal +
                        "   " + sumAchieved + "    " + pointZero.format(percent));
         output.println("");
         
         sumTotal = 0;
         sumAchieved = 0;
         }
      }
      output.close();
   }
} // end of class