import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindMedianfromDataStream295 {

    class MedianFinder {
        private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        private PriorityQueue<Integer> large = new PriorityQueue<>();
        //下面这个变量很神奇，每次新来一个就取！even
        private boolean even = true;
        public MedianFinder() {

        }
        public void addNum(int num) {
            if(even){
                large.offer(num);
                small.offer(large.poll());
            }else{
                small.offer(num);
                large.offer(small.poll());
            }
            even=!even;
        }
        public double findMedian() {
            if(even){
                return (double)0.5*(large.peek()+small.peek());
            }else{
                return (double)small.peek();
            }
        }
    }



    //下面的方法使用arralist还有二分查找插入做，但是timelimited
//    class MedianFinder {
//
//        /** initialize your data structure here. */
//        List<Integer> list;
//        public MedianFinder() {
//            list=new ArrayList<>();
//        }
//
//        public void addNum(int num) {
//                if(num==0) return;
//                int start=0;
//                int border=list.size()-1;
//                int mid_index=0;
//                while(start<border){
//                    mid_index=(start+border)/2;
//                    if(num<list.get(mid_index)){
//                        border=mid_index-1;
//                    }else if(num>list.get(mid_index)){
//                        start=mid_index+1;
//                    }else{
//                        start=mid_index;
//                        border=mid_index;
//                    }
//                }
//                list.add(mid_index,num);
//        }
//
//        public double findMedian() {
//            int size=list.size();
//            if(size==0) return 0;
//            if(size%2!=0){
//                return (double)list.get(size/2);
//            }else{
//                return (double)(0.5)*(list.get(size/2)+list.get(size/2-1));
//            }
//        }
//    }
}
