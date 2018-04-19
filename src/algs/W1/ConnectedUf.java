package algs.W1;
import edu.princeton.cs.algs4.*;

/**
 * Social network connectivity. Given a social network containing n members and a log 
 * file containing m timestamps at which times pairs of members formed friendships,
 *  design an algorithm to determine the earliest time at which all members are connected
 *   (i.e., every member is a friend of a friend of a friend ... of a friend). 
 *   Assume that the log file is sorted by timestamp and that friendship is an
 *    equivalence relation. The running time of your algorithm should be mlogn 
 *    or better and use extra space proportional to n.
 * @author xin
 *
 */

public class ConnectedUf {
	
	public static void main(String[] args){
		int n = StdIn.readInt();
		WeightedQuickUnionUF wuf = new WeightedQuickUnionUF(n);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			String datetime = StdIn.readString();
			StdOut.println(p+" connected "+q+" at "+datetime);
			wuf.union(p, q);
			if(wuf.count() == 1){
				System.out.println("All members were connected at "+datetime);
				break;
			}
		}
		
	}

}
