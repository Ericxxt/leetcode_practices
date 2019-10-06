import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubstring76 {
    public static String minWindow(String s, String t) {
        if(s.length()==0||t.length()==0){
            return "";
        }
        //用int数组记录t中字符出现的次数;
         int[] test_array=new int[256];
        //用来测试进入循环的数组，每次循环需要重新设置为test——array
        int[] record_array;
        for(char c :t.toCharArray()){
            test_array[c]++;
        }

        StringBuilder sb=new StringBuilder();
        int count;
        int sec_index=0;
        int i=0;
        boolean tf;
        String max_substr="";
//        while (i<s.length()-t.length()){
        while (i<s.length()){
            tf=true;
            if(t.contains(String.valueOf(s.charAt(i)))) {
                record_array=new int[256];

//            System.arraycopy(test_array,0,record_array,0,test_array.length);
                if(sb.length()!=0){
                    // System.out.println("sb:"+sb.toString());
                    sb.delete(0,sb.length());
                }
                count=0;
                for (int j = i; j < s.length(); j++) {
                    sb.append(String.valueOf(s.charAt(j)));
                    if(record_array[s.charAt(j)]<test_array[s.charAt(j)]){
//                        System.out.println("letter:"+String.valueOf(s.charAt(j))+",array_num:"+record_array[s.charAt(j)]);
                        record_array[s.charAt(j)]++;
                        count++;
                    }
//                        else if(record_array[s.charAt(j)]==0){
//
//                        }
                    else{

                    }
                    if(count==1&&tf){
                        tf=false;
                        sec_index=j;
//                        System.out.println("j:"+j);
                    }
                    if(count==t.length()){
                        if(max_substr.length()==0){
                            max_substr=sb.toString();
                        }else{
//                             System.out.println("sb:"+sb.toString());
                            max_substr=max_substr.length()>sb.length()?sb.toString():max_substr;
                        }
                        break;
                    }
                }
            }
            i=sec_index>i?sec_index:i+1;
        }
        return max_substr;
    }

    public static void main(String[] args) {
        String s="bcbbccbca";
        String t="ba";
        System.out.println("max:"+minWindow(s,t));
    }
}
