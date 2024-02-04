package dev.yojanpardo.grafosarboles.recursion;

public class SumRootToLeaf {

    public static void main(String[] args) {
        System.out.println("********** Sum Root To Leaf");
        Node<Integer> root = buildRoot();
        System.out.println(calculateSum(root));
    }

    private static Integer calculateSum(Node<Integer> node, String prevVal) {
        if(node == null){
            return 0;
        }

        String actualVal = prevVal + node.value;
        int numericVal = Integer.parseInt(actualVal);

        if(node.left == null && node.right == null){
            return numericVal;
        }

        return calculateSum(node.left, actualVal) + calculateSum(node.right, actualVal);

    }

    static Integer calculateSum(Node<Integer> node){
        return calculateSum(node, "");
    }

    private static Node<Integer> buildRoot() {

        Node<Integer> granSonLL = new Node<>(3);
        Node<Integer> granSonLR = new Node<>(4);
        Node<Integer> sonL = new Node<>(2, granSonLL, granSonLR);

        Node<Integer> granSonRL = new Node<>(6);
        Node<Integer> granSonRR = new Node<>(7);
        Node<Integer> sonR = new Node<>(5, granSonRL, granSonRR);

        return new Node<>(1, sonL, sonR);

    }

    static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> left, Node<T> right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
