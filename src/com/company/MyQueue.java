package com.company;

import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
    private class Node {
        Node linkToNextElement;
        T element;

        public Node(T element) {
            this.element = element;
            this.linkToNextElement = null;
        }
    }

    private Node headElement;
    private Node tailElement;
    private int size;

    private class MyLinkedIterator implements Iterator<T> {
        private Node shouldNext;
        public MyLinkedIterator(Node start) {
            shouldNext = start;
        }

        @Override
        public boolean hasNext() {
            return shouldNext != null;
        }

        @Override
        public T next() {
            T value = shouldNext.element;
            shouldNext = shouldNext.linkToNextElement;
            return value;
        }
    }

    public Iterator<T> iterator() {
        return new MyLinkedIterator(this.headElement);
    }

    private boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }
    public int size() {
        return size;
    }

    public void add(T value) {
        Node newNode = new Node(value);
        if (isEmpty()){
            headElement = tailElement = newNode;
        } else {
            tailElement.linkToNextElement = newNode;
            tailElement = newNode;
        }
        size++;
    }

    public T remove() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            T value = headElement.element;
            headElement = headElement.linkToNextElement;
            --size;
            return value;
        }
    }

    public T peek() throws Exception{
        Node newNode = headElement;
        if (newNode!=null) return newNode.element; else throw new Exception();
    }
}
