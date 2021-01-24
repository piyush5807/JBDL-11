import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    // 500
    // 200

    // catch or throw -  handle it

    public static void main(String[] args) throws Exception{

        tryWithResources();

//        try {
//            Scanner scanner = new Scanner(System.in);
//            int n = scanner.nextInt();
//            System.out.println(n);
////            int ans = n / 0;
//
//            // file IO
//
//            FileInputStream file  = new FileInputStream("/Users/pa/Downloads/sample.txt");
////            File file = new File("/Users/pa/Downloads/sample.txt");
//        }
////        }catch (NullPointerException e){
////            System.out.println("File not found");
////        }
//        catch (FileNotFoundException f){
//            System.out.println("File is not found");
//            throw new ArithmeticException();
//        }catch (ArithmeticException e){
//          System.out.println("Some arithmetic exception has occurred");
//          throw new FileNotFoundException();
//        }catch (Exception e){
//            System.out.println("Some error has occured");
////            throw new Exception("some exception has occurred");
//        }

//        System.out.println("At the end!!");

    }

    public static void testFunction() throws FileNotFoundException {
//        int ans = 10 / 0;

        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/pa/Downloads/sample.txt");
        } catch (FileNotFoundException e) {
            System.out.println("");
//            throw new FileNotFoundException();
        }finally {
            System.out.println("At the end of testFunction!!");
        }
    }

    public static void tryWithResources() throws FileNotFoundException {
        try(Person person = new Person();
            Scanner scn = new Scanner(System.in);
            ){
//            person = new Person();
            person.setName("ABC");
            person.setId(3);
            System.out.println(person);

            int ans = 10 / 0;
        }catch (Exception e){
            System.out.print("In the catch block");
            e.printStackTrace();
        }

    }

}
