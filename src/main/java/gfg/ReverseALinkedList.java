package gfg;


import java.util.Scanner;


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
        /**
         * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
         */
        public static Node reverse(Node root){
            Node previous=root;
            root=root.next;
            previous.next=null;
            while (root!=null){
                Node next=root.next;
                root.next=previous;
                previous=root;
                root=next;
            }
            return previous;
        }

        /**
         * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
         * @param root
         * @param groupCount
         * @return
         */
        public static Node reverseGroup(Node root,int groupCount){

            Node previous=null;
            Node prevTemp=null;
            Node first=null,pfirst=null;
            Node actual_root=null;
            while(root!=null) {
                previous=root;
                root = root.next;
                previous.next = null;
                pfirst=first;
                first=previous;
                int count=groupCount;
                count--;
                while (root != null && count-- > 0) {
                    Node next = root.next;
                    root.next = previous;
                    previous = root;
                    root = next;
                }
                if(prevTemp!=null&&pfirst!=null){
                    pfirst.next=previous;
                }
                if(actual_root==null){
                    actual_root=previous;
                }
                prevTemp=previous;
            }
            return actual_root;
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
            int groupCount=scanner.nextInt();


            Node tmp=Node.reverseGroup(root,groupCount);
            while(tmp!=null){
                System.out.print(tmp.data+" ");
                tmp=tmp.next;
            }


        }

    }
}
