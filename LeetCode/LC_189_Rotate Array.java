class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        while(k > len){
            k = k - len;
        }
        if(k == len || k == 0 || len == 1){
            return;
        }
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len-1);
        reverse(nums, 0, len - 1);
    }

    public void reverse(int[] nums, int a, int b){
        while(a < b){
            swap(nums, a, b);
            a++;
            b--;
        }
    }

    public void swap(int[] nums, int a, int b){
        int tem = nums[a];
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
