package com.laba.solvd.HW_ShoppingMallApp.LinkedList;

public class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}