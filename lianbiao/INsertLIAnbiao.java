package lianbiao;

public class INsertLIAnbiao {
	
	static void DeleteLastNodeFromCLL(CLLNode headNode){
        CLLNode temp=headNode;
        CLLNode currentNode=headNode;
        if(headNode==null){
            System.out.println("����Ϊ��");
            return;
        }
        while(currentNode.getNext()!=headNode){//û�а취�ﵽЧ��������ʹָ����ơ�currentNodeһֱ����һ����nextҲû�б仯��Ϊʲô���Ϻ����϶�Ҫ��ôд��
          temp=currentNode;
          System.out.println(currentNode.getNext().getData());
          currentNode.setNext(currentNode.getNext());
          System.out.println("=="+currentNode.getNext().getData());
        }  //����ѭ�������ҵ���β��㼰��ǰ�����
        temp.setNext(headNode);
        currentNode=null;
        return;
}

	static  void InsertAtBeginInCLL(CLLNode headNode,CLLNode nodeToInsert){
        CLLNode currentNode=headNode;  //�����½��
        System.out.println(currentNode.getData());
        System.out.println(currentNode.getNext().getData());
        System.out.println(currentNode.getNext()==headNode);
        currentNode.setNext(currentNode.getNext());
        System.out.println("=="+currentNode.getData());
        System.out.println("=="+currentNode.getNext().getData());
        
        while(currentNode.getNext()!=headNode){
        	//currentNode = currentNode.getNext();
          currentNode.setNext(currentNode.getNext());//currentNode��Ȼ��ԭ����λ��
          System.out.println("''"+currentNode.getNext().getData());
         
          }  //����ѭ������ֱ����β
        nodeToInsert.setNext(nodeToInsert);
        if(headNode==null)  //�ж�ͷ����Ƿ�Ϊ��
           headNode=nodeToInsert;
        else{  //�����½��Ϊ��ͷ���
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