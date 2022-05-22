
/**
 * Program that demonstrates the use of Singleton Design Pattern
 * Singleton Design Pattern creates one object to be used for all users of the app
 * This shows that only one object gets created
 */
package singleton;

public class SingletonClientDemo {
    public static void main(String[] args) {
        //Even though it looks like we are creating 3 SingletonDemo objects it's actually just one
        SingletonDemo obj1 = SingletonDemo.getInstance();
        SingletonDemo obj2 = SingletonDemo.getInstance();
        SingletonDemo obj3 = SingletonDemo.getInstance();

    }
}
