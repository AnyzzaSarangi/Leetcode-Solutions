class Solution {
    public int maxSubArray(int[] nums) {
        int maxS = nums[0];
        int curS = nums[0];
        for(int i=1;i<nums.length;i++){
            curS = Math.max(nums[i],curS+nums[i]);
            maxS = Math.max(maxS,curS);
        }
        return maxS;  
    }
}