package package1;

public final class RandomTest {

    // final - 1. variables
    // 2. functions
    // 3. class

    public final int a;

    public int b = 30;

    public RandomTest(int a) {
        this.a = a;
    }

    public String testFunction(String name){
        return "Hello " + name;
    }

    public String testFunction(String name, int a){
        return "Hello " + name + " " + a;
    }

    public static void main(String[] args) {

        RandomTest obj = new RandomTest(12);
        System.out.println(obj.testFunction("Piyush"));
        System.out.println(obj.testFunction("Piyush", 2));


    }
}
