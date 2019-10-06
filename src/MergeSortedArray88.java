public class MergeSortedArray88 {
//    nums1 = [1,2,3,0,0,0], m = 3    注意这里的m指的是nums1有数字的部分
//    nums2 = [2,5,6],       n = 3

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(n!=0){
            nums1[m+n-1]=(m==0||nums2[n]>nums1[m])?nums2[n--]:nums1[m--];
        }
    }
}
