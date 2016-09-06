import javax.swing.JOptionPane;
public class NameDialog{
	public static void main(String args[]){
		String prompt="What is your name?";
		String name = JOptionPane.showInputDialog(prompt);
		
		if(name=="Ahmad"){
			System.out.printf("Ya Allaah mujhe maaf kar dijiye please ya Allaah\n");
		}
		else if(name=="Abbasi"){
			JOptionPane.showMessageDialog(null,"Allaah mujhe maaf kar dijiye\n");
		}
		String response= String.format("Welcome to Java %s!",name);
		JOptionPane.showMessageDialog(null,response);
	}
}
