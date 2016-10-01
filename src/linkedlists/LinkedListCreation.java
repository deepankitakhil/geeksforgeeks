package linkedlists;

/**
 * Created by Deepankit on 9/25/2016.
 */
public class LinkedListCreation {
    private Node node;

    public LinkedListCreation(Node node) {
        this.node = node;
    }

    public static void main(String[] args) {
        Node headNode = new Node(1, null);
        LinkedListCreation linkedListCreation = new LinkedListCreation(headNode);
        int length = 10;
        for (int index = 2; index < length; index++) {
            Node nodeToBeAdded = new Node(index, null);
            linkedListCreation.addNodeToLinkedLists(nodeToBeAdded);
        }
        linkedListCreation.display();
    }

    private void display() {
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNodeReference();
        }

    }

    private boolean addNodeToLinkedLists(Node nodeToBeAdded) {
        if (nodeToBeAdded != null) {
            Node referenceNode = node;
            while (referenceNode != null && referenceNode.getNodeReference() != null)
                referenceNode = referenceNode.getNodeReference();
            referenceNode.nodeReference = nodeToBeAdded;
            return true;
        }
        return false;
    }

    private static final class Node {

        int data;
        Node nodeReference;

        public Node(int data, Node nodeReference) {
            this.data = data;
            this.nodeReference = nodeReference;
        }

        public int getData() {
            return data;
        }

        public Node getNodeReference() {
            return nodeReference;
        }
    }
}
