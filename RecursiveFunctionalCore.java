import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class RecursiveFunctionalCore {

    
    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        if (list == null || list.isEmpty()) {
            return List.of();
        }
        R headMapped = mapper.apply(list.get(0));
        List<R> tailMapped = map(list.subList(1, list.size()), mapper);

        return Stream.concat(Stream.of(headMapped), tailMapped.stream()).toList();
    }

  
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        if (list == null || list.isEmpty()) {
            return List.of();
        }
        T head = list.get(0);
        List<T> tailFiltered = filter(list.subList(1, list.size()), predicate);

        if (predicate.test(head)) {
            return Stream.concat(Stream.of(head), tailFiltered.stream()).toList();
        } else {
            return tailFiltered;
        }
    }

   
    public static <T, R> R foldLeft(List<T> list, R identity, BiFunction<R, T, R> accumulator) {
        if (list == null || list.isEmpty()) {
            return identity;
        }
        T head = list.get(0);
        R newAcc = accumulator.apply(identity, head);
        return foldLeft(list.subList(1, list.size()), newAcc, accumulator);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

      
        List<Integer> squares = map(nums, x -> x * x);
        System.out.println("Squares (Map): " + squares);

     
        List<Integer> evens = filter(nums, x -> x % 2 == 0);
        System.out.println("Evens (Filter): " + evens);

      
        int product = foldLeft(nums, 1, (acc, x) -> acc * x);
        System.out.println("Product (FoldLeft): " + product);
    }
}
