package algs;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {
	
	private boolean[] marked;	
	private int[] edgeTo;
	private final int s;
	
	public DepthFirstPaths(Graph g, int s){
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		this.s = s;
		dfs(g,s);
	}
	
	private void dfs(Graph g, int v){
		marked[v] = true;		
		for(int w: g.adj(v)){
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(g,w);
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		
		if(!hasPathTo(v)){
			return null;
		}
		Stack<Integer> path = new Stack<Integer>();		
		for(int x=v; x!=s; x=edgeTo[x]){
			path.push(x);
		}
		path.push(s);   //���㲻Ҫ���ˣ�
		return path;
	}	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
