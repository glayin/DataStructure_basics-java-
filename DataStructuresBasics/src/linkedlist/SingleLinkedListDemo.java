package linkedlist;


public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //test
        //create a node firstly
        Node hero1 = new Node(1,"Daniel","Dan");
        Node hero2 = new Node(2,"Johnny","John");
        Node hero3 = new Node(3,"Alexander","Alex");
        Node hero4 = new Node(4,"Susan","Sue");
        //create the linked list
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //add by order
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);

        singleLinkedList.list();
        }
    }

//define the SingleLinkedList to manage hero data
class SingleLinkedList {
    //initialize a head node with no data
    private Node head = new Node(0, " ", " ");

    //return the head node
    public Node getHead() {
        return head;
    }

    //add the node to a single linked list, when we do not consider the order
    //1.get the last node
    //2.this node next point to a new node
    public void add(Node namesNode
    ) {
        //because the head node cannot move, we need a auxiliary temp to iterate
        Node temp = head;
        //iterate the linkedlist to get the last
        while (true) {
            //find the last
            if (temp.next == null) {
                break;
            }
            //if cannot find, temp will go further
            temp = temp.next;
        }
        //when while exit, temp points to the last
        //the last next points to the new node
        temp.next = namesNode;
    }

    //when we add the hero, insert hero's ranking into specific position
    //(if the ranking is already existed, add failure, put the notice)
    public void addByOrder(Node namesNode) {
        //Because the head node cannot move, we can still use an auxiliary pointer to find the position to add
        //Because it is a single LinkedList, the temp us the node before the position, neither we cannot insert
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {//temp is already in the end of LinkedList
                break;
            }
            if (temp.next.no > namesNode.no) { //position found, insert to the temp
                break;
            } else if (temp.next.no == namesNode.no) {//the namesNode is already existed
                flag = true;
                break;
            }
            temp = temp.next; // move back, iterate the LinkedList

        }
        //check the flag value
        if (flag) {// cannot add, already existed
            System.out.printf("the hero order %d existed,cannot add\n", namesNode.no);
        } else {
            // insert into the linked list
            namesNode.next = temp.next;
            temp.next = namesNode;
        }
    }

    //modify the node data, change it by no, no cannot change
    //change the no of newNameNode
    public void update(Node newNameNode) {
        //check whether it is empty
        if (head.next == null) {
            System.out.println("the linked list is null");

        }
        // find the node needed to modify by no
        //define a temp
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {//temp is in the last position
                break;
            }

            if (temp.no == newNameNode.no) {
                flag = true;
                break;

            }
            temp = temp.next;
        }
        //check whether the node is found by flag
        if (flag) {
            temp.name = newNameNode.name;
            temp.nickname = newNameNode.nickname;
        } else {
            System.out.printf("not find no %d node,cannot change\n", newNameNode.no);
        }

    }

    //Delete the node
    //1.head node cannot change, we need a temp to find the node before the deleted one
    //2.when we compare, compare temp.next.no and the deleteone.no
    public void delete(int no) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }

            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("the node %d you wanna delete is not existed", no);
        }
    }

    //show the linked list(iteration)
    public void list() {
        //check whether the linked list is empty
        if (head.next == null) {
            System.out.println("the linked list is empty");
            return;
        }
        //the head node cannot change, we need a temp to iterate
        Node temp = head.next;
        while (temp != null) {

//            if(temp == null){
//                break;
//            }
            System.out.println(temp);
            temp = temp.next;

        }


    }
}

    //define HeroNode, every HeroNode is an object
    class Node {
        public int no;
        public String name;
        public String nickname;
        public Node next; // point to an another node

        // constructor
        public Node(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }


        //override the toString method


        @Override
        public String toString() {
            return "namesNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
        }

    }
