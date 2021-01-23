package package1;

public interface TestInterface{

    // In Java 8, you can have default as well as static methods in interfaces
    // static is used where you can call from the interface's name
    // default one is used when you have to call using this. <function name>
    static int sum(int a, int b){
        return a + b;
    }

    int subtract(int a, int b);
}
