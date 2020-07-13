public class MaximumProductSubarray152 {
    //
    public int maxProduct(int[] nums) {
//        int product=nums[0];
        int max_num=nums[0];
        int min_num=nums[0];
        int output_num=nums[0];
        //如果是4，-2，3，6 的情况，表示你不能保留最大值4没有任何意义，
        // 你必须在遇到3的时候，将3保留下来所以你不能拿current和历史最大的比
        for(int i=1;i<nums.length;i++){
            //这道题的int数组全都是自然数，所以乘积只会越来越大或者越来越小，一次遍历就可以了，0情况就使用当前值
            //max_num一旦遇到负数就会变成当前值
            //
            //如果当前nums[i]是小于0的那么用大概率是负的min_num乘出来的数会比较大
            if(nums[i]<0){
                max_num=max_num+min_num;
                min_num=max_num-min_num;
                max_num=max_num-min_num;
            }
            max_num=Math.max(nums[i],max_num*nums[i]);
            //因为存在负数，所以min一定要被保留下来
            min_num=Math.min(nums[i],min_num*nums[i]);
            output_num=Math.max(output_num,max_num);
        }
        return output_num;
    }
    //下面的这个方法有些慢，所以改写
//    public int maxProduct(int[] nums) {
//        int max_product=nums[0];
//        int array_product;
//         for(int i=0;i<nums.length;i++){
//             array_product=nums[i];
//             max_product=Math.max(max_product,nums[i]);
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[j]==0){
//                     max_product=Math.max(max_product,0);
//                     break;
//                 }
//                 array_product*=nums[j];
//                 max_product=Math.max(max_product,array_product);
//             }
//         }
//         return max_product;
//    }
}
