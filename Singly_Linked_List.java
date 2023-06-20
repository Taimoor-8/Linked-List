package Linked_List;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Singly_Linked_List {

    public NodeList head;
    static class NodeList{
        int data;
        public NodeList next;

        public NodeList(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(NodeList head){
        NodeList current =head;
        while (current!=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }


    public int length(){
        int count = 0;
        NodeList current = head;
        while (current!=null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertFirst(int value){
        NodeList newNode = new NodeList(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int value){
        NodeList newNode = new NodeList(value);
        if (head == null){
            head = newNode;
            return;
        }
        NodeList current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAtGivenPosition(int position, int value){
        NodeList newNode = new NodeList(value);
        if (position == 1){
            newNode.next = head;
            head = newNode;
        }
        else {
            int count = 1;
            NodeList previous = head;
            while(count<position-1){
                previous = previous.next;
                count++;
            }
            NodeList current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }

    public NodeList deleteFirst(){
            if (head == null){
                return null;
            }
            NodeList temp = head;
            head = head.next;
            temp.next = null;
            return temp;
    }

    public NodeList deleteLast(){
            if(head == null || head.next == null){
                return null;
            }
            NodeList current = head;
            NodeList previous = null;
            while(current.next != null){
                previous = current;
                current = current.next;
            }
            previous.next = null;
            return current;
    }

    public void DeletionAtGivenPosition(int position){
            if (position == 1){
                head = head.next;
            }
            else{
                int count = 1;
                NodeList previous = head;
                while (count < position-1){
                    previous = previous.next;
                    count++;
                }
                NodeList current = previous.next;
                previous.next = current.next;
            }
    }

    public boolean SearchElement(NodeList head , int searchKey ){
        if (head == null){
            return false;
        }
        NodeList current = head;

            while(current != null){
                if(current.data == searchKey){
                    return true;
                }
                current = current.next;
            }
            return false;
    }

    public NodeList reverseList(NodeList head){
        if (head == null){
            return null;
        }
        NodeList current = head;
        NodeList previous = null;
        NodeList next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public NodeList getMiddleElement(){
        NodeList slwPr = head;
        NodeList fastPr = head;
        while(fastPr.next != null && fastPr != null){
            slwPr = slwPr.next;
            fastPr = fastPr.next.next;
        }
        return slwPr;
    }

    public NodeList getNthNodeFromEnd(int n){
            NodeList mainPr = head;
            NodeList refPr = head;
            int count = 0;
            while(count < n){
                refPr = refPr.next;
                count++;
            }
            while (refPr != null){
                refPr = refPr.next;
                mainPr = mainPr.next;
            }
            return mainPr;
    }

    public void removeDuplicate(){
        if (head == null){
            return;
        }
        NodeList current = head;
        while (current != null && current.next != null){
            if (current.data == current.next.data){
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
    }

    public void insertionInSortedList(int value){
        NodeList newNode = new NodeList(value);
        NodeList current = head;
        NodeList temp = null;
        while(current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        temp.next = newNode;
        newNode.next = current;
    }

    public void deleteKey(int value){
        NodeList current = head;
        NodeList temp = null;
        while (current != null && current.data != value){
            temp = current;
            current = current.next;
        }
        if (current == null){
            return;
        }
        temp.next = current.next;
    }

    public boolean loopDetection(){
        NodeList fastPr = head;
        NodeList slowPr = head;
        while(fastPr != null && fastPr.next != null){
            fastPr = fastPr.next.next;
            slowPr = slowPr.next;
            if (fastPr == slowPr){
                return true;
            }
        }
        return false;
    }

    public NodeList startNodeOfLoop(){
        NodeList fastPr = head;
        NodeList slowPr = head;
        while (fastPr != null && fastPr.next != null){
            fastPr = fastPr.next.next;
            slowPr = slowPr.next;
            if (fastPr == slowPr){
                return getStartingNode(slowPr);
            }
        }
        return null;
    }
    private NodeList getStartingNode(NodeList slowPr) {
        NodeList temp = head;
        while(temp != slowPr){
            temp = temp.next;
            slowPr = slowPr.next;
        }
        return temp;
    }

    public void removeLoop(){
        NodeList fastPr = head;
        NodeList slowPr = head;
        while(fastPr != null && fastPr.next != null) {
            fastPr = fastPr.next.next;
            slowPr = slowPr.next;
            if (fastPr == slowPr) {
                removeLoop2(slowPr);
                return;
            }
        }
    }
    private void removeLoop2(@NotNull NodeList slowPr) {
        NodeList temp = head;
        while (temp.next != slowPr.next){
            temp = temp.next;
            slowPr = slowPr.next;
        }
        slowPr.next = null;
    }

    public NodeList mergeList(NodeList a , NodeList b){
        NodeList dummy = new NodeList(0);
        NodeList tail = dummy;
        while(a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
            if (a == null){
                tail.next = b;
            }
            else {
                tail.next = a;
            }

        return dummy.next;
    }

    public NodeList addNodes(NodeList a , NodeList b){
        NodeList dummy = new NodeList(0);
        NodeList tail = dummy;
        int carry = 0;
        while(a != null || b != null){
            int x = (a!=null) ? a.data : 0;
            int y = (b!=null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum/10;
            tail.next = new NodeList(sum % 10);
            tail = tail.next;

            if (a != null){
                a = a.next;
            }
            if (b != null){
                b = b.next;
            }
        }
        if (carry > 0){
            tail.next = new NodeList(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        Singly_Linked_List s = new Singly_Linked_List();
        Scanner sc = new Scanner(System.in);
        s.head = new NodeList(10);
        NodeList second = new NodeList(5);
        NodeList third = new NodeList(8);
        NodeList fourth = new NodeList(9);
        NodeList fifth = new NodeList(12);
        s.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
//        fifth.next = third;
        //When linked List is created
       /* s.display(s.head);
        System.out.println();
        System.out.println("The length of linked list is " + s.length());*/


        /*s.insertFirst(11);
        s.insertFirst(13);
        s.insertFirst(16);
        s.insertFirst(15);
        //When nodes are added at start
        s.display();
        System.out.println();
        System.out.println("The length of linked list after adding element to start is " + s.length());*/


        /*s.insertLast(7);
        s.insertLast(9);
        s.insertLast(65);
        s.insertLast(14);
//        When nodes are added at last
        s.display();
        System.out.println();
        System.out.println("The length of linked list after adding element to last is " + s.length());*/


        /*s.insertAtGivenPosition(3,198);
        s.insertAtGivenPosition(6,876);
        s.insertAtGivenPosition(8,546);
        s.insertAtGivenPosition(2,245);
//        When nodes are added at a given position
        s.display();
        System.out.println();
        System.out.println("The length of linked list after adding element to required position is " + s.length());*/


        System.out.println(s.deleteFirst());
        if (s.deleteFirst() == null){
            System.out.println("List is empty");
        }
        s.display(s.head);
        System.out.println();
        System.out.println("The length of linked list after deleting element from start is " + s.length());


//        To delete last Node form node list
        /*System.out.println(s.deleteLast());
        s.display(s.head);
        System.out.println();
        System.out.println("The length of linked list after deleting element from last is " + s.length());*/


        /*s.DeletionAtGivenPosition(4);
        s.display();
        System.out.println();
        System.out.println("The length of linked list after deleting element from last is " + s.length());*/


/*//       To search element in the list
        System.out.println("Enter the keyword to be searched");
        int search_key = sc.nextInt();
        if (s.SearchElement(s.head ,search_key)){
            System.out.printf("Search keyword %d is found in the Node list " , search_key);
            System.out.println();
        }*/


/*
//        To reverse the NodeList
        NodeList reverse_list = s.reverseList(s.head);
        s.display(reverse_list);*/


//            To find middle node form node list
            /*NodeList middleNode = s.getMiddleElement();
            System.out.println("The middle node of list node is " + middleNode.data);*/


//            Finding nth node in linked list
            /*System.out.println("Enter the node to be taken");
            int desiredNode = sc.nextInt();
            NodeList nthNode = s.getNthNodeFromEnd(desiredNode);
            int length = s.length();
            int givenNode = length - desiredNode + 1;
            System.out.println("The "+ givenNode +" node from last of the singly linked list is " + nthNode.data);*/


            /*s.insertFirst(3);
            s.insertFirst(3);
            s.insertFirst(2);
            s.insertFirst(1);
            s.insertFirst(1);
            s.display(s.head);
        System.out.println("\nThe linked list after removing duplicated nodes is ");
            s.removeDuplicate();
            s.display(s.head);*/


        /*s.insertFirst(15);
        s.insertFirst(10);
        s.insertFirst(8);
        s.insertFirst(5);
        s.insertFirst(3);
        s.insertionInSortedList(9);
        System.out.println("The linked list after the insertion is ");
        s.display(s.head);*/


        /*s.insertFirst(15);
        s.insertFirst(10);
        s.insertFirst(8);
        s.insertFirst(5);
        s.insertFirst(3);
        s.deleteKey(10);
        System.out.println("The linked list after deleting the given key is");
        s.display(s.head);*/


//        To detect whether the linked list has a loop
//        System.out.println(s.loopDetection());


//        To find staring node of the loop
//        System.out.println(s.startNodeOfLopp().data);


//        To remove loop from the linked list
        /*s.removeLoop();
        System.out.println(s.loopDetection());*/


        /*Singly_Linked_List s1 = new Singly_Linked_List();
//        s1.insertFirst(13);
        s1.insertFirst(9);
        s1.insertFirst(6);
        s1.insertFirst(4);*/

        /*Singly_Linked_List s2 = new Singly_Linked_List();
        *//*s2.insertFirst(15);
        s2.insertFirst(12);*//*
        s2.insertFirst(8);
        s2.insertFirst(6);
        s2.insertFirst(5);
        s2.insertFirst(2);*/

        /*Singly_Linked_List result = new Singly_Linked_List();
        *//*result.head = result.mergeList(s1.head , s2.head);
        result.display(result.head);*//*


        result.head = result.addNodes(s1.head , s2.head);
        result.display(result.head);*/
    }
}