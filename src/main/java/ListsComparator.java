import java.util.*;

/**
 * This class is used for a run time comparision of base methods with ArrayList and LinkedList
 */
public class ListsComparator {

    /**
     * Number of repetitions for each method
     */
    private int numberOfRepetitions = 30000;

    /**
     * This method compares working of List.add() method (in the beginning of the list) with ArrayList and LinkedList
     * @return - result entity
     */
    public ResultEntity compareAddInTheBeginningMethod() {
        List<Integer> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfRepetitions; i++) {
            arrayList.add(0, 1);
        }
        long arrayListResult = System.currentTimeMillis() - start;

        List<Integer> linkedList = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfRepetitions; i++) {
            linkedList.add(0, 1);
        }
        long linkedListResult = System.currentTimeMillis() - start;
        return new ResultEntity(arrayListResult, linkedListResult, numberOfRepetitions, "compareAddInTheBeginningMethod");
    }

    /**
     * This method compares working of List.delete() method (from the beginning of the list) with ArrayList and LinkedList
     * @return - result entity
     */
    public ResultEntity compareDeleteFromTheBeginning() {
        List<Integer> arrayList = new ArrayList<>();
        fillTheArray(arrayList);
        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfRepetitions; i++) {
            arrayList.remove(0);
        }
        long arrayListResult = System.currentTimeMillis() - start;

        List<Integer> linkedList = new LinkedList<>();
        fillTheArray(linkedList);
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfRepetitions; i++) {
            linkedList.remove(0);
        }
        long linkedListResult = System.currentTimeMillis() - start;
        return new ResultEntity(arrayListResult, linkedListResult, numberOfRepetitions, "compareDeleteFromTheBeginning");
    }

    /**
     * This method compares working of List.delete() method (from the middle of the list) with ArrayList and LinkedList
     * @return - result entity
     */
    public ResultEntity compareDeleteFromTheMiddle() {
        List<Integer> arrayList = new ArrayList<>();
        fillTheArray(arrayList);
        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfRepetitions; i++) {
            arrayList.remove(arrayList.size() / 2);
        }
        long arrayListResult = System.currentTimeMillis() - start;

        List<Integer> linkedList = new LinkedList<>();
        fillTheArray(linkedList);
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfRepetitions; i++) {
            linkedList.remove(linkedList.size() / 2);
        }
        long linkedListResult = System.currentTimeMillis() - start;
        return new ResultEntity(arrayListResult, linkedListResult, numberOfRepetitions, "compareDeleteFromTheMiddle");
    }

    /**
     * This method compares working of List.get() method (from the end of the list) with ArrayList and LinkedList
     * @return - result entity
     */
    public ResultEntity compareGetFromTheEnd() {
        List<Integer> arrayList = new ArrayList<>();
        fillTheArray(arrayList);
        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfRepetitions; i++) {
            arrayList.get(arrayList.size() - 1);
        }
        long arrayListResult = System.currentTimeMillis() - start;

        List<Integer> linkedList = new LinkedList<>();
        fillTheArray(linkedList);
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfRepetitions; i++) {
            linkedList.get(linkedList.size() - 1);
        }
        long linkedListResult = System.currentTimeMillis() - start;
        return new ResultEntity(arrayListResult, linkedListResult, numberOfRepetitions, "compareGetFromTheEnd");
    }

    /**
     * This method compares working of List.contains() method with ArrayList and LinkedList
     * In this case it searches for element that doesn't exist in any of given arrays
     * @return - result entity
     */
    public ResultEntity compareContains() {
        List<Integer> arrayList = new ArrayList<>();
        fillTheArray(arrayList);
        long start = System.currentTimeMillis();
        for (int i = 0; i < numberOfRepetitions; i++) {
            arrayList.contains(2);
        }
        long arrayListResult = System.currentTimeMillis() - start;

        List<Integer> linkedList = new LinkedList<>();
        fillTheArray(linkedList);
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfRepetitions; i++) {
            linkedList.contains(2);
        }
        long linkedListResult = System.currentTimeMillis() - start;
        return new ResultEntity(arrayListResult, linkedListResult, numberOfRepetitions, "compareContains");
    }

    /**
     * This method fills the list of type ArrayList or LinkedList with '1''s for the size = numberOfRepetitions
     *
     * @param list - list to be filled
     */
    private void fillTheArray(List list) {
        if (list instanceof ArrayList || list instanceof LinkedList) {
            for (int i = 0; i < numberOfRepetitions; i++) {
                list.add(1);
            }
        }
    }
}
