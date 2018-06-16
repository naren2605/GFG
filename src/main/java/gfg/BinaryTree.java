package gfg;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BinaryTree {

    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int a){
            this.data=a;
        }
    }
    Node root;

    BinaryTree(){
    }

    void add(int a){
        if(root==null){
            root=new Node(a);
            return;
        }
        Node tmp=root;
        while(tmp!=null){
            if(tmp.data>a){
                if(tmp.left==null){
                    tmp.left=new Node(a);
                    break;
                }
                tmp=tmp.left;
            }
            else{
                if(tmp.right==null){
                    tmp.right=new Node(a);
                    break;
                }
                tmp=tmp.right;

            }
        }

    }



    int maxDiameter=1;
    public int diameter(){
        treeDiameter(root);
        return maxDiameter;
    }


    int treeDiameter(Node node){

        if(node.left==null && node.right==null){
            return 1;
        }
        else if(node.right==null){
            int leftHeight=treeDiameter(node.left);
            maxDiameter=Math.max(maxDiameter,1+leftHeight);
            return 1+leftHeight;
        }
        else if(node.left==null){
            int rightHeight=treeDiameter(node.right);
            maxDiameter=Math.max(maxDiameter,1+rightHeight);
            return 1+rightHeight;
        }
        else{
            int leftHeight=treeDiameter(node.left);
            int rightHeight=treeDiameter(node.right);
            maxDiameter=Math.max(maxDiameter,1+leftHeight+rightHeight);
            return 1+Math.max(treeDiameter(node.left),treeDiameter(node.right));
        }

    }




    public void traverse(){
        traverse(root);
    }
    public void traverse(Node node){
            if(node!=null) {
                traverse(node.left);
                System.out.print(" " + node.data);
                traverse(node.right);
            }
    }

    public void boundaryView(){
        if(root!=null){
            System.out.print(" "+root.data);
            boundaryLeftView(root.left,true);
            boundaryRightView(root.right,true);
            System.out.println();
        }
    }
    public  void boundaryLeftView(Node parent, boolean left){
        if (parent==null){
        return;
        }

        if((parent.left==null&&parent.right==null)){
            System.out.print(" "+parent.data);
        }
        else if(parent.left==null&&parent.right!=null&&left){
            if(left){
                System.out.print(" "+parent.data);
            }
            boundaryLeftView(parent.right,true);
        }
        else{
            if(left){
                System.out.print(" "+parent.data);
            }
            boundaryLeftView(parent.left,left);
            boundaryLeftView(parent.right,false);
        }



    }

    public  void boundaryRightView(Node parent, boolean right){
        if (parent==null){
            return;
        }

        if((parent.left==null&&parent.right==null)){
            System.out.print(" "+parent.data);
        }
        else if(parent.right==null&&parent.left!=null&&right){

            boundaryRightView(parent.left,true);
            if(right){
                System.out.print(" "+parent.data);
            }
        }
        else{
            boundaryRightView(parent.left,false);
            boundaryRightView(parent.right,right);
            if(right){
                System.out.print(" "+parent.data);
            }
        }



    }
    public static void main(String[] args) {

        BinaryTree bst=new BinaryTree();
        bst.add(20);
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(14);
        bst.add(16);
        bst.add(30);
        bst.add(40);
        bst.add(35);
        bst.add(38);
        bst.add(37);
        bst.add(49);
        bst.traverse();
        System.out.println();
        bst.boundaryView();
        BinaryTree bst2=new BinaryTree();

        bst2.add(20);
        bst2.add(8);
        bst2.add(4);
        bst2.add(12);
        bst2.add(10);
        bst2.add(14);
        bst2.add(22);
        bst2.add(25);
        bst2.boundaryView();

        BinaryTree bst3= new BinaryTree();
        bst3.add(100);
        bst3.add(110);
        bst3.add(111);
        bst3.add(112);
        bst3.add(113);
        bst3.add(114);
        bst3.add(109);
        bst3.add(108);
        System.out.println(bst3.diameter());


        Scanner scanner=new Scanner(System.in);
        int tests=scanner.nextInt();
        while(tests-->0){

            HashMap<Integer,Integer[]> map = new HashMap<Integer, Integer[]>();
            String n=scanner.next();




        }

    }
}
