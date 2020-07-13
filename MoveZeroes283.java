public class MoveZeroes283 {
    //Runtime: 4 ms, faster than 13.54% of Java online submissions for Move Zeroes.
    //Memory Usage: 42.4 MB, less than 5.59% of Java online submissions for Move Zeroes.
    //自己想的方法，就是替换0与之后最近的一个不是0的数，然后后面的那个数赋值为0
    public void moveZeroes(int[] nums) {
      for(int i=0;i<nums.length;i++){
          if(nums[i]==0){
              for(int j=i+1;j<nums.length;j++){
                  if(nums[j]!=0){
                      nums[i]=nums[j];
                      nums[j]=0;
                      break;
                  }
              }
          }
      }
    }
    //leetcode高票方法
    //思想就是设置一个insert_postion表示可以插入的位置
    //如果遇到一个不为零的数字那么则插入这个位置，然后position++;
    //如果如果遇到0那么position不变，数组继续增加
    //insert所在的位置可以是0也可以是整数
    //相当于有两个index,insert的index保证了insert前面的都是非零数
    //因为i这个num只会不断增大，所以不需要将后面复制到前面的数改变，
    //12340567
    //12345567
    //12345667
    //12345677
    public void moveZeroes(int[] nums) {
        if(nums.length==0) return;
        int insert_position=0;
        for(int i:nums){
            if(i!=0){
                nums[insert_position++]=i;
            }
        }
        for(int j=insert_position;j<nums.length;j++){
            nums[j]=0;
        }
        return;
    }
}
