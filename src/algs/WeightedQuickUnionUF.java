package algs;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

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
			id[rootq]=p;
			sz[p]+=sz[q];
		}else{
			id[rootp]=q;
			sz[q]+=sz[p];
		}
		count--;
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(!uf.connected(p, q)){
				uf.union(p, q);
				StdOut.println(p+" - "+q);
			}
			
			
		}	
		StdOut.println("count:"+uf.count());
		

	}

}
