public class UniqueBinarySearchTrees96 {
    public static int numTrees(int n) {
        int[] d=new int[n+1];
        d[0]=1;
        d[1]=1;
        for(int i=2;i<d.length;i++){
            int j=0;
            while(j<i){
                //这个是乘数因为左边变换一次，总体的变换次数又翻了一倍
                d[i]+=d[j]*d[i-j-1];
//                System.out.println("j:"+j+","+d[i]);
                j++;
            }
        }
        return d[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }

}
