package trees;

/**
 * Created by deepankit on 12/11/2016.
 */
public class RecursiveDepthFirstSearch {

  public static void main(String[] args) {
    RecursiveDepthFirstSearch recursiveDepthFirstSearch = new RecursiveDepthFirstSearch();
    int range = 10;
    Node headReference = recursiveDepthFirstSearch.buildBinaryTree(range);
    recursiveDepthFirstSearch.recursiveInOrderTreeTraversal(headReference);
    recursiveDepthFirstSearch.recursivePreOrderTreeTraversal(headReference);
    recursiveDepthFirstSearch.recursivePostOrderTreeTraversal(headReference);
  }

  private void recursivePostOrderTreeTraversal(Node headReference) {
    if (headReference == null)
      return;
    recursivePostOrderTreeTraversal(headReference.leftChild);
    recursivePostOrderTreeTraversal(headReference.rightChild);
    System.out.println(headReference.value);
  }

  private void recursivePreOrderTreeTraversal(Node headReference) {
    if (headReference == null)
      return;
    System.out.println(headReference.value);
    recursivePreOrderTreeTraversal(headReference.leftChild);
    recursivePreOrderTreeTraversal(headReference.rightChild);
  }

  private void recursiveInOrderTreeTraversal(Node headReference) {
    if (headReference == null)
      return;
    recursiveInOrderTreeTraversal(headReference.leftChild);
    System.out.println(headReference.value);
    recursiveInOrderTreeTraversal(headReference.rightChild);
  }

  private Node buildBinaryTree(int range) {
    Node headReference = null;
    for (int index = 0; index < range; index += 2) {
      headReference = addNodeToTheTheLeftOfTheBinaryTree(createNewNode(index), headReference);
      headReference = addNodeToTheRightOfTheBinaryTree(createNewNode(index + 1), headReference);
    }

    return headReference;
  }

  private Node addNodeToTheRightOfTheBinaryTree(Node newNode, Node headReference) {
    Node referenceNode = headReference;
    if (headReference == null)
      headReference = newNode;
    else {
      while (referenceNode != null && referenceNode.rightChild != null)
        referenceNode = referenceNode.rightChild;
      referenceNode.rightChild = newNode;
    }
    return headReference;
  }

  private Node addNodeToTheTheLeftOfTheBinaryTree(Node newNode, Node headReference) {
    Node referenceNode = headReference;
    if (headReference == null)
      headReference = newNode;
    else {
      while (referenceNode != null && referenceNode.leftChild != null)
        referenceNode = referenceNode.leftChild;
      referenceNode.leftChild = newNode;
    }
    return headReference;
  }

  private Node createNewNode(int index) {
    return new Node(index, null, null);
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
