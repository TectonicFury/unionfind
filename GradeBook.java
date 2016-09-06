import javax.swing.JOptionPane;
public class GradeBook{
	private String courseName;
	public GradeBook(String name){
		courseName = name;
	}	
	public void setCourseName(String name){
		courseName = name;
	}
	public String getCourseName(){
		return courseName;
	}
	public void displayMessage(){
		String name_course = getCourseName();
		JOptionPane.showMessageDialog(null,"the name of the course is \n "+ name_course + " known by this function\n");
	}
}
