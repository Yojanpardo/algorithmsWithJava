package dev.yojanpardo;

public class LinkedListCycle {

    public static void main(String[] args) {

    }

    private static class Node<T> {
        private int index;
        private T value;
        private Node<T> prev;
        private Node<T> next;

        public int getIndex() {
            return index;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }


    }
}
