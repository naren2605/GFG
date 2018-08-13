package gfg;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 */
public class ParenthesisChecker {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            String expression=scanner.next();
            if(isbalanced(expression)){
                System.out.println("balanced");
            }
            else {
                System.out.println("not balanced");
            }
        }
    }

    private static boolean isbalanced(String exp){
        char[] expChar=exp.toCharArray();
        Stack<Character> expStack=new Stack<>();
        for(int i=0;i<expChar.length;i++){
            boolean isRight=isRightBrace(expChar[i]);
            if(isRight&&expStack.empty()){
                return false;
            }
            else {
                if(!isRight){
                expStack.push(expChar[i]);
                }
                else if(expStack.peek().equals(getLeft(expChar[i]))){
                    expStack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return expStack.isEmpty();
    }

    private static char getLeft(char brace){
        if(brace=='}'){
            return '{';
        }
        else if(brace==']'){
            return '[';
        }
        else{
            return '(';
        }
    }

    private static boolean isRightBrace(char brace){
        if(brace=='}'||brace==']'||brace==')'){
            return true;
        }
        return false;
    }

}
