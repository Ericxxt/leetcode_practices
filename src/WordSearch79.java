import java.util.Arrays;

public class WordSearch79 {
    //题目意思理解错了，是相邻字母是否能构成单词2019。08。31
//    public static boolean exist(char[][] board, String word) {
//        if(board.length==0||word.length()==0){
//            return false;
//        }
//            StringBuilder sb=new StringBuilder();
//            //use StringBuilder to connect every low in board
//            for(int i=0;i<board.length;i++){
//                sb.append(new String(board[i]));
//            }
//            char[] sorted_chars=sb.toString().toCharArray();
//            //sort the chars
////            Arrays.sort(sorted_chars);
////            char[] sorted_word=word.toCharArray();
////            Arrays.sort(sorted_word);
//            int index_chars=0;
//            int index_word=0;
//            while(index_word<word.length()&&index_chars<sorted_chars.length){
//                if(word.charAt(index_word)!=sorted_chars[index_chars]){
//                    index_chars++;
//                }else{
//                    index_word++;
//                    index_chars++;
//                }
//            }
//            System.out.println("index_word:"+index_word+",index_chars:"+index_chars);
//            if(index_word==word.length()){
//                return true;
//            }else{
//                return false;
//            }
//
//    }

    public static void main(String[] args) {
        char[][] board=new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
//        System.out.println(exist(board,"ABCCED"));
    }
}
