package package1;

public interface TestInt {

    default String getGreetingMsg(String name){
       return "Hello " + name;
    }
}
