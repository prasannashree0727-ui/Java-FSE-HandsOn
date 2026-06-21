public class Test {
    public static void main(String[] args) {

        Logger obj1 = Logger.getInstance();
        Logger obj2 = Logger.getInstance();

        obj1.log("Application started");
        obj2.log("User logged in");

        if (obj1 == obj2) {
            System.out.println("Both are same object");
        }
    }
}