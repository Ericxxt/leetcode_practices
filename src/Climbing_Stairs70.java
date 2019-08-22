public class Climbing_Stairs70 {

    //斐波那契数列，个人觉得很难想到
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int start_num=1;
        int sec_num=1;
        while(--n>0){
            sec_num+=start_num;
            start_num=sec_num-start_num;
        }
        return sec_num;
    }
}
