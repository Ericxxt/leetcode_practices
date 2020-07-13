import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordBreakII140 {
    //2020/02/15
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs_method(s,wordDict,new HashMap<String,List<String>>());
    }
    public List<String> dfs_method(String s,List<String> wordDict, HashMap<String, List<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        List<String> single_list=new LinkedList<>();
        if(s.length()==0){
            single_list.add("");
            return single_list;
        }
        //写错的时候把下面这个for循环也加了上去，但是其实只需要用startwith判断是否以
        //list中的单词开头就好了，所以这个方法真的比下面的递归要快
            for(String str: wordDict){
                if(s.startsWith(str)){
                    List<String> sub_list=dfs_method(s.substring(str.length()),wordDict,map);
                    for(String sub_str:sub_list){
                        //注意这里是判断sub_str是否是empty
                        single_list.add(str+ (sub_str.isEmpty()?"" : " ") +sub_str);
                    }
                }
            }
        map.put(s,single_list);
            //最终的map就是以整个s为key的list<string>，所以直接返回就可以
        return single_list;
    }
    //one comment
    //Using DFS directly will lead to TLE, so I just used HashMap to save the previous results to prune duplicated branches, as the following:
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> output_list=new ArrayList<>();
//        recur_gene(s,wordDict,new LinkedList<>(),output_list,0);
//        return output_list;
//    }
//    public void recur_gene(String s,List<String> wordDict,List<String> list,List<String> output_list,int index){
//        if(index==s.length()){
//            output_list.add(String.join(" ",new ArrayList<>(list)));
//            return;
//        }
//        for(int i=index+1;i<=s.length();i++){
//            String sub_str=s.substring(index,i);
//            if(wordDict.contains(sub_str)){
//                list.add(sub_str);
//                recur_gene(s,wordDict,list,output_list,i);
//                list.remove(list.size()-1);
//            }
//        }
//        return;
//    }
}
