import java.math.BigDecimal;
import java.util.Stack;

public class EvaluateReversePolishNotation150 {
    public int evalRPN(String[] tokens) {
//        if(tokens.length==0) return 0;
        Stack<String> stack=new Stack<>();
        String pushing_str="";
        for(String str:tokens){
            pushing_str=str;
            if("+".equals(str)){
                pushing_str= String.valueOf(Integer.valueOf(stack.pop())+Integer.valueOf(stack.pop()));
            }
            if("-".equals(str)){
                pushing_str=  String.valueOf(-1*(Integer.valueOf(stack.pop())-Integer.valueOf(stack.pop())));
            }
            if("*".equals(str)){
                pushing_str=  String.valueOf(Integer.valueOf(stack.pop())*Integer.valueOf(stack.pop()));
            }
            if("/".equals(str)){
                int i=Integer.valueOf(stack.pop());
                pushing_str=  String.valueOf(Integer.valueOf(stack.pop())/i);
            }
            stack.push(pushing_str);
        }
//        return Integer.valueOf(stack.pop());
        return Integer.valueOf(stack.peek());
    }
}
