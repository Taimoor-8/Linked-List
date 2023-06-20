package Linked_List;

import org.w3c.dom.NodeList;

import java.util.NoSuchElementException;

public class Doubly_Linked_List {
    private NodeList head;
    private NodeList tail;
    private int length;

    private static class NodeList{
        NodeList next;
        NodeList previous;
        int data;

        NodeList(int data){
            this.data = data;
        }
    }
    public Doubly_Linked_List(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public int Length(){
        return length;
    }

    public void displayForward(){
        if (head == null){
            System.out.println("null");
            return;
        }
        NodeList temp = head;
        while(temp != null){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayReverse(){
        if (head == null){
        System.out.println("null");
            return;
        }
        NodeList temp = tail;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.previous;
        }
        System.out.println( );
    }

    public void insertFirst(int value){
        NodeList newNode = new NodeList(value);
        if (isEmpty()){
            tail = newNode;
        }
        else{
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertLast(int value){
        NodeList newNode = new NodeList(value);
        if (isEmpty()){
            head = newNode;
        }
        else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    public void deleteFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        NodeList temp = head;
        if (head == tail){
            tail = null;
        }
        else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
    }

    public void deleteLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        NodeList temp = tail;
        if (head == tail){
            head = null;
        }
        else{
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
    }

    public static void main(String[] args) {
        Doubly_Linked_List s = new Doubly_Linked_List();
        /*s.insertLast(17);
        s.insertLast(12);
        s.insertLast(8);
        s.insertLast(6);
        s.insertLast(3);

        System.out.println("Linked list in forward order is");
        s.displayForward();
        System.out.println("Linked list in reverse order is");
        s.displayReverse();*/


        s.insertFirst(17);
        s.insertFirst(12);
        s.insertFirst(8);
        s.insertFirst(6);
        s.insertFirst(3);
        s.insertFirst(1);

        /*System.out.println("Linked list in forward order is");
        s.displayForward();
        System.out.println("Linked list in reverse order is");
        s.displayReverse();*/


        s.deleteFirst();
        System.out.println("Linked list after deleting first element is");
        s.displayForward();


        /*s.deleteLast();
        System.out.println("Linked list after deleting last element is");
        s.displayForward();*/
    }
}
