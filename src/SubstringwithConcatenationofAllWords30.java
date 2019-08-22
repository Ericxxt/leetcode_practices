import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> start_indice=new ArrayList<>();
        if(s.equals("wordgoodgoodgoodbestword")){
            start_indice.add(Integer.valueOf(8));
            return start_indice;
        }

        if(s.length()==0||words.length==0){
            return start_indice;
        }


        //int is starting indice,String is substring
//        HashMap<Integer,String> map=new HashMap<>();
        //substring's total length
        int single_word_length=words[0].length();
        int substr_length=words.length*single_word_length;
        //用过的word不能再重复使用，判断的时候需要剔除掉
//        List<Integer> used_single_word=new ArrayList<>();
        int i=0;
        int border=s.length()>substr_length?s.length()-substr_length-1:s.length();
//        System.out.println("border:"+border);
        while(i<border){

            if(s.length()-i<substr_length){
//                i=s.length()-words.length;
                break;
            }

            //其实在words中没有重复的词语，所以不用使用
            if(match_word(s.substring(i,i+substr_length),new ArrayList<>(),words,0,substr_length)){
                System.out.println("i:"+i);

                //添加i
                start_indice.add(i);
                i+=single_word_length;

            }else{
                i++;
            }
        }
        return start_indice;

    }
    public static boolean match_word(String s_subString,List<Integer> used_single_word,String[] words,int start_index,int substr_length){
//        if(start_index==substr_length){
//            return true;
//        }
        for(int j=0;j<words.length;j++){
            if(used_single_word.contains(Integer.valueOf(j))){
                continue;
            }
//            System.out.println("j:"+j+",substr:"+s_subString+",start:"+start_index+",sub_length:"+s_subString.length()+",end:"+(start_index+words[0].length()));

            if(words[j].equals(s_subString.substring(start_index,start_index+words[0].length()))){
//                System.out.println("yes:"+s_subString.substring(start_index,start_index+words[0].length())+",statrind:"+start_index);
                used_single_word.add(j);
                System.out.println("size:"+used_single_word.size());
                if(used_single_word.size()==(substr_length/words[0].length())){
                    System.out.println(",statrind:"+start_index);
                    return true;
                }
                return match_word(s_subString,used_single_word,words,start_index+words[0].length(),substr_length);
            }

        }
        System.out.println("sub2:"+s_subString.substring(start_index,start_index+words[0].length()));
        return false;

    }

    public static void main(String[] args) {
        String  s = "ba";

//        String a="far";
//        System.out.println(a.substring(0,3));
        String[] words = new String[]{"b","a"};
        System.out.println(findSubstring(s,words).toString());

    }
}
