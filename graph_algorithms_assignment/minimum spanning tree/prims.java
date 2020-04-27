// javacode to implement prim's algorithm. 
// adjacency matrix representation of graph is used.

import java.util.*;
import java.io.*;

class graph
{
  int nv;
  LinkedList<Integer> adj[];
  int[] visited;
  graph(int v)
  {
    nv = v;
    adj = new LinkedList[v];
    for(int i = 0; i<v; i++)
    {
      adj[i] = new LinkedList();
    }
    visited = new int[v];
    for(int i =0; i<v; i++)
    {
      visited[i] =0;
    }
  }
  void addEdge(int v, int w)
  {
    adj[v].add(w);
  }
  int minkey(int key[], int visited[])
  {
    int min = Integer.MAX_VALUE;
    int min_index = -1;
    for(int i =0; i<nv; i++)
    {
      if(visited[i] == 0 && key[i] < min)
      {
        min = key[i];
        min_index = i;
      }
    }
    return min_index;
  }
  void printans(int parent[], int cost[][])
  {
    System.out.println("edge \t\t weight");
    for(int i =1; i<nv; i++)
    {
      System.out.println(parent[i] + " - " + i+ "\t\t" + cost[parent[i]][i]);
    }
  }
void primsMST(int cost[][])
{
  int[] parent = new int[nv];
  int[] key = new int[nv];
  for (int i =0; i<nv; i++)
  {
    key[i] = Integer.MAX_VALUE;
  }
  key[0] = 0;
  parent[0] = -1;
    //MST will have nv vertices.
    for(int count = 0; count<nv; count++)
    {
      // find the node with minimum key value which is not yet visited.
      int u = minkey(key,visited);
      //visited that vertex u.
      visited[u] = 1;
      // find all the adjacents of u
      Iterator<Integer> inte = adj[u].listIterator();
      while(inte.hasNext())
      {
        int ver = inte.next();
        if(visited[ver]==0 && cost[u][ver] < key[ver])
        {
          parent[ver] = u;
          key[ver] = cost[u][ver];
        }
      }

    }

printans(parent, cost);

}
}
public class prims
{
  public static void main(String[] args)
  {
    graph g = new graph(8);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(1, 0);
    g.addEdge(2, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 2);
    g.addEdge(3, 4);
    g.addEdge(3, 5);
    g.addEdge(4, 3);
    g.addEdge(4, 5);
    g.addEdge(4, 6);
    g.addEdge(5, 3);
    g.addEdge(5, 4);
    g.addEdge(5, 6);
    g.addEdge(5, 7);
    g.addEdge(6, 4);
    g.addEdge(6, 5);
    g.addEdge(6, 7);
    g.addEdge(7, 5);
    g.addEdge(7, 6);
    int[][] cost = {
      {0, 2, 0, 0, 0, 0, 0, 0},
      {2, 0, 3, 0, 0, 0, 0, 0},
      {0, 3, 0, 4, 0, 0, 0, 0},
      {0, 0, 4, 0, 5, 6, 0, 0},
      {0, 0, 0, 5, 0, 7, 8, 0},
      {0, 0, 0, 6, 7, 0, 9, 10},
      {0, 0, 0, 0, 8, 9, 0, 11},
      {0, 0, 0, 0, 0, 10, 11, 0}
    };
    g.primsMST(cost);

  }
}
