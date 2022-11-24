package chapter03_Sort;

public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length-1 );
    }
    public static void process(int[] arr, int L, int R){
        if(L == R){
            return;
        }else{
            int mid = L+((R-L)>>1);
            process(arr, L, mid);
            process(arr, mid+1, R);
            merge(arr, L, R, mid);
        }

    }
    public static void merge(int[] arr, int L, int R, int M){
        int[] help = new int[R-L+1];
        int i = 0;
        int left = L;
        int right = M+1;
        while (left <= M && right <= R){
            if (arr[left] <= arr[right]) {
                help[i++] = arr[left++];
            } else {
                help[i++] = arr[right++];
            }
        }
        while(left <= M){
            help[i++] = arr[left++];
        }
        while (right <= R){
            help[i++] = arr[right++];
        }

        for(int k = 0; k<=help.length-1;k++){
            arr[L+k] = help[k];
        }
    }


    // find small sum
    public static int mergeSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        return process2(arr, 0, arr.length-1 );
    }
    public static int process2(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
            int mid = L + ((R - L) >> 1);
            return
                process2(arr, L, mid)
                +
                process2(arr, mid + 1, R)
                +
                merge2(arr, L, R, mid);
    }
    public static int merge2(int[] arr, int L, int R, int M){
        int[] help = new int[R-L+1];
        int i = 0;
        int left = L;
        int right = M+1;
        int sum = 0;
        while (left <= M && right <= R){
            sum += arr[left] < arr[right] ? (R - right +1)*arr[left] : 0;
            help[i++] = arr[left] < arr [right] ? arr[left++] : arr[right++];
        }
        while(left <= M){
            help[i++] = arr[left++];
        }
        while (right <= R){
            help[i++] = arr[right++];
        }

        for(i = 0; i<=help.length-1;i++){
            arr[L+i] = help[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,1,1,3,2};
        mergeSort(arr);
        for(int num: arr){
            System.out.print(num+"\t");
        }
        System.out.println();


        //  merge可以用来求一个数组的左边或者右边所有大于当前数；
        // 给一个数组，所有他左边比他小的数总和为 数总和，求这个数组中所有 数总和 的合
        System.out.println(mergeSort2(arr));

    }
}
