package problem3;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

	int lengthOfLongestSubstring(String s) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int strLength = s.length();
		int temp = 0;
		for (int i = 0; i < s.length(); i++) {
			temp = s.charAt(i);
			if (map.containsKey(temp)) {
			} else {
				map.put(temp,1);
			}
		}
		int length = map.size();
		for(int len = length;len >0;len--){
			for(int i = 0;i< strLength - len + 1;i++){
				String t = s.substring(i, i + len);
				boolean b1 = true;
				map.clear();
				for (int i1 = 0; i1 < t.length(); i1++) {
					temp = t.charAt(i1);
					if (map.containsKey(temp)) {
						b1 = false;
						break;
					} else {
						map.put(temp,1);
					}
				}
				if(b1){
					return len;
				}
			}
		}
		return 0;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date t = new Date();
		System.out.println(new Solution2().lengthOfLongestSubstring("zlddfyfdahlwonqjwzdlstfogtrorgnqrqvyqacrkppacflyeolwhrmnmgddmsvdirbbtfufvjhzo"));
		Date t2 = new Date();
		System.out.println(t2.getTime()-t.getTime());
	}

}
