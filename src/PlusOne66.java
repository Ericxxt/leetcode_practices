import java.util.Arrays;

public class PlusOne66 {
    public static int[] plusOne(int[] digits) {

//        boolean digit=true;
            for(int i=digits.length;i>0;i--){
                if(++digits[i-1]==10){
                    System.out.println("in");
                    digits[i-1]=0;
                    if(i==1){
                        int[] plusArray=new int[digits.length+1];
                        plusArray[0]=1;
                        for(int x=1;x<plusArray.length;x++){
                            plusArray[x]=digits[x-1];
                        }
                        return plusArray;
                    }

                }else{
                    break;
                }
            }
            return digits;

    }

    public static void main(String[] args) {
        int[] nums=new int[]{9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }
}
