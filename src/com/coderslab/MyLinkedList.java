package com.coderslab;


public class MyLinkedList<E> extends MyAbstractList<E> {

    MyArrayList<Node> list;

    public class Node {


        Object data;
        int next;

        public Node(Object o) {
            if(list.size() ==0){
                data = o;
                this.next =1;
            }
            else{
                data = o;
                next = list.size()+1;
            }
        }

        public Node(int index, Object o){

                data= o;
                next = index +1;
                for (int i= index; i<list.size();i++){
                    list.get(i).setNext(list.get(i).getNext()+1);
                }
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public int getNext() {
            return next;
        }

        public void setNext(int next) {
            this.next = next;
        }

    }

    public MyLinkedList() {
        list = new MyArrayList<>();
    }

    @Override
    public boolean add(Object o) {
        Node node = new Node(o);
        list.add(node);

     /*   list =sortedList(list);*/

        return true;
    }

    @Override
    public boolean add(int index, Object o) {

        Node node = new Node(index, o);
        list.add(node);
        list =sortedList(list);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int position =list.find(o);
        list.remove(position);
        return true;
    }

    @Override
    public boolean remove(int index) {
        list.remove(index);
        System.out.println("list.size() w metodzie remove w klasie MyLinkedList: "+list.size());
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i =0; i<list.size();i++){

            System.out.println(list.size());
            stringBuilder.append(list.get(i).data).append(",");
        }
        return stringBuilder.toString();
    }


    @Override
    public E get(int position) {
        return (E)list.get(position).data;
    }

    @Override
    public int size() {
        return list.size();
    }

    private MyArrayList<Node> sortedList(MyArrayList<Node> list){
        MyArrayList<Node> newArrayList = new MyArrayList<>();

        for (int i =0; i< list.size(); i++){
            for (int j =0;j<list.size(); j++){
                if(list.get(j).getNext()-1 == i){
                    newArrayList.add(list.get(j));
                }
            }
        }
        return newArrayList;
    }
/*
private void decreaseIndexAfterRemove(int index){
    for (int i = index; i < ; i++) {

    }*/
}

