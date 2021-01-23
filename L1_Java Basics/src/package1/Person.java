package package1;

import java.util.*;

public class Person {

    // 1. private - scope of same class (most restricted)
    // 2. default - scope of same package
    // 3. protected - scope is anywhere in the same package and only to child classes of other packages
    // 4. public - anywhere in project  (least restricted)

    int age;
    protected String name;
    private Double marks;

    List<String> mobiles;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0){
            return;
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public List<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
    }

//    public Person(int age, String name, Double marks, List<String> mobiles) {
//        this.age = age;
//        this.name = name;
//        this.marks = marks;
//        this.mobiles = mobiles;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(marks, person.marks
        )&& Objects.equals(mobiles, person.mobiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, mobiles);
    }

    public Person(int age, String name, Double marks, List<String> mobiles) {
        this.age = age;
        this.name = name;
        this.marks = marks;
        this.mobiles = mobiles;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", mobiles=" + mobiles +
                '}';
    }

    public static void main(String[] args) {
        // List <Integer> al = Arrays.asList(1, 3, 5, 2, 6, 8);
        // sum of squares of all the even no - 2^2 + 6^2 + 8^2
//        Person p = new Person();

        // Person[]p = new Person[100];
//
//        Person p1 = new Person(10, "ABC", 14.0, Arrays.asList("+91234", "+971234"));
//        Person p2 = new Person(10, "ABC", 13.0, Arrays.asList("+91234", "+971234"));
//
////        int h1 = p1.hashCode();
////        int h2 = p2.hashCode();
//
//        System.out.println(p1.hashCode() + " " + p2.hashCode());
//
//        HashMap<Person, Boolean> hashMap = new HashMap<>();
//
//        hashMap.put(p1, true); // h1
//        hashMap.put(p2, false); // h2
//
//        System.out.println(hashMap.get(p1));
//        System.out.println(hashMap.get(p2));
//        System.out.println(hashMap);

//        System.out.println((p1 == p2) + " " + p1 + " " + p2);
//        System.out.println(p1.equals(p2) + " " + p1 + " " + p2);


        List<Person> al = new ArrayList<>();

        al.add(new Person(12, "ABC", 12.0, null));
        al.add(new Person(13, "XYZ", 12.0, null));
        al.add(new Person(12, "DEF", 12.0, null));

        al.sort(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                if(o1.age == o2.age){
                    return o1.name.compareTo(o2.name);
                }

                return o2.age - o1.age;
            }

        });

        Person[] person = new Person[3];
        person[0] = new Person(12, "ABC", 12.0, null);
        person[1] = new Person(12, "DEF", 12.0, null);
        person[2] = new Person(13, "XYZ", 12.0, null);

        Arrays.sort(person, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age == o2.age) {
                    return o1.name.compareTo(o2.name);
                }

                return o2.age - o1.age;
            }
        });

//        Arrays.binarySearch(person, new Person(12, "ABC", 12.0, null));

        int[] arr = {1, 3, 5, 16, 8, 12};

        System.out.println(Arrays.binarySearch(arr, 16));

//        for(int i=0;i<person.length; i++){
//            System.out.println(person[i]);
//        }

//        System.out.println(al);
    }
}
