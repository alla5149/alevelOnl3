package com.zhmaka.container;

import com.zhmaka.model.Car;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CarList <T extends Car> implements Iterable {
    protected Node<T> first;
    protected Node<T> last;
    private int size;
    private int modCount;


    public CarList() {
    }

    public void addFirst(final T car) {
        if (Optional.ofNullable(car).isPresent()) {
            Node<T> newNode = new Node<>(null, car, first);
            if (first != null) {
                first.prev = newNode;
            } else {
                last = newNode;
            }
            first = newNode;
            size++;
            modCount += car.getCount();
        }
    }

    public void addLast(final T car) {
        if (Optional.ofNullable(car).isPresent()) {
            Node<T> l = last;
            Node<T> newNode = new Node<T>(l, car, null);
            last = newNode;
            if (l == null) {
                first = newNode;
            } else {
                l.next = newNode;
            }
            size++;
            modCount += car.getCount();
        }
    }


    private void addAfter(Node<T> current, T car) {
            Node<T> newNode = new Node<>(current, car, current.next);
            if (current.next == null) {
                last = newNode;
            } else {
                current.next.prev = newNode;
            }
            current.next = newNode;
            size++;
        }


    private T remove(final Node<T> node) {

        T oldData = node.data;
       final Node<T> prev = node.prev;
       final Node<T> next = node.next;

        if (prev == null) {
            first = node.next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            last = node.prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        node.data = null;
        size--;
        modCount++;
        return oldData;
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }


}
