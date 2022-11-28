public class Lemonade_Changes {

    // customers are in a line to buy lemonade, (giving an array)
    // each lemonade is 5 dollars
    // customer will only give you 5, 10, 20 dollar bill
    // find if you can have changes for all customers

    public static boolean changes(int[] customer){
        int five = 0, ten = 0;
        for(int bill: customer){
            if(bill == 5){
                five++;
            }
            if(bill == 10){
                if(five < 1){
                    return false;
                }
                five--;
                ten++;
            }

            if(bill == 20){
                if(ten > 0 && five > 0){
                    five--;
                    ten--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }


    // test
    public static void main(String[] args) {
        int[] customer = new int[]{5,5,10,10};
        System.out.println(changes(customer));
    }
}
