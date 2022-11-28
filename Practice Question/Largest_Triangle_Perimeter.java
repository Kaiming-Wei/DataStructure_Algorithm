import java.util.Arrays;

public class Largest_Triangle_Perimeter {

    // Giving an integer array
    // find 3 integer that can form the largest perimeter of a triangle


    public static int largestPerimeter(int[] size){
        Arrays.sort(size);
        for(int i = size.length - 1; i >= 2; i--){
            if(size[i-1] + size[i-2] > size[i]){
                return size[i] + size[i-1] + size[i-2];
            }
        }
        return 0;
    }

    // test
    public static void main(String[] args) {
        int[] size = new int[]{4,100,8,11};
        System.out.println(largestPerimeter(size));
    }
}
