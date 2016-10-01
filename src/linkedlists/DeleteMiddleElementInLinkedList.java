package linkedlists;

/**
 * Created by Deepankit on 9/26/2016.
 */
public class DeleteMiddleElementInLinkedList {

    private Node headNode;

    public DeleteMiddleElementInLinkedList(Node headNode) {
        this.headNode = headNode;
    }

    public static void main(String[] args) {
        DeleteMiddleElementInLinkedList deleteMiddleElementInLinkedList = new DeleteMiddleElementInLinkedList(new Node(11, null));
        int elementsCount = 10;
        deleteMiddleElementInLinkedList.addElementsToTheList(elementsCount);
        deleteMiddleElementInLinkedList.display();
        deleteMiddleElementInLinkedList.deleteElement();
        deleteMiddleElementInLinkedList.display();
    }

    private void deleteElement() {
        Node headReference = headNode;
        Node middleElement = findMiddleElementInTheList(headReference);
        deleteElementFromList(middleElement);
    }

    private boolean deleteElementFromList(Node middleElement) {
        Node headReference = headNode;
        Node previousNode = headReference;
        while (headReference != middleElement) {
            previousNode = headReference;
            headReference = headReference.reference;
        }
        previousNode.reference = headReference.reference;
        return true;

    }

    private Node findMiddleElementInTheList(Node headReference) {
        Node slowPointer = headReference;
        Node fastPointer = headReference;
        fastPointer = fastPointer.reference;
        while (fastPointer != null && fastPointer.reference != null) {
            fastPointer = fastPointer.reference.reference;
            slowPointer = slowPointer.reference;
        }
        return slowPointer;
    }

    private void display() {
        Node headReference = headNode;
        while (headReference != null) {
            System.out.println(headReference.value);
            headReference = headReference.reference;
        }
    }

    private void addElementsToTheList(int elementsCount) {
        for (int index = elementsCount; index >= 0; index--)
            addElementsAtTheEnd(new Node(index, null));
    }

    private boolean addElementsAtTheEnd(Node node) {
        if (node == null)
            return false;
        Node headReference = headNode;
        while (headReference != null && headReference.reference != null)
            headReference = headReference.reference;
        headReference.reference = node;
        return true;
    }

    private static class Node {
        private int value;
        private Node reference;

        public Node(int value, Node reference) {
            this.value = value;
            this.reference = reference;
        }
    }
}
