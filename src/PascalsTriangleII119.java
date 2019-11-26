import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII119 {
    //Runtime: 1 ms, faster than 90.28% of Java online submissions for Pascal's Triangle II.
    //Memory Usage: 33.8 MB, less than 6.17% of Java online submissions for Pascal's Triangle II.
    public List <Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) {
            return list;
        }
        for (int i = 0; i <= rowIndex; i++) {
            //刚开始第一个默认加1
            list.add(0, 1);
            //j=1表示从第二个元素开始进行运算，list.size() - 1让list.get(j) + list.get(j + 1)不会溢出
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}
