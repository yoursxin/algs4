package algs;

public class DepthFirstSearch {
	
	private boolean[] marked;
	private int count;
	
	public DepthFirstSearch(Graph g, int s){
		marked = new boolean[g.V()];		
		dfs(g,s);
	}
	private void dfs(Graph g, int s){
		marked[s] = true;
		count++;
		for(int w: g.adj(s)){
			if(!marked[w]){
				dfs(g, w);
			}
		}
	}
	
	public boolean marked(int v){
		return marked[v];
	}
	public int count(){
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
