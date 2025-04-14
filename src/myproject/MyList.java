package myproject;

public interface MyList<T> extends Iterable<T> {
    void add(T item); // Adds an item to the end of the list
    void set(int index, T item); // Replaces the element at the specified index with a new item
    void add(int index, T item); // Adds an item at a specific index
    void addFirst(T item);  // Adds an item at the beginning of the list
    void addLast(T item); // Adds an item at the end of the list (same as add)

    T get(int index);  // Returns the element at the specified index
    T getFirst(); // Returns the first element in the list
    T getLast(); // Returns the last element in the list

    void remove(int index); // Removes the element at the given index
    void removeFirst(); // Removes the first element in the list
    void removeLast(); // Removes the last element in the list

    void sort(); // Sorts the elements in the list

    int indexOf(Object object); // Returns the index of the first occurrence of the object
    int lastIndexOf(Object object); // Returns the index of the last occurrence of the object

    boolean exists(Object object);

    Object[] toArray();

    void clear();
    int size();
}
