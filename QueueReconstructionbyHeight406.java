import java.util.*;

public class QueueReconstructionbyHeight406 {
    //leetcode高票方法
    //这个方法的核心思想就是先按照height身高从大到小排序，如果身高一样那么按照index从小到大排序
    //比如7，1和【5，1】我们会先将7,1放入arraylist中，然后遇到5,1再放入，
    // 因为后面排序的元素大小比之前排序好的小，所以insert也不会存在改变之前序列的问题，
    //也纠结如果5,1插入的1号位置之前有两个位置怎么办
    //比如[5,0],[7,0],[7,1]再插入[5,1]
    //但是其实不会发生这种情况，因为这样的话，5，1前面就有两个>=5，因为input的都是符合条件的，所以不会发生这种情况
    //[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    //[[7,0],  [7,1], [5,0],[5,2], [6,1], [4,4],
    //上面是排序结果，之前想不通这种方法的原因之一是，
    // Array.put(int[])的时候要是int[]的index超过了array怎么办
    public int[][] reconstructQueue(int[][] people) {
        if(people.length==0||people[0].length==0) return new int[0][0];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[0]==t1[0]) return ints[1]-t1[1];
                return t1[0]-ints[0];
            }
        });
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<people.length;i++){
            list.add(people[i][1],new int[]{people[i][0],people[i][1]});
        }
        int i=0;
        for(int[] person:list){
            people[i][0]=person[0];
            people[i++][1]=person[1];
        }
        return people;
    }
//    public int[][] reconstructQueue(int[][] people) {
//        //个人感觉应该分为四种情况(然而这种想法是错的)
//
////        Map<Integer, List<Integer>> map=new HashMap<>();
////        for(int index=0;index<people.length;index++){
////            map.getOrDefault(people[index][0]+people[index][1],new ArrayList<>());
////            map.get(index).add(index);
////        }
////        List<Integer> list=new ArrayList<>();
////        for(int list_inx:map.keySet()){
////            for()
////        }
//        List<Integer> list=new ArrayList<>();
////        int list_size=0;
//        int last_idx_people=0;
//        for(int index=0;index<people.length;index++){
//            if(index==0){
//                list.add(index);
//            }else{
//                for(int last=index-1;last>=0;last--){
//                    last_idx_people=list.get(last);
//                    //因为是循环，直到新加的二项应该比list中的最后一项靠后的时候
//                    // 才将新增项添加到当前last的后面。并且结束循环break
//                    if(people[index][0]>=people[last_idx_people][0]&&people[index][1]>=people[last_idx_people][1]){
//                        list.add(last_idx_people+1,index);
//                    }else if()
//                }
//            }
//        }
//    }
}
