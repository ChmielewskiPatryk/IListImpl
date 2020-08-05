package com.coderslab;

import java.util.Arrays;

 class MyArrayList<E> implements ImyList<E> {

    private int capacity = 0;
    private Object [] arr;

    public MyArrayList(){
        arr= new Object[capacity];
    }
    public MyArrayList(int size){
        arr = new Object[size];
    }
 /*   public myAbstractList(myCollection<? extends E> e){
        to do in future.
    }*/

    @Override
    public boolean add(Object o) {
        increaseCapacity();
        arr[capacity - 1] = o;
        return true;

    }
    @Override
    public boolean add(int index, Object o) {
        set(index, o);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int[] positions = findAll(o);

        for (int i = 0; i < positions.length; i++) {
            arr[positions[i]] = null;
        }
        removeNullValues();
        arr = Arrays.copyOf(arr, arr.length - positions.length);
        return true;
    }

    @Override
    public boolean remove(int index) {

        try {
            arr[index] = null;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    removeNullValues();
                    arr = Arrays.copyOf(arr, arr.length - 1);
                }

            }
        } catch (IndexOutOfBoundsException E) {
            E.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public E get(int position) {
        return (E) arr[position];
    }

    @Override
    public void set(int position, Object o) {
        if (position < arr.length)
            arr[position] = o;
    }

    @Override
    public int size() {
        return arr.length;
    }


    @Override
    public void sort() {
        Arrays.sort(arr);
    }

    @Override
    public int[] findAll(Object o) {
        int[] resultArr = new int[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(o)) {
                resultArr = Arrays.copyOf(resultArr, resultArr.length + 1);
                resultArr[resultArr.length - 1] = i;
            }
        }
        return resultArr;
    }


    @Override
    public int find(Object o) {
        int result=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(o)) {
                result = i;
            }
            else{
                result = -1;
            }
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        if(arr.length ==0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
       if(findAll(o).length>0){
           return true;

       }else {
           return false;
       }

    }

    @Override
    public void clear() {
        arr = Arrays.copyOf(arr,0);

    }

    @Override
    public String toString() {
        return "myAbstractList{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    private void removeNullValues() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
            }
        }
    }

    private void increaseCapacity() {
        capacity++;
        arr = Arrays.copyOf(arr, capacity);
    }


}
