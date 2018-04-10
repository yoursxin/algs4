package algs.W1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Union-find with specific canonical element. Add a method find() to the
 * union-find data type so that find(i) returns the largest element in the
 * connected component containing i. The operations, union(), connected(), and
 * find() should all take logarithmic time or better. For example, if one of the
 * connected components is {1,2,6,9}, then the find() method should return 9 for
 * each of the four elements in the connected components.
 * 
 * @author xin
 *
 */
public class UFLarge {

	int[] sz;
	int[] id;
	int[] large;
	int count;

	public UFLarge(int N) {
		sz=new int[N];
		id = new int[N];
		large = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
			large[i] = i;
		}
		count = N;
	}

	public int root(int i) {
		while (id[i] != i) {
			i = id[i];
		}
		return i;
	}

	public int find(int i) {
		return large[root(i)];
	}
	public int count(){
		return count;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p,int q){
		int rootp = root(p);
		int rootq = root(q);
		if(rootp == rootq) 
			return;
		
		if(sz[rootp]>sz[rootq]){
			id[rootq] = p;
			sz[rootp]+=sz[rootq];
			
			if(large[rootp]<large[rootq]){
				large[rootp]=large[rootq];
			}
			
			
		}else{
			id[rootp] = q;
			sz[rootq] += sz[rootp];
			if(large[rootq]<large[rootp]){
				large[rootq]=large[rootp];
			}
			
		}
		count--;
	}

	public static void main(String[] args) {
		UFLarge uf = new UFLarge(10);
        uf.union(0, 2);
        uf.union(8, 4);
        StdOut.println(uf.find(0) == 2);
        StdOut.println(uf.find(4) == 8);
        uf.union(0, 4);
        StdOut.println(uf.find(0) == 8);
        StdOut.println(uf.find(2) == 8);
        uf.union(0, 6);
        StdOut.println(uf.find(6) == 8);
        uf.union(1, 9);
        uf.union(1, 2);
        StdOut.println(uf.find(4) == 9);
        StdOut.println("count:"+uf.count());

	}

}
