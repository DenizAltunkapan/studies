package firstSemester.tests;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class classTests {

    @Test

    public void testLIstIsImmutableAdd(){
        List<Integer> list = Collections.unmodifiableList(new ArrayList<>());
        assertThrows(UnsupportedOperationException.class, () -> list.add(3));
    }

    @Test
    public void testListReference(){
        final List<String> list1 = Collections.emptyList();
        final List<String> list2 = Collections.emptyList();
        assertTrue(list1==list2);
    }


}
