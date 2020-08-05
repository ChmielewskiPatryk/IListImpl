package com.coderslab;


import java.util.Arrays;

public class MyLinkedList<E> implements ImyList<E> {

    private Node head;
    private Node tail;


    private class Node {
        private Object data;
        private Node next;

        protected Node(Object data) {
            this.data = data;

        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private boolean addHead(Object data) {
        Node node = new Node(data);
        node.setNext(head.getNext());
        head = node;

        return true;

    }

    private boolean addNode(Object data) {

        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
        }
        tail.setNext(node);
        tail = node;


        return true;
    }


    @Override
    public boolean add(Object o) {
        addNode(o);
        return true;
    }

    @Override
    public boolean add(int index, Object o) {
        if (index == 0) {
            addHead(o);
        } else {
            Node oldNode = findNode(index);
            Node newNode = new Node(o);
            newNode.setNext(oldNode);
            findNode(index - 1).setNext(newNode);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        remove(find(o));

        return true;
    }

    @Override
    public boolean remove(int i) {
        if (i < 0) {
            return false;
        } else {

            if (i == 0) {
                head = findNode(1);
                return true;
            } else if (i == size()) {
                tail = findNode(i - 1);
                return true;
            } else {
                Node nodeToRemove = findNode(i);
                Node previousNode = findNode(i - 1);
                previousNode.setNext(nodeToRemove.getNext());
                nodeToRemove.setNext(null); //dobra jak zniszczyć obiekt ?

            }
        }


        return true;
    }

    @Override
    public E get(int position) {

        return (E) findNode(position).getData();

    }

    @Override
    public void set(int index, Object o) {
        Node newNode = new Node(0);
        add(index, o);

    }

    @Override
    public int size() {
        int counter = 1;
        Node tempNode = head;

        if (head == null) {
            return 0;
        } else if (head.equals(tail)) {
            return 1;
        }

        while (tempNode != tail) {

            tempNode = tempNode.getNext();
            counter++;
        }

        return counter;
    }

    @Override
    public void sort() {

    }

    @Override
    public int[] findAll(Object o) {
        int[] arr = new int[0];
        int counter = 0;
        Node tempNode = head;
        while (counter < size()) {
            if (tempNode.getData() == o) {
                arr = Arrays.copyOf(arr, arr.length + 1);
                arr[arr.length - 1] = counter;

            } else if (tail == tempNode) {
                return arr;
            }
            tempNode = tempNode.getNext();
            counter++;
        }
        return arr;
    }

    @Override
    public int find(Object o) {

        int counter = 0;
        Node tempNode;
        tempNode = head;
        while (counter < size()) {
            if (tempNode.getData().equals(o)) {
                return counter;
            } else if (tail == tempNode) {
                return -1;
            }
            tempNode = tempNode.getNext();
            counter++;
        }

        return 0;
    }


    @Override
    public boolean isEmpty() {
        if (head != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {
        if (find(0) > -1) {
            return true;
        } else {
            return false;
        }

    }


    @Override
    public void clear() {
        head = null;   //pytanie  co się dzieje z pozostałymi obiektami? Są niszczone?
        tail = null;

    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append(": [");
        for (int i = 0; i < size(); i++) {
            if (i == 0) {
                stringBuilder.append(get(i));
            } else {
                stringBuilder.append(",").append(get(i));
            }

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public E getFirst() {
        return (E) head.getData();
    }

    public E getLast() {
        return (E) tail.getData();
    }

    private Node findNode(int index) {
        if (index < 0) {
            return null;
        } else {
            int counter = 0;
            Node tempNode;
            tempNode = head;
            while (counter < index) {
                if (tail == tempNode) {
                    return null;
                }
                tempNode = tempNode.getNext();
                counter++;
            }
            return tempNode;
        }
    }

    public Object[] toArray() {
        Object[] arr = new Object[size()];
        for (int i = 0; i < size(); i++) {
            arr[i] = get(i);

        }
        return arr;
    }
}

