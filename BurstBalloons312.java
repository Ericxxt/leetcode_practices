public class BurstBalloons312 {
    //试试使用dp来解决这个问题
    public int maxCoins(int[] nums) {
        int[] array=new int[nums.length+2];
        int index=1;
        for(int num:nums){
            array[index++]=num;
        }
        array[0]=array[index]=1;
        int[][] dp=new int[index][index+1];
        //index=nums.length+1
        for(int k=2;k<index+1;k++){
            for(int left=0;left<=index-k;left++) {
                int right=left+k;
                for (int i = left + 1; i <right; i++) {
                    //可以发现，dp[left][i]和dp[i][right]相对于dp[left][right] 长度较小，然后在之前都已经被求值过
                    dp[left][right]=Math.max(dp[left][right],array[i]*array[left]*array[right]+dp[left][i]+dp[i][right]);
                }
            }
        }
        return dp[0][index];
    }
    //下面加入memorization算法
    //2020/03/20
    //Runtime: 8 ms, faster than 56.47% of Java online submissions for Burst Balloons.
    //Memory Usage: 37.4 MB, less than 15.79% of Java online submissions for Burst Balloons.
//    public int maxCoins(int[] nums) {
//        int[] add_two_array=new int[nums.length+2];
//        int i=1;
//        //将左右两端看不见的1值加上
//        for(int num:nums){
//            add_two_array[i++]=num;
//        }
//        add_two_array[0]=add_two_array[i]=1;
//        //left取i就可以不会超过i
////        int[][] memorization=new int[i+1][i+1];
//        int[][] memorization=new int[i][i+1];
//        return burst_ballon(add_two_array,memorization,0,i);
//    }
//    public int burst_ballon(int[] array,int[][] memorization,int left,int right){
//        if(left+1>=right) return 0;
//        if(memorization[left][right]>0)return memorization[left][right];
//        int max_value=0;
//        for(int i=left+1;i<right;i++){
//            //最大值=上次的最大值和这次的气球爆炸值加上左右两侧的气球爆炸值
//            max_value=Math.max(max_value,array[i]*array[left]*array[right
//                    ]+burst_ballon(array,memorization,left,i)+burst_ballon(array,memorization,i,right));
//        }
//        memorization[left][right]=max_value;
//        return memorization[left][right];
//    }
    //下面这种方法可行，很简便，但是会time exceeded
//    public int maxCoins(int[] nums) {
//        int[] add_two_array=new int[nums.length+2];
//        int i=1;
//        //将左右两端看不见的1值加上
//        for(int num:nums){
//            add_two_array[i++]=num;
//        }
//        add_two_array[0]=add_two_array[i]=1;
//        return burst_ballon(add_two_array,0,i);
//    }
//    public int burst_ballon(int[] array,int left,int right){
//        if(left+1>=right) return 0;
//        int max_value=0;
//        for(int i=left+1;i<right;i++){
//            //最大值=上次的最大值和这次的气球爆炸值加上左右两侧的气球爆炸值
//            max_value=Math.max(max_value,array[i]*array[left]*array[right
//                    ]+burst_ballon(array,left,i)+burst_ballon(array,i,right));
//        }
//        return max_value;
//    }

}
