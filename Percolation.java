import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
    private int[][] grid; //The square tile 
    private int counter;
    private int size;//The row (or column) dimension
    private int index;//the index of the current element referred by (i,j) in the id object
    private WeightedQuickUnionUF id;//The QuickUnion object which contains the data structure
    /*Constructor*/
    public Percolation(int n){
        if(n<=0) throw new IllegalArgumentException("Illegal Argument plz");
        grid = new int[n][n];
        id = new WeightedQuickUnionUF(n*n+3);//so that we can have indices from 1 to n*n+2
        size=n;//length of a side
	counter=0;
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
		
		if(iActual==0)id.union(index,size*size+1);//connecting the top row to the virtual top
		if(iActual==size-1)id.union(index,size*size+2);//connecting the bottom row to virtual bottom
		
		if((iActual-1)>=0){//checking whether its not at the top row
                	if(isOpen(i-1,j)){//if the box just above is open then lets make them connected
				id.union(index,index-size);
                 	}
            	}
			
		if((iActual+1)<size){//checking if its not at the bottom row
			if(isOpen(i+1,j)){
				id.union(index,index+size);
			}
		}
            
		if((jActual-1)>=0){//checking the left index if its open
            		if(isOpen(i,j-1)){
                		id.union(index,index-1);
        		 }
            	}
			
		if((jActual+1)<size){
			if(isOpen(i,j+1)){
				id.union(index,index+1);
			}
		}
        }
    }
    public boolean isOpen(int i,int j){
	int iIndex,jIndex;
	iIndex=i-1;jIndex=j-1;
	return (grid[iIndex][jIndex]==1);
    }
    public boolean isFull(int i,int j){
	int iIndex,jIndex;
	iIndex=i-1;jIndex=j-1;
	return id.connected((iIndex)*size+jIndex+1,size*size+1);//we have converted these indices 
    }
    public boolean percolates(){
    	return id.connected(size*size+1,size*size+2);
    }
	/*Test Client*/
    public static void main(String[] args){
    	int n = 10;
	int k = 0;
	int index_i;
	int index_j;
	int test=0;
	int sum = 0;
	int counter=0;
   
	StdOut.printf("\n");
	StdRandom.getSeed();
	double p_threshold;
	for(test=0;test<3000;test++){
		Percolation object = new Percolation(n);
		while(!object.percolates()){				
			index_i=StdRandom.uniform(n)+1;
			index_j=StdRandom.uniform(n)+1;	
			object.open(index_i,index_j);
		}
	}
	p_threshold=(1.0*sum)/(test*n*n);
	StdOut.printf("*p = %f \n",p_threshold);
     }	
}

