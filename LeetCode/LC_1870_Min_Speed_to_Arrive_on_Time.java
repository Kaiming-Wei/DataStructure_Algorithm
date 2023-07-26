class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour <= dist.length - 1){
            return -1;
        }
        int L = 1, R = 0;
        // we can calculate that the answer is between 1 - R
        // the max speed is the largest distance or the speed that can make the last train arrives in 0.01 hour
        for(int d : dist){
            R = Math.max(R, d);
        }
        R = Math.max(R, dist[dist.length - 1]*100);
        int speed = 0;

        // binary search
        while(L <= R){
            int M = L + ((R - L)>>1);
            if(time(dist, M) <= hour){
                speed = M;
                R = M - 1;
            }else{
                L = M + 1;
            }
        }
        return speed;
    }

    public double time(int[] dist, int speed){
        double t = 0;
        for(int i = 0; i<dist.length-1; i++){
            t += dist[i]%speed == 0 ? dist[i]/speed : dist[i]/speed + 1;
        }
        return t + dist[dist.length-1]/(double)speed;
    }
}
