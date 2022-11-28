public class Longest_Incr_SubArray {

    // Giving a  no order array,
    // find it's longest sub-array in increase order


    // greedy algorithm

    public static int maxSub_arr(int[] arr){
        int max = 0;
        int start = 0;
        for(int i = 0; i < arr.length; i++){
            if(i == arr.length - 1){
                max = Math.max(max, i - start + 1);
                break;
            }
            if(arr[i + 1] < arr[i]){
                max = Math.max(max, i - start + 1);
                start = i + 1;
            }
        }
        return max;
    }



    // test
    public static void main(String[] args) {
        int[] arr = new int[]{9,8};
        System.out.println(maxSub_arr(arr));
    }
}
