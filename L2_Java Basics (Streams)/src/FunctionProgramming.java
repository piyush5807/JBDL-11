import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionProgramming {

    // terminal - forEach, collect, reduce

    public static void main(String[] args) {

        // Q1. You are given an arr of integers, you have to print squares of all such nos who are divisible
        // by 10

        // 2* 40*10*10
        int [] arr = {1, 5, 2, 40, 10, 23, 4, 87, 5, 30};

//        int [] second_arr = {1, 3, 5, 4}; // (13 + 2) + (13 + 40) + (13 + )
        // sum = 0 + 1 = 1
        // 1 + 5 = 6

        // 2^2 + 40^2 + 10^2 + 10^2 + 4^2 + 30^2

        // 1600 100 100 0 900

//        for(int i=0;i<arr.length;i++){
//            if(arr[i] % 10 == 0){
//                System.out.print(arr[i]*arr[i] + " ");
//            }
//        }

        // Streams Approach

//        Arrays.stream()

        // {40, 10, 10, 0, 30}
        // {1600, 100, 100,0, 900}
        // terminal operations 1, intermediate - 0 - infinte
//        Arrays.stream(arr).filter(x -> x % 10 == 0).map(y -> y*y).forEach(x -> System.out.println(x));

        // Q2.You are given an arr of integers, you have to store squares of all such nos who are divisible
        // by 10 in some other arr

//        List<Integer> al = new ArrayList<>();
//
//        for(int i=0;i<arr.length;i++){
//            if(arr[i] % 10 == 0){
//                al.add(arr[i]*arr[i]);
//            }
//        }
//
//        System.out.println(al);

//        System.out.print(Arrays.stream(arr).boxed().filter(x -> x % 10 == 0).map(x -> x*x).collect(Collectors.toSet()));
//
//        List<Integer> al = Arrays.asList(1, 5, 2, 40, 10, 23, 10, 4, 0, 87, 5, 30);
//
//        al.stream().filter(x -> x % 10 == 0).map(x -> x*x).collect(Collectors.toList());


        // Q3. You are given an arr of integers, you have to calculate the sum of squares of even no.

//        int sum = 0;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i] % 2 == 0){
//                sum += arr[i]*arr[i];
//            }
//        }
//        System.out.println(sum);

//        {1, 2, 3, 4, 5}

//        Arrays.stream(arr).filter(x -> x % 2 == 0).map(x -> x * x).sum();
        System.out.println(Arrays.stream(arr).filter(x -> x % 2 == 0).reduce(1, (x, y) -> x * y));

        int [] a1 = {1, 3, 5, 7, 4, 6};
        int [] a2 = {1, 2, 3, 4, 5}; // 15

//        int a1Even = Arrays.stream(a1).filter(x -> x % 2 == 0).sum();
//        List<Integer> list = Arrays.stream(a2).boxed().map(x -> x + a1Even).collect(Collectors.toList());
//
//        System.out.println(list);

        // {11, 12, 13, 14, 15}

        int [] a = {1, 5, 2, 40, 10, 23, 4, 87, 5, 30};
        // Q4. List of squares of even nos whose squares are greater than 10

        // 1600, 100, 16, 900

        System.out.print(Arrays.stream(arr).boxed().filter(x -> (x % 2 == 0 && x*x > 10)).map(x -> x * x).collect(Collectors.toList()));

    }
}
