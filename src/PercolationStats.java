import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

	
	private int T;
	private double[] result;

	// perform trials independent experiments on an n-by-n grid
	public PercolationStats(int n, int trials) {
		
		if(n<1 || trials<1)
			throw new IllegalArgumentException();
		
		this.T = trials;

		result = new double[trials];
		Percolation p;
		int row;
		int col;
		for (int i = 0; i < trials; i++) {
			p = new Percolation(n);
			while (!p.percolates()) {
				row = StdRandom.uniform(1, n + 1);
				col = StdRandom.uniform(1, n + 1);
				p.open(row, col);
			}
			result[i] = p.numberOfOpenSites()*1.0 / (n * n);

		}
	}

	// sample mean of percolation threshold
	public double mean() {
		return StdStats.mean(result);
	}

	// sample standard deviation of percolation threshold
	public double stddev() {
		return StdStats.stddev(result);
	}

	// low endpoint of 95% confidence interval
	public double confidenceLo() {
		return mean() - 1.96 * stddev() / Math.sqrt(T);
	}

	// high endpoint of 95% confidence interval
	public double confidenceHi() {
		return mean() + 1.96 * stddev() / Math.sqrt(T);
	}

	// test client (described below)
	public static void main(String[] args) {
		//int N = Integer.parseInt(args[0]);
		//int T = Integer.parseInt(args[1]);
		PercolationStats ps = new PercolationStats(100, 50);
		StdOut.printf("mean                    = %f%n", ps.mean());
		StdOut.printf("stddev                  = %f%n", ps.stddev());
		StdOut.printf("95%% confidence interval = %f, %f%n", ps.confidenceLo(), ps.confidenceHi());
	}
}