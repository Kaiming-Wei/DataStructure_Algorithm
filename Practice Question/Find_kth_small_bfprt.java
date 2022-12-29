public class Find_kth_small_bfprt {

    // giving an unsorted array
    // find kth small number in this array --> O(N)

    // ------------------------------------------------------------------------------

    // using partition
    public static int findKthSmall_1(int[] arr, int k){
        if(arr == null || arr.length < k){
            return Integer.MIN_VALUE;
        }
        return process1(arr, k - 1, 0, arr.length - 1);
    }

    // !!!!assume k is between L and R
    private static int process1(int[] arr, int k, int L, int R){
        // if L == R   =>    L == R == k
        if(L == R){
            return arr[k];
        }
        int[] range = partition(arr, L, R, arr[L]);
        if(k < range[0]){
            return process1(arr, k, L, range[0] - 1);
        }else if(k > range[1]){
            return process1(arr, k, range[1] + 1, R);
        }else{
            return arr[k];
        }
    }
    // same as quick sort
    private static int[] partition(int[] arr, int L, int R, int povit) {
        int less = L - 1;
        int more = R + 1;
        int i = L;
        while(i < more){
            if(arr[i] < povit){
                less++;
                swap(arr, i, less);
                i++;
            }else if(arr[i] > povit){
                more--;
                swap(arr, i, more);
            }else{
                i++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j]; // arr[i] ^ arr[j] ^ arr[j]
//        arr[i] = arr[i] ^ arr[j]; // arr[i] ^ arr[j] ^ arr[i]
    }





    // ---------------------------------------------------------------------------------------------------------
    // bfprt
    // select median Of median as povit
    // 1. 5 number as a group
    // 2. sort each group
    // 3. each median(3rd number) in each group   -->  form a new array
    // 4. find median of new array and set it as povit
    public static int findKthSmall_2(int[] arr, int k){
        return bfprt(arr, 0 , arr.length-1, k-1);
    }
    private static int bfprt(int[] arr, int L, int R, int k){
        if(L == R){
            return arr[k];
        }
        int povit = medianOfMedian(arr, L, R);
        int[] range = partition(arr, L, R, povit);
        if(k < range[0]){
            return bfprt(arr, L, range[0] - 1, k);
        }else if(k > range[1]){
            return bfprt(arr, range[1] + 1, R, k);
        }else{
            return arr[k];
        }
    }

    private static int medianOfMedian(int[] arr, int L, int R) {
        int N = R - L + 1;
        int offset = N % 5 == 0 ? 0 : 1;
        int[] marr = new int[N / 5 + offset];
        for(int team = 0; team < marr.length; team++){
            int teamleader = L + team * 5;
            int lastmate = Math.min(teamleader + 4, R);
            marr[team] = getMedian(arr, teamleader, lastmate);
        }

        return bfprt(marr, 0 , marr.length - 1, marr.length / 2);
    }

    private static int getMedian(int[] arr, int first, int last) {
        b(arr, first, last); // quick sort
        int median = first + ((last - first) / 2);
        return arr[median];
    }


    // ---------------------------------------------------------------------------------------------------------
    // quick sort
    public static void quick(int[] arr){
        b(arr, 0, arr.length-1);
    }
    private static void b(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        int[] range = partition(arr, L, R, arr[L]);
        b(arr, L, range[0] - 1);
        b(arr, range[1] + 1, R);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5,2,1,4,1,3};
//        quick(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(findKthSmall_1(arr, 6));
        System.out.println(findKthSmall_2(arr, 6));
    }
}
