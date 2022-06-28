package ru.vsu.cs.uskova_anna_task1;

public class CyclicQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] arr;
    private int size;
    private int capacity;

    private int first;
    private int last;

    public CyclicQueue() {
        this.capacity = DEFAULT_CAPACITY;
        this.arr = new Object[capacity];
        this.first = 0;
        this.last = -1;
    }

    public void add(T element) {
        if(size == capacity){
            grow();
        }
        if (last == capacity - 1) {
            last = -1;
        }
        arr[++last] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T poll() {
        if(size == 0){
            return null;
        }
        T temp = (T) arr[first++];
        if (first == capacity) {
            first = 0;
        }
        size--;
        return temp;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) arr[first];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void grow() {
        this.capacity *= 2;
        Object[] temp = new Object[capacity];
        int index = 0;
        int i = first;
        do{
            if(i == arr.length){
                i = 0;
            }
            temp[index++] = arr[i++];
        } while(i != last + 1);
        this.arr = temp;
        this.first = 0;
        this.last = index-1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int i = first;
        do{
            if(i == arr.length){
                i = 0;
            }
            builder.append(arr[i++]).append(" ");
        } while(i != last);
        return builder.append(arr[last]).toString();
    }
}
