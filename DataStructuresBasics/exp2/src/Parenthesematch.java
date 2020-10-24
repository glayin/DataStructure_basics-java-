import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Parenthesematch {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.next();
    String [] arr = new String[a.length()];

        for(int i= 0; i < arr.length; i++){
            arr[i] = a.substring(i,(i+1));
        }
        System.out.println(Arrays.toString(arr));
        Stack<String> m = new Stack<String>();

        for(int i = 0; i < arr.length;i++)
        {if(arr[i].equals("(")||arr[i].equals("[")||arr[i].equals("{"))
            m.push(arr[i]);
            else if (arr[i].equals(")")||arr[i].equals("]")||arr[i].equals("}")) {
                if (m.empty()){
                    m.push(arr[i]);
                    break;}
                else{ Object c = m.peek();
                if (c.equals("(")  || c.equals("[")  || c.equals("{"))
                    m.pop(); }
            }

        }
        if(m.empty())
            System.out.println("yes");
        else System.out.println("no");
    }
}

