package com.laba.solvd.HW_ShoppingMallApp.LinkedList;

import java.util.*;

public class CustomLinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }


    /* Method which must be implemented:

    hashCode();
    equals();
    void clear();
    boolean removeAll(Collection<?> c);
    boolean addAll(Collection<? extends E> c);
    boolean containsAll(Collection<?> c);
    boolean remove(Object o);
    boolean add(E e);
    boolean contains(Object o);
    boolean isEmpty();
    int size();

     */

    @Override
    public int hashCode() {
        int hash = 1;
        for (T element : this) {
            hash = 17 * hash + (element == null ? 0 : element.hashCode());
        }
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomLinkedList<?> that = (CustomLinkedList<?>) o;
        return size == that.size && Objects.equals(head, that.head);
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        for (Object element : c) {
            modified |= remove(element);
        }
        return modified;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if (Objects.equals(head.data, o)) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null && !Objects.equals(current.data, o)) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        previous.next = current.next;
        size--;
        return true;
    }

    @Override
    public boolean add(T e) {
        Node<T> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while (current != null) {
            if (Objects.equals(current.data, o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
            if (iterator.hasNext()) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }


    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    // Method to display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(); // For a new line after the list
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}