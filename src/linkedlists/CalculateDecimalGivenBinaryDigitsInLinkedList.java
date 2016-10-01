package linkedlists;

/**
 * Created by Deepankit on 10/2/2016.
 */
public class CalculateDecimalGivenBinaryDigitsInLinkedList {
    private Node headNode;

    public CalculateDecimalGivenBinaryDigitsInLinkedList(Node headNode) {
        this.headNode = headNode;
    }

    public static void main(String[] args) {
        CalculateDecimalGivenBinaryDigitsInLinkedList calculateDecimalGivenBinaryDigitsInLinkedList = new CalculateDecimalGivenBinaryDigitsInLinkedList(new Node(0, null));
        int listSize = 10;
        calculateDecimalGivenBinaryDigitsInLinkedList.addElementsAtTheEnd(listSize);
        System.out.println(calculateDecimalGivenBinaryDigitsInLinkedList.findDecimalNumberRepresentation(listSize));
    }

    private long findDecimalNumberRepresentation(int listSize) {
        long digit = 0L;
        Node referenceNode = headNode;
        while (listSize >= 0) {
            digit += Math.pow(2, listSize) * referenceNode.data;
            referenceNode = referenceNode.node;
            listSize--;
        }
        return digit;
    }

    private void addElementsAtTheEnd(int listSize) {
        Node referenceNode = this.headNode;
        boolean flag = true;
        while (listSize-- > 0) {
            referenceNode.node = new Node(flag == true ? 1 : 0, null);
            referenceNode = referenceNode.node;
            flag = !flag;
        }
    }

    private static class Node {
        private int data;
        private Node node;

        public Node(int data, Node node) {
            this.data = data;
            this.node = node;
        }
    }
}
