public class RedBlackTree<E extends Comparable<E>> {
    private static boolean RED = false;
    private static boolean BLACK = true;
    Node<E> root;

    public boolean insert(E element) {
        Node<E> temp = new Node(element);
        temp.color = false;

        if (root == null) {
            temp.color = true;
            root = temp;
            return true;
        }

        boolean isInserted = false;
        Node<E> trav = root;

        while(isInserted == false) {
            if(element.compareTo(trav.element) > 0) {
                if (trav.rightChild != null) {
                    trav = trav.rightChild;
                } else {
                    trav.rightChild = temp;
                    temp.parent = trav;
                    isInserted = true;
                }
            } else if(element.compareTo(trav.element) < 0) {
                if (trav.leftChild != null) {
                    trav = trav.leftChild;
                } else {
                    trav.leftChild = temp;
                    temp.parent = trav;
                    isInserted = true;
                }
            } else if(element.compareTo(trav.element) == 0) {
                return false;
            }
        }

        return true;
    }

    public boolean contains(Comparable<E> object) {

    }

    public String toString() {

    }

    public void insertFix(Node cur) {
        while(cur.parent.color == false) {
            if (cur.parent == cur.parent.parent.leftChild) {

            }
        }
    }
}
