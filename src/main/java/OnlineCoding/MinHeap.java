package OnlineCoding;

public class MinHeap
{
    int[] heap;
    int maxSize;
    int size;

    public MinHeap(int maxSize)
    {
        heap = new int[maxSize+ 1];
        heap[0] = Integer.MIN_VALUE;
        size = 0;
        this.maxSize = maxSize;
    }

    public void insert(int element)
            throws Exception
    {
        if (size == maxSize) {
            throw new Exception("Heap already full");
        }

        heap[++size] = element;
        int pos = size;
        while (heap[pos] < heap[pos /2]) {
            int temp = heap[pos /2];
            heap[pos /2] = heap[pos];
            heap[pos] = temp;
        }
    }

    public int remove()
            throws Exception
    {
        if (size == 0) {
            throw new Exception("The heap is empty");
        }
        int result = heap[1];
        heap[1] = heap[size--];
        heapify(1);
        return result;
    }

    private void heapify(int index)
    {
        if (size >= index * 2 && heap[index * 2] < heap[index]) {
            int temp = heap[index];
            heap[index] = heap[index * 2];
            heap[index * 2] = temp;
            heapify(index * 2);
        }

        else if(size >= ((index * 2) + 1)  && heap[(index * 2) + 1] < heap[index]) {
            int temp = heap[index];
            heap[index] = heap[(index * 2) + 1];
            heap[index * 2 + 1] = temp;
            heapify((index * 2) + 1);
        }
    }

    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--) {
            heapify(pos);
        }
    }

    // Function to print the contents of the heap
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            if (i == size && size % 2 == 0) {
                System.out.print(" PARENT : " + heap[i]
                        + " LEFT CHILD : " + heap[2 * i]
                        + " RIGHT CHILD :" + heap[2 * i + 1]);
                System.out.println();
            }
            else {
                System.out.print(" PARENT : " + heap[i]
                        + " LEFT CHILD : " + heap[2 * i]
                        + " RIGHT CHILD :" + "NOT PRESENT");
                System.out.println();
            }
        }
    }

    public static void main(String[] arg)
            throws Exception
    {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        int a =2; int b = 2;
        int mid = (int) Math.ceil((int)(a + b) /2);
/*
        minHeap.insert(10);
*/
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();

        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
    }
}
