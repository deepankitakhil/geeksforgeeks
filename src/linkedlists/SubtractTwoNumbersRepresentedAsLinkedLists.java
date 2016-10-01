package linkedlists;

/**
 * Created by Deepankit on 10/1/2016.
 */
public class SubtractTwoNumbersRepresentedAsLinkedLists {
    private Node firstNumber;
    private Node secondNumber;
    private boolean isBorrowSet = false;

    public SubtractTwoNumbersRepresentedAsLinkedLists(Node firstNumber, Node secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public static void main(String[] args) {
        SubtractTwoNumbersRepresentedAsLinkedLists subtractTwoNumbersRepresentedAsLinkedLists = new SubtractTwoNumbersRepresentedAsLinkedLists(new Node(9, null), new Node(9, null));
        subtractTwoNumbersRepresentedAsLinkedLists.addNodesAtTheEnd();
        subtractTwoNumbersRepresentedAsLinkedLists.display();
        subtractTwoNumbersRepresentedAsLinkedLists.displayElements(subtractTwoNumbersRepresentedAsLinkedLists.calculateDifference());
    }

    private Node calculateDifference() {
        int lengthOfFirstNumber = calculateLength(firstNumber);
        int lengthOfSecondNumber = calculateLength(secondNumber);
        return identifyLargerElement(firstNumber, secondNumber, lengthOfFirstNumber, lengthOfSecondNumber);
    }

    private Node identifyLargerElement(Node firstNumber, Node secondNumber, int lengthOfFirstNumber, int lengthOfSecondNumber) {
        Node firstNumberReference = firstNumber;
        Node secondNumberReference = secondNumber;
        int differenceOfDigits = lengthOfFirstNumber - lengthOfSecondNumber;
        if (differenceOfDigits > 0) {
            return calculateDifferenceBetweenTwoElements(firstNumber, addLeadingZero(secondNumber, differenceOfDigits));
        } else if (differenceOfDigits < 0) {
            return calculateDifferenceBetweenTwoElements(secondNumber, addLeadingZero(firstNumber, -differenceOfDigits));
        } else {
            while (firstNumberReference != null) {
                if (firstNumberReference.number < secondNumberReference.number) {
                    return (calculateDifferenceBetweenTwoElements(secondNumber, firstNumber));
                }
                firstNumberReference = firstNumberReference.reference;
                secondNumberReference = secondNumberReference.reference;
            }
            return calculateDifferenceBetweenTwoElements(firstNumber, secondNumber);
        }
    }

    private Node addLeadingZero(Node node, int numberOfLeadingZeros) {
        Node nodeToBeAddedAtFront = null;
        while (numberOfLeadingZeros >= 1) {
            nodeToBeAddedAtFront = new Node(0, null);
            nodeToBeAddedAtFront.reference = node;
            numberOfLeadingZeros--;
        }

        return nodeToBeAddedAtFront;
    }

    private Node calculateDifferenceBetweenTwoElements(Node biggerNumber, Node smallerNumber) {
        if (smallerNumber == null && biggerNumber == null)
            return null;
        Node previousNode = calculateDifferenceBetweenTwoElements(biggerNumber != null ? biggerNumber.reference : null, smallerNumber != null ? smallerNumber.reference : null);
        if (this.isBorrowSet) {
            biggerNumber.number -= 1;
            this.isBorrowSet = false;
        }

        if (biggerNumber.number - smallerNumber.number < 0) {
            biggerNumber.number += 10;
            this.isBorrowSet = true;
        }


        Node currentNode = new Node(biggerNumber.number - smallerNumber.number, null);
        currentNode.reference = previousNode;
        return currentNode;
    }

    private int calculateLength(Node referenceNode) {
        Node reference = referenceNode;
        int count = 0;
        while (reference != null) {
            count++;
            reference = reference.reference;
        }
        return count;
    }

    private void display() {
        displayElements(firstNumber);
        System.out.println();
        displayElements(secondNumber);
        System.out.println();


    }

    private void displayElements(Node number) {
        Node reference = number;
        while (reference != null) {
            System.out.print(reference.number);
            reference = reference.reference;
        }
    }

    private void addNodesAtTheEnd() {
        addElements(firstNumber, secondNumber);
    }

    private static void addElements(Node firstNumber, Node secondNumber) {
        Node firstNumberReference = firstNumber;
        firstNumberReference.reference = new Node(9, null);
        firstNumberReference = firstNumberReference.reference;
        firstNumberReference.reference = new Node(9, null);
        firstNumberReference = firstNumberReference.reference;
        firstNumberReference.reference = new Node(9, null);
        firstNumberReference = firstNumberReference.reference;
        firstNumberReference.reference = new Node(9, null);

        firstNumberReference = secondNumber;
        firstNumberReference.reference = new Node(9, null);
        firstNumberReference = firstNumberReference.reference;
        firstNumberReference.reference = new Node(9, null);
        firstNumberReference = firstNumberReference.reference;
        firstNumberReference.reference = new Node(9, null);
        firstNumberReference = firstNumberReference.reference;
        firstNumberReference.reference = new Node(9, null);

    }

    private static class Node {
        private int number;
        private Node reference;

        public Node(int number, Node reference) {
            this.number = number;
            this.reference = reference;
        }
    }
}
