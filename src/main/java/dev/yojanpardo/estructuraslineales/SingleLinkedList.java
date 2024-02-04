package dev.yojanpardo.estructuraslineales;

import dev.yojanpardo.ListasEnlazadas;
import java.util.Objects;
import java.util.function.Consumer;

public class SingleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public void addNode(Node<T> node){
        final Node<T> newNode = new Node<>(node.getValue());

        if(Objects.isNull(head)){
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }

        this.tail = newNode;
    }

    public Node<T> findNodeByValue(T value){
        Node<T> pointer = this.head;

        while(Objects.nonNull(pointer)){
            if(pointer.getValue().equals(value)){
                return pointer;
            }

            pointer = pointer.getNext();
        }

        return null;
    }

    public void deleteNodeByValue(T value){
        Node<T> anterior = this.head;
        Node<T> actual = anterior.getNext();

        if (anterior.getValue().equals(value)){
            this.head = actual;
            return;
        }

        while(Objects.nonNull(actual)){
            if(actual.value.equals(value)){
                anterior.setNext(actual.getNext());
                return;
            }

            anterior = actual;
            actual = actual.getNext();
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }
    }

    public void forEach(Consumer<T> action) {
        SingleLinkedList.Node<T> current = head;
        while (current != null) {
            action.accept(current.getValue());
            current = current.next;
        }
    }

    public Node<T> reverseList(Node<T> node){
        Node<T> anterior = null;
        Node<T> actual = node;
        Node<T> siguiente = actual.getNext();


        while (Objects.nonNull(actual)){
            actual.setNext(anterior);
            anterior = actual;
            actual = siguiente;
            if(Objects.nonNull(siguiente)) {
                siguiente = siguiente.getNext();
            }
        }

        return anterior;

    }
}
