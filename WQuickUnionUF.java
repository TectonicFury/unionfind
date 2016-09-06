public class WQuickUnionUF{
	private int[] id;
	private int[] size;
	public WQuickUnionUF(int N){
		id=new int[N];
		size=new int[N];
	}
	private int root(int p){
		int i;
		for(i=p;i!=id[i];i=id[i]){
			id[i]=id[id[i]];
		}
		return i;
	}
	public boolean connected(int p,int q){
		return root(p)==root(q);
	}
	public void union(int p,int q){
		int pid=root(p);
		int qid=root(q);
		if(size[p]>size[q]){
			id[qid]=pid;
			size[pid]+=size[qid];
		}
		else{
			id[pid]=qid;
			size[qid]+=size[pid];
		}
	}
			 
