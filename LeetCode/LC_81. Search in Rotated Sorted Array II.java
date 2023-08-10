class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len-1;
        int m = 0, small = -1;
        while(l < r && nums[l] == nums[l+1]){
            l++;
        }

        while(r > l && nums[r] == nums[r-1]){
            r--;
        }
        while(l <= r){
            m = l + ((r - l) / 2);
            if(nums[m] < nums[0]){
                small = m;
                r = m - 1;
            }else{
                if(nums[m] == nums[0] && small == -1){
                    small = m;
                }
                l = m + 1;
            }
        }

        if(small != -1){
            if(target <= nums[len-1]){
                l = small;
                r = len - 1;
            }else{
                l = 0;
                r = small - 1;
            }
        }else{
            l = 0;
            r = len - 1;
        }

        while(l <= r){
             m = l + ((r - l) / 2);
             if(nums[m] == target){
                 return true;
             }
             if(nums[m] < target){
                 l = m + 1;
             }else{
                 r = m - 1;
             }
        }
        
    
        return false;
    }

}
