package package1;

import java.util.Arrays;

public class test implements TestInterface, TestInt{

//    public final String testFunction(String name){
//        return "Hello " + name;
//    }

    public static void main(String[] args) {

//        test t = new test();
//
//        System.out.println(t.getGreetingMsg("Piyush"));

//        RandomTest randomTest = new RandomTest(20);
//        System.out.println(randomTest.testFunction("ABC"));
//        randomTest.b = 20;

        SingletonClass singletonClass = SingletonClass.getInstance();
        SingletonClass singletonClass2 = SingletonClass.getInstance();
        SingletonClass singletonClass3 = SingletonClass.getInstance();

        System.out.println(singletonClass2 + " " + singletonClass + " " + singletonClass3);

    }

    @Override
    public int subtract(int a, int b) {
        return 0;
    }

    public void add(int a, int b){
        TestInterface.sum(a, b);
    }

    public String getMyMsg(String name){
        return this.getGreetingMsg(name);
    }

//
//    @Override
//    public String getGreetingMsg(String name) {
//        return "Hey: " + name;
//    }
}
