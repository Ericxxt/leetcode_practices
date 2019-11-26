public class InterleavingString97 {
    //有两个字符串，所以感觉每当遇到相同字符有两个选择，想用recursion试试
    //写的时候刚开始用了substring，但是substring会导致time limit，所以改成使用很多的index，速度比较慢
    //Runtime: 866 ms, faster than 6.61% of Java online submissions for Interleaving String.
    //Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Interleaving String.


    //  ********recursion method************
//    static boolean tf=true;
//    public static boolean isInterleave(String s1, String s2, String s3) {
//        if(s1.length()+s2.length()!=s3.length()){
//            return false;
//        }
//        return !recursion_str(s1,s2,s3,0,0,0);
//    }
//    public static boolean recursion_str(String s1,String s2,String s3,int index_1,int index_2,int index){
//        if(tf){
//            if(index==s3.length()){
//                tf=false;
//                return tf;
//            }
//            if(index_1<s1.length()&&s3.charAt(index)==s1.charAt(index_1)){
//                    recursion_str(s1, s2, s3,index_1+1,index_2,  index + 1);
//            }
//            if(index_2<s2.length()&&s3.charAt(index)==s2.charAt(index_2)){
//                    recursion_str(s1,s2,s3,index_1,index_2+1,index+1);
//            }
//        }
//        return tf;
//    }
//  ********recursion method************

    //下面想用DP 方法
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        int[][] dp=new int[s1.length()]
    }
    public static void main(String[] args) {
        String s1="aabcc";
        String s2="dbbca";
        String s3="aadbbcbcac";
        System.out.println(isInterleave(s1,s2,s3));

    }
}
