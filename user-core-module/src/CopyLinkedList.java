/**
 * 定义一个方法实现复制单链表的功能
 * 
 * 思想： 先让指针p指向原始链表的头结点，声明一个复制链表的头结点为空，同时声明另外一个指针指向该复制链表的头结点；
 * 若是首次复制节点，则复制链表的头结点的next为空，并让指针q指向该头结点；
 * 否则，再次new一个节点，让指针q指向该节点，直到读取到初始链表的最后一个节点；
 * 
 * @author zhengzhentao
 *
 */

public class CopyLinkedList {

	public CopyLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public static Node CopyLinkedListF1(Node head) { // 方法一：
		Node p = head;
		Node list = null;
		Node q = list;
		while (p != null) {
			if (list == null) {
				list = p;
				q = list;
			} else {
				// Node n = p;
				q.next = p;
				q = q.next;
			}
			p = p.next;
		}
		return list;
	}

	public static Node CopyLinkedListF2(Node head) { // 方法二
		Node list = new Node();
		Node headcopy = list;
		Node p = head.next;
		while (p != null) {
			Node n = p;
			list.next = n;
			list = p;
			p = p.next;
		}
		return headcopy;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Node headA = new Node();
		Node A1 = new Node();
		Node A2 = new Node();
		Node A3 = new Node();
		// 单链表headA
		A1.data = 1;
		A2.data = 3;
		A3.data = 5;
		headA.next = A1;
		A1.next = A2;
		A2.next = A3;
		// 调用方法
		Node list = CopyLinkedListF1(headA);
		Node P = list;
		while (P != null) {
			System.out.print(P.data + "---->");
			P = P.next;
		}
		System.out.println();
		while(headA!=null){
			System.out.print(headA.data+"-");
			headA=headA.next;
		}

	}

}
