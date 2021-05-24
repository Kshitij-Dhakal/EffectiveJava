package book.gp;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Combine generics and varargs judiciously</h1>
 * <p>It is critical that you do not annotate a method with <code>@SafeVarargs</code> unless it actually is safe.
 * So what does it take to ensure this? Recall that a generic array is created when the method is
 * invoked, to hold the varargs parameters. If the method doesn’t store anything into the array
 * (which would overwrite the parameters) and doesn’t allow a reference to the array to escape
 * (which would enable untrusted code to access the array), then it’s safe. In other words, if the
 * varargs parameter array is used only to transmit a variable number of arguments from the caller
 * to the method—which is, after all, the purpose of varargs—then the method is safe.</p>
 */
public class Item32 {

    // UNSAFE - Exposes a reference to its generic parameter array!
    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }

    public static void main(String[] args) {
        //throws class cast exception at runtime
        String[] attributes = pickTwo("Good", "Fast", "Cheap");
    }
}
