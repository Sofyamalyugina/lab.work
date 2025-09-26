class SimpleLinkedList {
    private Node head;
    
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public void insert(int data, int index) {
        Node newNode = new Node(data);
        
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    
    public void print() {
        Node current = head;
        System.out.print("Список: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public void findOccurrences(int target) {
        System.out.print("Элемент " + target + " найден на позициях: ");
        Node current = head;
        int position = 0;
        boolean found = false;
        
        while (current != null) {
            if (current.data == target) {
                System.out.print(position + " ");
                found = true;
            }
            current = current.next;
            position++;
        }
        
        if (!found) {
            System.out.print("не найден");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();

        list.insert(10, 0);
        list.insert(20, 1);
        list.insert(10, 2);
        list.insert(30, 3);
        list.insert(10, 4);
        list.insert(40, 5);

        System.out.print("Список: ");
        list.print();

        list.findOccurrences(10);
    }
}