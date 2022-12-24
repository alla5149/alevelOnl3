package com.zhmaka.container;

import com.zhmaka.model.Car;

import java.util.Iterator;
import java.util.Optional;

public class CarList<T extends Car> implements Iterable {
    protected Node<T> first;
    protected Node<T> last;
    private int size;
    private int modCount;


    public CarList() {
    }

    public void add(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        size++;

        Node<T> lastNode = last.prev;
        if (lastNode != first) {
            node.prev = lastNode;
        }
        lastNode.next = node;
        last.prev = node;
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


    public int getIndex(final T car) {
        Node<T> currentNode = first;
        int index = -1;
        boolean found = false;
        while (currentNode.next != null) {
            index++;
            if (car.getId().equals(currentNode.getData().getId())) {
                found = true;
                break;
            }
            currentNode = currentNode.next;
        }
        if (found = false) {
            index = -1;
        }
        return index;
    }


    public void insertIndex(int index, final T car) {
        if (size == 0 && index == 0) {
            add(car);
            return;
        }
        if (size != 0 && index == 0) {
            addFirst(car);
            return;
        }
        if (index >= size) {
            addLast(car);
        } else {
            Node<T> node = verifyIndexGetNode(index);
            Node<T> newNode = new Node<>();
            Node<T> prevNode = node.prev;
            newNode.data = car;
            newNode.next = node;
            newNode.prev = prevNode;
            prevNode.next = newNode;
            node.prev = newNode;
            size++;
        }
    }

    private Node<T> verifyIndexGetNode(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = first.next;
        while (index-- > 0) {
            node = node.next;
        }
        return node;
    }

    public void remove(int index) {
        Node<T> node = verifyIndexGetNode(index);
        Node<T> prevNode = node.prev;
        Node<T> nextNode = node.next;

        if (size == 1) {
            first.next = last;
            last.prev = first;
            size--;
        } else if (index == 0) {
            first.next = nextNode;
            nextNode.prev = null;
            node.next = null;
            size--;
        } else if (index == getSize() - 1) {
            last.prev = prevNode;
            prevNode.next = null;
            node.prev = null;
            size--;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            node.next = null;
            node.prev = null;
            size--;
        }
    }

    public int getCount() {
        int count = 0;
        Node current = first;
        while (current.next != null) {
            count += current.getData().getCount();
            current = current.next;
        }
        return count;
    }

    public int printNode() {
        Node current = first;
        if (first == null) {
            System.out.println("CarList is empty ");
        }
        System.out.println("Current list consist: ");
        while (current != null) {
            System.out.println(current.data.getId().toString());
            current = current.next;
        }
        return 0;
    }

    public Iterator<T> iterator() {
        return new myIterator<>(this);
    }

    class myIterator<T extends Car> implements Iterator<T> {
        Node<T> current;

        public myIterator(CarList<T> carList) {
            current = carList.first;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            T car = current.data;
            current = current.next;
            return car;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getModCount() {
        return modCount;
    }

    public void setModCount(int modCount) {
        this.modCount = modCount;
    }

}




