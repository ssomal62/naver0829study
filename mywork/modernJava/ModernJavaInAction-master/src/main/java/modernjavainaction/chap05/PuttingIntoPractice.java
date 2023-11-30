package modernjavainaction.chap05;


import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import scala.collection.parallel.ParIterableLike.FlatMap;

public class PuttingIntoPractice {

  public static void main(String... args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );
    
    //1
    List<Transaction> findIn2011Value = transactions.stream().filter(y -> y.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(toList());
    System.out.println(findIn2011Value);
    
    //2
    List<String> allCitiesWithTrader = transactions.stream().map(t-> t.getTrader().getCity()).distinct().collect(toList());
    System.out.println(allCitiesWithTrader);
    
    //3
    List<Trader> allTradersInCambridge = transactions.stream()
    		.map(Transaction::getTrader).filter(t -> t.getCity().equals("Cambridge")).sorted(comparing(Trader::getName)).distinct().collect(toList());
    System.out.println(allTradersInCambridge);
    
    //4 
    List<String> allTradersName = transactions.stream().map(t -> t.getTrader().getName()).sorted().distinct().collect(toList());
    System.out.println(allTradersName);
    
    //5
    boolean isTraderInMilan = transactions.stream().anyMatch(t->t.getTrader().getCity().equals("Milan"));
    System.out.println(isTraderInMilan);
    
    //6
    List<Integer> allValueInCambridge = transactions.stream().filter(t-> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).collect(toList());
    System.out.println(allValueInCambridge);
    
    //7
    OptionalInt maxValue = transactions.stream().mapToInt(Transaction::getValue).max();
    System.out.println(maxValue.getAsInt());
    
    //7
    OptionalInt minValue = transactions.stream().mapToInt(Transaction::getValue).min();
    System.out.println(minValue.getAsInt());
    /*
    //1 
    List<Transaction> allTransaction = transactions.stream()
    		.filter(t-> t.getYear() == 2011)
    		.sorted(comparing(Transaction::getYear))
    		.collect(toList());
    System.out.println("[1]: " + allTransaction);
    
    //2
    List<String> allCitiesWithTrader = transactions.stream()
    		.map(t-> t.getTrader().getCity())
    		.distinct()
    		.collect(toList()); 		
    System.out.println("[2]: " + allCitiesWithTrader);
    
    //3
    List<String> allTradersInCambridge = transactions.stream()
    		.map(Transaction::getTrader)
    		.filter(t-> t.getCity().equals("Cambridge"))
    		.map(Trader::getName)
    		.distinct()
    		.sorted()
    		.collect(toList());
    System.out.println("[3]: " + allTradersInCambridge);

    		
    //4
    List<String> allTraders = transactions.stream()
    		.map(t-> t.getTrader().getName())
    		.distinct()
    		.sorted()
    		.collect(toList());
    System.out.println("[4]: " + allTraders);		
    
    //5
    boolean isTraderInMilan = transactions.stream()
    		.anyMatch(t-> t.getTrader().getCity().equals("Milan"));
    System.out.println("[5]: " + isTraderInMilan);
   
    //6
    List<Integer> allValueInCambridge = transactions.stream()
    		.filter(t-> t.getTrader().getCity().equals("Cambridge"))
    		.map(Transaction::getValue)
    		.collect(toList());
    System.out.println("[6]: " + allValueInCambridge);
    
    //7
    OptionalInt maxValue = transactions.stream()
    		.mapToInt(Transaction::getValue)
    		.max();
    System.out.println("[7]: " +maxValue.getAsInt());

    //8
    OptionalInt minValue = transactions.stream()
    		.mapToInt(Transaction::getValue)
    		.min();
    System.out.println("[8]: " +minValue.getAsInt());

    
    //피타고라스...
    Stream<double[]> pita = IntStream.rangeClosed(1, 100).boxed()
    		.flatMap(a -> 
    		IntStream.rangeClosed(a, 100).mapToObj(b-> new double[]{a,b,(Math.sqrt(a*a+b*b))}).filter(i -> i[2] % 1 == 0));
    pita.limit(5).forEach(i->System.out.println((int)i[0] + ", " + (int)i[1]+", "+ (int)i[2]));
    
    Stream<String> stream = Stream.of("kang","lee","jae");
    stream.map(String::toUpperCase).forEach(System.out::println);
    
    Stream.iterate(new int[] {0,1}, n-> new int[] {n[1], n[0]+n[1]}).limit(20).forEach(t-> System.out.println("(" + t[0]+","+t[1]+")"));
    
*/

/*
    // 질의 1: 2011년부터 발생한 모든 거래를 찾아 값으로 정렬(작은 값에서 큰 값).
    List<Transaction> tr2011 = transactions.stream()
        .filter(transaction -> transaction.getYear() == 2011)
        .sorted(comparing(Transaction::getValue))
        .collect(toList());
    System.out.println(tr2011);

    // 질의 2: 거래자가 근무하는 모든 고유 도시는?
    List<String> cities = transactions.stream()
        .map(transaction -> transaction.getTrader().getCity())
        .distinct()
        .collect(toList());
    System.out.println(cities);

    // 질의 3: Cambridge의 모든 거래자를 찾아 이름으로 정렬.
    List<Trader> traders = transactions.stream()
        .map(Transaction::getTrader)
        .filter(trader -> trader.getCity().equals("Cambridge"))
        .distinct()
        .sorted(comparing(Trader::getName))
        .collect(toList());
    System.out.println(traders);

    // 질의 4: 알파벳 순으로 정렬된 모든 거래자의 이름 문자열을 반환 
    String traderStr = transactions.stream()
        .map(transaction -> transaction.getTrader().getName())
        .distinct()
        .sorted()
        .reduce("", (n1, n2) -> n1 + n2);
    System.out.println(traderStr);

    // 질의 5: Milan에 거주하는 거래자가 있는가?
    boolean milanBased = transactions.stream()
        .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
    System.out.println(milanBased);

    // 질의 6: Cambridge에 사는 거래자의 모든 거래내역 출력.
    transactions.stream()
        .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
        .map(Transaction::getValue)
        .forEach(System.out::println);

    // 질의 7: 모든 거래에서 최고값은 얼마인가?
    int highestValue = transactions.stream()
        .map(Transaction::getValue)
        .reduce(0, Integer::max);
    System.out.println(highestValue);

    // 가장 작은 값을 가진 거래 탐색
    Optional<Transaction> smallestTransaction = transactions.stream()
        .min(comparing(Transaction::getValue));
    // 거래가 없을 때 기본 문자열을 사용할 수 있도록발견된 거래가 있으면 문자열로 바꾸는 꼼수를 사용함(예, the Stream is empty)
    System.out.println(smallestTransaction.map(String::valueOf).orElse("No transactions found"));
    */
  }

  
  
}
