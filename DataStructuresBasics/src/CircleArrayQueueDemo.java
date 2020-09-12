
import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("test a circleArray");

        //create a CircleArray
        CircleArray queue = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // output a menu
        while (loop){
            System.out.println("s(show): show the queue");
            System.out.println("e(exit): exit the program");
            System.out.println("a(add): add data to the queue");
            System.out.println("g(get): get the data out of queue");
            System.out.println("h(head): view the head data of the queue");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("please enter a number");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("the head data of queue is %d\n", res);
                    } catch (Exception e) {
                        // TODO:handle exception
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'g':

                    try {
                        int res = queue.getQueue();
                        System.out.printf("the data got out is %d\n",res);
                    } catch (Exception e) {
                        //  TODO:handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("program exit");
    }
}

class CircleArray{
    private int maxSize; // indicate the maxsize of the array
    //change the front variable meaning: front points to the first element, that is to say arr[front] is the first element
    //front initialization = 0
    private int front;
    //change the rear variable meaning: rear points to the the one position behind last element for leave
    //front initialization = 0
    private int rear;
    private int[] arr; // this array is used to store and simulate the array

    public CircleArray(int arrMaxsize){
        maxSize = arrMaxsize;
        arr = new int[maxSize];
    }

    //check whether the queue is full
    public boolean isFull(){
        return (rear+1)%maxSize == front;

    }

    //check whether the queue is empty
    public boolean isEmpty(){
        return rear == front;
    }

    //add data to the queue
    public void addQueue(int n){
        //judge whether the queue is full
        if(isFull()){
            System.out.println("the queue is full,cannot add");
            return;
        }

        //add the data
        arr[rear] = n;
        //put the data back, must do the modulo operation
        rear = (rear + 1)%maxSize;
    }

    // get the data and move it out
    public int getQueue(){
        //check whether the array is empty
        if(isEmpty()){
            //throw exception
            throw new RuntimeException("the queue is full, cannot get");
        }
        //notes: front points to the first element
        //1.store the value of front in a temporary variable
        //2.move front back and modulo
        //3.return the temporary variable
        int value = arr[front];
        front = (front + 1)%maxSize;
        return value;
    }

    //show all data in the queue
    public void showQueue(){
        //iteration
        if(isEmpty()){
            System.out.println("empty queue, no data");
            return;
        }
        //hints: iteration starts from front, iterate how many elements
        for(int i = front; i < front + (rear + maxSize - front)%maxSize ; i++){
            System.out.printf("arr[%d]=%d\n",i % maxSize, arr[ i% maxSize]);
        }
    }

    //show the head of queue
    public int headQueue(){
        //check
        if(isEmpty()){
            throw new RuntimeException("empty queue, no data");
        }
        return arr[front];
    }
}