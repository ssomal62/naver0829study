package bit701.day0919;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sol25 {

    public static void main(String[] args) {


        int n = 15;
         List<Integer> list =  IntStream.rangeClosed(1, 200)
                         .filter(i -> !(i % 3 == 0))
                         .mapToObj(String::valueOf)
                         .filter(i -> !(i.contains("3")))
                         .limit(n)
                         .mapToInt(Integer::valueOf)
                         .boxed()
                         .collect(Collectors.toList());

        int  a = list.get(list.size()-1);

        System.out.println(a);
    }


}




