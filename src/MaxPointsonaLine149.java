import java.math.BigDecimal;
import java.util.HashMap;

public class MaxPointsonaLine149 {
    //leetcode不能使用BigDecimal
    //2019。08。16
    //这个算法学到的最有意义的是gcd，最大公因数
    public static int maxPoints(int[][] points) {
        //全局最优个数
        int ans=0;
        //局部最优个数
        int count=0;
        //重复点个数
        int duplicated=0;
        if(points.length<3){
            return points.length;
        }
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<points.length-1;i++){
            map.clear();
            duplicated=0;
            count=1;
            for(int j=i+1;j<points.length;j++){
                if(points[i][0]==points[j][0]&&points[i][1]==points[j][1]){
                    duplicated++;
                }else{
                    map.put(slope(points[i],points[j]),map.getOrDefault(slope(points[i],points[j]),1)+1);
                    count=Math.max(count,map.get(slope(points[i],points[j])));
                }
            }
            ans=Math.max(ans,count+duplicated);
        }
        return ans;
    }
    public static String slope(int[] p1, int[] p2){
        int after_p1=p2[1]-p1[1];
        int after_p2=p2[0]-p1[0];
        if(after_p2==0){
            return "0";
        }
        int gcd=generateGcd(after_p1,after_p2);
        after_p1/=gcd;
        after_p2/=gcd;
        return after_p1+"/"+after_p2;
//        System.out.println("slope:"+1.0*(p2[1]-p1[1])/(p2[0]-p1[0])+0.0);
        //即使使用double当分母分子数很大很接近时数字还是一样大的，改用String

    }
    private static int generateGcd(int a, int b) { // Euclid's Greatest Common Divisor (GCD) Algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        int[][] points=new int[][]{
                {1,1},{2,2},{3,3}};
        System.out.println(maxPoints(points));
        String str="gejfqejfeq";
        str.hashCode();
    }
}
