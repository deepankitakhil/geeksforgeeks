package linkedlists;

/**
 * Created by Deepankit on 9/26/2016.
 */
public class MergeSort {
    private Node headNode;

    public MergeSort(Node headNode) {
        this.headNode = headNode;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort(new Node(10, null));
        int elementCount = 10;
        mergeSort.addElementsToTheList(elementCount);
        mergeSort.sortElements();
        mergeSort.display();
    }

    private void sortElements() {
        Node headReference = headNode;
        headNode = sort(headReference);
    }

    private Node sort(Node headReference) {
        if (headReference == null || headReference.reference == null)
            return headReference;
        Node middleElement = findMiddleElementInTheList(headReference);
        Node nextToMiddle = middleElement.reference;
        middleElement.reference = null;
        Node firstSubListToBeMerged = sort(headReference);
        Node secondListToBeMerged = sort(nextToMiddle);
        return merge(firstSubListToBeMerged, secondListToBeMerged);
    }

    private Node merge(Node firstSubListToBeMerged, Node secondListToBeMerged) {
        Node mergedList;
        if (firstSubListToBeMerged == null)
            return secondListToBeMerged;
        if (secondListToBeMerged == null)
            return firstSubListToBeMerged;
        if (firstSubListToBeMerged.data < secondListToBeMerged.data) {
            mergedList = firstSubListToBeMerged;
            mergedList.reference = merge(firstSubListToBeMerged.reference, secondListToBeMerged);
        } else {
            mergedList = secondListToBeMerged;
            mergedList.reference = merge(firstSubListToBeMerged, secondListToBeMerged.reference);
        }
        return mergedList;
    }

    private Node findMiddleElementInTheList(Node headReference) {
        Node slowNode = headReference;
        Node fastNode = headReference.reference;
        while (fastNode != null && fastNode.reference != null) {
            fastNode = fastNode.reference.reference;
            slowNode = slowNode.reference;
        }
        return slowNode;
    }

    private void display() {
        Node headReference = headNode;
        while (headReference != null) {
            System.out.println(headReference.data);
            headReference = headReference.reference;
        }
    }

    private void addElementsToTheList(int elementCount) {
        for (int index = elementCount - 1; index >= 0; index--) {
            addElementsAtTheEnd(new Node(index, null));
        }
    }

    private boolean addElementsAtTheEnd(Node node) {
        if (node == null)
            return false;
        Node headReference = headNode;
        while (headReference != null && headReference.reference != null) {
            headReference = headReference.reference;
        }
        headReference.reference = node;
        return false;
    }

    private static class Node {
        private int data;
        private Node reference;

        public Node(int data, Node reference) {
            this.data = data;
            this.reference = reference;
        }
    }

}
