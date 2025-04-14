package myproject;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    // Adds an element and restores the heap property
    public void add(T item) {
        list.add(item);
        heapifyUp(list.size() - 1);
    }

    // Removes and returns the minimum element (root)
    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = list.get(0);
        T last = list.get(list.size() - 1);
        list.set(0, last);
        list.remove(list.size() - 1);
        heapifyDown(0);
        return min;
    }

    // Returns the minimum element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return list.get(0);
    }

    // Checks if the heap is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Returns the size of the heap
    public int size() {
        return list.size();
    }

    // Heapify up (restore heap after add)
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    // Heapify down (restore heap after poll)
    private void heapifyDown(int index) {
        int size = list.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && list.get(right).compareTo(list.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    // Swap two elements in the list
    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // Print heap as array
    public void printHeap() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
