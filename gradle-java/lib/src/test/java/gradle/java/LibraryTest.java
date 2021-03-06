/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gradle.java;

import java.util.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test void sortStringsWithLambdaTest() {
        List<String> toSort = Arrays.asList("a", "bbb", "cc");

        Library.sortStringsWithLambda(toSort);
        assertEquals(toSort, Arrays.asList("a", "cc", "bbb"));
    }
}
