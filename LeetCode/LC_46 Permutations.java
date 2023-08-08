class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        process(nums, res, 0);
        return res;
    }

    public void process(int[] nums, List<List<Integer>> res, int i){
        if(i == nums.length){
            List<Integer> list = new ArrayList<Integer>();
            copy(nums, list);
            res.add(list);
        }
        for(int j = i; j < nums.length; j++){
            swap(nums, i, j);
            process(nums, res, i+1);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j){
        if(i == j){
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public void copy(int[] nums, List<Integer> list){
        for(int a: nums){
            list.add(a);
        }
    }
}
