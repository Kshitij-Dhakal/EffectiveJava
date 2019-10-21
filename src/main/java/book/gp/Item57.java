package book.gp;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>Minimize the Scope of local variable</h1>
 * <p>
 * Declare variable where it is first
 * used.
 * </p>
 *
 * @author dhaka
 */
public class Item57 {

    private Item57() {
    }

    public static void main(String[] args) {
        List<String> names = List.of("Kshitij", "Subin", "Subash", "Lokesh");
        preferred(names);
        notPreferred(names);
    }

    private static void preferred(List<String> names) {
        //preffered idiom for iterating over a collection or array
        for (String name : names) {
            doSomething(name);
        }
        //idiom for iterating when you need the iterator
        for (Iterator<String> i = names.iterator(); i.hasNext(); ) {
            String name = i.next();
            doSomething(name);
        }
        //more readable code. Use this method when loop test involves method that is guaranteed to return same results
        for (int i = 0, n = expensiveComputation(); i < n; i++) {
            doSomething(i + "");
        }
    }

    private static void notPreferred(List<String> names) {
        Iterator<String> i = names.iterator();
        while (i.hasNext()) {
            doSomething(i.next());
        }
        Iterator<String> i2 = names.iterator();
        System.err.println("Should've ran twice. But doesn't.");
        while (i.hasNext()) { //bug forgot to change variable name
            doSomething(i2.next());
        }

    }

    private static void doSomething(String s) {
        System.out.println(s);
    }

    private static int expensiveComputation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Item57.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 10;
    }

}
