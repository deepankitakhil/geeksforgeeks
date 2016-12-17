package linkedlists;

import hackerrank.Solution;

/**
 * Created by deepankit on 12/9/2016.
 */
public class RedundantNodeDeletion {
  public static void main(String[] args) {
    RedundantNodeDeletion redundantNodeDeletion = new RedundantNodeDeletion();
    LinkedListNode head = null;

    head = redundantNodeDeletion.insertNodeIntoSinglyLinkedList(head, 2);
    head = redundantNodeDeletion.insertNodeIntoSinglyLinkedList(head, 3);
    head = redundantNodeDeletion.insertNodeIntoSinglyLinkedList(head, 2);
    head = redundantNodeDeletion.insertNodeIntoSinglyLinkedList(head, 2);
    head = redundantNodeDeletion.insertNodeIntoSinglyLinkedList(head, 2);

    redundantNodeDeletion.removeRedundantNode(head);
    redundantNodeDeletion.display(head);
  }

  private void display(LinkedListNode head) {
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }

  private LinkedListNode removeRedundantNode(LinkedListNode head) {
    LinkedListNode firstTraversal = head;
    LinkedListNode secondTraversal = null;
    LinkedListNode duplicate = null;

    while (firstTraversal != null && firstTraversal.next != null) {
      secondTraversal = firstTraversal;
      while (secondTraversal.next != null) {
        if (firstTraversal.val == secondTraversal.next.val) {
          duplicate = secondTraversal.next;
          secondTraversal.next = secondTraversal.next.next;
        } else
          secondTraversal = secondTraversal.next;
      }
      firstTraversal = firstTraversal.next;
    }
    return head;
  }

  private LinkedListNode insertNodeIntoSinglyLinkedList(LinkedListNode head, int val) {
    if (head == null) {
      head = new LinkedListNode(val);
      head.next = null;
    } else {
      LinkedListNode iter = head;
      while (iter.next != null) {
        iter = iter.next;
      }
      LinkedListNode node = new LinkedListNode(val);
      node.next = null;
      iter.next = node;
    }

    return head;
  }

  private static class LinkedListNode {
    int val;
    LinkedListNode next;

    public LinkedListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }
}
