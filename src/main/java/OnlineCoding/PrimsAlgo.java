package OnlineCoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;

public class PrimsAlgo
{
    public static void main(String[] args)
    {
        int n = 5;
        int[][] adjacencyMatrix = { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        Map<Integer, Vertex> vertexMap = new HashMap(n);

        for (int i = 0; i < n; i++) {
            if(i == 0) {
                vertexMap.put(i, new Vertex(i, null, 0));
            }
            else {
                vertexMap.put(i, new Vertex(i, null, Integer.MAX_VALUE));
            }
        }

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(vertexMap.values());

        while (!priorityQueue.isEmpty()) {
            //find min
            Vertex closest = priorityQueue.poll();
            System.out.println("Polled :" + closest.toString());
            if (closest.key == Integer.MAX_VALUE){
                System.out.println("Cannot create an mst, disjoint components in the graph");
                return;
            }
            //update neighbours
            updateNeighbours(closest, adjacencyMatrix, vertexMap, priorityQueue);
        }

        vertexMap.values().stream().filter(x -> x.parent != null)
                .forEach(x ->
                        System.out.println(String.format("%d --> %d", x.parent.get(), x.number)));

    }

    private static void updateNeighbours(Vertex v, int[][] adjacencyMatrix, Map<Integer, Vertex> vertexMap, PriorityQueue queue)
    {
        int[] edges = adjacencyMatrix[v.number];
        for(int i = 0; i < edges.length; i++) {
            Vertex neighbourHolder = vertexMap.get(i);
            if (edgeTo(edges[i]) && neighbourHolder.key > edges[i]) {
                neighbourHolder.setParent(Optional.of(v.number));
                neighbourHolder.setKey(edges[i]);
                queue.remove(neighbourHolder);
                queue.add(neighbourHolder);
            }
        }
    }

    private static boolean edgeTo(int i)
    {
        return i > 0;
    }

    static class Vertex
            implements Comparable<Vertex>
    {
        final int number;
        Optional<Integer> parent;
        int key;

        public Vertex(int number, Optional<Integer> parent, int key)
        {
            this.number = number;
            this.parent = parent;
            this.key = key;
        }

        public int getNumber()
        {
            return number;
        }

        public Optional<Integer> getParent()
        {
            return parent;
        }

        public int getKey()
        {
            return key;
        }

        public void setKey(int key)
        {
            this.key = key;
        }

        public void setParent(Optional<Integer> parent)
        {
            this.parent = parent;
        }

        @Override
        public int compareTo(Vertex vertex)
        {
            /*return (key - vertex.key);*/
            return (key - vertex.key);
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) { return true; }
            if (!(o instanceof Vertex)) { return false; }

            Vertex vertex = (Vertex) o;

            if (getNumber() != vertex.getNumber()) { return false; }
            if (getKey() != vertex.getKey()) { return false; }
            return getParent() != null ? getParent().equals(vertex.getParent()) : vertex.getParent() == null;
        }

        @Override
        public int hashCode()
        {
            int result = getNumber();
            result = 31 * result + (getParent() != null ? getParent().hashCode() : 0);
            result = 31 * result + getKey();
            return result;
        }

        @Override
        public String toString()
        {
            return "Vertex{" +
                    "number=" + number +
                    ", parent=" + parent +
                    ", key=" + key +
                    '}';
        }
    }
}
