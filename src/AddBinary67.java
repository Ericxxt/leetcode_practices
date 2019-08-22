import java.util.Stack;

public class AddBinary67 {
    //2019/8/16
//    结果
//    Runtime: 5 ms, faster than 6.64% of Java online submissions for Add Binary.
//    Memory Usage: 36 MB, less than 100.00% of Java online submissions for Add Binary.
    public static String addBinary(String a, String b) {
        int index_a=a.length()-1;
        int index_b=b.length()-1;
        Stack<Character> Binary_stack=new Stack<>();
        int carry=0;
        int tempo_num=0;
        while(index_a>-1||index_b>-1){
            //下面的if判断根据index在a或b的指向是否已经结束进行位上的相加
            if(index_a>-1&&index_b==-1){
                tempo_num=Integer.parseInt(a.charAt(index_a)+"")+carry;
            }else if(index_a==-1&&index_b>-1){
                tempo_num=Integer.parseInt(b.charAt(index_b)+"")+carry;
            }else{
                tempo_num=Integer.parseInt(a.charAt(index_a)+"")+Integer.parseInt(b.charAt(index_b)+"")+carry;
            }
            //根据相加结果判断是否有进位（carry）已经进栈的数（tempo_num）
            //改成三目运算
            carry=tempo_num>1?1:0;
            tempo_num=tempo_num%2==0?0:1;

//            if(tempo_num==3){
//                tempo_num=1;
//                carry=1;
//            }else if(tempo_num==2){
//                tempo_num=0;
//                carry=1;
//            }else{
//                carry=0;
//            }
            //

            Binary_stack.push((char)(tempo_num+'0'));
            System.out.println(Binary_stack.isEmpty());
            //指针的进位选择，如果结束，就保持结束状态
            if(index_a<=0&&index_b>0){
                index_a=-1;
                index_b--;
            }else if(index_a>0&&index_b<=0){
                index_a--;
                index_b=-1;
            }else{
                index_a--;
                index_b--;
            }
        }

        if(carry==1){
            Binary_stack.push('1');
        }
        StringBuilder sb=new StringBuilder();
        while(!Binary_stack.isEmpty()){
            sb.append(Binary_stack.pop());
            System.out.println(sb.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a="11";
        String b="1";
        addBinary(a,b);

    }
}
