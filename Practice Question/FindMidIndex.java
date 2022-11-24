public class FindMidIndex {

    // Giving an integer array
    // find an index that sum of left = sum of right



    // solution
    // calculate sum of entire array
    // for each index, find (right - value == left)
    // O(N^2)
    public static int midIndex(int[] arr){
        int left = 0, right = 0;
        for(int x: arr){
            right += x;
        }
        for(int i = 0; i < arr.length; i++){
            right -= arr[i];
            if(left == right){
                return i;
            }
            left += arr[i];
        }
        return -1;
    }


    // test
    public static void main(String[] args) {
        int[] arr = new int[]{1,-1,-2,-3,0,3,2,1};
        System.out.println(midIndex(arr));
    }
}
