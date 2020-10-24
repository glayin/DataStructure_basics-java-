import java.util.Scanner;

public class Numerchange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int  q=-1,r;
        MyStack m1 = new MyStack(10);

        while(q != 0){

            q = N /2;
            r = N %2;
            N = q;

            m1.push(r);
        }
        while (!m1.isEmpty()){

            System.out.print(m1.pop());
        }
    }

}

 class MyStack{
    private int maxSize;
    private int[] stackArray;
    private int top;
    public  MyStack(int s) {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }
    public  void push(int j) {
        stackArray[++top] = j;
    }
    public long pop() {
        return stackArray[top--];
    }
    public long peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}