package myproject;

public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    // Adds an element to the top of the stack
    public void push(T item) {
        list.add(item);
    }

    // Removes and returns the top element of the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    // Returns the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Returns the size of the stack
    public int size() {
        return list.size();
    }

    // Prints the elements from bottom to top
    public void printStack() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
