package com.zhmaka.container;

import com.zhmaka.model.Car;
import lombok.Getter;

@Getter
public class Node<T extends Car> {
    Node<T> prev; // before
    Node<T> next; // next
    T data; // now

    public Node(Node<T> prev, T car,Node<T> next) {
        this.data = car;
        this.next = next;
        this.prev = prev;
    }
}
