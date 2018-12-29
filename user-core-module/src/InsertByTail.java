import java.util.Scanner;

/**
 * 使用尾插法建立单链表
 * 
 * @author zhengzhentao
 *
 */



public class InsertByTail {


	// 尾插法建立一个单链表
	public static  Node tailCreatLinkedList(int[] num) {
		Node head = new Node();
		Node tail = new Node();
		head = tail;
		tail = head;
		head.data=num[0]; //初始化头结点
		for (int i = 1; i < num.length; i++) {
			Node p = new Node();
			p.data = num[i];
			tail.next = p; // 使新节点成为尾节点 （将表尾终端节点指向新节点）
			tail = p; // 修改当前指针指向尾节点（将当前新节点定义为表尾终端节点）
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		InsertByTail test = new InsertByTail();
//		Scanner scanner = new Scanner(System.in);
//		// 输入一串序列，并以“，”分开
//		String inputString = scanner.next();
//		String[] input = inputString.split(",");
//		int[] num = new int[input.length];
//		for (int i = 0; i < input.length; i++) {
//			num[i] = Integer.parseInt(input[i]);
//		}
		
		int [] num={1,2,3,4,5,6,7};
		Node head =tailCreatLinkedList(num);
		// 遍历打印输出链表
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
