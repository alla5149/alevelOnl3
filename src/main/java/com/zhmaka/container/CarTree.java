package com.zhmaka.container;

import com.zhmaka.model.Car;

import java.util.Stack;

public class CarTree<T extends Car> extends CarComparator<T>{
    private CarTreeNode<T> root;
    Node rootNode = null;

    public CarTree(final T car) {
        this.root = new CarTreeNode(car, null, null);
    }

    public CarTree() {

    }

    public Node findNodeByValue(T car) { // поиск узла по значению
        Node currentNode = rootNode; // начинаем поиск с корневого узла
        while (currentNode.getData() != car) { // поиск покуда не будет найден элемент или не будут перебраны все
            if (car.getCount() < currentNode.data.getCount()) { // движение влево?
                currentNode = currentNode.getPrev();
            } else { //движение вправо
                currentNode = currentNode.getNext();
            }
            if (currentNode == null) { // если потомка нет,
                return null; // возвращаем null
            }
        }
        return currentNode; // возвращаем найденный элемент
    }

    public void insertNode(T car) { // метод вставки нового элемента
        Node newNode = new Node(); // создание нового узла
        newNode.setData(car); // вставка данных
        if (rootNode == null) { // если корневой узел не существует
            rootNode = newNode;// то новый элемент и есть корневой узел
        } else { // корневой узел занят
            Node currentNode = rootNode; // начинаем с корневого узла
            Node parentNode;
            while (true) // мы имеем внутренний выход из цикла
            {
                parentNode = currentNode;
                if (car.getCount() == currentNode.data.getCount()) {   // если такой элемент в дереве уже есть, не сохраняем его
                    return;    // просто выходим из метода
                } else if (car.getCount() < currentNode.data.getCount()) {   // движение влево?
                    currentNode = currentNode.getPrev();
                    if (currentNode == null) { // если был достигнут конец цепочки,
                        parentNode.setNext(newNode); //  то вставить слева и выйти из методы
                        return;
                    }
                } else { // Или направо?
                    currentNode = currentNode.getNext();
                    if (currentNode == null) { // если был достигнут конец цепочки,
                        parentNode.setNext(newNode);  //то вставить справа
                        return; // и выйти
                    }
                }
            }
        }
    }

    public boolean deleteNode(T car) // Удаление узла с заданным ключом
    {
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isPrev = true;
        while (currentNode.getData() != car) { // начинаем поиск узла
            parentNode = currentNode;
            if (car.getCount() < currentNode.data.getCount()) { // Определяем, нужно ли движение влево?
                isPrev = true;
                currentNode = currentNode.getPrev();
            } else { // или движение вправо?
                isPrev = false;
                currentNode = currentNode.getNext();
            }
            if (currentNode == null)
                return false; // yзел не найден
        }

        if (currentNode.getPrev() == null && currentNode.getNext() == null) { // узел просто удаляется, если не имеет потомков
            if (currentNode == rootNode) // если узел - корень, то дерево очищается
                rootNode = null;
            else if (isPrev)
                parentNode.setPrev(null); // если нет - узел отсоединяется, от родителя
            else
                parentNode.setNext(null);
        } else if (currentNode.getNext() == null) { // узел заменяется левым поддеревом, если правого потомка нет
            if (currentNode == rootNode)
                rootNode = currentNode.getPrev();
            else if (isPrev)
                parentNode.setPrev(currentNode.getPrev());
            else
                parentNode.setNext(currentNode.getPrev());
        } else if (currentNode.getPrev() == null) { // узел заменяется правым поддеревом, если левого потомка нет
            if (currentNode == rootNode)
                rootNode = currentNode.getNext();
            else if (isPrev)
                parentNode.setPrev(currentNode.getNext());
            else
                parentNode.setNext(currentNode.getNext());
        } else { // если есть два потомка, узел заменяется преемником
            Node heir = receiveHeir(currentNode);// поиск преемника для удаляемого узла
            if (currentNode == rootNode)
                rootNode = heir;
            else if (isPrev)
                parentNode.setPrev(heir);
            else
                parentNode.setNext(heir);
        }
        return true; // элемент успешно удалён
    }

    // метод возвращает узел со следующим значением после передаваемого аргументом.
    // для этого он сначала переходим к правому потомку, а затем
    // отслеживаем цепочку левых потомков этого узла.
    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getNext(); // Переход к правому потомку
        while (currentNode != null) // Пока остаются левые потомки
        {
            parentNode = heirNode;// потомка задаём как текущий узел
            heirNode = currentNode;
            currentNode = currentNode.getPrev(); // переход к левому потомку
        }
        // Если преемник не является
        if (heirNode != node.getNext()) // правым потомком,
        { // создать связи между узлами
            parentNode.setPrev(heirNode.getNext());
            heirNode.setNext(node.getNext());
        }
        return heirNode;// возвращаем приемника
    }

    public void printTree() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(rootNode);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getData()); // выводим его значение в консоли
                    localStack.push(temp.getPrev()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getNext());
                    if (temp.getPrev() != null ||
                            temp.getNext() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }

    public int getCount(){
        if (rootNode == null){
            return 0;
        }else {
            return rootNode.getData().getCount() +
                    getCountNodes(rootNode.getPrev())+
                    getCountNodes(rootNode.getNext());
        }
    }

    private int getCountNodes(Node node){
        if (node == null){
            return 0;
        }else {
            int getCountNodes = node.getData().getCount() +
                    getCountNodes(node.getPrev()) +
                    getCountNodes(node.getNext());
        }
        return 0;
    }


    class CarTreeNode<T extends Car> {
        T car;

        public CarTreeNode getLeft() {
            return left;
        }

        public void setLeft(CarTreeNode left) {
            this.left = left;
        }

        public CarTreeNode getRight() {
            return right;
        }

        public void setRight(CarTreeNode right) {
            this.right = right;
        }

        CarTreeNode left;
        CarTreeNode right;

        public CarTreeNode(final T car, final CarTreeNode left, final CarTreeNode right) {
            this.car = car;
            this.left = left;
            this.right = right;
        }
    }
}

//    public void insert(T car) {
//        doInsert(root, car);
//    }
//
//    public Object doInsert(CarTreeNode node, @NonNull T car) {
//        if (node == null) {
//            return new Node(car);
//        }
//        if (car.getCount() < node.car.getCount()) {
//            if (node.left == null) {
//                node.left = new CarTreeNode<>(car, null, null);
//                return null;
//            } else {
//                node.left = (CarTreeNode) doInsert(node.getLeft(), car);
//            }
//        }
//        if (car.getCount() > node.car.getCount()) {
//            if (node.right == null) {
//                node.right = new CarTreeNode<>(car, null, null);
//                return null;
//            } else {
//                node.right = (CarTreeNode) doInsert(node.getRight(), car);
//                return null;
//            }
//        }
//        return node;
//    }
//


