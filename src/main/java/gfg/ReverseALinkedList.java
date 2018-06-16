package gfg;


import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
 */
public class ReverseALinkedList {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }

        public static Node addNext(Node node,int data){

            Node tmp=new Node(data);
            node.next=tmp;
            return tmp;
        }
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            Node node=null;
            Node root=null;
            while (n-->0){
                if(node==null){
                    node=new Node(scanner.nextInt());
                    root=node;
                }
                else{
                    node=Node.addNext(node,scanner.nextInt());
                }
            }

            Node previous=root;
            root=root.next;
            previous.next=null;
            while (root!=null){
                Node next=root.next;
                root.next=previous;
                previous=root;
                root=next;
            }

            Node tmp=previous;
            while(tmp!=null){
                System.out.print(tmp.data+" ");
                tmp=tmp.next;
            }


        }

    }
}
