package dev.yojanpardo;

import java.util.Objects;
import java.util.function.Consumer;

public class ListasEnlazadas {

    public static void main(String[] args) {
        MyLinkedList<Integer, Integer> test = new MyLinkedList<>();

        test.addNode(new Node<>(1,1));
        test.addNode(new Node<>(2,2));
        test.addNode(new Node<>(3,3));
        test.addNode(new Node<>(4,4));
        test.addNode(new Node<>(5,5));
        test.addNode(new Node<>(6,6));

        MyLinkedList<Integer, Integer> evenNodes = new MyLinkedList<>();
        MyLinkedList<Integer, Integer> oddNodes = new MyLinkedList<>();

        int nodeCounter = 1;
        Node<Integer, Integer> nodeIterator = test.getHead();

        while (Objects.nonNull(nodeIterator)){
            if(nodeCounter % 2 == 0){
                oddNodes.addNode(nodeIterator);
            } else {
                evenNodes.addNode(nodeIterator);
            }
            nodeCounter ++;
            nodeIterator = nodeIterator.getNext();
        }

        evenNodes.merge(oddNodes);

        System.out.println("sorted nodes:");

        evenNodes.forEach(System.out::println);

        System.out.println("my list is: ");

        test.forEach(System.out::println);

        System.out.println("reversed list:");

        test.reversed().forEach(System.out::println);
    }


    protected static class Node<K,V> {
        private final K key;
        private V value;
        private Node<K,V> prev;

        private Node<K,V> next;

        public Node(K key){
            this.key = key;
        }

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node<K, V> prev, Node<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getPrev() {
            return prev;
        }

        public void setPrev(Node<K, V> prev) {
            this.prev = prev;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value) && Objects.equals(prev, node.prev) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value, prev, next);
        }

        public boolean hasNext(){
            return Objects.nonNull(this.next);
        }

        public boolean hasPrev(){
            return Objects.nonNull(this.prev);
        }
    }

    protected static class MyLinkedList<K, V> {
        private Node<K,V> head;
        private Node<K,V> tail;

        public Node<K, V> getHead() {
            return head;
        }

        public void setHead(Node<K, V> head) {
            this.head = head;
        }

        public Node<K, V> getTail() {
            return tail;
        }

        public void setTail(Node<K, V> tail) {
            this.tail = tail;
        }

        public void addNode(Node<K,V> node) {
            final Node<K,V> insertNode = new Node<>(node.getKey(), node.getValue());

            if(Objects.isNull(this.head)){
                this.head = insertNode;
             } else {
                insertNode.setPrev(this.tail);
                this.tail.setNext(insertNode);
            }

            this.tail = insertNode;
        }

        public Node<K,V> getByKey(final K key){
            Node<K,V> current = this.head;

            while(Objects.nonNull(current)){

                if(current.getKey().equals(key)){
                    return current;
                }
                current = current.getNext();
            }
            return null;
        }

        public void forEach(Consumer<V> action) {
            Node<K, V> current = head;
            while (current != null) {
                action.accept(current.getValue());
                current = current.next;
            }
        }

        public Node<K,V> getByValue(final V value){
            Node<K,V> current = this.head;

            while(Objects.nonNull(current)){

                if(current.getValue().equals(value)){
                    return current;
                }
                current = current.getNext();
            }
            return null;
        }

        public void insertAfter(final K leftKey, final Node<K,V> insertNode){
            final Node<K,V> leftNode = this.getByKey(leftKey);
            if(Objects.isNull(leftNode.getNext())){
                insertNode.setPrev(leftNode);
                leftNode.setNext(insertNode);
                this.tail = insertNode;
            } else {
                final Node<K,V> rightNode = leftNode.getNext();
                leftNode.setNext(insertNode);
                rightNode.setPrev(insertNode);
                insertNode.setPrev(leftNode);
                insertNode.setNext(rightNode);
            }

        }

        public void deleteNode(final Node<K,V> node) {
            if(Objects.isNull(node)){
                return;
            }
            if(!node.hasNext() && !node.hasPrev()){
                this.head = null;
                this.tail = null;
            } else if(!node.hasNext()){
                this.tail = node.getPrev();
                this.tail.setNext(null);
            } else if(!node.hasPrev()){
                this.head = node.getNext();
                this.head.setPrev(null);
            } else {
                final Node<K,V> prev = node.getPrev();
                final Node<K,V> next = node.getNext();
                prev.setNext(next);
                next.setPrev(prev);
            }
        }

        public MyLinkedList<K,V> reversed(){
            final MyLinkedList<K,V> reversedLinkedList = new MyLinkedList<>();
            Node<K,V> current = this.tail;

            while(Objects.nonNull(current)){
                reversedLinkedList.addNode(new Node<>(current.getKey(), current.getValue()));
                current = current.getPrev();
            }

            return reversedLinkedList;
        }

        public void merge(final MyLinkedList<K,V> rightList){
            rightList.getHead().setPrev(this.tail);
            this.tail.setNext(rightList.head);
            this.tail = rightList.getTail();
        }
    }
}
