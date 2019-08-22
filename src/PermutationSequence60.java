public class PermutationSequence60 {
    //2019。08。16
    //问题在于使用递归方法之后，打印出的参数不变化，解决方法，需要使用全局变量

    //这道问题，我试用了leetcode46的解法，但是发现超出了时间，所以想着使用排列组合的方法限定范围
    static int count=0;
    public static String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();

        //计算排列组合数是n！，每个数字开头的组合是n!/n=(n-1)!
        if(n<2){
            return String.valueOf(n);
        }
        //single_num就是单个数字开头总共有的组合
        int single_num=1;
        for(int i=2;i<n;i++){
            single_num*=i;
        }
        //添加计算的结果的开头点位
        if(k%single_num==0){
            sb.append(k/single_num);
        }else{
            sb.append(k/single_num+1);
        }

        //当前组合开始计算count即可，而不需要从1开头

        //递归中的k值已经变化
        return recursion_method(sb,n,k-((Integer.parseInt(String.valueOf(sb.charAt(0)))-1)*single_num));
    }
    public static String recursion_method(StringBuilder sb,int n,int k){
        if(sb.length()==n){
            System.out.println("sb:"+sb.toString());
            count++;
            return sb.toString();
        }
        for(int i=1;i<=n;i++){
            if(sb.toString().contains(String.valueOf(i))){
                continue;
            }
            sb.append(String.valueOf(i));
            recursion_method(sb,n,k);   //问题在于使用递归方法之后，打印出的参数不变化，解决方法，需要使用全局变量
            if(count==k){
                break;
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
            System.out.println(getPermutation(2,1));
    }
}
