import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListsComparatorTest {

    @Test
    void allCompareMethods() {
        ListsComparator listsComparator = new ListsComparator();
        System.out.println(listsComparator.compareAddInTheBeginningMethod());
        System.out.println(listsComparator.compareDeleteFromTheBeginning());
        System.out.println(listsComparator.compareDeleteFromTheMiddle());
        System.out.println(listsComparator.compareGetFromTheEnd());
        System.out.println(listsComparator.compareContains());
    }

    @Test
    void compareAddInTheBeginningMethod() {
        ListsComparator listsComparator = new ListsComparator();
        System.out.println(listsComparator.compareAddInTheBeginningMethod());
    }

    @Test
    void compareDeleteFromTheBeginning() {
        ListsComparator listsComparator = new ListsComparator();
        System.out.println(listsComparator.compareDeleteFromTheBeginning());
    }

    @Test
    void compareDeleteFromTheMiddle() {
        ListsComparator listsComparator = new ListsComparator();
        System.out.println(listsComparator.compareDeleteFromTheMiddle());
    }

    @Test
    void compareGetFromTheEnd() {
        ListsComparator listsComparator = new ListsComparator();
        System.out.println(listsComparator.compareGetFromTheEnd());
    }

    @Test
    void compareContains() {
        ListsComparator listsComparator = new ListsComparator();
        System.out.println(listsComparator.compareContains());
    }
}
