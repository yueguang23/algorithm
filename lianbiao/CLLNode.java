package lianbiao;
public class CLLNode{
    private int data;
    private CLLNode next;
    private CLLNode prev;
    public CLLNode(int data){
        this.data = data;
    }
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }
    public void setNext(CLLNode next){
        this.next = next;
    }
    public CLLNode getNext(){
        return this.next;
    }
    public void setPrev(CLLNode prev){
        this.prev = prev;
    }
    public CLLNode getPrev(){
        return this.prev;
    }
    

}
