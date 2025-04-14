package myproject;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Stack Demo ===");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack(); // 10 20 30
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Top: " + stack.peek());   // 20

        System.out.println("\n=== Queue Demo ===");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.printQueue(); // A B C
        System.out.println("Dequeued: " + queue.dequeue()); // A
        System.out.println("Front: " + queue.peek());       // B

        System.out.println("\n=== MinHeap Demo ===");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(5);
        heap.add(2);
        heap.add(7);
        heap.add(1);
        heap.printHeap(); // 1 2 7 5
        System.out.println("Min: " + heap.poll()); // 1
        heap.printHeap(); // 2 5 7
    }
}

