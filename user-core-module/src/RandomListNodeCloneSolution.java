/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，
 * 输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * @author zhengzhentao
 *
 */

class RandomListNode {
	int value;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.value = label;
	}
}

public class RandomListNodeCloneSolution {



	public RandomListNode Clone(RandomListNode pHead) {
		return pHead;

	}

	// 第一步：复制原始链表的任意节点N并创建新节点N',再把N'链接到N的后面
	public static void cloneNodes(RandomListNode pHead) {

		RandomListNode P = pHead;
		while (P != null) {
			RandomListNode pCloned = new RandomListNode(0);
			pCloned.value = P.value;
			pCloned.next = P.next;
			pCloned.random = null;

			P.next = pCloned;
			P = pCloned.next;
		}

	}
	// 第二步：如果原始链表上的节点N的random指针指向S,则它对应的复制节点N'的random指向S的复制节点S'

	public static void connectRandomNodes(RandomListNode pHead) {
		RandomListNode PNode = pHead;
		while (PNode != null) {
			RandomListNode pCloned = PNode.next;
			if (PNode.random != null) {
				pCloned.random = PNode.random.next;
			}
			PNode = pCloned.next;
		}

	}

	// 第三步：把第二步得到的链表拆分成两个链表，奇数位置上的节点组成原始的链表，偶数位置上的节点组成复制出来的链表
	public static RandomListNode reconnectNodes(RandomListNode pHead) {

		RandomListNode PNode = pHead;
		RandomListNode pClonedHead = null;
		RandomListNode pClonedNode = null;
		if (PNode != null) {
			pClonedHead = pClonedNode = PNode.next;
			PNode.next = pClonedNode.next;
			PNode = PNode.next;
		}
		while (PNode != null) {
			pClonedNode.next = PNode.next;
			pClonedNode = pClonedNode.next;
			PNode.next = pClonedNode.next;
			PNode = PNode.next;
		}
		return pClonedHead;

	}

	// 把上面三步结合起来，就是复制链表的完整过程
	public static RandomListNode clone(RandomListNode pHead) {
		cloneNodes(pHead);
		connectRandomNodes(pHead);
		return reconnectNodes(pHead);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode head = new RandomListNode(0);
		head.value = 0;

		RandomListNode node1 = new RandomListNode(0);
		node1.value = 1;

		RandomListNode node2 = new RandomListNode(0);
		node2.value = 2;

		RandomListNode node3 = new RandomListNode(0);
		node3.value = 3;

		RandomListNode node4 = new RandomListNode(0);
		node4.value = 4;

		RandomListNode node5 = new RandomListNode(0);
		node5.value = 5;

		head.next = node1;

		node1.next = node2;
		node1.random = node4;

		node2.next = node3;
		node2.random = node5;

		node3.next = node4;

		node4.next = node5;
		node4.random = node2;

		// 测试方法一
		// cloneNodes(head);
		// while (head != null) {
		// System.out.println(head.value);
		// head = head.next;
		// }
		// System.out.println("====此时的head是："+head.next.value);

		// 测试方法二
		// connectRandomNodes(head);
		// while (head != null) {
		// if(head.random!=null){
		// System.out.println("此时的head是："+head.value+"对应的random指针指向的节点是："+head.random.value);
		// }
		// head = head.next;
		// }

		RandomListNode cloneNode = clone(head);
		while (cloneNode != null) {
			System.out.print(cloneNode.value + "--->");
			cloneNode = cloneNode.next;
		}

	}

}
