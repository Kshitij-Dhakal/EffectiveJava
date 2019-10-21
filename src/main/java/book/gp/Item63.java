package book.gp;

import dummydata.ListOf;

import java.util.List;

/**
 * <h1>Beware the performance of string concatenation</h1>
 * <p><strong>Using the string concateation operator repeatedly to concatenate n strings requires time quadratic in n.</strong>T This is an unfortunate consequence of the fact that strings are immutable. When two strings are concatenated, the contents of both are copied.</p>
 * <p><strong>To achieve acceptable performance, use a StringBuilder in place of a String.</strong></p>
 */
public class Item63 {
    public static void main(String[] args) {
        List<String> names = ListOf.names;
        System.out.println(names.size());
        slowConcatenation(names);
        fastStringBuilder(names);

    }

    private static void fastStringBuilder(List<String> names) {
        final long start = System.currentTimeMillis();
        StringBuilder b = new StringBuilder();
        for (String name : names) {
            b.append(name);
        }
//        System.out.println(b.toString());
        final long end = System.currentTimeMillis();
        System.out.println("Using StringBuilder : " + (end - start) + " millis");
    }

    private static void slowConcatenation(List<String> names) {
        final long start = System.currentTimeMillis();
        String concat = "";
        for (String name : names) {
            concat += name;
        }
//        System.out.println(concat);
        final long end = System.currentTimeMillis();
        System.out.println("Using String concatenation '+' : " + (end - start) + " millis");
    }
}
