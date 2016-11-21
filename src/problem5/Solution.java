package problem5;

public class Solution {

public String longestPalindrome(String s) {
	int l = s.length();
	for(int j = l;j >= 1;j--){
		for(int k = 0;k <= l-j;k++){
			boolean ok = true;
			for(int m = k;m<j/2+k;m++){
				int t = k+j-1-m+k;
				if(s.charAt(m) != s.charAt(t)){
					ok = false;
					break;
				}
			}
			if(ok){
				return s.substring(k, k+j);
			}
		}
	}
	return s;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(new Solution().longestPalindrome("babad"));
	}

}
