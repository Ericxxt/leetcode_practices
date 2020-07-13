import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule207 {
//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) { val = x; }
//    }
    //这题需要用到入度和出度的知识，当一门课程没有入度时，我们称这门课程是没有前提课程的，也就是满足拓扑结构
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<2)return true;
        int[] indegree=new int[numCourses];
        List<Integer>[] out_pre=new List[numCourses];
        for(int i=0;i<numCourses;i++){
            out_pre[i]=new LinkedList<Integer>();
        }
        for(int[] prair:prerequisites){
            indegree[prair[0]]++;
            out_pre[prair[1]].add(prair[0]);
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        //下面这里写错了需要的是对应的课程值，而不是入度的个数
//        for(int first_zero_indegree:indegree){
//            if (first_zero_indegree==0){
//                queue.offer(first_zero_indegree);
//            }
//        }
        //remove_num represent the all pairs;
        //when all pairs could be removed, then it proof that this course can be finished
        int removed_num=prerequisites.length;
        while(!queue.isEmpty()){
            int num_quene=queue.poll();
            for(int num:out_pre[num_quene]){
                //every time we call the num in one out_pre, we are finishing a pair
                removed_num--;
                //the indegree of num should be substracted
                if(--indegree[num]==0){
                    queue.offer(num);
                }
            }
        }
        return removed_num==0;
    }
//    //leetcode的高票答案
//public boolean canFinish(int numCourses, int[][] prerequisites){
//    int[] incomingEdges = new int[numCourses];
//    List<Integer>[] goCourses = new List[numCourses];
//    for(int i=0;i<goCourses.length;i++){
//        goCourses[i] = new LinkedList<Integer>();
//    }
//    for(int[] pair: prerequisites){
//        incomingEdges[pair[0]]++;
//        goCourses[pair[1]].add(pair[0]);
//    }
//    Queue<Integer> queue = new LinkedList<Integer>();
//    for(int i=0;i<incomingEdges.length;i++){
//        if(incomingEdges[i]==0){
//            queue.add(i);
//        }
//    }
//    int edgeCnt = prerequisites.length;
//    while(!queue.isEmpty()){
//        int cur = queue.poll();
//        for(int goCrs: goCourses[cur]){
//            edgeCnt--;
//            if(--incomingEdges[goCrs]==0)
//                queue.add(goCrs);
//        }
//    }
//    return edgeCnt==0;
//}

//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        //第一个思路是建立一个二阶矩阵
//        if(numCourses<2)return true;
//        for(int i=0;i<numCourses;i++){
//
//        }
//    }
}
