import java.util.*;

public class GenerateParentheses22 {

    //通宵想了的方法还是没有成功，原因是始终无法解决n=4存在的"(())(())"问题 "())(()"没办法通过测试
//    public static List<String> generateParenthesis(int n) {
//        if(n==1){
//            return new ArrayList<String>(Arrays.asList("()"));
//        }
//
//        List<String> lists=new ArrayList<>();
//
//
//            List<String> subList = generateParenthesis(n - 1);
//        String[] subLists;
//                if(n>4){
//                    subLists = subList.toArray(new String[subList.size()+1]);
//                    subLists[subList.size()]="())(()";
//        }else {
//                     subLists = subList.toArray(new String[subList.size()]);
//                }
//
////            for(String s:subLists){
////                System.out.println("sub 数组："+s);
////            }
//        int i=0;
//
//        while (i<subLists.length){
//
//            if (checkStack("()"+subLists[i])) {
//                lists.add("()"+subLists[i]);
//            }
//            if(checkStack(subLists[i]+"()")){
//                lists.add(subLists[i]+"()");
//            }
//            if(checkStack("("+subLists[i]+")")){
//                lists.add("("+subLists[i]+")");
//            }
//            i++;
//        }
//        return new ArrayList<>(new TreeSet<>(lists));
//    }
//    public static boolean checkStack(String str){        //push的时候是反的
//        Stack<Character> stringStack=new Stack<>();
//        for( char c : str.toCharArray()){
//            stringStack.push(c);
//        }
//
//        int left=0;
//        int right=0;
//        while(!stringStack.isEmpty()){
//            if(stringStack.pop()==')'){       //push的时候是反的
//                left++;
////                System.out.println("left:"+left);
//            }else{
//                right++;
////                System.out.println("right:"+right);
//            }
//            if(right>left){
//                System.out.println("right:"+right);
//                return false;
//            }
//        }
//        return true;
//
//
//    }
    public static List<String> generateParenthesis(int n) {
                List<String> lists=new ArrayList<>();
                helper("",n,0,0,lists);
                return lists;
    }
    public static void helper(String str,int n,int left, int right,List<String> lists){
        System.out.println("left:"+left+",right:"+right);
        if(right==n){
            lists.add(str);
            return;
        }
        if(left<n){
            helper(str+"(",n,left++,right,lists); //不能用left++ 也不能用++left 因为会改变left的值，影响这一步的递归
        }
        if(right<left){
            helper(str+")",n,left,++right,lists);
        }

    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4).size()+","+generateParenthesis(4).toString());
    }
}
