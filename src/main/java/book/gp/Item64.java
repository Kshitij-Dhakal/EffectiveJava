package book.gp;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <h1>Refer to objects by their interfaces</h1>
 * <p><strong>If you get into the habit of using interfaces as types, your program will be much more flexible.</strong></p>
 * <p>It is entirely appropriate to refer to an object by a class rather than an interface if no appropriate interface exists.</p>
 *
 */
public class Item64 {
    public static void main(String[] args) {
        //Good - uses interface as type
        Set<String> nameSet = new LinkedHashSet<>();
        //if you decided to switch implementations, all you have to do is change the class name in the constructor.
        //Set<String> nameSet = new HashSet<>();
        //and all of the surrounding code would continue to work
        /*
        There is one caveat: if the original implementation offered some special functionality not required by the general contract of the interface and the code depended on that functionality, then it is critical that the new implementation provide the same functionality.
         */

        //Bad - uses class as type
        LinkedHashSet<String> itemSet = new LinkedHashSet<>();
    }
}
