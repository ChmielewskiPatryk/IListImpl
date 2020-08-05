package com.coderslab;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarOutputStream;

public class Main {

    public static void main(String[] args) {


        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("jabłko");
        list.add("marchewka");
        list.add("gruszka");
        list.add("ananas");
        list.remove("jabłko");
        System.out.println(list.toString());
        list.remove("gruszka");
        System.out.println(list.toString());

    }
}
