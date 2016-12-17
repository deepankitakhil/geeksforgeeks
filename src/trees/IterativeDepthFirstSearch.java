package trees;

import java.util.Stack;

/**
 * Created by deepankit on 12/11/2016.
 */
public class IterativeDepthFirstSearch {
  public static void main(String[] args) {
    IterativeDepthFirstSearch iterativeDepthFirstSearch = new IterativeDepthFirstSearch();
    int range = 10;
    Node headReference = iterativeDepthFirstSearch.buildBinaryTree(range);
    iterativeDepthFirstSearch.inOrderTraversal(headReference);
    iterativeDepthFirstSearch.preOrderTraversal(headReference);
    iterativeDepthFirstSearch.postOrderTraversal(headReference);
  }

  private void inOrderTraversal(Node headReference) {
    Stack<Node> traversalStack = new Stack<>();

    while (true) {
      while (headReference != null) {
        traversalStack.push(headReference);
        headReference = headReference.leftChild;
      }
      if (traversalStack.isEmpty())
        return;
      headReference = traversalStack.pop();
      System.out.println(headReference.value);
      headReference = headReference.rightChild;
    }
  }

  private void postOrderTraversal(Node headReference) {
    Stack<Node> traversalStack = new Stack<>();
    Stack<Node> rootStack = new Stack<>();

    traversalStack.push(headReference);
    while (!traversalStack.isEmpty()) {
      Node poppedNode = traversalStack.pop();
      rootStack.push(poppedNode);
      if (poppedNode.leftChild != null)
        traversalStack.push(poppedNode.leftChild);
      if (poppedNode.rightChild != null)
        traversalStack.push(poppedNode.rightChild);
    }
    while (!rootStack.isEmpty())
      System.out.println(rootStack.pop().value);


  }

  private void preOrderTraversal(Node headReference) {
    Stack<Node> traversalStack = new Stack<>();

    while (true) {
      while (headReference != null) {
        System.out.println(headReference.value);
        traversalStack.push(headReference);
        headReference = headReference.leftChild;
      }
      if (traversalStack.isEmpty())
        return;

      headReference = traversalStack.pop();
      headReference = headReference.rightChild;
    }
  }

  private Node buildBinaryTree(int range) {
    Node headReference = null;
    for (int value = 0; value < range; value += 2) {
      headReference = addNewNodeAtTheLeftOfTheTree(createNewNode(value), headReference);
      headReference = addNewNodeAtTheRightOfTheTree(createNewNode(value + 1), headReference);
    }
    return headReference;
  }

  private Node addNewNodeAtTheRightOfTheTree(Node newNode, Node headReference) {
    if (headReference == null)
      headReference = newNode;
    else {
      Node traversalNode = headReference;
      while (traversalNode != null && traversalNode.rightChild != null)
        traversalNode = traversalNode.rightChild;
      traversalNode.rightChild = newNode;
    }
    return headReference;
  }

  private Node addNewNodeAtTheLeftOfTheTree(Node newNode, Node headReference) {
    if (headReference == null)
      headReference = newNode;
    else {
      Node traversalNode = headReference;
      while (traversalNode != null && traversalNode.leftChild != null)
        traversalNode = traversalNode.leftChild;
      traversalNode.leftChild = newNode;
    }
    return headReference;
  }

  private Node createNewNode(int value) {
    return new Node(value, null, null);
  }

  private static class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value, Node leftChild, Node rightChild) {
      this.value = value;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
    }
  }
}
