public class QuickUnionUF{
	private int[] id;
	
	public QuickUnionUF(int N){
		id = new int[N];
		for(int i=0;i<N;i++){
			id[i]=i;
		}
	}

	public int root(int p){
		int i;
		for( i=p;id[i]!=i;i=id[i]);
		return i;
	}

	public boolean connected(int p,int q){
		return root(p)==root(q);
	}

	public void union(int p,int q){
		int pid,qid;
		pid=root(p);
		qid=root(q);
		id[pid]=qid;
	}

}
			
