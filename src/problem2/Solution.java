/**
 *@author:zhao
 *@date:2016-11-21 21:51:49
 *@version:V1.0
 */
package problem2;

/**
 * @author zhao
 *
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ret = new ListNode(0);
		ListNode t = new ListNode(0);
		boolean isfirst = true;
		boolean isMoreTen = false;
		int val1 = 0;
		int val2 = 0;
		do {
			ListNode next = new ListNode(0);
			t.next = next;
			t = t.next;
			if (l1 == null) {
				val1 = 0;
			} else {
				val1 = l1.val;
				l1 = l1.next;
			}
			if (l2 == null) {
				val2 = 0;
			} else {
				val2 = l2.val;
				l2 = l2.next;
			}

			int val = val1 + val2;
			t.val = val;
			if (isMoreTen) {
				t.val = t.val + 1;
			}
			if (t.val >= 10) {
				isMoreTen = true;
			} else {
				isMoreTen = false;
			}
			t.val = t.val % 10;
			if (isfirst) {
				ret = t;
				isfirst = false;
			}
		} while (l1 != null || l2 != null || isMoreTen == true);
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
