import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private WeightedQuickUnionUF uf;
	private WeightedQuickUnionUF uff; //use for full 
	private boolean[][] sites;
	private int N;
	private int openSitesCount;
	// create n-by-n grid, with all sites blocked
	public Percolation(int n) {
		if(n<=0)
			throw new IllegalArgumentException();
		this.N = n;
		this.openSitesCount = 0;
		
		//add two sites,one is before (1,1),the other is after the (N,N)
		uf = new WeightedQuickUnionUF(n * n+2); 
		uff = new WeightedQuickUnionUF(n * n+1); 
		sites = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sites[i][j] = false;
			}
		}
		for(int i=transIndex(1,1); i<=transIndex(1,N); i++ ){
			uf.union(0, i);
			uff.union(0, i);
		}
		for(int i=transIndex(N,1);i<=transIndex(N,N);i++){
			uf.union(n*n+1, i);
		}			
		
	}
	
	private int transIndex(int row, int col){
		return (row-1)*N+col;
	}

	/**
	 * open site (row, col) if it is not open already
	 * @param row
	 * @param col
	 */
	public void open(int row, int col) {		
		
		checkValid(row,col);
		if(isOpen(row,col))
			return;
		
		sites[row-1][col-1] = true;
		openSitesCount++;
		
		int currentIndex = transIndex(row,col);		
		if(row-1>=1 && isOpen(row-1,col)){
			uf.union(transIndex(row-1,col), currentIndex);	
			uff.union(transIndex(row-1,col), currentIndex);
		}
		if(row+1<=N && isOpen(row+1,col)){
			uf.union(transIndex(row+1,col), currentIndex);	
			uff.union(transIndex(row+1,col), currentIndex);
		}
		if(col-1>=1 && isOpen(row,col-1)){
			uf.union(transIndex(row,col-1), currentIndex);	
			uff.union(transIndex(row,col-1), currentIndex);
		}
		if(col+1<=N && isOpen(row,col+1)){
			uf.union(transIndex(row,col+1), currentIndex);	
			uff.union(transIndex(row,col+1), currentIndex);
		}
		
	}

	/**
	 * is site (row, col) open?
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isOpen(int row, int col) {		
		
		checkValid(row,col);
		return sites[row-1][col-1];
	}

	/**
	 * A full site is an open site that can be connected to an open site in the
	 * top row via a chain of neighboring (left, right, up, down) open sites
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isFull(int row, int col) {
		// is site (row, col) full?
		checkValid(row,col);
		return isOpen(row,col) && uff.connected(0, transIndex(row,col));

	}

	/**
	 * number of open sites
	 * 
	 * @return
	 */
	public int numberOfOpenSites() {
		return openSitesCount;

	}

	/**
	 * does the system percolate?
	 * @return
	 */
	public boolean percolates()   {
		if(N==1)
			return sites[0][0];
		return uf.connected(0, N*N+1);
	}
	
	private void checkValid(int row,int col){
		if(row<1 || row>N || col<1 || col > N){
			throw new IllegalArgumentException();
		}
	}

	// test client (optional)
	public static void main(String[] args){
		/*
		StdOut.println("N=1");
		Percolation p = new Percolation(1);
		StdOut.println(p.numberOfOpenSites() == 0);
		StdOut.println(p.percolates() == true);
		p.open(1, 1);
		StdOut.println(p.percolates() == true);
		
		
		StdOut.println("N=2");
		Percolation p2 = new Percolation(2);		
		p2.open(1, 1);
		StdOut.println(p2.percolates());
		p2.open(2, 2);
		StdOut.println(p2.percolates());
		p2.open(1, 2);
		StdOut.println(p2.percolates());
		
		*/
		
		StdOut.println("N=3");
		Percolation p3 = new Percolation(3);
		StdOut.println(p3.numberOfOpenSites());
		p3.open(1, 1);
		StdOut.println(p3.percolates());
		p3.open(2, 1);
		StdOut.println(p3.percolates());
		p3.open(2, 2);
		StdOut.println(p3.percolates());
		p3.open(3, 2);
		StdOut.println(p3.percolates());
		
		
	}
}
