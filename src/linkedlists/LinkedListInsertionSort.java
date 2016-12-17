package linkedlists;

/**
 * Created by akhil on 12/17/2016.
 */
public class LinkedListInsertionSort {
    public static void main(String[] args) {
        LinkedListInsertionSort linkedListInsertionSort = new LinkedListInsertionSort();
        int range = 10;
        Node headNode = linkedListInsertionSort.buildUnsortedList(range);
        linkedListInsertionSort.printListContents(headNode);
        Node sortedHeadNode = linkedListInsertionSort.sortList(headNode);
        linkedListInsertionSort.printListContents(sortedHeadNode);
    }

    private Node sortList(Node headNode) {

        Node sortedNode;
        if (headNode == null || headNode.next == null)
            sortedNode = headNode;
        else {
            Node traversalNode = headNode;
            sortedNode = new Node(traversalNode.value, null);
            traversalNode = traversalNode.next;
            while (traversalNode != null) {
                Node lastNode = new Node(traversalNode.value, null);
                sortedNode = addNodeToItsSortedOrderPosition(sortedNode, lastNode);
                traversalNode = traversalNode.next;
            }
        }
        return sortedNode;
    }

    private Node addNodeToItsSortedOrderPosition(Node sortedNode, Node lastNode) {
        boolean nodeInserted = false;
        Node sortedListTraversalNode = sortedNode;
        if (sortedListTraversalNode.value > lastNode.value) {
            lastNode.next = sortedListTraversalNode;
            return lastNode;
        } else {
            while (sortedListTraversalNode.next != null) {
                if (sortedListTraversalNode.next.value >= lastNode.value) {
                    lastNode.next = sortedListTraversalNode.next;
                    sortedListTraversalNode.next = lastNode;
                    nodeInserted = true;
                    break;
                } else {
                    sortedListTraversalNode = sortedListTraversalNode.next;
                }

            }
        }
        if (!nodeInserted)
            sortedListTraversalNode.next = lastNode;
        return sortedNode;
    }

    private Node buildUnsortedList(int range) {
        Node headReference = null;
        for (int index = range; index >= 0; index--) {
            int value = 0 + (int) (Math.random() * ((range - 0) + 1));
            headReference = addNewNodeAtTheEnd(headReference, new Node(value, null));
        }
        return headReference;
    }

    private Node addNewNodeAtTheEnd(Node headReference, Node newNode) {
        if (headReference == null)
            headReference = newNode;
        else {
            Node traversedNode = headReference;
            while (traversedNode != null && traversedNode.next != null)
                traversedNode = traversedNode.next;
            traversedNode.next = newNode;
        }
        return headReference;
    }

    private void printListContents(Node headNode) {
        System.out.println();
        while (headNode != null) {
            System.out.println(headNode.value);
            headNode = headNode.next;
        }
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
