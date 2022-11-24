package chapter03_Sort;

public class QuickSort {
    private static void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
    public static void Partition(int[] arr, int L, int R){
        int less = L-1;
        int more = R;
        int i = 0;
        while (i<more){
            if(arr[i] < arr[R]){
                less++;
                swap(arr, i, less);
                i++;
            }else if(arr[i] == arr[R]){
                i++;
            }else{
                swap(arr,i, more-1);
                more--;
            }
        }
        swap(arr, R, more);

    }
    public static int[] Partition2(int[] arr, int L, int R){
        if(arr == null | L>R){
            return new int[]{-1, -1};
        }
        if(L == R){
            return new int[]{L, R};
        }
        int less = L-1;
        int more = R;
        int i = L;
        while (i<more){
            if(arr[i] < arr[R]){
                less++;
                swap(arr, i, less);
                i++;
            }else if(arr[i] == arr[R]){
                i++;
            }else{
                swap(arr,i, more-1);
                more--;
            }
        }
        swap(arr, R, more);
        more ++ ;
        return new int[]{less+1, more-1};
    }
    public static void process(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        int[] indexs = Partition2(arr, L, R);
        process(arr, L, indexs[0]-1);
        process(arr, indexs[1]+1, R);

    }
    public static void quickSort(int[] arr, int L, int R){
        if(arr.length<2 || arr ==null){
            return;
        }
        process(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,2,0};
        //Partition(arr, 0,arr.length-1);
        //quickSort(arr, 0 ,arr.length-1);
        for(int num: arr){
            System.out.print(num+"\t");
        }
        System.out.println();
    }
}
