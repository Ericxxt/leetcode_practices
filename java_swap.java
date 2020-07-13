public class java_swap {
    public static void main(String[] args) {
        int i=5;
        int j=4;
        swap(i,j);
        System.out.println("i:"+i+",j:"+j);
    }
    //这个例子证明了java是值传递而不是引用传递
    public static void swap(int i, int j){
        int z;
        z=i;
        i=j;
        j=z;
        return;
    }

}
