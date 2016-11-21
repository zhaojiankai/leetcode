/**
 *@author:zhao
 *@date:2016-11-21 21:55:38
 *@version:V1.0
 */
package problem443;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhao
 *
 */
public class Solution {

	final String[] gene = { "A", "G", "C", "T" };
	Boolean isEnd = false;
	Map<String, Integer> isExist = new HashMap<String, Integer>();

	public int minMutation(String start, String end, String[] bank) {
		isExist.put(start, 1);
		int length = 0;
		int min = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				String next = start.substring(0, i) + gene[j] + start.substring(i + 1);
				if (isExist.containsKey(next)) {
					continue;
				} else {
					isExist.put(next, 1);
				}
				for (int k = 0; k < bank.length; k++) {
					if (bank[k].equals(next)) {
						if (next.equals(end)) {
							isEnd = true;
							return 1;
						} else {
							length++;
							length = length + minMutation(next, end, bank);
						}
						break;
					}
				}
				if (min == 0 || length < min) {
					min = length;
				}
			}
		}
		if (isEnd) {
			return min;
		} else {
			return -1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
