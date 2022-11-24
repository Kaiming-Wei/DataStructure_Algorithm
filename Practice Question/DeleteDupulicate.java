public class DeleteDupulicate {

    // Giving a sorted array
    // Remove the duplicate elements without creating additional space
    // return the length of new array

    public static int removeDuplicates(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        int element = 0,
                same = 1;
        while (same < arr.length){
            // if the same, first pointer don't move, just move the second pointer
            if(arr[element] == arr[same]){
                same++;
            }else{
                // copy the different element into arr[element+1], move both pointer
                arr[++element] = arr[same++];
            }
        }
        // return the length
        return element + 1;
    }

    // test
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,3,4,4,5,5,5,5,5};
        System.out.println(removeDuplicates(arr));
    }

}
