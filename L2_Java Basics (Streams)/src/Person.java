public class Person implements AutoCloseable{

    int id;
    String name;

    public Person() throws Exception {
//        throw new Exception();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        //
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void test(){
        throw new ArithmeticException();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Making person null here!!");
    }
}
