/**
 * Program that demonstrates the use of Singleton Design Pattern
 * Singleton Design Pattern creates one object to be used for all users of the app
 */

package creational.singleton;

public class SingletonDemo {

    //Declaring object of this class as static, so it's a class object
    static SingletonDemo obj;

    //1.Create a private constructor so no other classes can create an object of this class
    private SingletonDemo() {
        System.out.println("Object created");
    }

    //2.Create a method that returns an object of this class
    public static SingletonDemo getInstance() {
        if (obj == null) {
            obj = new SingletonDemo();
        }
        return obj;
    }
}
