class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }


class singleLl{

    Node head;
    Node tail;
    public void insertAtBegin(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public int lengthLl(){
        int len = 0;
        Node temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    public void inserAtIndex(int data, int pos){
        Node newNode = new Node(data);
        Node curr = head;
        Node prev = head;
        for(int i=0; i<pos-1; i++){
            prev = curr;
            curr = curr.next;
        }
        newNode.next = curr;
        prev.next = newNode;

    }
    public void deleteAtbegin(){
        if(head == null){
            return;
        }
        head = head.next;
    }
    public void deleteAtEnd(){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }
    public void deleteAtIndex(int pos){
        Node prev = head;
        Node cur = head;
        for(int i=1; i<pos; i++){
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        cur.next = null;
    }
    public int search(int data,int l){
        Node temp = head;
        int i;
        for(i=1; i<=l; i++){
            if(temp.data == data){
                break;
            }
            temp = temp.next;
        }
        return i;
    }
    public void printL(){
        Node temp = head;
        while(temp.next!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print(temp.data+"->null");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to singly linked List");
        singleLl list = new singleLl();
        list.insertAtBegin(1);
        list.insertAtBegin(2);
        list.insertAtBegin(3);
        list.insertAtEnd(4);
        list.inserAtIndex(5,2);
        list.insertAtEnd(6);
        list.printL();
        System.out.println();
        System.out.println("head: "+list.head.data);
        System.out.println("tail: "+list.tail.data);
        System.out.println("length of singleLl is : "+list.lengthLl());
        System.out.println("element found at: "+list.search(4,list.lengthLl()));
        list.deleteAtbegin();
        list.deleteAtEnd();
        list.deleteAtIndex(3);
        list.printL();
    }
}