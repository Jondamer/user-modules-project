/**
 * 数组生成一个双向链表
 * 
 * @author zhengzhentao
 *
 */
class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}

}

public class DoubleLinked {

	public DoubleLinked() {
		// TODO Auto-generated constructor stub
	}

	public static TreeNode getDoubleLinked(int[] num) {

		TreeNode head = new TreeNode(0);
		TreeNode tail = new TreeNode(0);
		tail = head;
		head.val=num[0]; //初始化头结点
		for (int i = 1; i < num.length; i++) { // 建立右指针
			TreeNode p = new TreeNode(0);
			p.val = num[i];
			tail.right = p;
			tail = p;
		}
		return head;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 1, 2, 3, 4, 5, 6 };
        TreeNode head= getDoubleLinked(num);
        while(head!=null){
        	System.out.println(head.val);
        	head=head.right;
        }
	}

}
