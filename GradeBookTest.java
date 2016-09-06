import java.util.Scanner;

public class GradeBookTest{
	public static void main(String[] args){
		GradeBook myGradeBook = new GradeBook("");
		System.out.printf("the name of the course is %s: ",myGradeBook.getCourseName());
		System.out.printf("Please enter the name of the course : ");
		
		Scanner input = new Scanner(System.in);
		
		String nameOfCourse = input.nextLine();
		
		myGradeBook.setCourseName(nameOfCourse);
		
		myGradeBook.displayMessage();
	}
}
