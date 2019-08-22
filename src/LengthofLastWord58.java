public class LengthofLastWord58 {
    public static int lengthOfLastWord(String s) {
        //觉得这个程序写不好了，应该从最后面开始的

        //2019.08.02已经修改，已经最优
        int first_index=0;
        int last_index=0;
        boolean exist=false;
    for(int i=s.length();i>0;i--){
        if(s.charAt(i-1)!=32){
            if(!exist) {
                exist = true;
                first_index=i;
            }
        }
        if(s.charAt(i-1)==32&&exist){
            last_index=i;
//            exist=false;
           break;
        }
    }
//    if(exist){
//        return s.length()-first_index;
//    }else {
//        return last_index - first_index;
//    }

        return first_index-last_index;

    }

    // leetcode上面一条就搞定的公式，md实在是太强了。。。。。
//     return s.trim().length()-s.trim().lastIndexOf(" ")-1;

    public static void main(String[] args) {
        String s="    hfdhdf  ";
        System.out.println(lengthOfLastWord(s));

    }
}
