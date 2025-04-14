package myproject;

// A basic implementation of a doubly linked list using generic type T
public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    // Inner node class (doubly linked)
    private static class MyNode<T> {
        T data;
        MyNode<T> next;
        MyNode<T> prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;

    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public void addFirst(T element) {
        MyNode<T> newNode = new MyNode<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    @Override
    public void addLast(T element) {
        MyNode<T> newNode = new MyNode<>(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(item);
        } else if (index == length) {
            addLast(item);
        } else {
            MyNode<T> current = getNode(index);
            MyNode<T> newNode = new MyNode<>(item);

            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            length++;
        }
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        return tail.data;
    }

    @Override
    public void set(int index, T item) {
        getNode(index).data = item;
    }

    @Override
    public void remove(int index) {
        MyNode<T> node = getNode(index);
        unlink(node);
    }

    @Override
    public void removeFirst() {
        if (head == null) return;
        unlink(head);
    }

    @Override
    public void removeLast() {
        if (tail == null) return;
        unlink(tail);
    }

    @Override
    public boolean exists(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        for (MyNode<T> curr = head; curr != null; curr = curr.next) {
            if (curr.data.equals(o)) return i;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i = length - 1;
        for (MyNode<T> curr = tail; curr != null; curr = curr.prev) {
            if (curr.data.equals(o)) return i;
            i--;
        }
        return -1;
    }

    @Override
    public void sort() {
        if (length < 2) return;
        for (int i = 0; i < length; i++) {
            MyNode<T> current = head;
            while (current != null && current.next != null) {
                if (current.data.compareTo(current.next.data) > 0) {
                    T tmp = current.data;
                    current.data = current.next.data;
                    current.next.data = tmp;
                }
                current = current.next;
            }
        }
    }

    @Override
    public void clear() {
        head = tail = null;
        length = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[length];
        MyNode<T> current = head;
        for (int i = 0; i < length; i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator();
    }

    private class Iterator implements java.util.Iterator<T> {
        private MyNode<T> current = head;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T result = current.data;
            current = current.next;
            return result;
        }
    }

    // Helper to unlink a node
    private void unlink(MyNode<T> node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        length--;
    }

    // Helper to get a node at a specific index
    private MyNode<T> getNode(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }

        MyNode<T> current;
        if (index < length / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = length - 1; i > index; i--) current = current.prev;
        }
        return current;
    }
}

