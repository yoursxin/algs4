package algs;

public class WeightedQuickUnionUF {
	
	private int count;
	private int[] id;
	private int[] sz;
	
	public WeightedQuickUnionUF(int N){
		id = new int[N];
		sz = new int[N];
		for(int i=0; i<N; i++){
			id[i]=i;
			sz[i]=1;
		}
		count = N;
	}
	
	public int find(int i){
		while(id[i]!=i){
			i = id[i];
		}
		return id[i];
	}
	
	
	public boolean connected(int p,int q){
		return find(p) == find(q);
	}
	
	public int count(){
		return count;
	}
	
	public void union(int p,int q){
		
		
		int rootp = find(p);
		int rootq = find(q);
		if(rootp == rootq)
			return;
		
		if(sz[p]>sz[q]){
			id[q]=rootp;
			sz[q]+=sz[p];
		}else{
			id[p]=rootq;
			sz[p]+=sz[q];
		}
		count--;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
