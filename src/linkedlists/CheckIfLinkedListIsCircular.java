package linkedlists;

/**
 * Created by Deepankit on 9/26/2016.
 */
public class CheckIfLinkedListIsCircular {
    private Node headNode;

    public CheckIfLinkedListIsCircular(Node headNode) {
        this.headNode = headNode;
    }

    public static void main(String[] args) {
        CheckIfLinkedListIsCircular checkIfLinkedListIsCircular = new CheckIfLinkedListIsCircular(new Node(11, null));
        int elementsCount = 10;
        checkIfLinkedListIsCircular.addElementsToTheList(elementsCount);
        checkIfLinkedListIsCircular.display();
        checkIfLinkedListIsCircular.createCycle();
        System.out.println(checkIfLinkedListIsCircular.isCircular());
    }

    private boolean isCircular() {
        Node slowReference = headNode;
        Node fastReference = headNode;
        fastReference = fastReference.reference;
        while (fastReference != null && fastReference.reference != null) {
            fastReference = fastReference.reference.reference;
            slowReference = slowReference.reference;
            if (fastReference == slowReference)
                return true;
        }
        return false;
    }

    private void createCycle() {
        Node headReference = headNode;
        while (headReference != null && headReference.reference != null)
            headReference = headReference.reference;
        headReference.reference = headNode;
    }

    private void display() {
        Node headReference = headNode;
        while (headReference != null) {
            System.out.println(headReference.value);
            headReference = headReference.reference;
        }
    }

    private void addElementsToTheList(int elementsCount) {
        for (int index = elementsCount; index > 0; index--)
            addElementAtTheBeginning(new Node(index, null));
    }

    private boolean addElementAtTheBeginning(Node node) {
        if (node == null)
            return false;
        node.reference = headNode;
        headNode = node;
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
