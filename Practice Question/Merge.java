import java.util.Arrays;

public class Merge {

    // Giving 2 sorted integer arrays
    // arr1 has n elements, but n+m in length
    // arr2 has m elements
    // Merge arr2 into arr1, and in sorted order

    // 1.0
    // using System.arraycopy
    // then sort arr1
    public static int[] merge1(int[] arr1, int n, int[] arr2, int m){
        System.arraycopy(arr2, 0, arr1, n, m);
        Arrays.sort(arr1);

        return arr1;
    }


    // 2.0
    // Using merge sort
    // creating another array;
    public static int[] merge2(int[] arr1, int n, int[] arr2, int m){
        int[] merge = new int[n+m];
        int p1 = 0,
            p2 = 0,
            p3 = 0;

        while(p1 != n && p2 != m){
            if(arr1[p1] < arr2[p2]){
                merge[p3++] = arr1[p1++];
            }else{
                merge[p3++] = arr2[p2++];
            }
        }
        while(p1 != n){
            merge[p3++] = arr1[p1++];
        }
        while(p2 != m){
            merge[p3++] = arr2[p2++];
        }

        for(int i = 0; i < merge.length; i++){
            arr1[i] = merge[i];
        }

        return arr1;
    }


    // 3.0
    // compare the elements from largest
    // therefore, we don't have to create additional array to save the data
    public static int[] merge3(int[] arr1, int n, int[] arr2, int m){
        int p1 = n-1,
                p2 = m-1,
                p3 = n+m-1;

        while (p1 >= 0 && p2 >= 0){
            if(arr1[p1] >= arr2[p2]){
                arr1[p3--] = arr1[p1--];
            }else{
                arr1[p3--] = arr2[p2--];
            }
        }

        while(p1 >= 0){
            arr1[p3--] = arr1[p1--];
        }

        while(p2 >= 0){
            arr1[p3--] = arr2[p2--];
        }


        return arr1;
    }


    // test
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,5,7,9,0,0,0,0};
        int[] arr2 = new int[]{2,4,6,8};
        int n = arr1.length - arr2.length;
        int m = arr2.length;

        //1.0
        //System.out.println(Arrays.toString(merge1(arr1, n, arr2, m)));

        //2.0
        //System.out.println(Arrays.toString(merge2(arr1, n, arr2, m)));

        //3.0
        System.out.println(Arrays.toString(merge3(arr1, n, arr2, m)));

    }
}
