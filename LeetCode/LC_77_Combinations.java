class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int[] nums = new int[n + 1];
        for(int i = 0; i <= n; i++){
            nums[i] = i;
        }
        List<Integer> tem = new ArrayList<Integer>();
        process(nums, k, 1, tem, list);

        return list;
    }

    public void process(int[] nums, int k, int i, List<Integer> l, List<List<Integer>> list){
        if(l.size() == k){
            List<Integer> tem = new ArrayList<Integer>();
            for(Integer a : l){
                tem.add(a);
            }
            list.add(tem);
            return;
        }
        if(i == nums.length){
            return;
        }
        l.add(nums[i]);
        process(nums, k, i+1, l, list);
        l.remove(l.size()-1);
        process(nums, k, i+1, l, list);
    }
}
