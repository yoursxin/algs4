package algs;

import java.util.Iterator;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
	private static final String NEWLINE = System.getProperty("line.seperator");
	
	private final int V; // node
	private int E;
	private Bag<Integer>[] adj;

	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag<Integer>();
		}

	}

	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();  //±ßµÄÊýÁ¿
		for (int i = 0; i < E; i++) {
			addEdge(in.readInt(), in.readInt());
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public int degree(int v){
		return adj[v].size();
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append(V + " vertices, "+E+" edges "+ NEWLINE);
		for(int v=0; v < V; v++){
			s.append(v + ": ");
			for(int w : adj[v]){
				s.append(w+" ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
