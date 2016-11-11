package linkedlists;

/**
 * Created by Deepankit on 11/6/2016.
 */
public class DeleteNodesGreaterThanAGivenValue {
  public static void main(String[] args) {
    DeleteNodesGreaterThanAGivenValue deleteNodesGreaterThanAGivenValue = new DeleteNodesGreaterThanAGivenValue();
    LinkedListNode head = new LinkedListNode(1, null);
    head.next = new LinkedListNode(5, null);
    head.next.next = new LinkedListNode(4, null);
    head.next.next.next = new LinkedListNode(3, null);
    LinkedListNode linkedListNode = deleteNode(head, 5);
    printNodes(linkedListNode);
  }

  private static void printNodes(LinkedListNode linkedListNode) {

    while (linkedListNode != null) {

      System.out.println(linkedListNode.val);
      linkedListNode = linkedListNode.next;
    }
  }

  private static LinkedListNode deleteNode(LinkedListNode current, int key) {
    if (current == null) return null;

    if (current.val > key) {
      current = current.next;
      current = deleteNode(current, key);
    } else current.next = deleteNode(current.next, key);

    return current;
  }

  private static class LinkedListNode {
    int val;
    LinkedListNode next;

    public LinkedListNode(int val, LinkedListNode next) {
      this.val = val;
      this.next = next;
    }
  }

}
