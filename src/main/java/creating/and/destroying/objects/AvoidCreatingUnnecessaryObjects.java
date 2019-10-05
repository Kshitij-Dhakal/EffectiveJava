/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creating.and.destroying.objects;

/**
 *
 * @author dhaka
 */
public class AvoidCreatingUnnecessaryObjects {
    

    /**
     * Comparing primitive (long) to boxed primitive (Long)
     * @param i 1 for Long and anything else for long
     * @return 
     */
    public static long BoxedPrimitives(final int i) {
        // using object creation
        long start = System.currentTimeMillis();
        if (i == 1) {
            Long sum = 0L;
            for (long j = 0; j < Integer.MAX_VALUE; j++) {
                //new Long is created almost everytime j is added to sum
                sum += j;
            }

        } else {
            long sum = 0L;
            for (long j = 0; j < Integer.MAX_VALUE; j++) {
                sum += j;
            }

        }
         long end = System.currentTimeMillis();
         return end-start;
    }

    public static void main(String[] args) {
        BoxedPrimitives(1);
    }

}
