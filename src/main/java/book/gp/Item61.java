package book.gp;

import java.util.Comparator;

/**
 * <h1>Prefer primitive types to boxed primitives</h1>
 */
public class Item61 {
    private Item61() {

    }

    public static void main(String[] args) {
        erroneous();
        correct();
        slower();
        faster();
    }

    private static void faster() {
        final long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        final long end = System.currentTimeMillis();
        System.out.println("Time : " + (end - start));
    }

    private static void slower() {
        final long start = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        final long end = System.currentTimeMillis();
        System.out.println("Time : " + (end - start));
    }

    private static void correct() {
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed;
            return i < j ? -1 : (i == j ? 0 : 1);
        };
        int compare = naturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println(compare);
    }

    private static void erroneous() {
        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);
        int compare = naturalOrder.compare(new Integer(42), new Integer(42));
        //problem doesn't arises in Integer.valueof(42)
        /*
        The first test in naturalOrder works fine. Evaluating i<j causes the Integer instances referred to by i and j to be auto-unboxed; that is, it extracts their primitive values. The evaluation proceeds to check if the first of the resulting int values is less than the second. But suppose it is not. Then then next evaluates the expression i==j, which performs an identity on the two object references. If i and j refers to distinct Integer instances that represent the same in value, this comparison will return false, and the comparator will incorrectly return 1.
         */
        System.out.println(compare);
    }
}
