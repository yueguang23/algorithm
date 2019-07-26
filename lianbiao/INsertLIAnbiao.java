package lianbiao;

public class INsertLIAnbiao {
	
	static void DeleteLastNodeFromCLL(CLLNode headNode){
        CLLNode temp=headNode;
        CLLNode currentNode=headNode;
        if(headNode==null){
            System.out.println("链表为空");
            return;
        }
        while(currentNode.getNext()!=headNode){//没有办法达到效果，不能使指针后移。currentNode一直是那一个，next也没有变化？为什么书上和网上都要这么写？
          temp=currentNode;
          System.out.println(currentNode.getNext().getData());
          currentNode.setNext(currentNode.getNext());
          System.out.println("=="+currentNode.getNext().getData());
        }  //遍历循环链表，找到表尾结点及其前驱结点
        temp.setNext(headNode);
        currentNode=null;
        return;
}

	static  void InsertAtBeginInCLL(CLLNode headNode,CLLNode nodeToInsert){
        CLLNode currentNode=headNode;  //创建新结点
        System.out.println(currentNode.getData());
        System.out.println(currentNode.getNext().getData());
        System.out.println(currentNode.getNext()==headNode);
        currentNode.setNext(currentNode.getNext());
        System.out.println("=="+currentNode.getData());
        System.out.println("=="+currentNode.getNext().getData());
        
        while(currentNode.getNext()!=headNode){
        	//currentNode = currentNode.getNext();
          currentNode.setNext(currentNode.getNext());//currentNode仍然在原来的位置
          System.out.println("''"+currentNode.getNext().getData());
         
          }  //遍历循环链表直至表尾
        nodeToInsert.setNext(nodeToInsert);
        if(headNode==null)  //判断头结点是否为空
           headNode=nodeToInsert;
        else{  //设置新结点为表头结点
             nodeToInsert.setNext(headNode);
             currentNode.setNext(nodeToInsert);
             headNode=nodeToInsert;
        }
	}
	static int CircularListLength(CLLNode headNode){
		    int length=0;
		    CLLNode currentNode=headNode;
		    while(currentNode.getNext()!=null){
		         length++;
		         System.out.println(currentNode.getData());
		         currentNode=currentNode.getNext();
		         if(currentNode==headNode)
		               break;
		         }
		         return length;
		}
	 public static void main(String[] args) {
			CLLNode currentNode1 = new CLLNode(0);
			CLLNode currentNode2 = new CLLNode(1);
			currentNode1.setNext(currentNode2);
			currentNode2.setNext(currentNode1);
			System.out.println(currentNode1.getData());
			System.out.println(currentNode2.getData());
			System.out.println(currentNode2.getNext().getData());
//			for(int i = 2;i<=10;i++) {
//				CLLNode nodeToInsert = new CLLNode(i);
//				System.out.println("--"+nodeToInsert.getData());
//				InsertAtBeginInCLL(currentNode1,nodeToInsert);
//			}
			//System.out.println(CircularListLength(currentNode1));
			DeleteLastNodeFromCLL(currentNode1);
			//System.out.println(CircularListLength(currentNode1));
			System.out.println(currentNode1.getData());
			System.out.println(currentNode1.getNext().getData());
			
			
		}
}