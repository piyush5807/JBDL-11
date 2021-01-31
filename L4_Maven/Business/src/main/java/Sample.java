import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Sample {

    public static void main(String[] args) {

//        int ans = Main.sum(1, 2);
//
//        System.out.println(ans);


        // sum of squares of even nos
        List<Integer> list = Arrays.asList(1, 3, 2, 4, 5, 1, 6, 7, 1);

        list.stream().forEach(System.out::println);

//        System.out.println(list.stream().filter(x -> x % 2 == 0).map(x -> x * x).reduce(0, (x, y) -> x + y));
    }
}
