public class CountingBits338 {
    //下面解法相当于
    //f[1] = (f[0]==0) + (1%1==1) = 1
    //f[11] = (f[1]==1) + (11%1==1)  = 2
    //f[110] = (f[11]==2) + (110%1==0) = 2
    //f[1101] = (f[110] ==2) + (1101%1==1) =3;
    //...
    public int[] countBits(int num) {
        int[] array=new int[num+1];
        //i=0 正好已经初始化0了
        for(int i=1;i<=num;i++)array[i]=array[i>>1]+(i&1);
        return array;
    }
}
