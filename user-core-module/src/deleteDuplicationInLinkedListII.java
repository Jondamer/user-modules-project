import java.util.HashSet;

/** 程序还有问题---多个相邻的节点的话就没办法删除其他的。
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点保留，
 * @author zhengzhentao
 *
 */

public class deleteDuplicationInLinkedListII {

	public deleteDuplicationInLinkedListII() {
		// TODO Auto-generated constructor stub
	}

	public static ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
			return pHead;
		}

		HashSet<Integer> hs = new HashSet<>();
		ListNode p = pHead;
		while (p != null) {
			 hs.add(p.val);
			 if (hs.contains(p.val)) { 
				deleteNode(p);
			}
			p = p.next;
		}
		return pHead;

	}

	// 删除某一个节点
	public static void deleteNode(ListNode node) {
		if (node == null)
			return;
		ListNode nextNode = node.next;
		if (nextNode == null)
			return;
		node.next = nextNode.next;
		node.val = nextNode.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode A = new ListNode(2);
		ListNode B = new ListNode(3);
		ListNode C = new ListNode(3);
		ListNode D = new ListNode(3);
		ListNode E = new ListNode(5);
		ListNode F = new ListNode(5);
		head.next = A;
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		E.next = F;
		ListNode tempNode = deleteDuplication(head);
		// 遍历
		while (tempNode != null) {
			System.out.print(tempNode.val + "--->");
			tempNode = tempNode.next;
		}

	}

}
