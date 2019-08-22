import java.util.Arrays;

public class CountandSay38 {
    public static String countAndSay(int n) {
            if(n==1){
                return "1";
            }
//            System.out.println("str:"+str);

            String[] strs=countAndSay(n-1).split("");
            StringBuilder result=new StringBuilder();
//            int temporary=Integer.parseInt(strs[0]);
//            System.out.println("tem:"+temporary);
            int count=1;
            for(int i=1;i<strs.length;i++){
                if(!strs[i].equals(strs[i-1])){
                    result.append(count).append(strs[i-1]);
                    count=1;
//                    temporary=Integer.parseInt(strs[i]);
                }else{
                    count++;
                }
            }
            result.append(count).append(strs[strs.length-1]);//将最后重复或者未重复的数字描述
            return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
