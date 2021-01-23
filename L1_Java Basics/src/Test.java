import package1.*;

import java.util.List;

public class Test extends Person implements TestInterface{
    public Test(int age, String name, Double marks, List<String> mobiles) {
        super(age, name, marks, mobiles);
    }
//    public Test(int age, String name, Double marks, List<String> mobiles) {
//        super(age, name, marks, mobiles);
//    }


    // Java doesn't support multiple inheritance in terms of classes

    public static void main(String[] args) {


    }

    public void test(){

    }


    @Override
    public int subtract(int a, int b) {
        return Math.abs(a - b);
    }
}
