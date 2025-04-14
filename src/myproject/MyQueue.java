package myproject;

public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    // Adds an element to the end of the queue
    public void enqueue(T item) {
        list.add(item);
    }

    // Removes and returns the first element in the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T front = list.get(0);
        list.remove(0);
        return front;
    }

    // Returns the first element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }

    // Returns the size of the queue
    public int size() {
        return list.size();
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Prints elements from front to back
    public void printQueue() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}

