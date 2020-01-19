package OnlineCoding;

import com.sun.javafx.geom.Edge;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KruskalAlgo
{

    /*
    Algorithm:
    1. Make a disjoint set for each vertex
    2. Sort all edges by weight
    3. Repeat until all n-1 edges found or list empty
        Pick and edge
        - If it joins 2 disjoint sets then join them (same representative element), add edge to result
        - Else discard

    Data structures:
    1. Set
    2. Way to merge sets (representative element)
    3. Sorted edges, edge have to be comparable

     */

    public static void main(String[] args)
    {
        int n = 5;
        int[][] adjacencyMatrix = { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        List<Edge> edges = new ArrayList<>();
        for (int i =0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    edges.add(new Edge(i, j, adjacencyMatrix[i][j]));
                }
            }
        }

        Map<Integer, Node> nodes = new HashMap<>();

        for(int i = 0; i < n; i ++) {
            nodes.put(i, new Node(i, i));
        }


        Collections.sort(edges);
        List<Edge> mstEdges = new ArrayList<>();
        Iterator<Edge> edgeIterator = edges.iterator();
        while(mstEdges.size() < n-1 && edgeIterator.hasNext()) {
            Edge nextEdge = edgeIterator.next();
            if (nodes.get(nextEdge.getU()).getRepValue(nodes) != nodes.get(nextEdge.getV()).getRepValue(nodes)) {
                Node node1 = nodes.get(nextEdge.getU());
                Node node2 = nodes.get(nextEdge.getV());
                if (node1.getRepValue(nodes) < node2.getRepValue(nodes)) {
                    node2.setParentIndex(node1.getIndex());
                    mstEdges.add(nextEdge);
                }
                else if (node1.getRepValue(nodes) < node2.getRepValue(nodes)) {
                    node1.setParentIndex(node2.getIndex());
                    mstEdges.add(nextEdge);
                }
            }
        }

        mstEdges.stream().forEach(x -> System.out.println(x));

    }

    static class Node
    {
        final int index;
        int parentIndex;

        public Node(int index, int parentIndex)
        {
            this.index = index;
            this.parentIndex = parentIndex;
        }

        public void setParentIndex(int parentIndex)
        {
            this.parentIndex = parentIndex;
        }

        public int getIndex()
        {
            return index;
        }

        public int getParentIndex()
        {
            return parentIndex;
        }

        public int getRepValue(Map<Integer, Node> nodeMap)
        {
            if (index == parentIndex) {
                return index;
            }
            return nodeMap.get(parentIndex).getRepValue(nodeMap);
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) { return true; }
            if (!(o instanceof Node)) { return false; }

            Node node = (Node) o;

            if (getIndex() != node.getIndex()) { return false; }
            return getParentIndex() == node.getParentIndex();
        }

        @Override
        public int hashCode()
        {
            int result = getIndex();
            result = 31 * result + getParentIndex();
            return result;
        }
    }

    static class Edge implements Comparable<Edge>
    {
        final int u;
        final int v;
        final int weight;

        public Edge(int u, int v, int weight)
        {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int getU()
        {
            return u;
        }

        public int getV()
        {
            return v;
        }

        public int getWeight()
        {
            return weight;
        }

        @Override
        public int compareTo(Edge o)
        {
            return weight - o.weight;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) { return true; }
            if (!(o instanceof Edge)) { return false; }

            Edge edge = (Edge) o;

            if (getU() != edge.getU()) { return false; }
            if (getV() != edge.getV()) { return false; }
            return getWeight() == edge.getWeight();
        }

        @Override
        public int hashCode()
        {
            int result = getU();
            result = 31 * result + getV();
            result = 31 * result + getWeight();
            return result;
        }

        @Override
        public String toString()
        {
            return "Edge{" +
                    "u=" + u +
                    ", v=" + v +
                    ", weight=" + weight +
                    '}';
        }
    }

}
