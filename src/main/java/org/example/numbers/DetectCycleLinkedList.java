package org.example.numbers;
public class DetectCycleLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // Creating cycle: 5 → 3
        node5.next = node3;
        boolean cycleExists = hasCycle(node1);
        System.out.println("Cycle exists: " + cycleExists);
    }
}