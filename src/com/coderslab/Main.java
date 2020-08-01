package com.coderslab;


import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

/*        ImyList<String> arr = new myArrayList<>();
        arr.add("Patryk");
        arr.add("Michał");
        arr.add("Adam");
        System.out.println(arr.get(1));*/
    /*    System.out.println(arr.toString());
        arr.sort();
        System.out.println(arr.toString());

        arr.remove("Michał");
        System.out.println(arr.toString());
        ImyList<String> arr1 = arr;
        System.out.println(arr1.toString());
        arr.clear();

        System.out.println(arr1.toString());
        System.out.println(arr.toString());
        System.out.println(arr.isEmpty());




        List<String> linkedList = new LinkedList<>();
        linkedList.add("Patryl");
        linkedList.add("Michał");
        linkedList.add("Adam");
        linkedList.add(1,"Kutasiarz");
        System.out.println(linkedList.toString());*/

        List<String> linkedList = new ArrayList<>();
    MyAbstractList <String> list = new MyLinkedList<>();
    list.add("cokolwiek 1");
    list.add("cokolwiek 2");
    list.add("cokolwiek 3");


        list.add(1,"cokolwiek 4");
        list.remove(2);
        list.add("cokolwiek 5");
        System.out.println("list.size() w klasie Main:"+ list.size());



    }


}
