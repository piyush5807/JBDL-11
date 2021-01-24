import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComp {

    // 1. Multi Threading
    // 2. File Operations
    // 3. Maven

    public static void main(String[] args) {

        List<String> countries = Arrays.asList("Ind", "NZ", "Aus", "SA", "WI",
                "SL", "Pak", "Afg", "Austria", "USA");

        // return the first country starting with A

//      n + x + x - 3
        countries.stream().filter(x -> StreamsComp.filterMyCountry(x)).findFirst();

        System.out.print(countries.stream().filter(StreamsComp::filterMyCountry).map(x -> x+ " ").reduce("", String::concat));
//        System.out.print(country);



//        // n iterations - 3
//        List<String> forLoopCountries = new ArrayList<>();
//        for(int i=0;i<countries.size();i++){
//            if(countries.get(i).startsWith("A") || countries.get(i).startsWith("a")){
//                System.out.print(countries.get(i));
//                break;
//            }
//        }
    }

    public static boolean filterMyCountry(String country){
        System.out.println("Filtering for country :" + country);
        return country.startsWith("A") || country.startsWith("a");
    }
}
