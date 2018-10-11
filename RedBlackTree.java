import java.lang.StringBuilder;

public class RedBlackTree<E extends Comparable<E>> {
    private static boolean RED = false;
    private static boolean BLACK = true;
    private Node<E> root;
    private String traversal = new String();

    public boolean insert(E element) {
        if (element == null) {
            throw new NullPointerException("This parameter cannot be null");
        }

        Node<E> temp = new Node(element);
        temp.color = RED;

        if (root == null) {
            temp.color = BLACK;
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
        insertFix(temp);
        return true;
    }

    public boolean contains(Comparable<E> object) {
        if(object == null ) {
            return false;
        }

        Node<E> trav = root;

        while(trav != null) {
            if(object.compareTo(trav.element) > 0) {
                trav = trav.rightChild;
            } else if(object.compareTo(trav.element) < 0) {
                trav = trav.leftChild;
            } else if(object.compareTo(trav.element) == 0) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        String output = new String();
        output = preOrder(root);
        return output;
    }

    public String preOrder(Node node) {
        if (node == null) {
            return "";
        }

        traversal += node.toString();

        preOrder(node.leftChild);

        preOrder(node.rightChild);

        return traversal;
    }

    public void insertFix(Node cur) {
        if (cur.parent.color == BLACK) {
            return;
        }

        Node A = cur;                                                   //A is current node
        Node B = cur.parent;                                            //B is parent node
        Node C = B.parent;                                              //C is grandparent node

        if (C.rightChild == B) {                                        //B is a right child
            if (C.leftChild.color == BLACK || C.leftChild == null) {     //if B's sibling is black or null
                if (B.rightChild == A) {
                    C.rightChild = B.leftChild;
                    B.leftChild = C;
                    B.color = BLACK;
                    C.color = RED;
                } else if(B.leftChild == A) {
                    A.rightChild = B;
                    A.leftChild = C;
                    B.leftChild = null;
                    C.rightChild = null;
                    C.color = RED;
                    A.color = BLACK;
                }
            } else if(C.leftChild.color == RED) {                     //if B's sibling is red
                C.leftChild.color = BLACK;
                C.rightChild.color = BLACK;
                if(root != C) {
                    C.color = RED;
                }
            }
        } else if(C.leftChild == B) {                                   //B is a left Child
            if (C.rightChild.color == BLACK || C.leftChild == null) {    //if B's sibling is black or null
                if (B.leftChild == A) {
                    C.leftChild = B.rightChild;
                    B.rightChild = C;
                    B.color = BLACK;
                    C.color = RED;
                } else if(B.rightChild == A) {
                    A.rightChild = C;
                    A.leftChild = B;
                    B.rightChild = null;
                    C.leftChild = null;
                    C.color = RED;
                    A.color = BLACK;
                }
            } else if(C.rightChild.color == RED) {                     //B's sibling is red
                C.leftChild.color = BLACK;
                C.rightChild.color = BLACK;
                if(root != C) {
                    C.color = RED;
                }
            }
        }
    }
}

class Node<E extends Comparable<E>> {
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

    public String toString() {
        if (color == false) {
            return " *" + element;
        }
        return " " + element;
    }
}
