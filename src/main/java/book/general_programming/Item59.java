package book.general_programming;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Know and use the libraries</h1>
 * <p>
 *
 * </p>
 */
public class Item59 {
    private static Random rnd = new Random();

    //do not do this
    private static int notPreferredRandomNumberGenerator(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    private static int preferredRandomNumberGenerator(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        semanticError(n);
        correct(n);
        //read release notes and use libraries whenever possible
//        preferredMethodToFetchURLContent();
    }

    private static void correct(int n) {
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (preferredRandomNumberGenerator(n) < n / 2) low++;
        }
        System.out.println(low);
    }

    private static void semanticError(int n) {
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (notPreferredRandomNumberGenerator(n) < n / 2) low++;
        }
        //if method truly generated random numbers low should be around half of total sample size. But is is around 666,666 (almost two third of sample)
        System.out.println(low);
    }

    private static void preferredMethodToFetchURLContent() {
        try (InputStream in = new URL("https://www.google.com").openStream()) {
            in.transferTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
