import java.util.Scanner;

public class ArrayQueueDemo{
    public static void main(String[] args) {
        //create a queue
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // output an array
        while(loop){
            System.out.println("s(show): show the queue");
            System.out.println("e(exit): exit the queue");
            System.out.println("a(add):add the data into array");
            System.out.println("g(get):get the data from the array");
            System.out.println("h(head):view the head of the array");
            key = scanner.next().charAt(0);//receive a char
            switch (key) {

                case's':
                    queue.showQueue();
                    break;
                case'a':
                    System.out.println("enter a number");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case'g': // get the data

                    try {
                        int res = queue.getQueue();
                        System.out.printf("the data got out is %d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'h'://view the head of the queue

                    try {int res = queue.headQueue();
                        System.out.printf("the head of queue is %d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e'://exit
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
                    }


            }
        System.out.println("exit the programme");
    }

}

// use the array to simulate a queue - write a ArrayQueue class
class ArrayQueue {
    private int maxSize;
    private int rear;
    private int front;
    private int arr[];

    // create a constructor of the queue
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //check whether the queue is full
    public boolean isFull(){
        return rear == maxSize - 1;

    }

    //check whether the queue is empty
    public boolean isEmpty(){
        return rear == front;
    }

    //add data to the queue
    public void addQueue(int n){
        //check whether the queue is full
        if(isFull()){
            System.out.println("the queue is full, cannot add");
            return;
        }
        rear++; //move the data back
        arr[rear] = n;
    }
    //get the data in the queue
    public int getQueue(){

        if(isEmpty()){
            //throw the exception
            throw new RuntimeException("the queue is empty, cannot get the data");
        }
        front++;
        return arr[front];
    }
    // show all the data in a queue
    public void showQueue(){
        //array iteration
        if(isEmpty()){
            System.out.println("the queue is empty");
            return;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("empty queue");
        }
        return arr[front+1];
    }
}
