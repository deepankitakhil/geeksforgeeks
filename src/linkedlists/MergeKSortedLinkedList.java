package linkedlists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deepankit on 9/26/2016.
 */
public class MergeKSortedLinkedList {
    private Node headNode;
    private List<MergeKSortedLinkedList> sortedElementsList;

    public MergeKSortedLinkedList() {
        sortedElementsList = new ArrayList<>();
    }

    public MergeKSortedLinkedList(Node headNode) {
        this.headNode = headNode;
        sortedElementsList = new ArrayList<>();
    }

    public static void main(String[] args) {
        int elementsCount = 10;
        int incrementFactor = 1;
        MergeKSortedLinkedList mergeKSortedLinkedList = new MergeKSortedLinkedList();
        mergeKSortedLinkedList.sortedElementsList.add(new MergeKSortedLinkedList(null));
        mergeKSortedLinkedList.sortedElementsList.add(new MergeKSortedLinkedList(null));
        mergeKSortedLinkedList.sortedElementsList.add(new MergeKSortedLinkedList(null));

        mergeKSortedLinkedList.addKSortedLists(mergeKSortedLinkedList.getSortedElementsList(), elementsCount, incrementFactor);
        mergeKSortedLinkedList.sortKListUsingMergeSort();
        mergeKSortedLinkedList.display();
    }

    private void sortKListUsingMergeSort() {
        List<MergeKSortedLinkedList> sortedElementsList = getSortedElementsList();
        Node sortedList = sortedElementsList.get(0).headNode;
        for (int index = 1; index < sortedElementsList.size(); index++) {
            sortedList = sort(sortedList, sortedElementsList.get(index).headNode);
        }
    }

    private Node sort(Node pointerToFirstLinkedList, Node pointerToSecondLinkedList) {
        Node resultantList = null;
        if (pointerToFirstLinkedList == null)
            return pointerToSecondLinkedList;
        if (pointerToSecondLinkedList == null)
            return pointerToFirstLinkedList;
        if (pointerToFirstLinkedList.value < pointerToSecondLinkedList.value) {
            resultantList = pointerToFirstLinkedList;
            resultantList.reference = sort(pointerToFirstLinkedList.reference, pointerToSecondLinkedList);
        } else {
            resultantList = pointerToSecondLinkedList;
            resultantList.reference = sort(pointerToFirstLinkedList, pointerToSecondLinkedList.reference);
        }
        return resultantList;
    }

    private void display() {
        List<MergeKSortedLinkedList> sortedElementsList = getSortedElementsList();
        displayElements(sortedElementsList.get(2));
    }

    private void displayElements(MergeKSortedLinkedList linkedList) {
        Node headReference = linkedList.headNode;
        while (headReference != null) {
            System.out.print(headReference.value + "-->");
            headReference = headReference.reference;
        }
    }

    public List<MergeKSortedLinkedList> getSortedElementsList() {
        return sortedElementsList;
    }

    private void addKSortedLists(List<MergeKSortedLinkedList> sortedElementsList, int elementsCount, int incrementFactor) {
        for (MergeKSortedLinkedList linkedList : sortedElementsList) {
            linkedList.addElementsInTheList(elementsCount, ++incrementFactor);
        }
    }


    private void addElementsInTheList(int elementsCount, int incrementFactor) {
        for (int index = 0; index <= elementsCount; index++) {
            addElementsAtTheEnd(new Node(index * incrementFactor, null));
        }
    }

    private void addElementsAtTheEnd(Node node) {
        Node headReference = headNode;
        if (headReference == null)
            headNode = node;
        else {
            while (headReference != null && headReference.reference != null)
                headReference = headReference.reference;
            headReference.reference = node;
        }
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
