public class SearchinRotatedSortedArrayII81 {
    //2019.09.02
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array II.
//    Memory Usage: 39.5 MB, less than 52.11% of Java online submissions for Search in Rotated Sorted Array II.
    static boolean finded=false;
    static boolean going=true;
    public static boolean search(int[] nums, int target) {
        finded=false;
       going=true;
        if(nums.length<10){   //在数量少的时候直接循环就可以了，快多了
            return iterate_all(nums,target);
        }
        if(nums[0]==nums[(nums.length-1)/2]&&nums[(nums.length-1)/2]==nums[nums.length-1]){
            return iterate_all(nums,target);
        }
        return search_num(nums,0,nums.length-1,target);
        //返回最大值的index
//        int max_index=-1;
        //定义个boolean ，true向右，false向左边


    }
    public static boolean search_num(int[] nums,int start,int end,int target){
        int medium=(end+start)>>>1;
        while (start<end&&!finded&&going) {
            if (nums[start] == target || nums[end] == target || nums[medium] == target) {
                finded=true;
                System.out.println("success!");
                return finded;
            } else if (nums[start] > target) {
                //向右找

                if (nums[medium] > target) {//start和medium都大于target，只需要向左边找
                    search_num(nums, start, medium-1, target);

                } else {    //medium<target
                    search_num(nums, medium + 1, end, target);

                }

            } else if (nums[start] < target) {
                //向左找
                //if medium>start，start又小于target，只需要左边找
                if (nums[medium] > target) {
                    search_num(nums, start, medium-1, target);
                } else {
                    if (nums[medium] > nums[start]) {//medium小于target但是大于start，往右边
                        search_num(nums, medium + 1, end, target);
                    } else {//medium<start，只需要往左找
                        search_num(nums, start, medium-1, target);
                    }

                }
            }
        }
        going=false;
        return finded;
    }

    public static boolean iterate_all(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(search(nums,2));

    }
//    public void search_pivot_left(int[] nums,int start,int end,int max_index){
////        if(max_index!=-1){
////            return;
////        }
//        int now_num=nums[start];
//        for(int i=start;i<=end;i++){
//            if(now_num>nums[i]){
//                max_index=i-1;
//                return;
//            }else if(now_num!=nums[i]){  //只有now_num和当前不一样的时候才重新赋值
//                now_num=nums[i];
//            }
//        }
//        return;
//    }

}
