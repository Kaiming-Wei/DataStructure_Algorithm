class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int[] len = new int[nums.length];      // the max lenth of subarray at the each index
        int[] count = new int[nums.length];     // how many max length of subarray at the each index
        Arrays.fill(len,1);
        Arrays.fill(count,1);

        for(int i=0; i<=nums.length-1; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    // increasing subarray
                    if(len[i] < len[j]+1){
                        // find a longer subarray
                        len[i] = len[j]+1;
                        count[i] = count[j];
                    }else if(len[i] == len[j]+1){
                        // if they are the same length, that means we find another group of arrays 
                        // that ending with nums[j], and it can add nums[i] at the end
                        count[i] = count[i]+count[j]; 
                    }
                }
            }
        }

        int max = -1;
        int ans = 0;
        for(int i = 0; i<len.length; i++){
            if(len[i] > max){
                max = len[i];
                ans = count[i];
            }else if(len[i] == max){
                ans += count[i];
            }
        }
        return ans;
    }
}
