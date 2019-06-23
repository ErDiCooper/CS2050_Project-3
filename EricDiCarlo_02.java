import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class EricDiCarlo_02 {

   private static Student student1; // The first Student object
   private static Student student2; // The second Student object
      
   private static GradeItem gradeItem1; // The first GradeItem object
   private static GradeItem gradeItem2; // The second GradeItem object
   

   public static void main(String[] args) throws FileNotFoundException{   
   
      final String INPUT_FILENAME = "Project_02_Input01.txt"; // The initial input file, provided by guidelines
      final String INPUT_FILENAME2 = "Project_02_Input02.txt"; // The second input file, made by students
      
      String tempString; // Data from Scanner inputOne is stored here
      String[] tempArray; // tempString is split() into this array
      String tempString2; // Data from Scanner inputTwo is stored here
      String[] tempArray2; // tempString2 is split() into this array
      
      File inputFileOne = new File(INPUT_FILENAME);
      Scanner inputOne = new Scanner(inputFileOne);
      
      File inputFileTwo = new File(INPUT_FILENAME2);
      Scanner inputTwo = new Scanner(inputFileTwo);
      
      // Test to make sure the Student constructor works
      System.out.println("Running Test 1a:");
      student1 = new Student("900123456", "Joe", "Doe", "joedoe@msudenver.edu");
      System.out.println("Student{" + student1.toString() + "}\n");
      
      // Test to make sure the GradeItem constructor works
      System.out.println("Running Test 1b:");
      gradeItem1 = new GradeItem("900123456", "1", "23456", "HW", "20190112", "100", "95");
      System.out.println("Grade Item{" + gradeItem1.toString() + "}");
      
      
      System.out.println("\n*******************************************************************\n");
      
      System.out.println("Running Test 2a:");
      // Take the data for student1 and student2 and process  
      tempString = inputOne.nextLine();
      tempArray = tempString.split(",");     
      tempString2 = inputTwo.nextLine();
      tempArray2 = tempString2.split(",");
      processStudentData(tempArray, tempArray2);
      // Processing complete
      
      // Test to make sure student1 was processed.    
      System.out.println("Student Object Data");
      System.out.println(student1.getID());
      System.out.println(student1.getFirstName());
      System.out.println(student1.getLastName());
      System.out.println(student1.getEmail() + "\n");
      
      
      System.out.println("Running Test 2b:");
      // Take the data for gradeItem1 and gradeItem2 and process
      tempString = inputOne.nextLine();
      tempArray = tempString.split(",");
      tempString2 = inputTwo.nextLine();
      tempArray2 = tempString2.split(",");
      processGradeItemData(tempArray, tempArray2);
      // Processing complete
      
      // Test to make sure gradeItem1 was processed.
      System.out.println("GradeItem Data");
      System.out.println(gradeItem1.getGradeItemID());
      System.out.println(gradeItem1.getID());
      System.out.println(gradeItem1.getCourseID());
      System.out.println(gradeItem1.getItemType());
      System.out.println(gradeItem1.getDate());
      System.out.println(gradeItem1.getMaxScore());
      System.out.println(gradeItem1.getActualScore());
      
      
      
      System.out.println("\n*******************************************************************\n");
      
      // Ensure that equals() of Student class works as intended
      // Also, test to see if student1 and student2 have unique student IDs
      System.out.println("Running Test 3a:");      
      if (student1.equals(student1)) {
         System.out.println("Student objects are equal: Student IDs are " + student1.getID());
      }
      else {
         System.out.println("Student objects are unequal: Student IDs are " + student1.getID() +
                            " and " + student2.getID());
      }
      if (student1.equals(student2)) {
         System.out.println("Student objects are equal: Student IDs are " + student1.getID());
      }
      else {
         System.out.println("Student objects are unequal: Student IDs are " + student1.getID() +
                            " and " + student2.getID());
      }
      
      
      // Ensure that equals() of GradeItem class works as intended
      // Also, test to see if gradeItem1 and gradeItem2 have unique student IDs
      System.out.println("\nRunning Test 3b:");
      if (gradeItem1.equals(gradeItem1)) {
         System.out.println("GradeItem objects are equal: Student IDs are " + gradeItem1.getID());
      }
      else {
         System.out.println("GradeItem objects are unequal: Student IDs are " + gradeItem1.getID() +
                            " and " + gradeItem2.getID());
      }
      if (gradeItem1.equals(gradeItem2)) {
         System.out.println("GradeItem objects are equal: Student IDs are " + gradeItem1.getID());
      }
      else {
         System.out.println("GradeItem objects are unequal: Student IDs are " + gradeItem1.getID() +
                            " and " + gradeItem2.getID());
      }
   } // end of main
//*****************************************************************************************   
   
   /**
      * processStudentData() - Validates input code and provides data for the Student constructor
      * @param data - The array holding the data for student1
      * @param data2 - The array holding the data for student2
   */   
   public static void processStudentData(String[] data, String[] data2) {
      if(!data[0].equals("STUDENT") || !data2[0].equals("STUDENT")) {
         throw new IllegalArgumentException("The data provided was incompatible with the Student type.");
      }
      if(!data[1].equals("ADD") || !data2[1].equals("ADD")) {
         throw new IllegalArgumentException("This function is only able to ADD data, not remove it.");
      }
      try {
         student1 = new Student(data[2], data[3], data[4], data[5]);
         student2 = new Student(data2[2], data2[3], data2[4], data2[5]);
      }
      catch (IllegalArgumentException e) {
         System.err.println(e);
      }
   }
//*****************************************************************************************   
   
   /**
      * processGradeItemData() - Validates input code and provides data for the GradeItem constructor
      * @param data - The array holding the data for gradeItem1
      * @param data2 - The array holding the data for gradeItem2
   */      
   public static void processGradeItemData(String[] data, String[] data2) {
      if(!data[0].equals("GRADE ITEM") || !data2[0].equals("GRADE ITEM") ) {
         throw new IllegalArgumentException("The data provided was incompatible with the Grade Item type.");
      }
      if(!data[1].equals("ADD") || !data2[1].equals("ADD")) {
         throw new IllegalArgumentException("This function is only able to ADD data, not remove it.");
      }
      try {
         gradeItem1 = new GradeItem(data[3], data[2], data[4], data[5], data[6], data[7], data[8]);
         gradeItem2 = new GradeItem(data2[3], data2[2], data2[4], data2[5], data2[6], data2[7], data2[8]);
      }
      catch (IllegalArgumentException e) {
         System.err.println(e);
      }
   }
}