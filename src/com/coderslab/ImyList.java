package com.coderslab;

public interface ImyList<E> extends ImyCollection<E> {
    @Override
    boolean add(Object o);

    @Override
    boolean add(int index, Object o);

    @Override
    boolean remove(Object o);

    @Override
    boolean remove(int i);

    @Override
    E get(int position);

    @Override
    void set(int position, Object o);

    @Override
    int size();

    @Override
    void sort();

    @Override
    int[] findAll(Object o);

    @Override
    default int find(Object o) {
        return 0;
    }

    @Override
    boolean isEmpty();

    @Override
    boolean contains(Object o);

    @Override
    void clear();
}
