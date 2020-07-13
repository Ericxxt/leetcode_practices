import java.util.*;

public class TopKFrequentElements347 {
    //2020/3/24
    //Runtime: 9 ms, faster than 89.19% of Java online submissions for Top K Frequent Elements.
    //Memory Usage: 42.8 MB, less than 6.89% of Java online submissions for Top K Frequent Elements.
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length==0) return null;
        //下面的lists其实就是bucket
        //这个题目的bucket不是为了nums做的，而是为了frequency制作的
        List<Integer>[] lists=new List[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key:map.keySet()){
            int frequency=map.get(key);
            if(lists[frequency]==null) lists[frequency]=new ArrayList<>();
            lists[frequency].add(key);
        }
        List<Integer> result=new ArrayList<>();
        //下面这步result.size()<k 很巧妙，写在里面就可以了
        for(int i=nums.length;i>=0&&result.size()<k;i--){
            if(lists[i]!=null) result.addAll(lists[i]);
        }
        return result;
    }




    //下面这种解法是自己想的，但是nums里面可能存在负数，所以这种方法不可行
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        if(nums.length==0) return null;
////        List<Map<Integer,Integer>> bucket=new ArrayList<HashMap<>>()[nums[nums.length-1]+];
//        int[][] bucket=new int[nums[nums.length-1]+1][1];
//        for(int num:nums){
//            bucket[num][0]++;
//        }
//        Map<Integer,Set<Integer>> map=new HashMap<>();
//        //不应该用次数作为key，因为频率可能有重复
//        for(int i=1;i<bucket.length;i++){
//            map.put(bucket[i][0],map.getOrDefault(bucket[i][0],new HashSet<>()));
//            map.get(bucket[i][0]).add(i);
//        }
//        Integer[] keyArray= map.keySet().toArray(new Integer[map.size()]);
//        Arrays.sort(keyArray, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer integer, Integer t1) {
//                return t1-integer;
//            }
//        });
//        List<Integer> list=new ArrayList<>();
//        for(int i=0;i<k;i++){
//            list.addAll(map.get(keyArray[i]));
//        }
//        return list;
//    }
}
