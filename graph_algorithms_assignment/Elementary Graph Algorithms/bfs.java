// Java program to print BFS traversal from a given source vertex.
import java.util.*;
import java.io.*;
public class bfs
{
  private int nv;   // No. of vertices
  private LinkedList<Integer> adj[]; //Adjacency Lists
  bfs(int v)
  {
    nv = v;
    adj = new LinkedList[v];
    for (int i=0; i<v; ++i)
    {
         adj[i] = new LinkedList();
    }

  }
  void addEdge(int v,int w)
    {
        adj[v].add(w);
    }


  void BFS(int s)
  {
    boolean visited[] = new boolean[nv];

    // Create a queue for BFS
    LinkedList<Integer> Q = new LinkedList<Integer>();

    // Mark the current node as visited and enqueue it
    visited[s]=true;
    Q.add(s);
    while (Q.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = Q.poll();
            System.out.print(s+"\n");

            // Get all adjacent vertices of the dequeued vertex

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    Q.add(n);
                }
            }
        }
  }

  public static void main(String[] args)
  {
       bfs graph = new bfs(8);
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
        System.out.println("following is the BFS traversal using vertex 2 as source vertex : ");
        graph.BFS(2);
  }
}
