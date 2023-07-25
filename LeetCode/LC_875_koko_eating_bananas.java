class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // we can calculate the 
        // worst case : max_time = max bananas in pile
        // best case : min time = 1
        // using binary search
        int L = 1, R = 0;
        int speed = 1;
        for(int pile : piles){
            R = Math.max(pile, R);
        }
        while(L <= R){
            int mid = L + ((R - L)/2);
            int finish = time(piles, mid);
            if(finish <= h && finish > 0){
                speed = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return speed;
    }

    public int time(int[] piles, int speed){
        int time = 0;
        for(int pile : piles){
            time += pile % speed == 0 ? pile/speed : pile/speed + 1;
        }
        return time;
    }
}
