package com.zhmaka.container;

import com.zhmaka.model.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T extends Car> {
    Node<T> prev; // left
    Node<T> next; // rigth
    T data;



    public Node(final T car) {
        this.prev = prev;
        this.data = car;
        this.next = next;
    }

    public Node() {

    }

    @Override
    public String toString() {
        return "Node{" +
                "data =" + data +
                ", left =" + prev +
                ", right =" + next +
                '}';
    }
}