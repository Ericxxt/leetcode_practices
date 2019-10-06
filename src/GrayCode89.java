import java.util.LinkedList;
import java.util.List;

public class GrayCode89 {
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        //i>>1其实就是i/2
        //The idea is simple. G(i) = i^ (i/2).这条就是原理！！！！！！！！
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }

    public static void main(String[] args) {

        System.out.println(grayCode(2).toString());
    }
}
