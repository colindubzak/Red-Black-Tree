public class Node<E extends Comparable<E>> {
    E element;
    Node leftChild;
    Node rightChild;
    Node parent;
    boolean color;

    Node(E data) {
        element = data;
        leftChild = null;
        rightChild = null;
    }
}
