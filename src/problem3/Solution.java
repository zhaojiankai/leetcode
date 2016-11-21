package problem3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.naming.CommunicationException;

public class Solution {
	int strLength = 0;
	Map<String, Integer> charTimes = new HashMap<String, Integer>();
	Map<String, ArrayList<Integer>> charIndexs = new HashMap<String, ArrayList<Integer>>();
	LinkedList<String> sortArray = new LinkedList<String>();

	int lengthOfLongestSubstring(String s) {
		strLength = s.length();
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			temp = s.substring(i, i + 1);
			if (charTimes.containsKey(temp)) {
				charTimes.put(temp, charTimes.get(temp) + 1);
			} else {
				charTimes.put(temp, 1);
			}
			if (charIndexs.containsKey(temp)) {
				ArrayList<Integer> t = charIndexs.get(temp);
				t.add(i);
				charIndexs.put(temp, t);
//				sortArray.add(temp);
			} else {
				ArrayList<Integer> t = new ArrayList<Integer>();
				t.add(i);
				charIndexs.put(temp, t);
				sortArray.add(temp);
			}
		}
		sortArray.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return charTimes.get(o1).compareTo(charTimes.get(o2));
			}

		});
		int length = sortArray.size();
		for (int i = length; i > 0; i--) {
			boolean isOK = getIsExist(0, strLength, 0, i,0);
			if(isOK){
				return i;
			}
		}
		return -11;
	}

	public boolean getIsExist(int start, int end, int beginIndex, int length,int notExistChar) {
		for (int j = beginIndex; j < sortArray.size(); j++) {
			List<Integer> indexs = charIndexs.get(sortArray.get(j));
			boolean isRepeat = false;
			boolean isExist = false;
			int lastExistIndex = 0;
			for (int m = 0; m <indexs.size(); m++) {
				int value = 0;
				
					value = indexs.get(m);
				
				if (value >= start && value < end) {
					if (isExist) {
						if(lastExistIndex == start){
							lastExistIndex = value;
//							continue;
						}
						isRepeat = true;
						boolean ok1 = false;
						boolean ok2 = false;
						if (lastExistIndex - start >= length) {
							 ok1 = getIsExist(start, lastExistIndex, j + 1, length,notExistChar);
							if(ok1){
								return true;
							}
						}
						if (end - lastExistIndex >=length) {
							 ok2 = getIsExist(lastExistIndex, end, j, length,notExistChar);
							if(ok2){
								return true;
							}
						}
						return false;
					} else {
						isExist = true;
						lastExistIndex = value;
//						if(value == start){
//							isExist = false;
//						}
						
					}
				}
			}
			if(!isExist){
				notExistChar ++;
				if(notExistChar > sortArray.size() - length){
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
	}

}
