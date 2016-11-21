package problem1;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        int length = nums.length;
        for(int i = 0;i < length;i++){
            for(int j = i + 1;j < length;j++){
                if(nums[i] + nums[j] == target){
                    array[0] = i;
                    array[1] = j;
                }
            }
        }
        return array;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
