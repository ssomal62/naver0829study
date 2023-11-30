package Solution;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.AbstractMap.SimpleEntry;

public class Solution_31 {


    public int[] solution(int[] arr, int[] query) {

        List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
        AtomicInteger limit_Num  = new AtomicInteger();

        IntStream.range(0,query.length)
                .map(i -> {
                    if(i % 2 == 0){
                        limit_Num.set(list.size() - 1 - query[i]);
                        return list.size() - 1 ;
                    } else {
                        limit_Num.set(query[i]);
                        return 0;
                    }})
                .forEach(i -> IntStream.iterate(i , n -> i == 0 ? n : n - 1).limit(limit_Num.get()).forEach(n -> list.remove(n)));

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    //홍희표 답
    public int[] solution3(int[] arr, int[] query) {

        SimpleEntry<Integer, Integer> se = IntStream.range(0, query.length).boxed().reduce(
                new SimpleEntry<>(0, 0),
                (acc, i) -> i % 2 == 1 ? new SimpleEntry<>(acc.getKey() + query[i], acc.getValue()) : new SimpleEntry<>(acc.getKey(), acc.getKey() + query[i]),
                (a, b) -> null
        );
        return se.getKey().equals(se.getValue()) ? new int[] {-1} : Arrays.copyOfRange(arr, se.getKey(), se.getValue());

    }
    //베스트 답
    public int[] solution2(int[] arr, int[] query) {

        return IntStream.range(0, query.length)
                .boxed()
                .reduce(arr, (current, next) -> next % 2 == 0 ?
                        Arrays.copyOfRange(current, 0, query[next] + 1) :
                        Arrays.copyOfRange(current, query[next], current.length), (a, b) -> a);

    }
    public int[] solution4(int[] arr, int[] query) {

        for(int i=0; i<query.length; i++) {
           arr = (i % 2 == 0) ? Arrays.copyOf(arr, query[i] + 1) : Arrays.copyOfRange(arr, query[i], arr.length);
        }

        return arr;

    }

    public static void main(String[] args) {
        Solution_31 sol = new Solution_31();

        int[] arr   = {0, 1, 2, 3, 4, 5, 6, 7,4,6,8,4,5,6};//length 11
        int[] query = {9, 1, 4,1};
        // 8, 10, 12


        for (int i : sol.solution(arr, query)){
            System.out.println(i);
        }

    }
}
