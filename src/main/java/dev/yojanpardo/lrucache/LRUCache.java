package dev.yojanpardo.lrucache;

import java.util.HashMap;
import java.util.Objects;
import javax.sound.sampled.Line;

public class LRUCache {

    private HashMap<Integer,LinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkedNode head, tail;

    public LRUCache(int capacity){
        this.size = 0;
        this.capacity = 0;
        this.head = new LinkedNode();
        this.tail = new LinkedNode();

        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key){
        LinkedNode node = cache.get(key);

        if (Objects.isNull(node)){
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void moveToHead(LinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    public void removeNode(LinkedNode node) {
        LinkedNode prev = node.prev;
        LinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    static class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;
    }

    public void addNode(LinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    public LinkedNode popTail(){
        LinkedNode res = tail.prev;

        this.removeNode(res);
        return res;
    }

    public void put(int key, int value){
        LinkedNode node = cache.get(key);

        if(Objects.isNull(node)){
            final LinkedNode linkedNode = new LinkedNode();
            linkedNode.value = value;
            linkedNode.key = key;

            cache.put(key, linkedNode);
            addNode(linkedNode);
            ++size;

            if (size > capacity){
                final LinkedNode removedTail = this.popTail();
                cache.remove(removedTail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }
}
