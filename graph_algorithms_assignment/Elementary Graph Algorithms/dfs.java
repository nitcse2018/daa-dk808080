// Java program to print DFS traversal from a given given graph 
import java.io.*; 
import java.util.*; 

public class dfs 
{ 
	private int nv; // No. of vertices 
  
	private LinkedList<Integer> adj[];  // Adjacency list

	dfs(int v) 
	{ 
		nv = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	//Function to add an edge into the graph 
	void addEdge(int v, int w) 
	{ 
		adj[v].add(w); 
	} 


	void DFSUtil(int v,boolean visited[]) 
	{ 
		// Mark the current node as visited and print it 
		visited[v] = true; 
		System.out.print(v+", "); 

		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = adj[v].listIterator(); 
		while (i.hasNext()) 
		{ 
			int n = i.next(); 
			if (!visited[n]) 
				DFSUtil(n, visited); 
		} 
	} 

	// The function to perform DFS traversal.
	void DFS(int v) 
	{ 
		
		boolean visited[] = new boolean[nv]; 

		// Call the recursive helper function to print DFS traversal 
		DFSUtil(v, visited); 
	} 

	public static void main(String args[]) 
	{ 
		dfs graph = new dfs(8); 

    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(1, 0);
    graph.addEdge(2, 1);
    graph.addEdge(2, 3);
    graph.addEdge(3, 2);
    graph.addEdge(3, 4);
    graph.addEdge(3, 5);
    graph.addEdge(4, 3);
    graph.addEdge(4, 5);
    graph.addEdge(4, 6);
    graph.addEdge(5, 3);
    graph.addEdge(5, 4);
    graph.addEdge(5, 6);
    graph.addEdge(5, 7);
    graph.addEdge(6, 4);
    graph.addEdge(6, 5);
    graph.addEdge(6, 7);
    graph.addEdge(7, 5);
    graph.addEdge(7, 6);
    System.out.println("following is the DFS traversal using vertex 2 as source vertex : ");
    graph.DFS(2);
	} 
} 

