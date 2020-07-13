import java.util.Stack;
import java.util.regex.Pattern;

public class DecodeString394 {
//    public String decodeString(String s) {
//        char[] chars=s.toCharArray();
//        Stack<Character> stack=new Stack<>();
//        for(char single_char:chars){
//            if(single_char=='[') continue;
//            if(single_char==']'){
//                StringBuilder sb=new StringBuilder();
//                while (!Character.isDigit(stack.peek())){
//                    sb.append(stack.pop());
//                }
//            }
//        }
//    }
    //仿照高票答案来了一次
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
//Memory Usage: 37.5 MB, less than 5.68% of Java online submissions for Decode String.
    //这个tm居然这么快
    //下面代码的思想就是每当遇到一个[，就将当前的可用字符串放入stack，
    // 然后计算完]中的内容之后将stack中的字符串+【 】构成新的字符串
    public String decodeString(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Integer> count_stack=new Stack<>();
        Stack<String> str_stack=new Stack<>();
        int index=0;
        while(index<s.length()){
            if(Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index++) - '0');
                }
                count_stack.push(count);
            }else if(s.charAt(index)=='['){
                str_stack.push(sb.toString());
                sb.delete(0,sb.length());
                index++;
            }else if(s.charAt(index)==']'){
                //3[fe10[abf]]
                //fe4[ge]
                StringBuilder temp_str=new StringBuilder(str_stack.pop());
                int times=count_stack.pop();
                for(int i=0;i<times;i++){
                    temp_str.append(sb);
                }
                sb=temp_str;
                index++;
            }else{
                sb.append(s.charAt(index++));
            }
        }
        return sb.toString();
    }
    //下面的写了很久，但是感觉还是因为没看清楚题目，忽略了许多情况
//    public String decodeString(String s) {
//        Stack<String> stack=new Stack<>();
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i)=='[') continue;
//            if(s.charAt(i)==']'){
//                //2[abd2[bd]]
//                String sub_str="";
//                if(stack.peek().length()>1){
//                    sub_str=stack.pop();
//                }
//                //第一个sb是用来构建可能存在的数字后面的小字符串
//                StringBuilder sb=new StringBuilder();
//                while (!stack.isEmpty()&&!Character.isDigit(stack.peek().charAt(0))&&stack.peek().length()==1){
//                    sb.append(stack.pop().charAt(0));
//                }
//                if(sb.length()>1) sb=sb.reverse();
//                //第2个sb是用来构建有几次的循环次数
//                StringBuilder stack_sb=new StringBuilder();
//                if (Character.isDigit(stack.peek().charAt(0))) {
//                    for (int times = Integer.valueOf(stack.pop()); times > 0; times--) {
//                        stack_sb.append(sb).append(sub_str);
//                    }
//                }else{
//                    stack_sb.append(sb).append(sub_str);
//                }
//                //第三个sb是为了防止stack里面上一次计算已经存有string
//                StringBuilder over_sb=new StringBuilder();
//                if (!stack.isEmpty()&&stack.peek().length()>1) over_sb.append(stack.pop());
//                stack.push(over_sb.append(stack_sb).toString());
//            }else{
//                stack.push(String.valueOf(s.charAt(i)));
//            }
//        }
//        StringBuilder sb;
//        while(stack.size()>1){
//            String str=stack.pop();
//            sb=new StringBuilder(stack.pop());
//            stack.push(sb.append(str).toString());
//        }
//        return stack.isEmpty()?"":stack.peek();
//    }
}
