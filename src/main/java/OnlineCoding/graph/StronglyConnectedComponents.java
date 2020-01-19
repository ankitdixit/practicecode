package OnlineCoding.graph;

import java.util.Stack;

public class StronglyConnectedComponents
{
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components "+
                "in given graph ");
        printSCCs(g);
    }

    private static void printSCCs(Graph g)
    {
        int[] orderedVertices = dfs(g);
        Graph gTranspose = g.getTranspose();
        printComponents(gTranspose, orderedVertices);
    }

    private static void printComponents(Graph g, int[] orderedVertices)
    {
        boolean[] visited = new boolean[g.getVertexCount()];
        for (int i = 0; i < g.getVertexCount(); i++) {
            if (visited[i]) continue;
            System.out.println();
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            visited[i] = true;
            while (!stack.isEmpty()) {
                int node = stack.pop();
                System.out.print(node + ",");
                for (int child : g.getAdj(node)) {
                    if (!visited[child]) {
                        stack.push(child);
                        visited[child] = true;
                    }
                }
            }
        }
    }

    private static int[] dfs(Graph g)
    {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[g.getVertexCount()];
        int[] visitedOrder = new int[g.getVertexCount()];
        int count = 0;

        for (int i = 0; i < g.getVertexCount(); i ++) {
            if (visited[i]) {
                continue;
            }
            stack.push(i);
            visited[i] = true;
            while(!stack.isEmpty()) {
                int node= stack.pop();
                visitedOrder[count++] = node;
                for (int j = 0; j < g.getAdj(node).size(); j++) {
                    int child = g.getAdj(node).get(j);
                    if (!visited[child]) {
                        stack.push(child);
                        visited[child] = true;
                    }
                }
            }
        }

        /*for (int i = 0; i < visitedOrder.length / 2; i++) {
            int temp = visitedOrder[i];
            visitedOrder[i] = visitedOrder[visitedOrder.length -1 -i];
            visitedOrder[visitedOrder.length -1 -i] = temp;
        }*/
        return visitedOrder;
    }
}
