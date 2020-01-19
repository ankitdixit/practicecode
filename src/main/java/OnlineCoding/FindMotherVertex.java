package OnlineCoding;

import OnlineCoding.graph.Graph;

public class FindMotherVertex
{
    //Find a vertex from which all other vertices are reachable

    public static void main(String[] args)
    {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(5, 2);
        g.addEdge(5, 6);
        g.addEdge(6, 0);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        System.out.println(findMother(g));
    }

    private static int findMother(Graph g)
    {
        boolean[] visited = new boolean[g.getVertexCount()];
        int motherCandidate = -1;
        for (int i = 0; i < g.getVertexCount(); i++) {
            int out = dfs(g, i, visited);
            if (out != -1) {
                motherCandidate = out;
            }
        }
        visited = new boolean[g.getVertexCount()];
        dfs(g, motherCandidate, visited);
        for (int i = 0; i < visited.length; i++ ) {
            if (!visited[i]) return -1;
        }

        return motherCandidate;
    }

    private static int dfs(Graph g, int node, boolean[] visited)
    {
        if (visited[node]) {
            return -1;
        }
        visited[node] = true;
        for (int child : g.getAdj(node)) {
            if (!visited[child]) {
                dfs(g, child, visited);
            }
        }
        return node;
    }
}
