import java.util.ArrayList;

/**
 * 输入一个链表，反转链表后，输出新链表的表头
 *
 * @author zhengzhentao
 */


public class ReverseList {

    // 定义一个函数，达到翻转链表的功能
    public static Node ReverseList(Node headA) {
//		头插法重新建立链表
        if (headA == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Node head2 = new Node();
        Node temp = headA.next;
        while (temp != null) {
            Node p = new Node();
            p.data = temp.data;
            p.next = head2.next;
            head2.next = p;    // 对应的是第二种方法翻转链表
            list.add(temp.data);
            temp = temp.next;
        }
        System.out.println("list1中的值是：");
        for (Integer integer : list) {
            System.out.println(integer);
        }
        Node head = new Node();
        for (int i = 0; i < list.size(); i++) {
            Node p = new Node();
            p.data = list.get(i);
            p.next = head.next;
            head.next = p;
        }
//		return head;   对应的是第一种方法达到翻转链表的效果
        return head2;   //对应的是第二种方法达到翻转链表的效果
    }

    public static void main(String[] args) {
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
        Node newHead = ReverseList(headA);
        System.out.println("翻转之后的链表:");
        Node temp = newHead.next;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

}
