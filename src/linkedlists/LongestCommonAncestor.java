package linkedlists;

/**
 * Created by deepankit on 12/8/2016.
 */
public class LongestCommonAncestor {

  public static void main(String[] args) {
    LongestCommonAncestor longestCommonAncestor = new LongestCommonAncestor();
    int firstListInputRange = 10;
    int secondListInputRange = 14;

    Node firstListHeadReference = longestCommonAncestor.buildLinkedList(firstListInputRange);
    Node secondListHeadReference = longestCommonAncestor.buildLinkedList(secondListInputRange);

    Node lowestCommonAncestorNode = longestCommonAncestor.lowestCommonAncestorHeadReference(firstListHeadReference, secondListHeadReference);
    longestCommonAncestor.printLowestCommonAncestorNode(lowestCommonAncestorNode);
  }

  private void printLowestCommonAncestorNode(Node lowestCommonAncestor) {

    while (lowestCommonAncestor != null) {
      System.out.println(lowestCommonAncestor.input);
      lowestCommonAncestor = lowestCommonAncestor.reference;
    }
  }

  private Node buildLinkedList(int inputRange) {
    Node headReference = null;
    Node newNode;
    for (int index = inputRange; index > 0; index--) {
      newNode = new Node(index);
      headReference = addNewNodeToTheEndOfHeadReference(headReference, newNode);
    }
    return headReference;
  }

  private Node addNewNodeToTheEndOfHeadReference(Node headReference, Node newNode) {
    if (headReference == null)
      headReference = newNode;
    else {
      Node traversalNode = headReference;

      while (traversalNode != null && traversalNode.reference != null)
        traversalNode = traversalNode.reference;

      traversalNode.reference = newNode;
    }
    return headReference;
  }

  private Node lowestCommonAncestorHeadReference(Node firstListHeadReference, Node secondListHeadReference) {
    Node firstListTraversalNode = firstListHeadReference;
    Node secondListTraversalNode = secondListHeadReference;

    boolean isFirstListLongest = isFirstListLongest(firstListTraversalNode, secondListTraversalNode);
    int lengthDifference = isFirstListLongest ? findLengthDifference(firstListTraversalNode, secondListTraversalNode) : findLengthDifference(secondListTraversalNode, firstListTraversalNode);


    if (isFirstListLongest)
      firstListTraversalNode = traverseListByLengthDifference(firstListTraversalNode, lengthDifference);
    else
      secondListTraversalNode = traverseListByLengthDifference(secondListTraversalNode, lengthDifference);


    return returnCommonAncestorIfExists(firstListTraversalNode, secondListTraversalNode);

  }

  private Node returnCommonAncestorIfExists(Node firstListTraversalNode, Node secondListTraversalNode) {

    while (firstListTraversalNode != null && secondListTraversalNode != null) {
      if (firstListTraversalNode.input == secondListTraversalNode.input)
        return firstListTraversalNode;
      else {
        firstListTraversalNode = firstListTraversalNode.reference;
        secondListTraversalNode = secondListTraversalNode.reference;
      }
    }
    return null;
  }

  private Node traverseListByLengthDifference(Node listTraversalNode, int length) {

    while (length > 0) {
      listTraversalNode = listTraversalNode.reference;
      length--;
    }
    return listTraversalNode;
  }

  private int findLengthDifference(Node firstListTraversalNode, Node secondListTraversalNode) {

    Node firstListTraversalHeadNode = firstListTraversalNode;
    Node secondListTraversalHeadNode = secondListTraversalNode;
    int lengthDifferenceCount = 0;
    while (firstListTraversalHeadNode != null && secondListTraversalHeadNode != null) {
      secondListTraversalHeadNode = secondListTraversalHeadNode.reference;
      firstListTraversalHeadNode = firstListTraversalHeadNode.reference;
    }

    while (firstListTraversalHeadNode != null) {
      lengthDifferenceCount++;
      firstListTraversalHeadNode = firstListTraversalHeadNode.reference;
    }
    return lengthDifferenceCount;
  }

  private boolean isFirstListLongest(Node firstListTraversalNode, Node secondListTraversalNode) {

    Node firstListTraversalHeadNode = firstListTraversalNode;
    Node secondListTraversalHeadNode = secondListTraversalNode;

    while (firstListTraversalHeadNode != null && secondListTraversalHeadNode != null) {
      secondListTraversalHeadNode = secondListTraversalHeadNode.reference;
      firstListTraversalHeadNode = firstListTraversalHeadNode.reference;
    }
    if (firstListTraversalHeadNode == null)
      return false;

    return true;
  }


  private static class Node {
    private int input;
    private Node reference;

    Node(int input) {
      this.input = input;
      reference = null;
    }
  }
}
