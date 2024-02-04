package dev.yojanpardo.grafosarboles.recursion;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.TreeMap;

public class BFS {

    public static <T> BinaryTreeNode<T> bfs(BinaryTreeNode<T> root, T value) {

        if (Objects.isNull(root)) {
            return null;
        }

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;

        while (!queue.isEmpty()){
            BinaryTreeNode<T> currentNode = queue.poll();
            System.out.printf("visiting node with value [%s] at level [%d]\n", currentNode.getValue(), level);

            if(currentNode.getValue().equals(value)){
                return currentNode;
            }

            if(Objects.nonNull(currentNode.getLeft())){
                queue.add(currentNode.getLeft());
            }

            if(Objects.nonNull(currentNode.getRight())){
                queue.add(currentNode.getRight());
            }

            level++;
        }

        return null;
    }


}
