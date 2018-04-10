package algs.W1;
import  edu.princeton.cs.algs4.StdOut;


/**
 * 第 3 个问题
Successor with delete. Given a set of n integers S={0,1,...,n−1} and a sequence 
of requests of the following form:

Remove x from S
Find the successor of x: the smallest y in S such that y≥x.
design a data type so that all operations (except construction) take logarithmic time 
or better in the worst case.
 * @author xin
 *
 */
public class UFSuccessor{
	private boolean[] data;
	private UFLarge uf;
	private int N;
	
	public UFSuccessor(int N){
		this.N = N;
		uf = new UFLarge(N);
		data = new boolean[N];
		for(int i=0; i<N; i++){
			data[i] = true;
		}
	}
	
	public void remove(int i){
		data[i] = false;
		if(i>0 && !data[i-1]){
			uf.union(i, i-1);
		}
		if(i<N-1 && !data[i+1]){
			uf.union(i, i+1);
		}
	}
	
	public int getSuccessor(int i){
		if(data[i]){
			return i;
		}else{
			int succ =  uf.find(i)+1;
			if(succ>=N){
				return -1;
			}else{
				return succ;
			}
			
		}
		
		
	}

	public static void main(String[] args) {
		UFSuccessor test = new UFSuccessor(10);
        test.remove(2);
        StdOut.println(test.getSuccessor(2) == 3);
        test.remove(3);
        StdOut.println(test.getSuccessor(2) == 4);
        StdOut.println(test.getSuccessor(8) == 8);
        test.remove(8);
        StdOut.println(test.getSuccessor(8) == 9);
        test.remove(9);
        StdOut.println(test.getSuccessor(8) == -1);
        test.remove(5);
        test.remove(4);
        StdOut.println(test.getSuccessor(3) == 6);

	}

}
