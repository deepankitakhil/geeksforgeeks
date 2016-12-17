package linkedlists;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by deepankit on 12/8/2016.
 */
public class CloneLinkedList {

  public static void main(String[] args) {
    int nodeMaxValue = 10;
    CloneLinkedList cloneLinkedList = new CloneLinkedList();
    Node headNode = cloneLinkedList.buildLinkedList(nodeMaxValue);
    Node CloneLinkedList = cloneLinkedList.createClone(headNode);
    cloneLinkedList.display(headNode);
    cloneLinkedList.display(CloneLinkedList);
  }

  private void display(Node headNode) {

    Node traverseNode = headNode;

    while (traverseNode != null) {
      System.out.println(traverseNode.value);
      traverseNode = traverseNode.next;
    }
  }

  private Node createClone(Node headNode) {
    Node referenceNode = headNode;
    Map<Node, Node> nodeMap = new LinkedHashMap<>();
    while (referenceNode != null) {
      nodeMap.put(referenceNode, new Node(referenceNode.value));
      referenceNode = referenceNode.next;
    }

    referenceNode = headNode;

    while (referenceNode != null) {

      Node clonedNode = nodeMap.get(referenceNode);
      clonedNode.next = nodeMap.get(referenceNode.next);
      clonedNode.random = nodeMap.get(referenceNode.random);

      referenceNode = referenceNode.next;
    }
    return nodeMap.get(headNode);
  }


  private Node buildLinkedList(int nodeMaxValue) {
    Node headNodeReference = null;
    for (int index = 0; index < nodeMaxValue; index++) {

      Node newNode = new Node(index);
      headNodeReference = addNewNodeAtTheEndOfTheHeadNodeReference(headNodeReference, newNode);
    }
    return headNodeReference;

  }


  private Node addNewNodeAtTheEndOfTheHeadNodeReference(Node headNodeReference, Node newNode) {

    Node headTraversal = headNodeReference;
    if (headTraversal == null)
      headNodeReference = newNode;
    else {
      while (headTraversal != null && headTraversal.next != null) {
        headTraversal = headTraversal.next;
      }
      headTraversal.next = newNode;
    }
    return headNodeReference;
  }


  private static class Node {
    int value;
    Node next;
    Node random;

    Node(int value) {
      this.value = value;
      this.next = null;
      this.random = null;
    }
  }
}
