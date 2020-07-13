import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber202 {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        int sum;
        int bit_num;
        while (set.add(n)){
            //sum 要记得设成0呀！！！！！！！！！！
            sum=0;
            set.add(n);
            while(n!=0){
                bit_num=n%10;
                n/=10;
                sum+=bit_num*bit_num;
            }
            if(sum==1) return true;
             n=sum;
        }
        return false;
    }
}
