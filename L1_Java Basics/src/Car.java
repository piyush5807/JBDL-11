public class Car extends Vehicle {


    public static void main(String[] args) {

        Car o = new Car();



    }


    @Override
    public int calculateSpeed(int milage, int cc) {
        return super.calculateSpeed(milage, cc);
    }

    @Override
    public int durability(String type, int years) {
        return 0;
    }
}
