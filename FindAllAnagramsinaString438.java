import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString438 {
    //s: "cbaebabacd" p: "abc"
    //The substring with start index = 0 is "cba", which is an anagram of "abc".
    //The substring with start index = 6 is "bac", which is an anagram of "abc".
    //这个题目难解决的问题在于如果验证字符串是abddddd如何比较时候计算d的数量
    public List<Integer> findAnagrams(String s, String p) {

    }
    public List<Integer> recur_plus(String s, String p,int start, int index_s, Map<Integer,Integer> map, List<Integer> list){
        for(int i=index_s;i<s.length();i++){
            if(s.charAt(index_s))
        }
    }
    //下面这种方法叫sliding window
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        if(s.length()==0||p.length()==0||s.length()<p.length()) return list;
        int[] record_p= new int[123];
        for(char single_char:p.toCharArray()){
            record_p[single_char]++;
//            System.out.println("int[]:"+record_p[single_char]+",sum:"+single_char);
        }
        int count=p.length();
        int left,right;
        left=right=0;
        while(right<s.length()){
            if(record_p[s.charAt(right)]>0) {
                count--;
                //下面这步应该放外面，
//                record_p[right]--;
            }
            //下面这步不管p中存不存在数组中都要减去，因为在后面这个right变成left的时候sliding的时候还会再加上的
            record_p[s.charAt(right)]--;
            right++;
            if(count==0){
                list.add(left);
            }
            if(right-left==p.length()){
//                if(record_p[s.charAt(left)]>-1) count++;
//                record_p[s.charAt(left)]++;
                count=++record_p[s.charAt(left)]>0?++count:count;
                left++;
            }
            //下面这步right++要放在上面，这样right-left==p.length的判断才有效
//            right++;
        }
        return list;
     }
}
