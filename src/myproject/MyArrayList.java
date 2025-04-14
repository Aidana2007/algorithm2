package myproject;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements; // Array to store elements
    private int length;        // Number of elements in the list

    // Constructor with initial capacity of 5
    public MyArrayList() {
        elements = new Object[5];
        length = 0;
    }

    // Adds an element to the end
    @Override
    public void add(T item) {
        if (length == elements.length) {
            increaseCapacity(); // resize if needed
        }
        elements[length++] = item;
    }

    // Replaces element at specific index
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    // Adds element at a specific index
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (length == elements.length) {
            increaseCapacity();
        }
        // Shift elements to the right
        for (int i = length; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        length++;
    }

    // Adds element to the beginning
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    // Adds element to the end (same as add)
    @Override
    public void addLast(T item) {
        add(item);
    }

    // Returns element at specific index
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Returns first element
    @Override
    public T getFirst() {
        return get(0);
    }

    // Returns last element
    @Override
    public T getLast() {
        return get(length - 1);
    }

    // Removes element by index
    @Override
    public void remove(int index) {
        checkIndex(index);
        // Shift left to fill the gap
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[length - 1] = null;
        length--;
    }

    // Removes first element
    @Override
    public void removeFirst() {
        remove(0);
    }

    // Removes last element
    @Override
    public void removeLast() {
        remove(length - 1);
    }

    // Sorts list using bubble sort
    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                T current = (T) elements[j];
                T next = (T) elements[j + 1];
                if (current.compareTo(next) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    // Returns index of first occurrence of object
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    // Returns index of last occurrence of object
    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    // Checks if list contains the object
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Returns array with all elements
    @Override
    public Object[] toArray() {
        Object[] result = new Object[length];
        for (int i = 0; i < length; i++) {
            result[i] = elements[i];
        }
        return result;
    }

    // Clears all elements
    @Override
    public void clear() {
        elements = new Object[5];
        length = 0;
    }

    // Returns number of elements
    @Override
    public int size() {
        return length;
    }

    // Checks if index is valid
    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }

    // Doubles the capacity of the array
    private void increaseCapacity() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    // Iterator implementation so we can use for-each loop
    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator();
    }

    private class Iterator implements java.util.Iterator<T> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < length;
        }

        public T next() {
            return (T) elements[currentIndex++];
        }
    }
}

