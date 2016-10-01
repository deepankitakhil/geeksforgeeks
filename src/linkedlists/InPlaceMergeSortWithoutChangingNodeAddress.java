package linkedlists;

/**
 * Created by Deepankit on 9/27/2016.
 */
public class InPlaceMergeSortWithoutChangingNodeAddress {
    private Node headNode;

    public InPlaceMergeSortWithoutChangingNodeAddress(Node headNode) {
        this.headNode = headNode;
    }

    public static void main(String[] args) {
        InPlaceMergeSortWithoutChangingNodeAddress firstSortedList = new InPlaceMergeSortWithoutChangingNodeAddress(new Node(1, null));
        InPlaceMergeSortWithoutChangingNodeAddress secondSortedList = new InPlaceMergeSortWithoutChangingNodeAddress(new Node(1, null));
        int elementsCountForFirstList = 3;
        int elementsCountForSecondList = 10;
        firstSortedList.addElementsToTheList(elementsCountForFirstList, true);
        secondSortedList.addElementsToTheList(elementsCountForSecondList, false);
        firstSortedList.inPlaceMergeSort(secondSortedList, true);
        firstSortedList.display();
        secondSortedList.display();
    }

    private boolean isListStillSorted() {
        Node referenceNode = this.headNode;
        while (referenceNode != null && referenceNode.reference != null) {
            if (referenceNode.value > referenceNode.reference.value)
                return false;
            referenceNode = referenceNode.reference;
        }
        return true;
    }

    private void inPlaceMergeSort(InPlaceMergeSortWithoutChangingNodeAddress secondList, boolean isFirstListBigger) {

        Node firstListHeadNode = this.headNode;
        Node secondListHeadNode = secondList.headNode;
        if (isFirstListBigger) {
            sort(secondList, firstListHeadNode, secondListHeadNode);
        } else {
            sort(this, secondListHeadNode, firstListHeadNode);
        }
    }

    private void sort(InPlaceMergeSortWithoutChangingNodeAddress secondList, Node biggerList, Node smallerList) {
        Node biggerListReferenceNode = biggerList;
        while (biggerListReferenceNode != null) {
            if (biggerListReferenceNode.value > smallerList.value) {
                swapNodeValues(smallerList, biggerListReferenceNode);
                boolean listStillSorted = secondList.isListStillSorted();
                if (!listStillSorted)
                    secondList.sort();
            }
            biggerListReferenceNode = biggerListReferenceNode.reference;
        }
    }


    private void sort() {
        Node referenceNode = this.headNode;
        while (referenceNode != null && referenceNode.reference != null) {
            if (referenceNode.value > referenceNode.reference.value) {
                swapNodeValues(referenceNode, referenceNode.reference);
                referenceNode = referenceNode.reference;
            } else
                break;
        }
    }

    private void swapNodeValues(Node secondListHeadNode, Node firstListHeadNode) {
        firstListHeadNode.value = firstListHeadNode.value ^ secondListHeadNode.value;
        secondListHeadNode.value = firstListHeadNode.value ^ secondListHeadNode.value;
        firstListHeadNode.value = firstListHeadNode.value ^ secondListHeadNode.value;
    }

    private void display() {
        Node referenceNode = headNode;
        while (referenceNode != null) {
            System.out.print(referenceNode.value + " --->");
            referenceNode = referenceNode.reference;
        }
        System.out.println();
    }

    private void addElementsToTheList(int elementsCount, boolean isEven) {
        int jumpCount;
        if (isEven)
            jumpCount = 2;
        else
            jumpCount = 3;
        int startValue = this.headNode.value;
        for (int index = startValue * jumpCount; index <= elementsCount * jumpCount; index = index + jumpCount)
            addElementAtTheEnd(new Node(index, null));

    }

    private void addElementAtTheEnd(Node node) {
        Node referenceNode = headNode;
        if (referenceNode == null)
            referenceNode = node;
        while (referenceNode != null && referenceNode.reference != null)
            referenceNode = referenceNode.reference;
        referenceNode.reference = node;
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
