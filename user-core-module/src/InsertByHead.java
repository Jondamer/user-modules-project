import java.util.Scanner;


/**
 * 使用头插法创建单链表
 * @author zhengzhentao
 *
 */


public class InsertByHead {

	public static  Node insertByHead(int[] num){
		Node head=new Node();
		for(int i=0;i<num.length;i++){
			Node p =new Node();
			p.data=num[i];
			p.next =head.next;
			head.next=p;
		}				
		return head;		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		InsertByHead test = new InsertByHead();
//		Scanner scanner = new Scanner(System.in);
//		// 输入一串序列，并以“，”分开
//		String inputString = scanner.next();
//		String[] input = inputString.split(",");
//		int[] num = new int[input.length];
//		for (int i = 0; i < input.length; i++) {
//			num[i] = Integer.parseInt(input[i]);
//		}
		
		int [] num ={1,2,3,4,5,6,7};
	    Node head =insertByHead(num);
//	    遍历打印输出链表
	    Node temp =head.next;
	    while(temp!=null){
	    	System.out.println(temp.data);
	    	temp=temp.next;
	    }
	}

}
