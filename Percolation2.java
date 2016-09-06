import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation2{
    private int[][] grid; //The square tile 
	public int[][] fullness;
	public int counter;
    private int size;//The row (or column) dimension
    private int index;//the index of the current element referred by (i,j) in the id object
  
    private WeightedQuickUnionUF id;//The QuickUnion object which contains the data structure
	
    public Percolation2(int n){
        if(n<=0) throw new IllegalArgumentException("Illegal Argument plz");
        grid = new int[n][n];
		fullness = new int[n][n];
        id = new WeightedQuickUnionUF(n*n+3);//so that we can have indices from 1 to n+2
        size=n;//length of a side
		counter=0;
    }
	public int percolationCount(){
		return id.count();
	}
    public void open(int i,int j){
		int iActual=i-1;
		int jActual=j-1;
		if(iActual<0 ||iActual>=size) throw new IndexOutOfBoundsException("row index i out of Bounds\n");
        if(jActual<0 ||jActual>=size) throw new IndexOutOfBoundsException("column index j out of Bounds\n");
       
	    if(grid[iActual][jActual]==0){    
        	grid[iActual][jActual]=1;
			counter++;
            index=iActual*size+jActual+1;//the index in the id object
			if(iActual==0)id.union(index,size+1);//fullness[iActual][jActual]=1;
			if(iActual==size-1)id.union(index,size+2);
			if((iActual-1)>=0){//checking the up index if its open
                 if(isOpen(iActual-1,jActual)==1){
					 id.union(index,index-size);
                 }
            }
			
			if((iActual+1)<size){
				if(isOpen(iActual+1,jActual)==1){
					id.union(index,index+size);
					
				}
			}
            
			if((jActual-1)>=0){//checking the left index if its open
            	if(isOpen(iActual,jActual-1)==1){
                	id.union(index,index-1);
                }
            }
			
			if((jActual+1)<size){
				if(isOpen(iActual,jActual+1)==1){
					id.union(index,index+1);
				}
			}
        }
	}
	public int isOpen(int i,int j){
		if(grid[i][j]==1)return 1;
		else return 0;
    }
    public int isFull(int i,int j){
		if(fullness[i][j]==1)return 1;
		else return 0;
    }
    public int percolates(){
    	if(id.connected(size+1,size+2))return 1;
		return 0;
    }
 
    public static void main(String[] args){
    	int n = 100;
		int k = 0;
		int index_i;
		int index_j;
		int test=0;
		float sum = 0;
		int counter;
   
		StdOut.printf("\n");
		StdRandom.getSeed();
		float[] array = new float[1000];
		for(test=0;test<1000;test++){
			Percolation2 object = new Percolation2(n);
        	for(;;){				
				index_i=StdRandom.uniform(n)+1;
				index_j=StdRandom.uniform(n)+1;	
				object.open(index_i,index_j);
				counter=object.counter;
				if(object.percolates()==1)break;
				k++;
			}
			array[test]=((float)counter)/(n*n);
		}
		
		for(int i=0;i<test;i++)sum+=array[i];
		StdOut.printf("sum =%f\n",sum);
		StdOut.printf("*p = %f \n",(float)sum/test);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				StdOut.printf("%d ",object.grid[i][j]);
			}
			StdOut.printf("\n");
		}
		StdOut.printf("\n");
    }
}

