public class Candy135 {
    //2020/02/12
//    Runtime: 368 ms, faster than 5.20% of Java online submissions for Candy.
//    Memory Usage: 43.2 MB, less than 9.09% of Java online submissions for Candy.
    public int candy(int[] ratings) {
        if(ratings.length==0){
            return 0;
        }
        int[] arrays=new int[ratings.length];
        arrays[0]=1;
        for(int i=1;i<ratings.length;i++){
//            if(ratings[i]<ratings[i-1]){
//                add_candy(ratings,i,arrays);
//            }else if(ratings[i]==ratings[i-1]){
            if(ratings[i]<=ratings[i-1]){
                arrays[i]=1;
            }else{
                arrays[i]=arrays[i-1]+1;
            }
        }
        for(int index=ratings.length-1;index>0;index--){
            //权重比前一个的权重大不能说明前一个一定需要增加，因为有可能前一个的糖果本身就已经比i的多了
            if(ratings[index]<ratings[index-1]){
                while(arrays[index]>=arrays[index-1]){
                    arrays[index-1]++;
                }
            }
        }
        int sum=0;
        for(int num:arrays){
            // System.out.println("num:"+num);
            sum+=num;
        }
        return sum;
    }
    //2020/02/12
    //Runtime: 457 ms, faster than 5.12% of Java online submissions for Candy.
    //Memory Usage: 43.4 MB, less than 9.09% of Java online submissions for Candy.
//    public int candy(int[] ratings) {
//        if(ratings.length==0){
//            return 0;
//        }
//        int[] arrays=new int[ratings.length];
//        arrays[0]=1;
//        for(int i=1;i<ratings.length;i++){
//            if(ratings[i]<ratings[i-1]){
//                add_candy(ratings,i,arrays);
//            }else if(ratings[i]==ratings[i-1]){
//                arrays[i]=1;
//            }else{
//                arrays[i]=arrays[i-1]+1;
//            }
//        }
//        int sum=0;
//        for(int num:arrays){
//            // System.out.println("num:"+num);
//            sum+=num;
//        }
//        return sum;
//    }
//    public void add_candy(int[] ratings,int index,int[] arrays){
//        arrays[index]=1;
//        for(int i=index;i>0;i--){
//            if(ratings[i]<ratings[i-1]){
//                //权重比前一个的权重大不能说明前一个一定需要增加，因为有可能前一个的糖果本身就已经比i的多了
//                if(arrays[i]>=arrays[i-1]){
//                    arrays[i-1]++;
//                }
//            }else{
//                return;
//            }
//        }
//        return;
//    }
}
