package problem4;

public class Solution {

public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	int[] array = new int[nums1.length + nums2.length];
	for(int i = 0,j = 0;i+j<nums1.length+nums2.length;){
		if(i == nums1.length){
			array[i+j] = nums2[j];
			j++;
			continue;
		}
		if(j == nums2.length){
			array[i+j] = nums1[i];
			i++;
			continue;
		}
		if(nums1[i] <= nums2[j]){
			array[i+j] = nums1[i];
			i++;
		}else{
			array[i+j] = nums2[j];
			j++;
		}
	}
	if(array.length%2 == 0){
		return Double.valueOf(Integer.valueOf(array[array.length/2 - 1] + array[array.length/2]))/2;
	}else{
		return Double.valueOf(array[array.length/2]);
	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s1 = {1,2};
		int[] s2 = {3,4};
		System.out.println(new Solution().findMedianSortedArrays(s1, s2));
	}

}
