package com.coderslab;

public interface ImyCollection<E> {

    boolean add(E e);

    boolean add(int index, E e);

    boolean remove(E e);

    boolean remove(int i);

    Object get(int position);

    void set(int position, E e);

    int size();

    void sort();

    int[] findAll(Object o);

    int find(Object o);

    boolean isEmpty();

    boolean contains(Object o);

    void clear();
}
