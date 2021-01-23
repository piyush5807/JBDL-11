package package1;

public class SingletonClass {

    private static SingletonClass singletonClassObject = null;

    private SingletonClass(){

    }

    public static SingletonClass getInstance(){
        if(singletonClassObject == null){
            singletonClassObject = new SingletonClass();
        }

        return singletonClassObject;

    }

    public static void main(String[] args) {
    }

}
