package OnlineCoding.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List

    //Constructor
    public Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    //Function to add an edge into the graph
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
    }

    // Function that returns reverse (or transpose) of this graph
    Graph getTranspose()
    {
        Graph g = new Graph(V);
        for (int v = 0; v < V; v++)
        {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    public int getVertexCount()
    {
        return V;
    }

    public LinkedList<Integer> getAdj(int i)
    {
        return adj[i];
    }

}
