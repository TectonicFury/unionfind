import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
public class TestStdOut{
	public static void main(String[] args){
		int a=17;
		int b=23;
		int sum=a+b;
		StdOut.println("Hello,World!");
		StdOut.printf("%d + %d = %d random=%d\n",a,b,sum,StdRandom.uniform(10));
	}
}
