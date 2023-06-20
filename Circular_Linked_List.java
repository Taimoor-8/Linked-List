package Linked_List;

import org.w3c.dom.NodeList;

import java.util.NoSuchElementException;

public class Circular_Linked_List {
    NodeList last;
    int length;
    private static class NodeList{
        NodeList next;
        int data;

        public NodeList(int data){
            this.data = data;
        }
    }

    public Circular_Linked_List(){
        last = null;
        length = 0;
    }

    public boolean isEmpty(){
        return last == null;
    }

    public int Length(){
        return length;
    }

    public void display(){
        if (last == null){
            System.out.println("null");
            return;
        }
        NodeList first = last.next;
        while (first != last){
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.print(first.data);
        System.out.println();
    }

    public void insertFirst(int value){
        NodeList temp = new NodeList(value);
        if (last == null){
            last = temp;
        }
        else{
            temp.next = last.next;
        }
        last.next  = temp;
        length++;
    }

    public void insertLast(int value){
        NodeList temp = new NodeList(value);
        if (last == null){
            last = temp;
        }
        else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    public void deleteFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        NodeList temp = last.next;
        if(last.next == last){
            last = null;
        }
        else{
            last.next = temp.next;
        }
        temp.next = null;
        length--;
    }

    public void deleteLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (last.next == last){
            System.out.println("null");
            return;
        }
        NodeList temp = last.next;
        NodeList first = last.next;
        while (temp.next != last){
            temp = temp.next;
        }
        temp.next = first;
        last.next = null;
        last = temp;
        length--;
    }

    public static void main(String[] args) {
        Circular_Linked_List cll = new Circular_Linked_List();
        NodeList first = new NodeList(3);
        NodeList second = new NodeList(5);
        NodeList third = new NodeList(7);
        NodeList fourth = new NodeList(10);
        NodeList fifth = new NodeList(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = first;
        cll.last = fifth;

        cll.display();

        /*cll.insertFirst(1);
        System.out.println("Linked list after inserting node at start is");
        cll.display();*/


        /*cll.insertLast(20);
        System.out.println("Linked list after inserting node at last is");
        cll.display();*/


        cll.deleteFirst();
        System.out.println("Linked list after deleting first node is");
        cll.display();


        cll.deleteLast();
        System.out.println("Linked list after deleting last node is");
        cll.display();
    }
}
