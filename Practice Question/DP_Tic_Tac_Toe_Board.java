public class DP_Tic_Tac_Toe_Board {
    // giving a string array of X and O
    // find is this Tic_Tac_Toe(TTT) board valid
    // ex: ["XOX"
    //      "OXO"     -->   valid board, return true
    //      "XOX"]


    // ex: ["XXX"
    //      "   "     -->   Not valid board, return false
    //      "XOX"]



    // there are only 3 cases
    // X win    -- >  #ofX - #ofO == 1  and 3 X is in lined
    // O win    -- >  #ofX - #ofO == 0  and 3 O is in lined
    // unfinished game ---> #ofX - #ofO == 1 or #ofX - #ofO == 0
    public static boolean isValid_Board(String[] arr){
        int x = 0, o = 0;
        for(String string: arr){
            for(int i = 0; i<string.length(); i++){
                if(string.charAt(i) == 'X'){
                    x++;
                }
                if(string.charAt(i) == 'O'){
                    o++;
                }
            }
        }
        if(isWinner(arr, "X") && x-o == 1){
            return true;
        }else if(isWinner(arr, "O") && !isWinner(arr, "X") && x-o == 0){
            return true;
        }else if(!isWinner(arr, "X") && !isWinner(arr, "O") && x-o == 1){
            return true;
        }else if(!isWinner(arr, "X") && !isWinner(arr, "O") && x-o == 0){
            return true;
        }
        return false;
    }
    private static boolean isWinner(String[] board, String flag){
        flag = flag + flag + flag;
        //String[][] board = new String[3][3];
        for(int i = 0; i < board.length; i++){
            // ---
            if(board[i].equals(flag)){
                return true;
            }

            // |
            if((board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i) + "").equals(flag)){
                return true;
            }
        }

        //  /
        if((board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2) + "").equals(flag)){
            return true;
        }
        if((board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0) + "").equals(flag)){
            return true;
        }

        return false;
    }


    // test
    public static void main(String[] args) {
        String[] board1 = {"XXX", "OOO", "   "}; // false
        String[] board2 = {"XX ", "OO ", "   "}; // true
        String[] board3 = {"XOX", "OOX", "XXO"}; // True
        String[] board4 = {"XO ", "XXX", "XXO"}; // false

        System.out.println(isValid_Board(board1));
        System.out.println(isValid_Board(board2));
        System.out.println(isValid_Board(board3));
        System.out.println(isValid_Board(board4));
    }
}
