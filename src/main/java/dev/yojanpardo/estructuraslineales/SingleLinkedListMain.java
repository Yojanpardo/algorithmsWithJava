package dev.yojanpardo.estructuraslineales;

import java.util.Objects;

public class SingleLinkedListMain {

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addNode(new SingleLinkedList.Node<>(1));
        list.addNode(new SingleLinkedList.Node<>(2));
        list.addNode(new SingleLinkedList.Node<>(3));
        list.addNode(new SingleLinkedList.Node<>(2));
        list.addNode(new SingleLinkedList.Node<>(1));

        System.out.println("the list is palindrome: " + isPalindrome(list));

    }

    private static boolean isPalindrome(SingleLinkedList<Integer> list) {
        SingleLinkedList.Node<Integer> turtle = list.getHead();
        SingleLinkedList.Node<Integer> rabbit = turtle;
        SingleLinkedList.Node<Integer> middle;

        while(Objects.nonNull(turtle)){
            if(Objects.isNull(rabbit) || Objects.isNull(rabbit.getNext())){
                middle = turtle;
                SingleLinkedList.Node<Integer> reversedNode = list.reverseList(middle.getNext());
                turtle.setNext(reversedNode);
                turtle = turtle.getNext();
                break;
            }
            turtle = turtle.getNext();
            rabbit = rabbit.getNext().getNext();
        }

        SingleLinkedList.Node<Integer> head = list.getHead();

        while(Objects.nonNull(turtle)){
            if (!turtle.getValue().equals(head.getValue())){
                return false;
            }
            turtle = turtle.getNext();
            head = head.getNext();
        }

        return true;
    }
}
