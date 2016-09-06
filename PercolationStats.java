import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats{
	
	private int counter=0;
	private double[] probability;
	private int numberOfTrials;
	public PercolationStats(int n,int trials){
		int index_i;
		int index_j;
		int test=0;
		int size = n*n;
		numberOfTrials=trials;
		probability = new double[trials];
		
		StdRandom.getSeed();
		
		for(test=0;test<trials;test++){
			Percolation object = new Percolation(n);
        	while(!object.percolates()){				
				index_i=StdRandom.uniform(n)+1;
				index_j=StdRandom.uniform(n)+1;
				if(!object.isOpen(index_i,index_j)){	
					object.open(index_i,index_j);
					counter++;
				}
			}
			probability[test]=(1.0*counter)/size;
			counter=0;
		}
	}
	public double mean(){
		return StdStats.mean(probability);
	}
	public double stddev(){
		if(numberOfTrials<=1)return Double.NaN;
		return StdStats.stddev(probability);
	}
	public double confidenceLo(){
		if(numberOfTrials<=1)return Double.NaN;
		return mean()-1.96*stddev()/Math.sqrt(numberOfTrials);
	}
	public double confidenceHi(){
		if(numberOfTrials<=1)return Double.NaN;
		return mean()+1.96*stddev()/Math.sqrt(numberOfTrials);
	}
	
    public static void main(String[] args){
		Stopwatch watch = new Stopwatch();
		int n,trials;
		n=Integer.parseInt(args[0]);
		trials=Integer.parseInt(args[1]);
		PercolationStats pSO = new PercolationStats(n,trials);
		StdOut.printf("mean                     = %.15f\n",pSO.mean());
		StdOut.printf("stddev                   = %.15f\n",pSO.stddev());
		StdOut.printf("95%% confidence interval = %.15f, %.15f\n",pSO.confidenceLo(),pSO.confidenceHi());
		StdOut.printf("Elapsed time = %.15f\n",watch.elapsedTime());
	}	
}