package trees;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by deepankit on 12/10/2016.
 */
public class CloneBinaryTree {
  public static void main(String[] args) {
    int range = 10;
    CloneBinaryTree cloneBinaryTree = new CloneBinaryTree();
    Node headNodeReference = cloneBinaryTree.buildBinaryTree(range);
    cloneBinaryTree.inOrderTraversal(headNodeReference);
    Node clonedTree = cloneBinaryTree.cloneTree(headNodeReference);
    cloneBinaryTree.inOrderTraversal(clonedTree);
  }

  private Node cloneTree(Node headNodeReference) {
    Map<Node, Node> clonedNodeMapping = new LinkedHashMap<>();
    return cloneLeftAndRightReference(headNodeReference, clonedNodeMapping);
  }

  private Node cloneLeftAndRightReference(Node headNodeReference, Map<Node, Node> clonedNodeMapping) {
    if (headNodeReference == null)
      return null;

    Node clonedNode = new Node(headNodeReference.value, null, null, null);
    clonedNodeMapping.put(headNodeReference, clonedNode);
    clonedNode.leftReference = cloneLeftAndRightReference(headNodeReference.leftReference, clonedNodeMapping);
    clonedNode.rightReference = cloneLeftAndRightReference(headNodeReference.rightReference, clonedNodeMapping);
    copyRandomReference(clonedNode.randomReference, headNodeReference.randomReference, clonedNodeMapping);
    return clonedNode;
  }

  private void copyRandomReference(Node clonedRandomReference, Node randomReference, Map<Node, Node> clonedNodeMapping) {
    if (clonedRandomReference == null)
      return;
    clonedRandomReference.randomReference = clonedNodeMapping.get(randomReference.randomReference);
    copyRandomReference(clonedRandomReference.leftReference, randomReference.leftReference, clonedNodeMapping);
    copyRandomReference(clonedRandomReference.rightReference, randomReference.rightReference, clonedNodeMapping);
  }

  private void inOrderTraversal(Node headNodeReference) {
    if (headNodeReference == null)
      return;
    inOrderTraversal(headNodeReference.leftReference);
    System.out.println(headNodeReference.value);
    inOrderTraversal(headNodeReference.rightReference);

  }

  private Node buildBinaryTree(int range) {
    Node headNodeReference = null;
    for (int index = 0; index < range; index += 2) {
      Node newNodeForRightReference = createNewNode(index);
      Node newNodeForLeftReference = createNewNode(index + 1);
      headNodeReference = addNewNodeAtRightOfHeadNodeReference(newNodeForRightReference, headNodeReference);
      headNodeReference = addNewNodeAtLeftOfHeadNodeReference(newNodeForLeftReference, headNodeReference);
    }

    return headNodeReference;
  }

  private Node addNewNodeAtRightOfHeadNodeReference(Node newNode, Node headNodeReference) {
    Node traversalNode = headNodeReference;
    if (headNodeReference == null)
      headNodeReference = newNode;
    else {
      while (traversalNode != null && traversalNode.rightReference != null) {
        traversalNode = traversalNode.rightReference;
      }
      traversalNode.rightReference = newNode;
    }
    return headNodeReference;
  }

  private Node addNewNodeAtLeftOfHeadNodeReference(Node newNode, Node headNodeReference) {
    Node traversalNode = headNodeReference;
    if (headNodeReference == null)
      headNodeReference = newNode;
    else {
      while (traversalNode != null && traversalNode.leftReference != null) {
        traversalNode = traversalNode.leftReference;
      }
      traversalNode.leftReference = newNode;
    }
    return headNodeReference;
  }

  private Node createNewNode(int value) {
    return new Node(value, null, null, null);
  }

  private static class Node {
    private int value;
    private Node leftReference;
    private Node rightReference;
    private Node randomReference;

    public Node(int value, Node leftReference, Node rightReference, Node randomReference) {
      this.value = value;
      this.leftReference = leftReference;
      this.rightReference = rightReference;
      this.randomReference = randomReference;
    }
  }
}
