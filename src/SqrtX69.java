public class SqrtX69 {

    //太慢了
//    public static int mySqrt(int x) {
//
//        for(int i=1;i<=x/2+1;i++){
//            if(i*i==x){
//
//                return i;
//            }else if(i*i>x||i*i>Integer.MAX_VALUE){
//
//                return i-1;
//            }
//        }
//        return 0;
//    }

    public static int mySqrt(int x){
        int r=x;
           if(r==0){
               return 0;
           }
         while (r>x/r){

             r=(r+x/r)>>>1; //位运算
         }
         return r;

    }

    public static void main(String[] args) {
        System.out.println(mySqrt(3));
    }
}
