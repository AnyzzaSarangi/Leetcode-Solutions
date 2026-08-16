class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,res);
        return res;
    }
    private static void backtrack(int[] nums,int idx,List<List<Integer>> res){
        if(idx == nums.length){
            List<Integer> permutation = new ArrayList<>();
            for(int num: nums){
                permutation.add(num);
            }
            res.add(permutation);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,idx,i);
            backtrack(nums,idx+1,res);
            swap(nums,idx,i);
        }
    }
    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}