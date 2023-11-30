package modernjavainaction.chap04;

import static java.util.stream.Collectors.toList;
import static modernjavainaction.chap04.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HighCaloriesNames {

  public static void main(String[] args) {
    List<String> names = menu.stream()
        .filter(dish -> {
          System.out.println("filtering " + dish.getName());
          return dish.getCalories() > 300;
        })
        .map(dish -> {
          System.out.println("mapping " + dish.getName());
          return dish.getName();
        })
        .limit(3)
        .collect(toList());
    System.out.println(names);
    //////////////
    List<String> threeHighCaloricDishNames = menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3).collect(toList());
    System.out.println(threeHighCaloricDishNames);
    
    List<Dish> twoMeatDisies = menu.stream().filter(t -> t.getType().equals(Dish.Type.MEAT)).limit(2).collect(toList());
    System.out.println(twoMeatDisies);
    
    List<Integer> dishNameLengths = menu.stream().map(Dish::getName).map(String::length).collect(toList());
    System.out.println(dishNameLengths);
    
    int calories = menu.stream().mapToInt(Dish::getCalories).sum();
    System.out.println("calories : 칼로리리" + calories);
    
    
    //List<String> str = new ArrayList<>(Arrays.asList("Hello","World"));
    String[] str = {"Hello","World"};
    Stream<String> words = Arrays.stream(str);
    //에러
    //String str1 = words.map(w->w.split("")).distinct().collect(Collectors.joining());; 
    
//    String str2 = words.map(w->w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.joining());;  
//    System.out.println(str2);
//    
//    List<Integer> numbers = Arrays.asList(1,2,3,4,5);
//    
//    List<Integer> result = numbers.stream().map(i -> (int)Math.pow(i,2)).collect(toList());
//    
//    System.out.println(result);
//    
//    List<Integer> num1 = Arrays.asList(1,2,3);
//    List<Integer> num2 = Arrays.asList(3,4);
//    
//    List<int[]> pairs = num1.stream().flatMap( i -> num2.stream().filter(j-> (i+j)% 3 ==0).map(j -> new int[] {i,j})).collect(toList());
//    
//    for(int[] i : pairs) {
//    	System.out.print(Arrays.toString(i));
    	
    long sum = menu.stream().count();
    System.out.println(sum);
    
    
    
    }
    
  }


